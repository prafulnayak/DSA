package org.sairaa;

import java.util.*;

public class StackOperation {
    static Stack<Long> stack = new Stack<>();
    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    public static void stackOperation(){
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
                    stack.push(no);
                    priorityQueue.add(no);
                    break;
                case 2:
                    priorityQueue.remove(stack.pop());
                    break;
                case 3:
                    System.out.println(priorityQueue.peek());
                    break;

            }
        }
        scanner.close();
    }
}
