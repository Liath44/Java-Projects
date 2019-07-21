package Merchants;
import Auction.Item;

public class Historian extends Merchant
    {
    private final int FavBeginning;
    private final int FavEnd;

    public Historian(int B, String F, int FB, int FE)
        {
        super(B, F);
        FavBeginning = FB;
        FavEnd = FE;
        }

    public Historian(int B, String F, int Century)
        {
        super(B, F);
        FavBeginning = (Century - 1) * 100 + 1;
        FavEnd = Century * 100;
        }

    public boolean Strategy(Item thing)
        {
        return (FavBeginning <= thing.getProductionYear() && FavEnd >= thing.getProductionYear());
        }
    }
