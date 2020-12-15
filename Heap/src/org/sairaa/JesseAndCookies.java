package org.sairaa;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/jesse-and-cookies/problem?h_r=next-challenge&h_v=zen
 */
public class JesseAndCookies {
    static int jeeseAndCookies(){
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int noOfIteration =0;
        while (n>0){
            n--;
            priorityQueue.add(scanner.nextLong());
        }
        Long smallest = Long.MIN_VALUE;
        Long smallest2 = Long.MIN_VALUE;
//        System.out.println(priorityQueue.size());
        while (!priorityQueue.isEmpty()){
//            System.out.println("peek: "+priorityQueue.peek()+" Size:"+priorityQueue.size());
            if(priorityQueue.size()>=2){
                if(priorityQueue.peek()>= k){
                    return noOfIteration;
                }else{
                    smallest = priorityQueue.poll();
                    smallest2 = priorityQueue.poll();
                    priorityQueue.add((smallest+(smallest2*2)));
                }

            }else{
                if(priorityQueue.peek() >=k)
                    return noOfIteration;
                else
                    return -1;
            }
            noOfIteration++;
        }
        return -1;
    }
}


