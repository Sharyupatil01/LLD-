


abstract class Car{
    protected String model;
    protected String brand;
    protected int speed;
    protected boolean isEngineOn;
    public Car(String model,String brand){
        this.model=model;
        this.brand=brand;
        this.speed=0;
        this.isEngineOn=false;
    }
    public void startEngine()
    {
        isEngineOn=true;
        System.out.println("Engine Started !! ....");
    }
    public void stopEngine()
    {
        isEngineOn=false;
        System.out.println("Engine Stopped !! ....");
    }

   public  abstract void acceralate();
    public abstract void breakk();

}

class ManualCar extends Car{
    public ManualCar(String model,String brand){
        super(model,brand);
    }
    int speed=0;


    public void acceralate()
    {
        speed+=20;
        System.out.println("Speed MANUAL increased to "+speed+" kmph");
    }
    public void breakk()
    {
        speed-=10;
        System.out.println("Speed MANUAL decreased to "+speed+" kmph");
    }


}
class ElectricCar extends Car{
    public ElectricCar(String model,String brand){
        super(model,brand);
    }
    int speed=0;
   public  void acceralate()
    {
        speed+=90;
        System.out.println("Speed TESLA  increased to "+speed+" kmph");
    }
    public void breakk()
    {
        speed-=20;
        System.out.println("Speed TESLA decreased to "+speed+" kmph");
    }
}



public class DynamicPolymorphism {
    public static void main(String args[])
    {
        Car bmw=new ManualCar("bmw","rcf100");
        bmw.startEngine();
        bmw.acceralate();
        bmw.breakk();
        bmw.stopEngine();

        System.out.println("---------------------------");

        Car tesla=new ElectricCar("Tesla","Model 3");
        tesla.startEngine();
        tesla.acceralate();
        tesla.breakk();
        tesla.stopEngine();

    }
}
