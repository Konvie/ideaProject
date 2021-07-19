package Card;

import java.io.Flushable;

public class Card {
    public static enum Flush {
        HEART(0),
        SPADE(1),
        DIAMOND(2),
        CLUB(3),
        JOKER(4);

        private  int value;

        Flush(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static Flush fromValue(int value) {    //fromValue确定传进的值是否为Flush枚举类中的一个变量
            for (Flush f : Flush.values()) {
                if (f.getValue() == value) {
                    return f;
                }
            }
            throw new RuntimeException("Unknown flush");
        }
    }

    private Flush flush;        //牌的花色
    private int number;         //牌面大小

    public Card(Flush flush, int number) {
        this.flush = flush;
        this.number = number;
    }   //将传进的参数赋给Card类，以此作为一张牌

    public Flush getFlush() {
        return this.flush;
    }   //获取Card中的花色，花色类型为枚举类

    public int getNumber() {
        return this.number;
    }   //获取Card中的牌面大小

    @Override
    public String toString() {
        return this.flush + " : " + this.number;
    }   //牌的属性面板 花色：牌面
}

