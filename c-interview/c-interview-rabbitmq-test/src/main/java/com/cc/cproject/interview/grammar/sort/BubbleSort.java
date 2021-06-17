package com.cc.cproject.interview.grammar.sort;

/**
 * 从第一个数字开始，跟后面的所有数据都比较一遍，比较相邻的两个数字，然后按要求，交换相应顺序。
 *
 * @author changcheng
 * @since 2021-05-19 8:09
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        //比较n次
        for (int i = 0; i < arr.length; i++) {
            //从第一个开始，两两比较，先选出一个最大的，交换到最后
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
