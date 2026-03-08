
// Method Argument Rule : 
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides

class Parent
{
    void print(String a)
    {
        System.out.println("Printing parent class print" + a);
    }

}
class Child extends Parent{
    @Override
    void print(String a)
    {
        System.out.println("Printing child class print" + a);
    }
}
class Client{
    Parent p ;
    Client(Parent p)
    {
        this.p=p;
    }
    void printMsg()
    {
        p.print("hello");
    }
}
public class MethodSignatureRule {
    public static void main(String args[])
    {
       Parent p=new Parent();
       p.print("hello World");
       Client c=new Client(p);
       c.printMsg();

    }

}
