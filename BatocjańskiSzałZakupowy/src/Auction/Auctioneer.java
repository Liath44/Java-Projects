package Auction;
import Merchants.*;

public class Auctioneer
    {
    public Auctioneer()
        {
        }

    public Merchant[] Auction(Item[] ForSale, Merchant[] Attendants)
        {
        Merchant[] Outcome = new Merchant[ForSale.length];
        for(int i = 0; i < ForSale.length; ++i)
            {
            boolean Sold = false;
            int j = 0;
            while(j < Attendants.length && !Sold)
                {
                if(Attendants[j].AbleToBuy(ForSale[i].getPrice()) && Attendants[j].Strategy(ForSale[i]))
                    {
                    Attendants[j].Buy(ForSale[i].getPrice());
                    Sold = true;
                    }
                ++j;
                }
            if(Sold)
                {
                Outcome[i] = Attendants[j - 1];
                }
            else
                {
                Outcome[i] = null;
                }
            }
        return Outcome;
        }
    }
