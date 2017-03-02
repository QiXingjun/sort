package com.qixingjun.exchange;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author XingJun Qi
 * @MyBlog www.qixingjun.tech
 * @Version 1.0.0
 * @Date 2017/3/2
 * @Description
 * 基本思想：通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 */
public class QuickSort {
    public static void quickSort(int[] arr,int left,int right){
        if (left<right){
            int pivotKey = partition(arr,left,right);
            quickSort(arr,left,pivotKey-1);
            quickSort(arr,pivotKey+1,right);
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr,int left,int right){
        //获取left和right之间的一个随机数
        Random random = new Random();
        int pivotKey = left+random.nextInt(right-left);
        //将下标为pivotKey的数和下标为left的数交换，即将pivotKey换到最左边。
        swap(arr, pivotKey, left);
        while (left<right){
            while (left<right&&arr[left]<arr[pivotKey]){
                left++;
            }
            swap(arr, pivotKey, left);
            while (left<right&&arr[right]>arr[pivotKey]){
                right--;
            }
            swap(arr, pivotKey, right);
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 8;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr,0,N-1);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
