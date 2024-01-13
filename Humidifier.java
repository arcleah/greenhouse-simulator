package lab5;
public class Humidifier {
    /**
     * instance variable for humidifier on or off
     */
    private boolean on;

    /**
     * Constructor
     */

    public Humidifier(){

    }

    /**
     * Method to turn on humidifier
     */
    public void HumidifierIsOn(){
        on = true;
    }

    /**
     * Method to turn off humidifier
     */
    public void HumidifierIsOff(){
        on = false;
    }

    /**
     * Method to return if humidifier is on or off
     * @return
     */
    public boolean IsHumidifierOn(){
        return on;
    }
}
