package lab5;
public class AirConditioner {
    /**
     * Instance variable on
     */
    private boolean on;

    /**
     * Air conditioner constructor
     */
    public AirConditioner(){
    }

    /**
     * Method to turn on air con
     */
    public void airConditionerIsOn(){
        on = true;
    }

    /**
     * Method to turn off air con
     */
    public void airConditionerIsOff(){
        on = false;
    }

    /**
     * Method for air con status
     * @return status
     */
    public boolean IsAirConOn(){
        return on;
    }
}
