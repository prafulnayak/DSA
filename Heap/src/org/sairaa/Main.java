package org.sairaa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*     Find Median      */
//        System.out.println("Find Median ");
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        int n;
//        while (t -- > 0){
//            n = scanner.nextInt();
//            FindMedian ans = new FindMedian();
//            for (int i=0;i<n;i++){
//                int x = scanner.nextInt();
//                ans.insertHeap(x);
//                System.out.println((int)Math.floor(ans.getMedian()));
//            }
//        }

        /*     Heap Operation      */
//        HeapOperation.heapOperation();

        /*     Jesse and cookies      */
//        int no = JesseAndCookies.jeeseAndCookies();
//        System.out.println(no);


        ///Running Median
//        RunningMedian.findRunningMedian();
        /*
        *intersection Computes the list of values that are the intersection of all the arrays. Each value in the result is present in each of the arrays.
intersection(new int[]{1, 2, 3}, new int[]{1, 2}, new int[]{1, 2, 5})

Output => [1, 2]

         */

//        MinimumAvgTime.inputArray();

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> a =new ArrayList<>();
        a.add(1);a.add(2);a.add(3);
        ArrayList<Integer> b =new ArrayList<>();
        b.add(1);b.add(2);
        ArrayList<Integer> c =new ArrayList<>();
        c.add(1);c.add(2);c.add(5);
        arrayLists.add(a);arrayLists.add(b);arrayLists.add(c);
        InsertA.findCommon(arrayLists);

    }
}
