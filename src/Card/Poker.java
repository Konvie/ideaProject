package Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Poker {
    private static final int TOTAL_CARDS = 54;

    private Deck deckA;

    private Deck deckB;

    private Deck deckC;

    private Random rand;

    public Poker() {
        this.deckA = new Deck();
        this.deckB = new Deck();
        this.deckC = new Deck();

        this.rand = new Random();
    }

    public Deck getDeckA() {
        return this.deckA;
    }

    public Deck getDeckB() {
        return this.deckB;
    }

    public Deck getDeckC() {
        return this.deckC;
    }

    public void deal() {
        this.rand.setSeed(System.currentTimeMillis());

        deckA.reset();      //清空这仨兄弟的手牌，？还想出老千？
        deckB.reset();
        deckC.reset();

        List<Integer> cache = new ArrayList<>();
        for (; cache.size() < Poker.TOTAL_CARDS;) {
            int num = rand.nextInt(TOTAL_CARDS);//进行模运算，计算结果必为0-53，此处num相当于给所有手牌进行了一个编号
            if (Poker.contains(cache, num))     //此处的contains为自己创建的方法，转到下面查看
                continue;                       //如果已经包含，进行下一次循环
            cache.add(num);                     //不包含，就把num添加到容器中,
        }   //

        for (int i = 0; i < Poker.TOTAL_CARDS / 3; i++) {
            int num = cache.get(i);     //获取cache容器中存储的手牌编号
            Poker.deal(deckA, num);
        }

        for (int i = 18; i < 2 * Poker.TOTAL_CARDS / 3; i++) {
            int num = cache.get(i);
            Poker.deal(deckB, num);
        }

        for (int i = 36; i < Poker.TOTAL_CARDS; i++) {
            int num = cache.get(i);
            Poker.deal(deckC, num);
        }
    }   //开始打牌

    private static boolean contains(List<Integer> cache, int num) {
        return cache.contains(num);
    }   //套娃容器中的方法，好像是判断是否包含

    private static void deal(Deck deck, int num) {//利用编号来获取手牌的花色和牌面
        if (num < TOTAL_CARDS - 2)
            deck.add(Card.Flush.fromValue(num % 4), num / 4 + 1);   //相当于编号0-3为A
        else {
            if (num == TOTAL_CARDS - 2)
                deck.add(Card.Flush.JOKER, 0);
            else
                deck.add(Card.Flush.JOKER, 1);
        }
    }
}
