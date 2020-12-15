package org.sairaa;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello Stack");
        String x ="{}}}{{[([]])]}}}";
        System.out.println(" is Par: "+Parenthesis.ispar(x));
        StackOperation.stackOperation();
    }
}
