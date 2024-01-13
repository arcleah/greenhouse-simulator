package lab5;
public class HumidityController extends Thread {
    /**
     * Variables
     */
    private double currentHumidity, lowHumidity, highHumidity, humidityRate, externalWeatherRate;
    private boolean flag = false;
    private GreenhouseView view;

    /**
     * Constructor that creates humidity controller
     * @param currentHumidity current humidity
     * @param lowHumidity min range
     * @param highHumidity max range
     * @param humidityRate rate
     * @param externalWeatherRate external rate
     * @param view greenhouse view
     */
    public HumidityController(double currentHumidity, double lowHumidity, double highHumidity, double humidityRate, double externalWeatherRate, GreenhouseView view) {
        this.currentHumidity = currentHumidity;
        this.lowHumidity = lowHumidity;
        this.highHumidity = highHumidity;
        this.humidityRate = humidityRate;
        this.externalWeatherRate = externalWeatherRate;
        this.view = view;
    }

    /**
     * Kills the thread
     */
    public void kill(){
        this.flag = true;
    }

    /**
     * Runs the thread
     */

    public void run() {
        try {
            while (!flag) {
                // Creates humidifier object to access the humidifier
                Humidifier humidifier = new Humidifier();
                // When humidity needs to increase
                if (currentHumidity < lowHumidity) {
                    humidifier.HumidifierIsOn();
                    currentHumidity += (humidityRate + externalWeatherRate);
                    System.out.println("humidity rate: " + currentHumidity);
                    System.out.print("humidifier on");
                    // Sets the current humidity and the humidifier status
                    view.setCurrentHumidity(currentHumidity);
                    view.setHumidifierStat(humidifier.IsHumidifierOn());
                    Thread.sleep(30000);
                    // When humidity needs to decrease
                } else if (currentHumidity > highHumidity) {
                    humidifier.HumidifierIsOff();
                    currentHumidity -= (humidityRate + externalWeatherRate);
                    System.out.println("humidity rate: " + currentHumidity);
                    System.out.print("humidifier off");
                    view.setCurrentHumidity(currentHumidity);
                    view.setHumidifierStat(humidifier.IsHumidifierOn());
                    Thread.sleep(30000);
                    // Otherwise, humidifier is off
                } else {
                    humidifier.HumidifierIsOff();
                    view.setCurrentHumidity(currentHumidity);
                    view.setHumidifierStat(humidifier.IsHumidifierOn());
                    Thread.sleep(30000);
                }
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    /**
     * Get method
     * @return current humidity
     */
    public double getCurrentHumidity() {
        return currentHumidity;
    }

    /**
     * Get method
     * @return low humidity
     */
    public double getLowHumidity() {
        return lowHumidity;
    }

    /**
     * Get method
     * @return high humidity
     */
    public double getHighHumidity() {
        return highHumidity;
    }

    /**
     * Get method
     * @return humidity rate
     */
    public double getHumidityRate() {
        return humidityRate;
    }
}

