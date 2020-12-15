package org.sairaa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumAvgTime {
    static int[][] pA;
    static PriorityQueue<TimePizza> pQ = new PriorityQueue<TimePizza>();
    static int n = 0;
    static long time =0;
    static long timeX =0;
    static int nextOrderTime = 0;
    static void inputArray(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        pA = new int[n][2];
        for(int i =0; i<n; i++){
            pA[i][0] = scanner.nextInt();
            pA[i][1] = scanner.nextInt();
        }
        sortArray();
        minimumAverage();
    }

    private static void sortArray() {
        Arrays.sort(pA, Comparator.comparingInt(o -> o[0]));
    }
    static long minimumAverage() {
        pQ.add(new TimePizza(pA[0][0], pA[0][1]));
        nextOrderTime = 1;
        time = pA[0][0];
        findAvgTime();
        System.out.println("--"+n+"---------"+time+"-"+time/n);
        return time/n;
    }
    /*
    * x =min(time, sizeof array)
if(n<time){
    loop array(until a[n] < x){
    n++;
    add to priorityQueue()
}
else{
time = time + PQ.poll.getTime- intime
callR(time)

    * */

    private static void findAvgTime() {
        while (!pQ.isEmpty()){
            TimePizza timePizza = pQ.poll();
            timeX = timeX+timePizza.getPizzaTime();

            time = time + timeX - timePizza.getInTime();
            System.out.println("time: "+time+"-----"+timeX);
            long x = Math.min(n,time);
            if(nextOrderTime<=time){
                for(; nextOrderTime<x; nextOrderTime++){
                    pQ.add(new TimePizza(pA[nextOrderTime][0], pA[nextOrderTime][1]));
                }
            }
        }


//        0 3 7:00- 7:03 = 3
//        1 9  7:01 - 7:17 = 16
//        2 5  7:02-7:08 -6
//        3 10 7.03 - 7:27 =  24

    }
    public static class TimePizza implements Comparable<TimePizza>{
        int inTime;
        int pizzaTime;

        public TimePizza() {
        }

        public TimePizza(int inTime, int pizzaTime) {
            this.inTime = inTime;
            this.pizzaTime = pizzaTime;
        }

        public int getInTime() {
            return inTime;
        }

        public void setInTime(int inTime) {
            this.inTime = inTime;
        }

        public int getPizzaTime() {
            return pizzaTime;
        }

        public void setPizzaTime(int pizzaTime) {
            this.pizzaTime = pizzaTime;
        }

        @Override
        public int compareTo(TimePizza o) {
            return this.pizzaTime-o.pizzaTime;
        }
        //    @Override
//    public int compareTo(TimePizza compareTimePizza) {
//        if(this.weight- compareTimePizza.weight ==0)
//            return 0;
//        else
//            return  (this.weight- compareTimePizza.weight)>0 ?1:-1;
//    }
    }

}
