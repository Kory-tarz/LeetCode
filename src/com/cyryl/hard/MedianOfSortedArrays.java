package com.cyryl.hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0;
        int left2 = 0;
        int totalNums = nums1.length + nums2.length;
        int numbersToDelete;
        boolean evenLength = totalNums % 2 == 0;
        if (evenLength) {
            numbersToDelete = totalNums / 2 - 1;
        } else {
            numbersToDelete = totalNums / 2;
        }
        System.out.println("TO DELETE: " + numbersToDelete);
        while (left1 < nums1.length && left2 < nums2.length && numbersToDelete > 0) {
            int shift = (numbersToDelete % 2 == 0) ? numbersToDelete / 2 : numbersToDelete / 2 + 1;
            int oneIdx = Math.min(left1 + shift - 1, nums1.length - 1);
            int twoIdx = Math.min(left2 + shift - 1, nums2.length - 1);
            System.out.println(nums1[oneIdx] + " ? " + nums2[twoIdx]);
            if (nums1[oneIdx] > nums2[twoIdx]) {
                numbersToDelete -= Math.min(shift, nums2.length - left2);
                left2 += shift;
            } else {
                numbersToDelete -= Math.min(shift, nums1.length - left1);
                left1 += shift;
            }
            System.out.printf("Nums1: %s, Nums2: %s, toDelete: %s", left1, left2, numbersToDelete);
        }
        if (left1 >= nums1.length) {
            return lowestFromArr(nums2, left2 + numbersToDelete, evenLength);
        } else if (left2 >= nums2.length) {
            return lowestFromArr(nums1, left1 + numbersToDelete, evenLength);
        } else {
            return lowestFromTwo(nums1, nums2, left1, left2, evenLength);
        }
    }

    public double lowestFromTwo(int[] a, int[] b, int aStart, int bStart, boolean even) {
        double sum = 0;
        if (a[aStart] < b[bStart]) {
            sum += a[aStart];
            aStart++;
        } else {
            sum += b[bStart];
            bStart++;
        }
        if (even) {
            if (bStart >= b.length) {
                sum += a[aStart];
            } else if (aStart >= a.length) {
                sum += b[bStart];
            } else sum += Math.min(a[aStart], b[bStart]);
        }
        return even ? sum / 2 : sum;
    }

    public double lowestFromArr(int[] arr, int start, boolean even) {
        double sum = arr[start] + (even ? arr[start + 1] : 0);
        return even ? sum / 2 : sum;
    }
}
