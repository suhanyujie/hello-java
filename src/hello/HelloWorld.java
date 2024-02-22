package hello;

import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
//         hello1();
//        int res = varTypeFn1(1, 2);
//        System.out.printf(String.format("%d\n", res));
//        res = 3;
//        System.out.printf(String.format("%d\n", res));
//        typeTrans1();
//        concatStr1();
//        multiLineStr1();
//        defArray1();
//        strArr1();
        traverseArr1();
//        readInput1();
//        switchCases();
//        switchAsExpressive();
    }

    /**
     * print hello world
     */
    public static void hello1() {
        String s1 = "samuel";
        System.out.println("hello world..." + s1);
    }

    /**
     * 基本类型 int
     *
     * @param a int
     * @param b int
     * @return int
     */
    public static int varTypeFn1(int a, int b) {
        return a + b;
    }

    // 声明 float 类型，需要在数值后加 `f`
    public static void typeFloat1() {
        float f1 = 1.0f;
        System.out.printf(String.format("%v\n", f1));
    }

    // 声明 float 类型，需要在数值后加 `f`
    public static void typeImplicitTrans() {
        int a = 1;
        short b = 1;
        var s = a + b;
        System.out.printf(String.format("隐式转换：%s\n", s));
    }

    // 类型转换
    public static void typeTrans1() {
        int a0 = 1;
        short b = 1;
        a0 = (int) b;
        System.out.printf("类型转换：%s\n", a0);

        int a = 2147483641;
        short a2 = (short) a;
        System.out.printf("超出范围的类型转换 get：%d, expect:%d\n", a2, 2147483641);
    }

    // 字符串若与数值变量拼接，会先将数值转换为字符串，再进行拼接
    public static void concatStr1() {
        int a = 1;
        String s1 = "hell world ";
        String s2 = s1 + a;
        System.out.printf("字符串连接 %s\n", s2);
    }

    // 多行字符串
    public static void multiLineStr1() {
        String s1 = """
                hello
                world
                .
                """;
        System.out.printf("多行字符串 %s\n", s1);
    }

    // 定义数组
    public static void defArray1() {
        int[] arr1 = new int[5];
        int[] arr2 = new int[]{1, 2};
        int[] arr3 = {1, 2};
        arr1[0] = arr1[1] = 1;
        System.out.printf("数组：%s, len:%d\n", Arrays.toString(arr1), arr1.length);
    }

    // 遍历数组
    public static void traverseArr1() {
        String[] sArr = {"hello", "world", "."};
        System.out.printf("数组：%s, len:%d\n", Arrays.toString(sArr), sArr.length);

        // for each 遍历
        for (String item : sArr) {
            System.out.println(item);
        }
        for (int idx = sArr.length - 1; idx >= 0; idx--) {
            System.out.println(sArr[idx]);
        }
    }

    public static void strArr1() {
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s);
    }

    public static void readInput1() {
        Scanner s1 = new Scanner(System.in);
        String res = "";
        while (s1.hasNext()) {
            String tmpStr = s1.nextLine();
            System.out.printf("input: %s\n", tmpStr);
            if (tmpStr.equals("exit")) {
                break;
            }
        }
        System.out.print("input end...\n");
    }

    // switch 使用时，记得加上 `break`！
    public static void switchCases() {
        int op = 2;
        switch (op) {
            case 1:
                System.out.print("1...\n");
            case 2:
                System.out.print("2...\n");
            case 3:
                System.out.print("3...\n");
                break;
            case 4:
                System.out.print("4...\n");
        }
        System.out.print("end...\n");
    }

    // switch 作为表达式使用
    public static void switchAsExpressive() {
        int op = 3;
        String res = switch (op) {
            case 1 -> "1";
            case 2 -> "2";
            case 3 -> {
                yield "3"; // 使用 yield 返回一个值作为 switch 表达式的值
            }
            default -> "0";
        };
        System.out.printf("switch res: %s\n", res);
    }
}

/*

## 基本数据类型
* 整数类型 byte（1 字节）, short（2 字节）, int（4 字节）, long（8 字节）
* 浮点数：float（4 字节）, double（8 字节）
* 字符类型：char（2 字节）
* 布尔：boolean（1 字节）

需要注意的是，声明浮点数时，如果不带 `f`，直接赋值一个浮点数，则编译器视其为 double 类型。如下：

```
float f1 = 1.0; // 被视为 double 类型，不能赋值给 float 变量
float f2 = 1.0f; // 声明时带上 f，才被视为 float 类型
```

布尔类型只有 true，false 两种值，理论上 1bit 就可以表示，但 java 中，boolean 被表示为 4 字节整数。

字符类型，不仅可以表示标准的 ASCII 值，还可以表示范围更大的 Unicode 字符。这一点和 Rust 中的[字符类型](https://doc.rust-lang.org/stable/book/ch03-02-data-types.html#the-character-type)相似。

## var 关键字
用于辅助定义变量，java 定义变量时，标识符前是类型名，有时候类型名很长，可以使用 var 替代，并通过编译器进行推导实际的变量类型。

## 位移运算
byte 和 short 类型位移运算时，会先转换为 int 再进行位移运算。

## 运算符优先级
优先级从高到低排列：

* `()`
* `!`, `~`, `++`, `--`
* `*`, `/`, `%`
* `+`, `-`
* `<<`, `>>`, `>>>`
* `&`
* `|`
* `+=`, `-=`, `*=`, `/=`, `=`

## 类型提升和强制转换
和大多数编程语言一样，java 中也存在变量的隐式转换和作用域提升。这都是为了在开发时，有更多的便利。

类型转换时，需要注意的是，超出范围的强制转型会得到**错误**的结果。例如：

```java
int a = 2147483641;
        short a2 = (short) a;
        // get: -7
        System.out.printf("超出范围的类型转换 get：%d, expect:%d\n", a2, 2147483641);
```

## 字符串

### 字符串拼接
字符串若与数值变量拼接，会先将数值转换为字符串，再进行拼接

### 特殊的定界符
java 中的字符串可以使用 `"""` 定义字符串，优点是定义多行字符串时，可读性更好。

```java
String s1 = """
hello
world
.
""";
```




*/
