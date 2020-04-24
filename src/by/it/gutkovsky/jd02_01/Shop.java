package by.it.gutkovsky.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Shop {
    public static void main(String[] args) {

        System.out.println("shop is opened");

        Map<Integer, Integer> mapForChecking = new HashMap<>(); // temporary map for checking

        int number = 0;
        List<Buyer> buyers = new ArrayList<>();
        int factor;
        for (int time = 0; time < 240; time++) {
            int count; // quantity of buyers that will enter to the shop
            factor = time / 60;
//            factor = 0;

            if (((60 * factor) <= time) && (time <= (30 + 60 * factor))) {
                if (Manager.checkingQuantityInShop() < ((time - (60 * factor)) + 10)) {
                    count = (time - 60 * factor) + 10 - Manager.checkingQuantityInShop();
                    for (int i = 0; i < count; i++) {
                        number++;
                        buyers.add(creatCustomer(number, buyers));
                    }
                }
            }

//            if (time > 30 && time <= 60) {
            if (time > (30 + (factor * 60)) && time < (60 + (factor * 60))) {
                if (Manager.checkingQuantityInShop() < (40 + (30 - (time - (60 * factor))))) {
//                if (Manager.checkingQuantityInShop() < 40) {
                    count = (40 + (30 - (time - (60 * factor)))) - Manager.checkingQuantityInShop();
                    for (int i = 0; i < count; i++) {
                        number++;
                        buyers.add(creatCustomer(number, buyers));
                    }
                }
            }

//            if (time > 60 && time <= 90) {
//                if(Manager.checkingQuantityInShop() < ((time-60) + 10)) {
//                    count = (time-60)+10-Manager.checkingQuantityInShop();
//                    for (int i = 0; i < count; i++) {
//                        number++;
//                        buyers.add(creatCustomer(number,buyers));
//                    }
//                }
//            }
//
//            if (time > 90) {
//                count = (40 + (30 - (time-60)))-Manager.checkingQuantityInShop();
//                for (int i = 0; i < count; i++) {
//                    number++;
//                    buyers.add(creatCustomer(number,buyers));
//                }
//            }

            // it was before start C part 2
//            count = Helper.getRandom(0, 2);
//            for (int i = 0; i < count; i++) {
//                number++;
//                buyers.add(creatCustomer(number, buyers));
//            }
            mapForChecking.put(time, Manager.checkingQuantityInShop()); // temprory method method that helping to test
            Helper.sleep(1000);
        }

        Helper.sleep(2000);

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop is closed");


        // testing block
        ForTesting.printingMap(mapForChecking);

    }

    static Buyer creatCustomer(int number, List<Buyer> buyers) {
        Buyer buyer;
        if ((buyers.size() % 4 != 0)) {
            buyer = new Buyer(number);
        } else {                                    // pensioner is coming
            buyer = new Buyer(number, true);
        }
        buyer.start();
        return buyer;
    }
}
