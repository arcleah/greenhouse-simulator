
package lab5;

public class SoilMoistureController extends Thread {
    /**
     * Variables
     */
    private double currentSoilMoisture, lowMoisture, highMoisture, sprinklerRate, externalWeatherRate;
    private GreenhouseView view;
    private boolean flag = false;

    /**
     * Constructor to create soil moisture controller
     * @param currentSoilMoisture current soil moisture
     * @param lowMoisture min range
     * @param highMoisture max range
     * @param sprinklerRate rate
     * @param externalWeatherRate external rate
     * @param view greenhouse view
     */

    public SoilMoistureController(double currentSoilMoisture, double lowMoisture, double highMoisture, double sprinklerRate, double externalWeatherRate, GreenhouseView view) {
        this.currentSoilMoisture = currentSoilMoisture;
        this.lowMoisture = lowMoisture;
        this.highMoisture = highMoisture;
        this.sprinklerRate = sprinklerRate;
        this.externalWeatherRate = externalWeatherRate;
        this.view = view;
    }

    /**
     * Kill thread
     */
    public void kill(){
        this.flag = true;
    }

    /**
     * Run thread
     */
    public void run() {
        try {
            while (!flag) {
                // Creates sprinkler object to access sprinkler system
                SprinklerSystem sprinkler = new SprinklerSystem();
                // When moisture is low and needs to increase
                if (currentSoilMoisture < lowMoisture) {
                    sprinkler.SprinklerIsOn();
                    currentSoilMoisture += (sprinklerRate + externalWeatherRate);
                    System.out.println("soil moisture: " + currentSoilMoisture);
                    System.out.print("sprinkler on");
                    // Sets current moisture and sprinkler status
                    view.setCurrentSoilMoisture(currentSoilMoisture);
                    view.setSprinklerStat(sprinkler.IsSprinklerOn());
                    Thread.sleep(30000);
                    // When moisture is high and needs to decrease
                } else if (currentSoilMoisture > highMoisture) {
                    sprinkler.SprinklerIsOff();
                    currentSoilMoisture -= (sprinklerRate + externalWeatherRate);
                    System.out.println("soil moisture: " + currentSoilMoisture);
                    System.out.print("sprinkler off");
                    view.setCurrentSoilMoisture(currentSoilMoisture);
                    view.setSprinklerStat(sprinkler.IsSprinklerOn());
                    Thread.sleep(30000);
                    // Otherwise, sprinkler is off
                } else {
                    sprinkler.SprinklerIsOff();
                    view.setCurrentSoilMoisture(currentSoilMoisture);
                    view.setSprinklerStat(sprinkler.IsSprinklerOn());
                    Thread.sleep(30000);
                }
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    /**
     * Get method
     * @return current soil moisture
     */
    public double getCurrentSoilMoisture() {
        return currentSoilMoisture;
    }

    /**
     * Get method
     * @return low moisture
     */
    public double getLowMoisture() {
        return lowMoisture;
    }

    /**
     * Get method
     * @return high moisture
     */

    public double getHighMoisture() {
        return highMoisture;
    }

    /**
     * Get method
     * @return sprinkler rate
     */
    public double getSprinklerRate() {
        return sprinklerRate;
    }
}
