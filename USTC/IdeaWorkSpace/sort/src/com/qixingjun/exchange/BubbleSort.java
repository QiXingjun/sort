package com.qixingjun.exchange;

import java.util.Scanner;

/**
 * @Author XingJun Qi
 * @MyBlog www.qixingjun.tech
 * @Version 1.0.0
 * @Date 2017/3/2
 * @Description
 * (1)基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数
 * 依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序
 * 与排序要求相反时，就将它们互换。
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int temp;
        int size = arr.length;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if (arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 10;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        bubbleSort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
