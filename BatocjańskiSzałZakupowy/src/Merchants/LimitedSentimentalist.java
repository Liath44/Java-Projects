package Merchants;
import Auction.Item;

public class LimitedSentimentalist extends Sentimentalist
    {
    private final int ItemLimit;
    private int ActLimit;

    public LimitedSentimentalist(int B, String F, String M, int I)
        {
        super(B, F, M);
        ItemLimit = I;
        ActLimit = 0;
        }

    public boolean Strategy(Item thing)
        {
        if(AbleToBuy(thing.getPrice()) && super.Strategy(thing) && ItemLimit >= ActLimit)
            {
            ++ActLimit;
            return true;
            }
        else
            {
            return false;
            }
        }
    }
