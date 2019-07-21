package Merchants;
import Auction.Item;

public class Sentimentalist extends Merchant
    {
    private final String MyBelovedHomeland;

    public Sentimentalist(int B, String F, String M)
        {
        super(B, F);
        MyBelovedHomeland = M;
        }

    public boolean Strategy(Item thing)
        {
        return MyBelovedHomeland.equals(thing.getCountryOfOrigin());
        }
    }
