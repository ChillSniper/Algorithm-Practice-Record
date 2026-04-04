package com.herbert.T4;

public class Main {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthA = nums1.length, lengthB = nums2.length;
        int lengthSum = lengthA + lengthB;
        int k = (lengthSum + 1) / 2;
        if (lengthSum % 2 == 1) {
            return getK(nums1, nums2, 0, 0, k);
        }
        int bf = getK(nums1, nums2, 0, 0, k);
        int af = getK(nums1, nums2, 0, 0, k + 1);
        return (bf + af) * 1.0 / 2;
    }

    private int getK(int[] nums1, int[] nums2, int stA, int stB, int k) {
        // 一开始这里写错了，注意计算数组长度时，最好代入一个特值计算一下。
        int lengthA = nums1.length - (stA);
        int lengthB = nums2.length - (stB);
        if (lengthA == 0) {
            return nums2[stB + k - 1];
        }
        if (lengthB == 0) {
            return nums1[stA + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[stA], nums2[stB]);
        }
        int lx = Math.min(lengthA, k / 2);
        int ly = Math.min(lengthB, k / 2);
        int valx = nums1[stA + lx - 1];
        int valy = nums2[stB + ly - 1];
        if (valx <= valy) {
            return getK(nums1, nums2, stA + lx, stB, k - lx);
        }
        return getK(nums1, nums2, stA, stB + ly, k - ly);
    }
}
