package search;

public class BinarySearchTest1 {
    public static void main(String[] args) {
        double[] arytest = {0.3, 0.78, 1.3, 1.35, 2.3, 2.6, 3.0, 4.4, 5.9 };
        BinarySearch1 bs1 = new BinarySearch1(arytest, 0.78);
        int high = arytest.length - 1;
        System.out.println(bs1.BinarySearchNonRecursive());
        System.out.println(bs1.BinarySearchRecursive(0, high, high / 2));
    }
}

// 非递归二分查找
// 注意，这个类的如果有显式初始化的初始变量，则先运行
// 故利用ary.length显示初始化属性变量是不行的，此时构造方法还没有执行
class BinarySearch1 {
    public double[] ary;
    public double target;

    int low = 0;

    public BinarySearch1(double[] ary, double target) {
        this.ary = ary;
        this.target = target;
    }

    public BinarySearch1() {
    }

    public int BinarySearchNonRecursive() {
        int high = ary.length - 1;  // 注意这句一定要写在方法里面，不能写在外面
        int mid = (low + high) / 2;
        int i;
        for (i = 0; i < ary.length / 2; i++) {
            if (ary[mid] < target) {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else if (ary[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            else
                return mid;
        }
        return mid;
    }

    public int BinarySearchRecursive(int low, int high, int mid) {
        if (ary[mid] < target) {
            low = mid + 1;
            mid = (low + high) / 2;
        }
        else if (ary[mid] > target) {
            high = mid - 1;
            mid = (low + high) / 2;
        }
        else {
            return mid;
        }
        return BinarySearchRecursive(low, high, mid);
    }
}