package com.yis.sort;

/**
 * @author YeShuai
 * @date 2021/4/20
 */
public class Sort {

    /**
     * 将一个int类型数组转化为字符串
     *
     * @param arr
     * @param flag
     * @return
     */
    private static String arrayToString(int[] arr, String flag) {
        String str = "数组为(" + flag + ")：";
        for (int a : arr) {
            str += a + "\t";
        }
        return str;
    }

    // public static void main(String[] args) {
    //     Sort s = new Sort();
    //     int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
    //     System.out.println(arrayToString(num, "未排序"));
    //     s.quickSort(num, 0, num.length - 1);
    //     System.out.println(arrayToString(num, "排序"));
    // }


    /**
     * 1.快速排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)： 快速排序的递归深度最好（平均）为 O(logN) ，最差情况（即输入数组完全倒序）为 O(N)。
     *
     * @param arr
     * @return
     */
    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为1时，终止
        if (l >= r) {
            return;
        }
        // （以 arr[l] 作为基准数划分）,数组中比key小的放在左边，比key大的放在右边
        //设置最左边的元素为基准值key
        int key = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            // 右指针的数字 >= 左边的数字,右指针 j 往左移位,直到遇到比key小的值
            while (i < j && arr[j] >= key) {
                j--;
            }
            // 左指针的数字 >= 左边的数字,右指针 i 往右移位,直到遇到比key大的值
            while (i < j && arr[i] <= key) {
                i++;
            }
            // 交换左右指针指向的元素
            swap(arr, i, j);
        }
        // 该轮交换完成后，将key换到左指针结束位置（中间值位置）
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Double s = 2.0000;
        Double res = 1.0000;
        int n = 10;
        for (int i = 0; i < n; i++) {
            res = res * s;
            System.out.println(res);
        }
    }
}
