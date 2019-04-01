package identifier;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        scanner1();
    }

    public static void scanner1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter your name:");
        String name = scan.nextLine();
        System.out.println("please enter your age:");
        String age = scan.nextLine();
        System.out.println("please enter your weight:");
        String wei = scan.nextLine();
        System.out.println("your name is:"+name);
    }
}
