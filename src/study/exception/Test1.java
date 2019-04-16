package study.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) {
        testAException();
    }

    public static void testAException(){
        int b = 0;
        int res = 0;
        try {
            res = 2/b;
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return;
        } finally {
            System.out.println(res);
        }
    }

    /**
     * 读文件内容
     * 注意：方法重写中声明异常原则：子类重写父类方法时，如果父类方法有声明异常，那么子类声明的异常范围不能超过父类声明的范围。
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readFile(String filename) throws FileNotFoundException, IOException {
        FileReader in = new FileReader(filename);
        try {
            int tem = in.read();
            while (tem != -1) {
                System.out.println((char)tem);
                tem = in.read();
            }
        } finally {
            in.close();
        }
    }
}

class Test1_1  extends Test1 {
    public static void main(String[] args) {
        try {
            readFile();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readFile () throws IOException,NullPointerException,FileNotFoundException {
        try {
            throw new IOException("io error...");
        }catch (Exception e) {
            throw e;
        }
        // System.out.println("this is son's function...");
    }
}

/*

## 异常
* 软件程序在运行过程中，遇到例外的情况，我们称之为异常，英文是：Exception
* 异常处理，就是指程序在出现问题时依然可以正确的执行完

### java对异常的处理过程
* 1. 抛出异常：在执行一个方法时，如果发生异常，则这个方法生成代表该异常的一个对象，停止当前执行路径，并把异常对象提交给JRE。
* 2.捕获异常：JRE得到该异常后，寻找相应的代码来处理该异常。JRE在方法的调用栈中查找，从生成异常的方法开始回溯，直到找到相应的异常处理代码为止。

### 异常类
* JDK 中定义了很多异常类，这些类对应了各种各样可能出现的异常事件，所有异常对象都是派生于Throwable类的一个实例
* Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为`java.lang.Throwable`，`Throwable`下面又派生了两个子类：`Error`和`Exception`
    * Error是程序无法处理的错误，表示运行应用程序中较严重问题。
    * Exception类是所有异常类的父类，其子类对应了各种各样可能出现的异常事件。 通常Java的异常可分为：
        * `RuntimeException` 运行时异常
        * `CheckedException` 已检查异常
* 除此之外，还可以自己定义异常处理类

### RuntimeException
* 在方法抛出异常之后，运行时系统将转为寻找合适的异常处理器(exception handler)。潜在的异常处理器是异常发生时依次存留在调用栈中的方法的集合。当异常处理器所能处理的异常类型与方法抛出的异常类型相符时，即为合适的异常处理器。
* 运行时系统从发生异常的方法开始，依次回查调用栈中的方法，直至找到含有合适异常处理器的方法并执行。当运行时系统遍历调用栈而未找到合适的异常处理器，则运行时系统终止。同时，意味着Java程序的终止。

### CheckedException
* 所有不是RuntimeException的异常，统称为Checked Exception，又被称为“已检查异常”，如IOException、SQLException等以及用户自定义的Exception异常。 这类异常在编译时就必须做出处理，否则无法通过编译

### catch
* 每个try语句块可以伴随一个或**多个catch语句**，用于处理可能产生的不同类型的异常对象。

### finally
* 有些语句，不管是否发生了异常，都必须要执行，那么就可以把这样的语句放到finally语句块中。
* 通常在finally中关闭程序块已打开的资源，比如：关闭文件流、释放数据库连接等。

### try-catch-finally语句块的执行过程
* 程序首先执行可能发生异常的try语句块。如果try语句没有出现异常则执行完后跳至finally语句块执行;
* 如果try语句出现异常，则中断执行并根据发生的异常类型跳至相应的catch语句块执行处理。
* catch语句块可以有多个，分别捕获不同类型的异常。
* catch语句块执行完后程序会继续执行finally语句块。
* finally语句是可选的，如果有的话，则不管是否发生异常，finally语句都会被执行。

#### finally注意事项
* 即使try和catch块中存在return语句，finally语句也会执行。是在执行完finally语句后再通过return退出。
* `finally`语句块只有一种情况是不会执行的，那就是在执行finally之前遇到了System.exit(0)结束程序运行。

### 异常机制本质
* 当程序出现错误，程序安全退出的机制。

## 写代码注意的点：
* 1. 逻辑代码和错误处理代码不要放一起!


 */
