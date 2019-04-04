package Object;

public class TestExtends {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.say();
        System.out.println(s1 instanceof Student);
        System.out.println(s1 instanceof Person);
        System.out.println(s1 instanceof Object);
        s1.testOverride();
    }

}

class Person {
    String name;

    public void say(){
        System.out.println("saying something...");
    }

    public void testOverride(){
        System.out.println("this is Person's func");
    }
}

class Student extends Person {
    public String major;
    public void testOverride(){
        System.out.println("the func of testOverride has been override...");
    }

}


/*
## 继承
* 父类也称作超类 基类 派生类
* Java中只有单继承，不像C++中有多继承。
* 接口可以多继承。
* Java中的类一定有一个继承的父类，如果没有显示的进行`extends`，则默认继承`Object`

## 重写
### 重写的三个要点
* 方法名 形参列表要相同
* 返回值类型和声明异常类型，子类小于等于父类
* 访问权限，子类大于等于父类

## super
* 可以使用`super`关键字来对父类中的方法和属性进行使用，类似于PHP中的`parent`
* 在所有的构造方法中，第一句一定会调用`super()`，如果写，则调用。如果不写，则默认调用
*

 */
