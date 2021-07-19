package Card;

public class PokerGame {
    public static void main(String[] args) {
        Poker poker = new Poker();

        poker.deal();

        System.out.println("===========deck a===========");
        System.out.println(poker.getDeckA());

        System.out.println("===========deck b===========");
        System.out.println(poker.getDeckB());

        System.out.println("===========deck C===========");
        System.out.println(poker.getDeckC());
    }
}
