package sort;

import java.util.Arrays;

public class MergeSortTest1 {
    public static void main(String[] args) {
        double[] a = {3.0, 1.3, 2.3, 0.3, 4.4};
        double[] b = {4.1, 0.5, 3.2, 3.7, 0.5};
        sort(a,0,a.length - 1);
        for (Double x: a) {
            System.out.println(x);
        }
    }

    public static void sort(double[] x, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        sort(x, low, mid);
        sort(x, mid + 1, high);
        // 如果x[mid] <= x[mid + 1]，则不用merge
        if (x[mid] > x[mid + 1]) merge(x, low, mid, high);
    }

    public static void merge(double[] x, int low, int mid, int high) {
        int i = low, j = mid + 1;
        double[] xx = Arrays.copyOfRange(x, low, high + 1);
        for (int k = low; k <= high; k++) {
            //前两个分支是临近结束时的条件，k循环一开始不会走前两个分支（走后两个）
            if (i > mid) {  //如果左半部分元素已经全部处理完毕（均放置于x的左半部分）
                            //此时k位于x的**右半部分**，将**右指针j**所指元素（一定是最大的几个）放到当前位置
                x[k] = xx[j - low];
                j++;
            }
            else if (j > high) { //如果xx右半部分元素已经全部处理完毕（均放置于x的左半部分）
                                 //此时k位于x的**右半部分**，将**左指针i**所指元素（一定是最大的几个）放到当前位置
                x[k] = xx[i - low];
                i++;
            }
            //后两个分支的核心思想就是比较左右指针i，j所指的元素，把较小的一个放到当前位置
            else if (x[i - low] < x[j - low]) { //左半部分所指元素<右半部分所指元素，把左指针i所指的元素放到当前位置，i++
                x[k] = xx[i - low];
                i++;
            }
            else {  //左半部分所指元素>=右半部分所指元素，把右指针j所指的元素放到当前位置，j++
                x[k] = xx[j - low];
                j++;
            }
        }
    }
}
