package Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private static final int MAX_NUM = 18;  //手牌上限为18

    private final List<Card> cards;     //cards为手牌集合，为cards创建一个容器

    public Deck() {
        cards = new ArrayList<>();
    }       //为cards分配空间（数组列表啥也没有）

    public void add(Card.Flush flush, int number) {
        add(new Card(flush, number));
    }       //将花色和数组组合为一个Card类，套娃下面的重载函数

    public void add(Card card) {
        cards.add(card);
    }       //套娃cards容器自带的add函数，将一个card纳入手牌

    public boolean contain(Card.Flush flush, int number) {
        for (Card c : cards) {
            if (c.getFlush() == flush && c.getNumber() == number)
                return true;
        }
        return false;
    }   //判断cards中是否包含传递进来的特定花色和牌面的牌

    public boolean isFull() {
        return cards.size() == Deck.MAX_NUM;
    }   //判满

    public void reset() {
        cards.clear();
    }       //清空手牌

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Card c : cards) {
            if (sb.length() > 0)
                sb.append(", ");
            sb.append(c);
        }   //先输出一个","在输出cards中储存的一张手牌，若cards中没有手牌，就不输出","

        return sb.toString();
    }

}
