package Object;

public class TestArray {
    public static void main(String[] args) {
        int[] a1 = new int[4];
        for (int i=0;i<4;i++) {
            a1[i] = i*12;
        }
        for (int i=0;i<a1.length;i++) {
            System.out.println(a1[i]);
        }
        System.out.println("--------------------------");
        // foreach写法
        for (int m:a1){
            System.out.println(m);
        }
    }
}

/*
## 数组
* 数组是相同类型数据的有序集合。数组秒数的是相同类型的若干个数据，按照一定的先后次序排列组合而成。
* 其中，每一个数据称作一个元素，每个元素可以通过一个索引（下标）来访问他们

### 3个基本特点
* 长度是确定的。数组一旦被创建，它的大小就是不可改变的
* 其元素必须是相同类型，不允许出现混合类型
* 数组可以是任何数据类型，包括基本类型和引用类型

### foreach
* 针对foreach的使用，一般是读取数组的时候使用，如果对数组修改，则使用for循环

### 其他
* 数组变量属于引用类型，数组也可以看成是对象，数组中的每个元素相当于该对象的成员变量因此声明一个数组，一般用`new`关键字


 */
