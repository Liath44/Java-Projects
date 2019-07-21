package Auction;
import Merchants.*;

public class Main
    {
    private static Merchant[] CreateAttendants()
        {
        Merchant[] Outcome = new Merchant[7];
        Outcome[0] = new VeryThrifty(1200, "VeryThrifty");
        Outcome[1] = new ModeratelyThrifty(1200, "ModeratelyThrifty");
        Outcome[2] = new LimitedSentimentalist(1200, "LimitedSentimentalist", "Japan", 1);
        Outcome[3] = new Historian(1200, "Historian64", 1340, 1899);
        Outcome[4] = new Sentimentalist(1200, "VeryThrifty", "Japan");
        Outcome[5] = new CoinTosser(1200, "CoinTosser");
        Outcome[6] = new Historian(1200, "Historian", 20);//XX century
        return Outcome;
        }

    private static Item[] CreateItems()
        {
        Item[] Outcome = new Item[17];
        Outcome[0] = new Item(1549, "Japan", 250);
        Outcome[1] = new Item(966, "Poland", 120);
        Outcome[2] = new Item(1618, "CzechRepublic", 330);
        Outcome[3] = new Item(1410, "Poland", 530);
        Outcome[4] = new Item(1944, "France", 770);
        Outcome[5] = new Item(2019, "China", 1);
        Outcome[6] = new Item(1996, "Japan", 50);
        Outcome[7] = new Item(1998, "Japan", 100);
        Outcome[8] = new Item(1866, "Lichtenstein", 1200);
        Outcome[9] = new Item(1923, "Japan", 870);
        Outcome[10] = new Item(1914, "Japan", 220);
        Outcome[11] = new Item(1914, "Japan", 430);
        Outcome[12] = new Item(1634, "Japan", 550);
        Outcome[13] = new Item(1831, "Poland", 320);
        Outcome[14] = new Item(1795, "Japan", 510);
        Outcome[15] = new Item(1777, "Lichtenstein", 1050);
        Outcome[16] = new Item(1867, "Japan", 530);
        return Outcome;
        }

    private static void Report(Merchant[] AuctionResults)
        {
        System.out.println("-------------------------- Auction Results --------------------------");
        int i = 0;
        while(i < AuctionResults.length)
            {
            System.out.print("Auction.Item No." + (i + 1) + ": ");
            if(i + 1 < 10)
                {
                System.out.print(" ");
                }
            if(AuctionResults[i] != null)
                {
                System.out.println(AuctionResults[i].getFancyPseudonym());
                }
            else
                {
                System.out.println("No one");
                }
            ++i;
            }
        System.out.println("-------------------------------- Fin --------------------------------");
        }

    public static void main(String[] args)
        {
        Auctioneer Bajtmajster = new Auctioneer();
        Item[] ForSale = CreateItems();
        Merchant[] Attendants = CreateAttendants();
        Merchant[] AuctionResults = Bajtmajster.Auction(ForSale, Attendants);
        Report(AuctionResults);
        }
    }
