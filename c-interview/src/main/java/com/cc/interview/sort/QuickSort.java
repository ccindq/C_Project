package com.cc.interview.sort;

/**
 * 排序：从小到大
 * 它的平均运行时间为O(NlogN)。最坏的时间复杂度为O(N^2)
 * 1）快速排序基本步骤：
 * a) 如果数据集S中的元素个数为0或1，则返回。
 * b) 选取S中的一个元素v，我们称这个元素v为pivot支点。
 * c) 把S-{v}分成两部分S1 = {x<=v} ，S2 = {x>=v}。
 * d) 返回quicksort(S1) ， v， quicksort(S2)。
 *
 * @author changcheng
 * @since 2021-05-19 8:09
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr=new int[]{12,20,5,16,15,1,30,45};
        quickSort(arr,0,7);
        for(int i:arr){
            System.out.println(i);
        }
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static  int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                for(int n:arr){
                    System.out.println(n);
                }
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
