
class Car{
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    // protected int currentGear;
    protected int currentSpeed;

    public Car(String brand , String model)
    {
        this.brand=brand;
        this.model=model;
        this.isEngineOn=false;
        this.currentSpeed=0;
    }
    public void startEngine()
    {
        isEngineOn=true;
        System.out.println("Engine Started!! ...");
    }
    public void stopEngine()
    {
        isEngineOn=false;
        System.out.println("Engine Stopped !! ...");
    }

    public void acceralate()
    {
        if(!isEngineOn)
        {
            System.out.println("Engine is off !!");
        }
        currentSpeed+=10;
        System.out.println("Speed increased to "+currentSpeed+" kmph");
    }

    public void breakk()
    {
        currentSpeed-=10;
        System.out.println("Speed decreased to "+currentSpeed+" kmph");
    }



}

class ManualCar extends Car{
    private int currentGear=0;

    public ManualCar(String brand, String model) {
        super(brand, model);
        this.currentGear=0;
    }
    public void shiftGear(int gearNumber)
    {
        if(!isEngineOn)
        {
            System.out.println("Engine is off !!");
        }
        currentGear=gearNumber;
        System.out.println("Gear changed to "+currentGear);
    }

}
class ElectricCar extends Car{
    private int batteryPercentage;
    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryPercentage=100;
    }
    public void ChargeBattery()
    {
        this.batteryPercentage=100;
        System.out.println("Battery Charged !!");

    }
}

public class Inheritence {
    public static void main(String args[])
    {
       ManualCar BMW = new ManualCar("bmw", "rcf100");
       BMW.startEngine();
       BMW.shiftGear(3);
       BMW.acceralate();
       BMW.shiftGear(2);
       BMW.acceralate();
       BMW.breakk();
       BMW.stopEngine();

       System.out.println("---------------------------");

       ElectricCar Tesla = new ElectricCar("Tesla", "Model 3");
       Tesla.startEngine();
       Tesla.acceralate();
       Tesla.breakk();
       Tesla.stopEngine();
       Tesla.ChargeBattery();

       



    }
}
