package Object;

public class Access {
    public static void main(String[] args) {
        Human h1 = new Human();
        h1.setName("samuel001");
        System.out.println(h1.getName());
    }


}

class Human {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/*
### 封装
* 访问权限修饰符：private default protected public
* 它们的严格顺序从右向左

#### private
* 表示私有，只有自己能访问

#### default
* 表示没有修饰符修饰，只有当前包的类能访问

#### protected
* 表示被同一个包的类以及其他包中的子类访问

#### public
* 表示可以被该项目中的所有包中的所有类访问


 */

