package org.sairaa;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {
    //min heap (Default)
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    //max heap
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    // Function to insert heap
    public static void insertHeap(int x)
    {
        // add your code here
        if(max.isEmpty()){
            max.add(x);
        }else if(x<max.peek()) {
            min.add(max.peek());
            max.poll();
            max.add(x);
        }else if(min.isEmpty()){
            min.add(x);
        }else {
            min.add(x);
        }
        balanceHeaps();
    }

    // Function to balance Heaps
    public static void balanceHeaps()
    {
        // add your code here
        if(Math.abs(max.size()-min.size()) > 1){
            if (max.size() > min.size())
            {
                min.add(max.peek());
                max.poll();
            }

            else
            {
                max.add(min.peek());
                min.poll();
            }
        }
    }

    // function to getMedian
    public static double getMedian()
    {
        // add your code here
        double median = 0.0; //Stores current median
        // if total size is even
        if ((max.size() + min.size()) % 2 == 0)
        {
            median = (max.peek() + min.peek());
            median /= 2;
        }
        else // if total size is even
        {
            if (min.isEmpty())
                median = max.peek();
            else if (min.size() < max.size())
                median = max.peek();
            else
                median = min.peek();
        }

        return median;
    }
}