package com.qixingjun.selectionsort;

import java.util.Scanner;

/**
 * @Author XingJun Qi
 * @MyBlog www.qixingjun.tech
 * @Version 1.0.0
 * @Date 2017/3/2
 * @Description 基本思想：
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当
 * 中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）
 * 和第n个元素（最后一个数）比较为止。
 * <p/>
 * 操作方法：
 * 第一趟，从n 个记录中找出关键码最小的记录与第一个记录交换；
 * 第二趟，从第二个记录开始的n-1 个记录中再选出关键码最小的记录与第二个记录交换；
 * 以此类推.....
 * 第i 趟，则从第i 个记录开始的n-i+1 个记录中选出关键码最小的记录与第i 个记录交换，
 * 直到整个序列按关键码有序。
 */
public class SimpleSelectionSort {
    public static void selectionSort(int[] arr) {
        int size = arr.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = i; j < size; j++) {
                if (arr[j]<arr[k]){
                    k = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 10;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        selectionSort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
