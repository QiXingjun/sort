//package com.qixingjun.insertsort;
//
//import java.util.Scanner;
//
///**
// * @Author XingJun Qi
// * @MyBlog www.qixingjun.tech
// * @Version 1.0.0
// * @Date 2017/3/2
// * @Description
// * 希尔排序又叫缩小增量排序
// * 1、基本思想：
// * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
// * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
// *
// * 2、操作方法：
// * 1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
// * 2、按增量序列个数k，对序列进行k 趟排序；
// * 3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
// * 分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，
// * 表长度即为整个序列的长度。
// *
// * 时间复杂度：O（n^2）.
// */
//public class ShellSort {
//
//    public static void shellSort(){
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        final int N = 10;
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        shellSort(arr);
//        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//}
