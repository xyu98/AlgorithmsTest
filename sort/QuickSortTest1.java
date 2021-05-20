package sort;

public class QuickSortTest1 {
    public static void main(String[] args) {
        double[] a = {3.0, 1.3, 2.3, 0.3, 4.4};
        double[] b = {4.1, 0.5, 3.2, 3.7, 0.5};
        quickSort(a,0,a.length - 1);
        for (Double x: a) {
            System.out.println(x);
        }
    }

    public static void quickSort(double[] x, int low, int high) {
        if (low >= high) return;  // 注意终止条件！！
        int i = low, j = high;
        double cur = x[i];
        while (i < j) {
            while (i < j && x[j] >= cur) j--;
            if (i < j) {
                x[i] = x[j];
                i++;
            }
            while (i < j && x[i] < cur) i++;
            if (i < j) {
                x[j] = x[i];
                j--;
            }
        }
        x[i] = cur;
        quickSort(x, low, i - 1);
        quickSort(x, i + 1, high);
    }
}
