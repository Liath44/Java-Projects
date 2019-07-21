package Merchants;
import Auction.Item;

public abstract class Merchant
    {
    private final int Budget;
    private int Cart;   //as in shopping cart
    private final String FancyPseudonym;

    public Merchant(int B, String F)
        {
        Budget = B;
        Cart = 0;
        FancyPseudonym = F;
        }

    /*public int getBudget()
        {
        return Budget;
        }

    public int getCart()
        {
        return Cart;
        }*/

    public String getFancyPseudonym()
        {
        return FancyPseudonym;
        }

    public void Buy(int a)
        {
        Cart = Cart + a;
        }

    public Boolean AbleToBuy(int a)
        {
        return Budget >= Cart + a;
        }

    public abstract boolean Strategy(Item thing);
    }
