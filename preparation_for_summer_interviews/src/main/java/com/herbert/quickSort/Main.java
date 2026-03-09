package com.herbert.quickSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0;i < n;i ++) {
                arr[i] = sc.nextInt();
            }
            m.quickSort(arr, 0, n - 1);
            for (int i = 0;i < n;i ++) {
                System.out.print(arr[i] + " ");
            }
        }
        sc.close();
        
    }
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return ;
        int index = partition(arr, l, r);
        quickSort(arr, l, index - 1);
        quickSort(arr, index + 1, r);
    }
    private int partition(int[] arr, int l, int r) {
        int basedVal = arr[l];
        int i = l, j = r;
        while (i < j) {
            while (j > i && arr[j] >= basedVal) -- j;
            while (i < j && arr[i] <= basedVal) ++ i;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[l] = arr[i];
        arr[i] = basedVal;
        return i;
    }
}
