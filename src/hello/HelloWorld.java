package hello;

public class HelloWorld {
    public static void main(String[] args) {
//         hello1();
//        int res = varTypeFn1(1, 2);
//        System.out.printf(String.format("%d\n", res));
//        res = 3;
//        System.out.printf(String.format("%d\n", res));
        typeImplicitTrans();
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

需要注意的是，超出范围的强制转型会得到**错误**的结果。



*/
