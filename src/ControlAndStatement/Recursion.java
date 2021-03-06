package ControlAndStatement;

public class Recursion {
    static int somePro = 0;
    public static void main(String[] args) {
        int res = testRev(somePro);
        System.out.println(res);
    }

    public static int testRev(int i1){
        if (i1<20) {
            return testRev(i1+1);
        }
        System.out.println(i1);

        return i1+1;
    }
}

/**
 *

 ## 递归
 *  递归是一种常见的解决问题的方法，即把问题逐渐简单化。递归的基本思想就是“自己调用自己”，一个使用递归技术的方法将会直接或者间接的调用自己。
 *  递归结构包括2个部分：
    * 定义递归头
    * 递归体

 ### 递归的缺陷
 * 使用递归，会使程序体看起来结构简单
 * 在要求高性能的情况下尽量避免使用递归，递归调用既花时间又耗内存
 * 注意：任何能用递归解决的问题也能使用迭代解决。当递归方法可以更加自然地反映问题，并且易于理解和调试，并且不强调效率问题时，可以采用递归;


 *
 */
