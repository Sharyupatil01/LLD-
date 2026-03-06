
class Hello
{
    public void sayHello()
    {
        System.out.println("Hello");
    }
    public void sayHello(int a)
    {
        System.out.println("Hello "+a);
    }
    public void sayHello(int a,int b)
    {
        System.out.println("Hello "+a+" "+b);
    }
    public void sayHello(String a)
    {
        System.out.println("Hello "+a);
    }
}

public class StaticPolymorphism {
    public static void main(String args[])
    {
        Hello h1=new Hello();
        h1.sayHello();
        h1.sayHello(10);
        h1.sayHello(10,20);
        h1.sayHello("Hello");


    }
}
