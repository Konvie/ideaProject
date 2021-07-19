package Swaper;

class ValuerHolder {
    private int value;

    public ValuerHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Swaper {
    private static void swap_i(int a, int b) {
        int c = a;
        a = b;
        b = c;
    }

    private static void swap_s(String s, String t) {
        String x = s;
        s = t;
        t = x;
    }

    private static void swap_o(ValuerHolder u, ValuerHolder v) {
        int x = u.getValue();
        u.setValue(v.getValue());
        v.setValue(x);
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a = " + a + ", b = " + b);

        swap_i(a, b);                                   //形参无法完成交换
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + a + b);         //字符串连接

        String s = "Hello";
        String t = "World";
        System.out.println("s = " + s + ", t = " + t);

        swap_s(s, t);                                   //同上
        System.out.println("s = " + s + ", t = " + t);

        ValuerHolder u = new ValuerHolder(30);
        ValuerHolder v = new ValuerHolder(40);
        System.out.println("u = " + u.getValue() + ", v = " + v.getValue());

        swap_o(u, v);
        System.out.println("u = " + u.getValue() + ", v = " + v.getValue());
    }
}

/* 结果
* a = 10, b = 20

* swap_i(a, b);
* a = 10, b = 20
* a + b = 1020

* swap_s(s, t);
* s = Hello, t = World
* s = Hello, t = World

* swap_o(u, v);
* u = 30, v = 40
* u = 40, v = 30
*/