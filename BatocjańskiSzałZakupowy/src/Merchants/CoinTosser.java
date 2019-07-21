package Merchants;
import java.util.Random;
import Auction.Item;

public class CoinTosser extends Merchant
    {
    private static final Random r = new Random();

    public CoinTosser(int B, String F)
        {
        super(B, F);
        }

    public boolean Strategy(Item thing)
        {
        return r.nextBoolean();
        }
    }
