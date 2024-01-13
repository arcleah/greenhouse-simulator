package lab5;
public class SprinklerSystem {
    /**
     * Instance variable on
     */
    private boolean on;

    /**
     * Sprinkler system constructor
     */
    public SprinklerSystem(){
    }

    /**
     * Method to turn on sprinkler
     */
    public void SprinklerIsOn(){
        on = true;
    }

    /**
     * Method to turn off sprinkler
     */
    public void SprinklerIsOff(){
        on = false;
    }

    /**
     * Sprinkler status
     * @return status
     */
    public boolean IsSprinklerOn(){
        return on;
    }
}
