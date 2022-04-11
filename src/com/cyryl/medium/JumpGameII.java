package com.cyryl.medium;

public class JumpGameII {
    public static int jump(int[] nums) {
        if(nums.length == 1)
            return 0;

        int[] jumpsRequired = new int[nums.length];
        int distance = 1;
        int lastIndex = nums.length-1;
        int jumpLength;
        int jump;
        int bestJump;
        int jumpTarget;
        boolean bestJumpFound;

        for(int i=lastIndex-1; i>=0; i--){
            jumpLength = nums[i];
            if(jumpLength >= distance)
                jumpsRequired[i] = 1;
            else if(jumpLength > 0){
                jump = 1;
                bestJump = distance;
                bestJumpFound = false;
                while(!bestJumpFound && jump<= jumpLength) {
                    jumpTarget = i + jump;
                    if(jumpsRequired[jumpTarget] != 0) {
                        if ((nums[jumpTarget] == jumpLength - jump) && bestJump >= jumpsRequired[jumpTarget]) {
                            jumpsRequired[i] = jumpsRequired[jumpTarget];
                            bestJumpFound = true;
                        } else if (jumpLength - jump > nums[jumpTarget] && bestJump >= jumpsRequired[jumpTarget]){
                            bestJump = jumpsRequired[jumpTarget]-1;
                            jump += nums[jumpTarget]-1;
                        } else if (bestJump > jumpsRequired[jumpTarget]) {
                            bestJump = jumpsRequired[jumpTarget];
                        }
                    }
                    jump++;
                }
                if(!bestJumpFound)
                    jumpsRequired[i] = bestJump+1;
            }
            distance++;
        }
        return jumpsRequired[0];
    }
}
