
class MySportCar {
   private  String brand;
   private  String model;
  private   boolean isEngineOn=false;
    private int currentGear=0;
   private  int currentSpeed=0;
   private String tyreType;

    MySportCar(String brand, String model)
    {
        this.model=model;
        this.brand=brand;
        // this.tyreType="RFT";
    }
    public int getSpeed()
    {
        return currentSpeed;
    }
    
    public int getGear()
    {
        return currentGear;
    }

    public String getTyreType()
    {
        return tyreType;
    }

    public void setTyreType(String tyreType) {
        this.tyreType = tyreType;
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
     
    
    public void accelerate()
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



class Encapsulation{
    public static void main(String args[])
    {
         MySportCar sportCar=new MySportCar("KTM", "RC 200");
         sportCar.startEngine();
         sportCar.shiftGear(2);
         sportCar.accelerate();
         sportCar.shiftGear(3);
         sportCar.accelerate();
         sportCar.breakk();
         sportCar.stopEngine();
         sportCar.setTyreType("Sharyu");
         System.out.println(sportCar.getTyreType());

    }
}
