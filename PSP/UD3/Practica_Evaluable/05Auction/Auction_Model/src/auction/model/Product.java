package auction.model;

import java.io.Serializable;

/**
 * This class will store the products information in the auction application
 */
public class Product implements Serializable
{
    String name;
    float price;
    String buyersName;

    public Product(String name, float price) 
    {
        this.name = name;
        this.price = price;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public float getPrice() 
    {
        return price;
    }

    public void setPrice(float price) 
    {
        this.price = price;
    }

    public String getBuyersName() 
    {
        return buyersName;
    }

    public void setBuyersName(String buyersName) 
    {
        this.buyersName = buyersName;
    }    
}
