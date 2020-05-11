package by.it.gutkovsky;


import java.text.DateFormat;
import java.util.*;

public class Main  {

    public static void main(String[] args) {

//        System.out.println(args.length);

//        int a = 4 / 5;
//        String s = null;
//        String d = s + s;
//        String f = "";
//        System.out.println(f);
//        System.out.println(s+s);
//        System.out.println(s);
//        System.out.println(d);

//        Locale locale = Locale.getDefault();
//        System.out.println(locale);

//        boolean b = false;
//        if (b== false)
//            if (b = false)
//                System.out.println("if statment");
//            else
//                System.out.println("else statment");

//        int n = 33;
//        int k = 0;
//
//        while (n > 0) {
//            k += n % 2;
//            n /= 2;
//        }
//
//        System.out.println(k);


//        System.out.println(a);
//        System.out.println("\033[32m sadfs"); // цветная печать: 30 - черный.
        // 31 - красный. 32 - зеленый. 33 - желтый. 34 - синий. 35 - пурпурный. 36 - голубой. 37 - белый.

        /* jd01_10 BeanTester:
         System.out.printf("\033[32m method: \033[36m%s= \033[31m%s\n",methodName,methodResult); // цветной вывод
                /*
                \033 - далее символ отвечающий за цвет
                [30m - черный
                [31m - красный
                [32m - зеленый
                [33m - желтый
                [34m - синий
                [35m - пурпурный
                [36m - голубой
                [37m - белый.
                 */

//        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");
//
//        System.out.println(tz.getRawOffset());
//        System.out.println(tz.getOffset(System.currentTimeMillis()));
//        System.out.println(tz.useDaylightTime());
//
//        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.ENGLISH));
//        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH));
//        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.ENGLISH));
//        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.ENGLISH));
//
//        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.FRENCH));
//        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.FRENCH));
//        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.FRENCH));
//        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.FRENCH));

//        int myInt = 0;
//        float myFloat = 0;
//        float result = myInt / myInt;

//        int a = 5;
//        test(++a);
//    }
//
//        static void test ( int a){
//            a += EASY + a++;
//            System.out.println(a);
//        }
//    }
//    interface I {
//        public final static int EASY = 5;

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
//        GregorianCalendar calendar = new GregorianCalendar();
////        Calendar calendar = Calendar.getInstance();
//        Date time = calendar.getTime();
//        System.out.println(time);
//        System.out.println(df.format(time));
//        int a =0;
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        GregorianCalendar calendar2 = new GregorianCalendar();

        System.out.println(df.format(calendar2.getTime()));
        System.out.println(calendar2.getTime());


    }
}
