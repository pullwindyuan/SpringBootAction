package nuc.jyg.chapter8.test;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 2:27 2017/7/14.
 * @Descrip
 */
public class TestStatic {

    private static int i = 1;

//    private int i = 1; // static方法不能调用非static的变量

    static {

    }

    public static void main(String[] args) {
        System.out.println(i);
    }

    public void test() {
        System.out.println(i);
    }
}
