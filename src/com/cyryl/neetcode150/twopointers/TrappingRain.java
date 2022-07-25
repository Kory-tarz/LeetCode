package com.cyryl.neetcode150.twopointers;

public class TrappingRain {

    private final int GO_LEFT = -1;
    private final int GO_RIGHT = 1;
    private final int NONE = 0;

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int current = 0;
        int state = NONE;
        int stateMin = 0;

        int waterContained = 0;

        while (left < right){
            if(state == NONE){
                if(height[left] < height[right]){
                    current = left+1;
                    state = GO_RIGHT;
                    stateMin = height[left];
                }else{
                    current = right-1;
                    state = GO_LEFT;
                    stateMin = height[right];
                }
            }
            if(height[current] < stateMin){
                waterContained += stateMin - height[current];
                current += state;
            }else{
                if(state == GO_RIGHT){
                    left = current;
                }else{
                    right = current;
                }
                state = NONE;
            }
        }
        return waterContained;
    }
}
