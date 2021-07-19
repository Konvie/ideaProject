package Greeter;
interface Gentleman {
    default void greet() {
            System.out.print("Hello, from Gentleman");
        }
}

class Grandpa implements Gentleman {    //实现父类，子类不可以覆盖父类的方法或者变量。即使子类定义与父类相同的变量或者函数，也会被父类取代
    public Grandpa() {
        System.out.println("Grandpa constructor");
    }
}

class Parent extends Grandpa {          //可以实现父类，也可以调用父类初始化 this.parent()。而且会覆盖父类定义的变量或者函数
    public Parent() {
        System.out.println("Parent constructor");
    }

    @Override
    public void greet() {
        System.out.print("Hello, from Parent");
    }
}

class Child extends Parent {            //可以实现父类，也可以调用父类初始化 this.parent()。而且会覆盖父类定义的变量或者函数
    public Child() {
        System.out.println("Child constructor");
    }

    @Override
    public void greet() {
        super.greet();                  //子类用super() 来调用父类的无参构造器
        System.out.print(" Hello, from Child");
    }
}

public class Greeter {
    public static void main(String[] args) {
        Gentleman g=new Grandpa();
        Gentleman p=new Parent();
        Gentleman c=new Child();

        g.greet();
        System.out.println();

        p.greet();
        System.out.println();

        c.greet();
        System.out.println();
    }
}
/*
Grandpa constructor
Grandpa constructor
Parent constructor
Grandpa constructor
Parent constructor
Child constructor
Hello, from Gentleman
Hello, from Parent
Hello, from Parent Hello, from Child
*/