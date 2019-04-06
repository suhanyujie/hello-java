package Object;

public class TestCastTo {
    {
        System.out.println("this is static block");
    }

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        System.out.println("this is TestCastTo something...");
        Animal a1 = new Animal();
        a1.eat();
        Dog d1 = new Dog();
        // 将Dog转为Animal类型
        Animal d2 = (Animal)d1;
        d2.eat();
        // 将Animal类型转型为Dog
        Dog t1 = (Dog)d2;
        t1.goHome();
    }
}

class Animal {
    public void eat(){
        System.out.println("animal eatting...");
    }
}

class Dog extends Animal {
    public void goHome(){
        System.out.println("dog will go home...");
    }
}

/*
## 对象的类型转换




 */
