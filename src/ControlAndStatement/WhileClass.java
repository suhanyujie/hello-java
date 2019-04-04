package ControlAndStatement;

public class WhileClass {
    public static void main(String[] args) {
//        testWhile();
        testLabel();
    }

    /**
     * 用于循环语句前的label
     */
    public static void testLabel(){
        int i1 = 0;
        int i2 = 0;
        label1: do {
            i1++;
            System.out.println();
            if (i1 > 4) {
                break;
            }
            label1_1: while (true) {
                System.out.print(i2);
                i2++;
                if (i2>3) {
                    i2 = 0;
                    continue label1;
                }
            }
        } while (true);
    }

    public static void testWhile(){
        int i1 = 1;
        while (i1 == 1) {
            if (i1 > 5)break;
            System.out.println("the line number is" + i1);
            i1++;
        }
    }
}

/**
 *
 ## while控制语句
 * 和PHP不同的是，在java中，while的条件必须是布尔表达式或者布尔值，不可以是其他的
 * 但是在PHP中，就比较灵活，可以是整形，字符串，空值等等

## 标签 label
 *  java中虽然有goto作为保留关键字，但并没有使用它。但有很类似的label
 *  “标签”是指后面跟一个冒号的标识符，例如：“label:”。对Java来说唯一用到标签的地方是在循环语句之前。



 *
 */

