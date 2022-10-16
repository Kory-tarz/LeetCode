package com.cyryl.daily.october;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */

public class Skyline {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int HEIGHT = 2;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        CityLayout cityLayout = new CityLayout();
        for (int[] building : buildings) {
            cityLayout.addBuilding(building[LEFT], building[RIGHT], building[HEIGHT]);
        }
        return cityLayout.getLayout();
    }

    private class CityLayout{

        Map<Integer, Integer> values;
        Set<Integer> points;

        public CityLayout() {
            this.values = new HashMap<>();
            points = new HashSet<>();
        }

        public void addBuilding(int left, int right, int height){
            update(left, right - 1, 0, Integer.MAX_VALUE, 1, height);
            points.add(left);
            points.add(right);
        }

        private void update(int left, int right, int totalLeft, int totalRight, int idx, int height){
            if(left > totalRight || right < totalLeft){
                return;
            }
            if(totalLeft >= left && right >= totalRight){
                values.put(idx, Math.max(values.getOrDefault(idx, 0), height));
            } else {
                int mid = (totalLeft + totalRight) / 2;
                update(left, right, totalLeft, mid, idx * 2, height);
                update(left, right, mid + 1, totalRight, idx * 2 + 1, height);
                values.put(idx, Math.max(values.getOrDefault(idx * 2, 0), values.getOrDefault(idx * 2 + 1, 0)));
            }
        }

        private int findMax(int left, int right){
            return getMax(left, right - 1, 0, Integer.MAX_VALUE, 1);
        }

        private int getMax(int left, int right, int totalLeft, int totalRight, int idx){
            if(left > totalRight || right < totalLeft || !values.containsKey(idx)){
                return 0;
            }
            if(totalLeft >= left && right >= totalRight){
                return values.getOrDefault(idx, 0);
            } else {
                int mid = (totalLeft + totalRight) / 2;
                int leftMax = getMax(left, right, totalLeft, mid, idx * 2);
                int rightMax = getMax(left, right, mid + 1, totalRight, idx * 2 + 1);
                return Math.max(values.getOrDefault(idx, 0), Math.max(leftMax, rightMax));
            }
        }

        public List<List<Integer>> getLayout(){
            List<List<Integer>> result = new ArrayList<>();
            int prevMax = 0;
            int prevPoint = 0;
            List<Integer> sortedPoints = points.stream().sorted().collect(Collectors.toList());
            for (int curr : sortedPoints){
                int max = findMax(prevPoint, curr);
                System.out.println("Curr: " + curr + " max: " + max);
                if(prevMax != max){
                    result.add(List.of(curr, prevMax));
                    prevMax = max;
                    prevPoint = curr;
                }
            }
            return result;
        }
    }
}
