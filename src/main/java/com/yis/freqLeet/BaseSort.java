package com.yis.freqLeet;

import java.util.Arrays;

/**
 * 排序
 *
 * @author YeShuai
 * @date 2021/5/10
 */
public class BaseSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 9, 3, 2};
        int[] ints = quickSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        // 1.遍历n次
        for (int i = 0; i < arr.length; i++) {
            // 2.每次遍历时，最后一位为最大值，比较范围缩减1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 3.比较元素大小，交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * 希尔排序
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int len = arr.length;
        // 1. 初始化增量
        int gap = len / 2;
        while (gap > 0) {
            // 2. 遍历每个增量对应的分组
            for (int i = gap; i < len; i++) {
                int temp = arr[i]; // 分组最后一个的元素
                int preIndex = i - gap; // 前一个跨度的元素
                // 3.分组内使用跨度插入排序
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
    }

    /**
     * 归并排序 (递归思想)
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        // 双指针 逐步比对left和right的元素
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) { // left添加完成，后续直接添加right
                result[index] = right[j++];
            } else if (j >= right.length) { // right添加完成，后续直接添加left
                result[index] = left[i++];
            } else if (left[i] > right[j]) { // 逐步比对left和right的元素，小的插入result数组，指针加一
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        partition(arr, 0, arr.length - 1);
        return arr;
    }

    public static void partition(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 1.随机选取数组元素作为中心点
        int pivotIndex = (int)(left + Math.random() * (right - left + 1));
        // 2.将中心元素放到最右边
        swap(arr, pivotIndex, right);
        int i = left;
        int j = right - 1;
        // 3.比中心元素小的放左边，大的放右边
        while (i <= j) {
            if (arr[i] <= arr[right]) {
                i++;
            } else {
                swap(arr, i, j);
                j--;
            }
        }
        // 4.将中心元素 从右边换回到中心位置
        swap(arr, i, right);
        partition(arr, left, i - 1);
        partition(arr, i+1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
