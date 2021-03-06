package by.it.tolstik.jd02_03;

import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner;
    private boolean waitState = false;

    private static final Semaphore semaphore = new Semaphore(20);
    private static final Semaphore backetSemaphore = new Semaphore(50);

    void setWaitState(boolean waitState) {
        this.waitState = waitState;
    }

    Buyer(int number) {
        super("Buyer № " + number + " ");
        Manager.buyerEnterToShop(); //зашел покупатель (счетчик ++)
    }

    @Override
    public void run() {

        try {
            System.out.println(this + "ждет корзину.");
            backetSemaphore.acquire();
            Backet extract = Backet.extract();
            takeBacket();
            System.out.println(extract);
            enterToMarket(); //вошел в магазин
            try {
                semaphore.acquire();
                chooseGoods(); //взял корзину, начал выбирать товары, положил товары в корзину, завершил выбирать товары
            } catch (InterruptedException e) {
                throw new RuntimeException();
            } finally {
                semaphore.release();
            }
            goToQueue();
            goOut(); //вышел из магазина
            Backet.add(extract);
            System.out.println(extract);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            backetSemaphore.release();
        }


    }

    @Override
    public void enterToMarket() {
        if (isPensioner()) System.out.println(this + "вошел в магазин, он пенсионер");
        else System.out.println(this + "вошел в магазин");
        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "начал выбирать товары"); //начал выбирать товары
        int timeout;
        if (pensioner) timeout = (int) (Helper.getRandom(500, 2000) * Manager.K_FOR_OLDER_PEOPLE);//коэф пенсионера
        else timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout, 100);
        putGoodsToBacket(); //положил товары в корзину
        if (pensioner) System.out.println(this + "завершил выбирать товары, он пенсионер");
        else System.out.println(this + "завершил выбирать товары"); //завершил выбирать товары
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            QueueBuyers.add(this);
            waitState = true;
            while (waitState) {
                try {
                    System.out.println(this + "стал в очередь");
                    this.wait(); //ждем notify();
                    System.out.println(this + "покинул очередь");
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.print(this + "вышел из магазина и вернул на место ");
        Manager.buyerQuiteShop(); //вышел покупатель (счетчик ++)

    }

    @Override
    public boolean isPensioner() {
        int flag = Helper.getRandom(1, 4);
        if (flag == 1) pensioner = true;
        return pensioner;
    }

    @Override
    public void takeBacket() {
        System.out.print(this + "взял корзину ");
    }

    @Override
    public int putGoodsToBacket() {
        int timeout;
        if (pensioner) timeout = (int) (Helper.getRandom(500, 2000) * Manager.K_FOR_OLDER_PEOPLE);//коэф пенсионера
        else timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout, 10);
        //загрузка в тележку рандомных продуктов из Goods
        int count = Helper.getRandom(1, 4);
        int sum = 0; //инициализация суммы чека
        for (int i = 0; i < count; i++) {
            int value = Helper.getRandom(1, Goods.goodsList().size() - 1);
            System.out.println(this + "положил в корзину " + Goods.getGoodsName().get(value)
                    + " за " + Goods.getGoodsPrice().get(value) + " рублей.");
            sum += Goods.getGoodsPrice().get(value);
        }
        return sum;
    }

    @Override
    public String toString() {
        return getName();
    }
}
