interface Car
{
    void startEngine();
    void stopEngine();
    void accelerate();
    void breakk();
    void shiftGear(int gearNumber);

}

class MySportCar implements Car{
    String brand;
    String model;
    boolean isEngineOn=false;
    int currentGear=0;
    int currentSpeed=0;

    MySportCar(String brand, String model)
    {
        this.model=model;
        this.brand=brand;
    }
    @Override 
    public void startEngine()
    {
        isEngineOn=true;
        System.out.println("Engine Started!! ...");
    }
    
    @Override
    public void stopEngine()
    {
        isEngineOn=false;
        System.out.println("Engine Stopped !! ...");

    }
     
    @Override 
    public void accelerate()
    {
        if(!isEngineOn)
        {
           System.out.println("Engine is off !!");
        }
        currentSpeed+=10;
        System.out.println("Speed increased to "+currentSpeed+" kmph");
    }

    @Override 
    public void breakk()
    {
        currentSpeed-=10;
        System.out.println("Speed decreased to "+currentSpeed+" kmph");
    }

    @Override 
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



class Abstraction{
    public static void main(String args[])
    {
         Car sportCar=new MySportCar("KTM", "RC 200");
         sportCar.startEngine();
         sportCar.shiftGear(2);
         sportCar.accelerate();
         sportCar.shiftGear(3);
         sportCar.accelerate();
         sportCar.breakk();
         sportCar.stopEngine();
    }
}
