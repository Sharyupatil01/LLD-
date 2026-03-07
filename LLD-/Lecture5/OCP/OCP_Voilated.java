
import java.util.ArrayList;
import java.util.List;

// Product class representing any item in eCommerce.
class Product{
    public String name;
    public int price;
    Product(String name , int price)
    {
        this.name=name;
        this.price=price;
    }
}
// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart{
    private List<Product> products=new ArrayList<>();
    public void addProduct(Product p)
    {
        products.add(p);
    }
    public List<Product> getProducts()
    {
        return products;
    }
    public int getTotalPrice()
    {
        int total=0;
        for(Product p : products)
        {
            total+=p.price;
        }
        return total;
    }
}

// 2. ShoppingCartPrinter: Only responsible for printing invoices

class InvoicePrinter
{
    private ShoppingCart cart;
    public InvoicePrinter(ShoppingCart cart)
    {
        this.cart=cart;
    }

    public void printInvoice()
    {
        System.out.println("Shopping cart invoice: ");
        for(Product p : cart.getProducts())
        {
            System.out.println(p.name+" "+p.price);
        }
        System.out.println("Total Price :" + cart.getTotalPrice());
    }

}

// 3. ShoppingCartStorage: Only responsible for saving cart to DB


class DBSaving
{
    private ShoppingCart cart;
    public DBSaving(ShoppingCart cart)
    {
        this.cart=cart;
    }

    //Here we are violating OCP
    //OCP RULE THAT SAYS 
    //A class should be open for extension but closed for modification
    //FOR MODIFICATION OF SAVING TO DB I NEED TO MODIFICTE THE ENTIRE CLASS AND CHANGE THE CODE 
    public void saveDb()
    {
        System.out.println("Saving to db ...");
    }
    public void savetoSqlDb()
    {
        System.out.println("Saving to SQL db");
    }
    public void savetoNoSqlDb()
    {
        System.out.println("Saving to NoSQL db");
    }

    public void savetoFile()
    {
        System.out.println("Saving to File");
    }

}



public class OCP_Voilated {
    public static void main(String args[])
    {
        ShoppingCart sc=new ShoppingCart();
        sc.addProduct(new Product("LipBalm Wishcare",124));
        sc.addProduct(new Product("Simple Face Wash",650));

        InvoicePrinter ip=new InvoicePrinter(sc);
        ip.printInvoice();
        DBSaving db=new DBSaving(sc);
        db.saveDb();


    }
}
