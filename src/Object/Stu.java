package Object;

public class Stu {
    int id;
    byte age;
    String name;

    public static void main(String[] args) {
        Stu stu1 = new Stu();
        stu1.play();
    }

    public void play(){
        System.out.println("i'm playing....");
    }
}

/*

## 内存分析详解
* java虚拟机的内存可以分为3个区域：栈 堆 方法区
* 实际上方法区也是位于堆区中，但它比较特殊
* 方法区又叫静态区，JVM只有一个方法区，被所有线程共享
* 线程之间，栈空间是独立的

## 构造方法
### 要点
* 通过new关键字调用
* 构造器虽然有返回值，但是不能定义返回值类型（返回的类型是当前new的类），不能在构造器里使用return返回某个值
* 如果没有定义构造器，则编译器会自动定义一个无参数的构造函数，如果已定义，则编译器不会自动添加
* 构造器的方法名必须和类名一致

### 其他
* 构造函数也可以重载，根据不同的参数列表，可以做不同的逻辑处理

## GC
* java中将内存区域做了一些区分

### 持久代
* 用于存放静态文件 如Java类 方法等，持久代对垃圾回收没有显著影响

### 年轻代

### 老年代

## 对象创建过程
* 1.分配对象空间，并将对象成员变量初始化为0或空
* 2.执行属性值的显式初始化
* 3.构造方法的执行
* 4.返回对象的地址给相关的变量

### 注意事项
* 在方法中，如果参数列表的参数名出现2义性，在方法体中，如果要使用属性，则需在变量名前加`this.`，如果未加，则代表的是局部变量
* 在方法或构造器中，如果要调用构造器，不能直接使用`constructorName()`的方式调用，而应该是`this()`的方式调用构造器

## 面向对象
### 三大特征：
* 继承 分装 多态

### 封装
* 访问权限修饰符：private default protected public
* 它们的严格顺序从右向左

 */
