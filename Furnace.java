package lab5;

public class Furnace {
    /**
     * instance variables
     */
    private boolean on;

    /**
     * Constructor
     */
    public Furnace() {
    }

    /**
     * Method to turn on furnace
     */
    public void furnaceIsOn(){
        on = true;
    }

    /**
     * Method to turn off furnace
     */
    public void furnaceIsOff(){
        on = false;
    }

    /**
     * Furnace status
     * @return status
     */
    public boolean IsFurnaceOn(){
        return on;
    }
}
