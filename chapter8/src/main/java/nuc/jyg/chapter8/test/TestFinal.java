package nuc.jyg.chapter8.test;

import java.util.ArrayList;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 2:14 2017/7/14.
 * @Descrip
 */
public class TestFinal {
    public static void main(String[] args) {
        System.out.println(new TestFinal().example());
    }

    public void f1(final int i) {
        //i++;    //i是final类型的,值不允许改变的.
        System.out.print(i);
    }

    public String example() {
        final ArrayList<String> example = new ArrayList<String>();
        example.add("Hello, World!");
        final String foo = example.get(0);
        return foo.toLowerCase();
    }
}