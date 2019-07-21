package Auction;

public class Item
    {
    private int ProductionYear;
    private String CountryOfOrigin;
    private int Price;

    public Item(int Y, String C, int P)
        {
        ProductionYear = Y;
        CountryOfOrigin = C;
        Price = P;
        }

    public int getProductionYear()
        {
        return ProductionYear;
        }

    public String getCountryOfOrigin()
        {
        return CountryOfOrigin;
        }

    public int getPrice()
        {
        return Price;
        }
    }
