package com.herbert.T1855;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxLength = Integer.MIN_VALUE;
        int n1 = nums1.length, n2 = nums2.length;

        // 从当前 i, j 进行比较，
        // if nums i > numsj then ++i, ++ j
        // else ++ j, to get the max value
        
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            while (i > j && j < n2) {
                ++ j;
            }
            if (i > j) {
                break;
            }

            if (nums1[i] > nums2[j]) {
                ++ i;
                ++ j;
            } else {
                while (j < n2 && nums1[i] <= nums2[j]) {
                    ++ j;
                }
                maxLength = Math.max(maxLength, j - 1 - i);
                ++ i;
            }
        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
