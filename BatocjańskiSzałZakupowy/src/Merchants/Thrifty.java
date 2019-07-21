package Merchants;
import Auction.Item;

public abstract class Thrifty extends Merchant
    {
    private int NoItems;
    private int PriceSum;
    private final double Multiplyer;

    public Thrifty(int B, String F, double M)
        {
        super(B, F);
        NoItems = 0;
        PriceSum = 0;
        Multiplyer = M;
        }

    private double Average()
        {
        return (double)PriceSum/(double)NoItems;
        }

    public boolean Strategy(Item thing)
        {
        boolean Outcome;
        if(NoItems == 0)
            {
            Outcome = false;
            }
        else
            {
            Outcome = thing.getPrice() < Multiplyer * Average();
            }
        ++NoItems;
        PriceSum = PriceSum + thing.getPrice();
        return Outcome;
        }
    }
