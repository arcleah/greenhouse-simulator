package lab5;

public class TempController extends Thread {
    /**
     * Variables
     */
    private double lowTemperature, highTemperature, desiredTemperature, coolingRate, heatingRate, currentTemperature, externalWeatherRate;
    private boolean flag = false;
    private GreenhouseView view;

    /**
     * Temp controller constructor
     * @param desiredTemperature desired temp
     * @param coolingRate cooling rate
     * @param heatingRate heating rate
     * @param currentTemperature current temp
     * @param externalWeatherRate external rate
     * @param view greenhouse view
     */

    public TempController(double desiredTemperature, double coolingRate, double heatingRate, double currentTemperature, double externalWeatherRate, GreenhouseView view) {
        this.desiredTemperature = desiredTemperature;
        this.coolingRate = coolingRate;
        this.heatingRate = heatingRate;
        this.currentTemperature = currentTemperature;
        this.externalWeatherRate = externalWeatherRate;
        this.view = view;

        lowTemperature = desiredTemperature - 3;
        highTemperature = desiredTemperature + 3;
    }

    /**
     * Kill Thread
     */
    public void kill(){
        this.flag= true;
    }

    /**
     * Run Thread
     */
    public void run() {
        try {
            while (!flag) {
                // Creates objects for furnace and air conditioner
                Furnace furnace = new Furnace();
                AirConditioner airConditioner = new AirConditioner();
                // If temp too low, heats up
                if (currentTemperature < lowTemperature) {
                    furnace.furnaceIsOn();
                    airConditioner.airConditionerIsOff();
                    currentTemperature += (heatingRate + externalWeatherRate);
                    System.out.println("temperature: " + currentTemperature);
                    System.out.print("furnace on");
                    System.out.print("air conditioner off");
                    // Sets current temp, furnace status and air con status
                    view.setCurrentTemp(currentTemperature);
                    view.setFurnaceStat(furnace.IsFurnaceOn());
                    view.setAirStat(airConditioner.IsAirConOn());
                    Thread.sleep(30000);
                    // When temp too high, it cools
                } else if (currentTemperature > highTemperature) {
                    furnace.furnaceIsOff();
                    airConditioner.airConditionerIsOn();
                    currentTemperature -= (coolingRate + externalWeatherRate);
                    System.out.println("temperature: " + currentTemperature);
                    System.out.print("furnace off");
                    System.out.print("air conditioner on");
                    view.setCurrentTemp(currentTemperature);
                    view.setFurnaceStat(furnace.IsFurnaceOn());
                    view.setAirStat(airConditioner.IsAirConOn());
                    Thread.sleep(30000);
                    // Otherwise, temperture is off
                } else {
                    furnace.furnaceIsOff();
                    airConditioner.airConditionerIsOff();
                    view.setCurrentTemp(currentTemperature);
                    view.setFurnaceStat(furnace.IsFurnaceOn());
                    view.setAirStat(airConditioner.IsAirConOn());
                    Thread.sleep(30000);
                }
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    /**
     * Get method
     * @return current temp
     */
    public double getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     * Get method
     * @return desired temp
     */
    public double getDesiredTemperature() {
        return desiredTemperature;
    }

    /**
     * Get method
     * @return heating rate
     */
    public double getHeatingRate() {
        return heatingRate;
    }

    /**
     * Get method cooling rate
     * @return
     */
    public double getCoolingRate() {
        return coolingRate;
    }

    /**
     * Get method
     * @return external rate
     */
    public double getExternalWeatherRate() {
        return externalWeatherRate;
    }
}

