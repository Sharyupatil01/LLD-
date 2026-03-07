import java.util.ArrayList;
import java.util.List;
class Product 
{
    public String name;
    public int price;
    Product(String name , int price)
    {
        this.name=name;
        this.price=price;
    }

}
// Violating SRP: ShoppingCart is handling multiple responsibilities
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
      // 2. Violating SRP - Prints invoice (Should be in a separate class)
    public void PrintInvoice()
    {
        System.out.println("Shopping cart invoice: ");
        for(Product p : products)
        {
            System.out.println(p.name+" "+p.price);
        }
        System.out.println("Total Price :" + getTotalPrice());

    }

      // 3. Violating SRP - Saves to DB (Should be in a separate class)
    public void saveDb()
    {
        System.out.println("Saving to db ...");
    }


}



public class VoilatedForm {
    public static void main(String args[])
    {
        ShoppingCart sp=new ShoppingCart();
        sp.addProduct(new Product("LipBalm Wishcare",124));
        sp.addProduct(new Product("Simple Face Wash",650));

        sp.PrintInvoice();
        sp.saveDb();


    }
}
