package sort;

public class SelectSortTest1 {
    public static void main(String[] args) {
        double[] a = {3.0, 1.3, 2.3, 0.3, 4.4, 5.9, 1.35, 0.78, 2.6};
        SelectSort ss1 = new SelectSort();
        ss1.Sort(a);
        for (double x: a) {
            System.out.print(x + " ");
        }
    }
}

class SelectSort {
    public void Sort(double[] ary) {
        int i, j, min;
        for (i = 0; i < ary.length; i++) {
            min = i;
            for (j = i + 1; j < ary.length; j++) {
                if (ary[min] > ary[j])
                    min = j;
            }
            swap(ary, i, min);
        }
    }

    public void swap(double[] ary, int i, int j) {
        double temp;
        temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
}