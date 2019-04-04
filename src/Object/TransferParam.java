package Object;

public class TransferParam {
    String other;

    public TransferParam(String other){
        this.other = other;
    }

    public static void main(String[] args) {
        TransferParam t1 = new TransferParam("hello1");
        System.out.println("t1'value is:"+ t1.other);
        t1.testChangeParam(t1);
        System.out.println("t1'value is:"+ t1.other);
    }

    /**
     * 值传递，传递的是地址，所以可以通过值传递，修改对象中的值
     * @param t1
     */
    public void testChangeParam(TransferParam t1){
        t1.other = "after changed";
    }
}


/*
## 传值机制
* 值传递，传递的是地址，所以可以通过值传递，修改对象中的值


 */
