package by.it.akhmelev.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
