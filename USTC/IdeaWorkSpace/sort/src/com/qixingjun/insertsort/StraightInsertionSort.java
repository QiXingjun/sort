package com.qixingjun.insertsort;

import java.util.Scanner;

/**
 * @Author XingJun Qi
 * @MyBlog www.qixingjun.tech
 * @Version 1.0.0
 * @Date 2017/3/2
 * @Description 直接插入排序
 * 基本思想:
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，
 * 直至整个序列有序为止。
 *
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 *
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，
 * 所以插入排序是稳定的。
 *
 * 时间复杂度：O（n^2）
 */
public class StraightInsertionSort {

    public static void insertSort(int[] arr){
        int size = arr.length;
        int temp;
        int j;
        for (int i = 0; i < size; i++) {
            temp = arr[i];
            //假如temp比前面的值小，则将前面的值后移
            for (j = i; j>0 && temp < arr[j-1]; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 10;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        insertSort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
