package com.cyryl.medium;

import java.util.*;

public class DuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, List<Integer>>map = new HashMap<>(nums.length);

        List<Integer> list;
        int currentNumber = 0;
        int nextNumber;
        boolean sameNumber = false;

        for(int i=0; i<nums.length; i++){
            currentNumber = nums[i];
            if(map.containsKey(currentNumber)){
                map.get(currentNumber).add(i);
            }else{
                list = new ArrayList<>();
                list.add(i);
                map.put(currentNumber, list);
            }
        }

        Arrays.sort(nums);

        int j;

        for(int i=0; i<nums.length-1; i++){
            nextNumber = nums[i+1];
            if(i>0)
                sameNumber = currentNumber == nextNumber;
            currentNumber = nums[i];
            j=i;
            while(j<nums.length && (long)nextNumber - (long)currentNumber <= t){

                if(nextNumber == currentNumber){
                    if(!sameNumber && checkTheSameNumber(map.get(currentNumber), k))
                        return true;
                }else if (checkIndexDistance(map.get(currentNumber), map.get(nextNumber), k)){
                    return true;
                }
                if(j+1 < nums.length)
                    nextNumber = nums[j+1];
                j++;
            }
        }
        return false;
    }

    private static boolean checkTheSameNumber(List<Integer> list, int k){
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i+1) - list.get(i) <= k)
                return true;
        }
        return false;
    }

    private static boolean checkIndexDistance(List<Integer> list1, List<Integer> list2, int k){
        int i1 = 0;
        int i2 = 0;
        while(i1 < list1.size() && i2 < list2.size()){
            if (Math.abs(list1.get(i1) - list2.get(i2)) <= k)
                return true;
            else if(list1.get(i1) >= list2.get(i2)){
                i2++;
            }else{
                i1++;
            }
        }
        return false;
    }
}
