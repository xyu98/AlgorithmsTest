package sort;

public class BubbleTest1 {

    public static void main(String[] args) {
        double[] a = {3.0, 1.3, 2.3, 0.3, 4.4};
        double[] b = {4.1, 0.5, 3.2, 3.7, 0.5};
        BubbleSort1 bs1 = new BubbleSort1(a, 10);
        BubbleSort2 bs2 = new BubbleSort2(b, 10);
        bs1.sort(a);
        bs2.sort(b);
        for (double x: a) {
            System.out.print(x + " ");
        }
        System.out.println(" ");
        for (double x: b) {
            System.out.print(x + " ");
        }
    }

}

//这里用抽象类而非接口，因为BubbleSort和BS1，BS2有明显的从属关系
abstract class BubbleSort {
    public int max_size;
    public double ary[] = new double[max_size]; //声明变量的时候直接初始化OK，单独初始化只能写在方法中
    // 抽象类里可以有构造方法，接口里不能有。但是有参构造方法不能被继承。默认继承父类无参构造的方法。
    // 接口里只能有常量和public static final类型的成员变量且必须显式初始化
    // 接口比抽象类更严格，因为接口必须非常稳定
}

class BubbleSort1 extends BubbleSort{
    BubbleSort1(double ary[], int max_size) {
        this.max_size = max_size;
        this.ary = ary;
    }

    BubbleSort1() {
    }

    public void sort(double ary[]) {
        int i, j;
        for (i = 0; i < ary.length; i++) {
            for (j = i + 1; j < ary.length ; j++) {
                if (ary[i] > ary[j])
                    Function.swap(ary, i, j);
            }
        }
    }
}

// 改进版冒泡算法
class BubbleSort2 extends BubbleSort{
    BubbleSort2(double ary[], int max_size) {
        this.max_size = max_size;
        this.ary = ary;
    }

    BubbleSort2() {
    }

    public void sort(double ary[]) {
        int i, j;
        boolean flag = true;
        for (i = 0; i < ary.length && flag; i++) {
            flag = false;
            //若没有数据交换，则flag一直玩false，也就是说从当前i往后已经排好了，此时直接完成排序即可
            for (j = i + 1; j < ary.length ; j++) {
                if (ary[i] > ary[j]) {
                    Function.swap(ary, i, j);
                    flag = true;
                }
            }
        }
    }
}

class Function {
    public static void swap(double ary[], int i, int j) {
        double temp;
        temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
}