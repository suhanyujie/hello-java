package hello;

public class HelloWorld {
    public static void main(String[] args) {
        // hello1();
        int res = varTypeFn1(1, 2);
        System.out.printf(String.format("%d\n", res));
        res = 3;
        System.out.printf(String.format("%d\n", res));
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
}

/**
 *
 */
