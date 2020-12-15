package org.sairaa;

import java.util.*;

public class InsertA {
    public static void findCommon(ArrayList<ArrayList<Integer>> masterList){
        HashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        for(int i =0; i<masterList.size();i++){
            ArrayList<Integer> list = masterList.get(i);
            for(int j=0; j<list.size();j++){
                if(hashMap.containsKey(list.get(j))){
                    int t = hashMap.get(list.get(j))+1;
                    hashMap.put(list.get(j),t);
                }else{

                    hashMap.put(list.get(j),1);
                }

            }
        }
        hashMap.forEach((key, value) -> {
            if(value==masterList.size()){
                System.out.println("[Key] : " + key + " [Value] : " + value);
            }
        });
    }
}
