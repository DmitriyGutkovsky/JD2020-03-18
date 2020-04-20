package by.it.gutkovsky.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int positionZero = 0;
        while (true){
            String inp = sc.next();
            if (inp.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(inp);
            //-1 1 2 3 4 8  0 0 8 -2 -3 9 -7
            // 1 2 3 4 8 8 9 0 0 -1 -2 -3 -7

            if (value < 0) {
                list.add(value);
            } else if(value==0) {
                list.add(positionZero, value);
            } else {
                list.add(positionZero++, value);

            }
        }
        System.out.println(list);

    }

}
