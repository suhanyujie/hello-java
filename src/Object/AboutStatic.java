package Object;

public class AboutStatic {
    static int id;
    static String name;
    String other;

    static {
        System.out.println("this is Class static block...");
        id = 1;
        name = "samuel";
        printOther();
    }

    public static void printOther(){
        System.out.println(name);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        AboutStatic a1 = null;
    }

}

/*
## static
* `static`修饰的成员变量和方法，从属于类。普通变量和方法从属于对象。
* 静态变量存放于方法区，和对象的存放区域不同！
* `static`声明的语句块，在类初始化时，会执行，如main中的`AboutStatic a1 = null;`会出现类的初始化
*






 */
