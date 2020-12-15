package org.sairaa;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    //min heap (Default)
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    //max heap
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static double res = 0;
    static int count =0;
    static int[] ccc;
//System.out.println(df.format(PI));
    public static void findRunningMedian(){
        ccc = new int[5];
        System.out.println(ccc.length);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (count<n){
            count++;
            int x = scanner.nextInt();
            insertToHeap(x);

        }
    }

    private static void insertToHeap(int x) {
        if(max.isEmpty())
            max.add(x);
        else if(x<max.peek()){
            min.add(max.poll());
            max.add(x);
        }else {
            min.add(x);
        }
        balanceHeap();
        printMean();
    }

    private static void printMean() {
        if(count%2 ==0){
            res = (double)(max.peek() + min.peek())/2;
            System.out.println(String.format("%.1f", res));
        }else {
            if(max.size() > min.size()){
                res = Double.parseDouble(max.peek().toString());
                System.out.println(res);
            }
            else {
                res = Double.parseDouble(min.peek().toString());
                System.out.println(res);
            }
        }
    }

    private static void balanceHeap() {
        if(Math.abs(max.size()-min.size()) > 1){
            if(max.size() - min.size() > 1){
                min.add(max.poll());

            }else{
                max.add(min.poll());

            }
        }
    }
}
