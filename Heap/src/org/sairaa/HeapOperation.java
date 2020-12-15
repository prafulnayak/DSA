package org.sairaa;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapOperation {
    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    public static void heapOperation(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = 0;
        Long no;
        while (n>0){
            n--;
            q = scanner.nextInt();
            switch (q){
                case 1:
                    no = scanner.nextLong();
                    priorityQueue.add(no);
                    break;
                case 2:
                    no = scanner.nextLong();
                    priorityQueue.remove(no);
                    break;
                case 3:
                    System.out.println(priorityQueue.peek());
                    break;

            }
        }
        scanner.close();
    }
}
