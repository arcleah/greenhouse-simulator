package lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GreenhouseView extends JFrame {
    // Temperature Labels and Text fields
    /**
     * Instance variables pre-assigned for the GUI
     */
    private Furnace furnace;
    private AirConditioner airConditioner;
    private SprinklerSystem sprinklerSystem;
    private Humidifier humidifier;
    private JLabel currentTemp;
    private JLabel desiredTemp;
    private JLabel externalWeather;
    private JLabel heatingRate;
    private JLabel coolingRate;
    private JTextField textDesiredTemp;
    private JTextField textCurrentTemp;
    private JTextField textHeatingRate;
    private JTextField textCoolingRate;
    private JTextField textExternalWeatherRate;

    // Soil Moisture Labels and Text fields
    private JLabel soilMoisture, lowMoisture, highMoisture, sprinklerRate, externalSoilRate;

    private JTextField textSoil, textLowMoisture, textHighMoisture, textSprinklerRate, textExternalSoil;

    // Humidity Labels and Text fields
    private  JLabel humidity, lowHumidity, highHumidity, humidityRate, externalHumidityRate;
    private JTextField textHumidity, textLowHumidity, textHighHumidity, textHumidityRate, textExternalHumidity;

    // Other Labels
    private JLabel outputs;
    private JLabel currentTempResult, currentSoilMoistureResult, currentHumidityResult, furnaceStat, airStat, sprinklerStat, humidifierStat;

    // Start and End buttons
    private JButton start;
    private JButton end;

    /**
     * GreenhouseView constructor
     */
    public GreenhouseView() {
        super();

        // Creating labels
        // Temperature labels
        currentTemp = new JLabel("Current Temperature (°C): ");
        desiredTemp = new JLabel("Desired Temperature (°C): ");
        heatingRate = new JLabel("Furnace Heating Rate (°C/min): ");
        coolingRate = new JLabel("Air Conditioner Cooling Rate (°C/min): ");
        externalWeather = new JLabel("External weather rate for Temperature (°C/min): ");
        // Soil Moisture labels
        soilMoisture = new JLabel("Current Soil Moisture (%): ");
        lowMoisture = new JLabel("Minimum Soil Moisture (0-100%): ");
        highMoisture = new JLabel("Maximum Soil Moisture (0-100%): ");
        sprinklerRate = new JLabel("Sprinkler Rate (%/min): ");
        externalSoilRate = new JLabel("External weather rate for Soil (%/min): ");
        // Humidity labels
        humidity = new JLabel("Current humidity (%): ");
        lowHumidity = new JLabel("Minimum Humidity (0-100%): ");
        highHumidity = new JLabel("Maximum Humidity (0-100%): ");
        humidityRate = new JLabel("Humidifier Rate (%/min): ");
        externalHumidityRate = new JLabel("External weather rate for Humidity (%/min): ");
        // Other Labels
        outputs = new JLabel("Outputs: ");
        currentTempResult = new JLabel();
        currentSoilMoistureResult = new JLabel();
        currentHumidityResult = new JLabel();
        furnaceStat = new JLabel();
        airStat = new JLabel();
        sprinklerStat = new JLabel();
        humidifierStat = new JLabel();

        // Creating text fields
        // Temperature text fields
        textCurrentTemp = new JTextField(10);
        textDesiredTemp = new JTextField(10);
        textHeatingRate = new JTextField(10);
        textCoolingRate = new JTextField(10);
        textExternalWeatherRate = new JTextField(10);
        // Soil Moisture text fields
        textSoil = new JTextField(10);
        textLowMoisture = new JTextField(10);
        textHighMoisture = new JTextField(10);
        textSprinklerRate = new JTextField(10);
        textExternalSoil = new JTextField(10);
        //Humidity text fields
        textHumidity = new JTextField(10);
        textLowHumidity= new JTextField(10);
        textHighHumidity = new JTextField(10);
        textHumidityRate = new JTextField(10);
        textExternalHumidity = new JTextField(10);

        // Creating buttons/other labels
        start = new JButton("Start");
        end = new JButton("End");

        // Add Components
        Container pane = getContentPane();
        pane.setLayout((new FlowLayout(FlowLayout.LEFT)));
        // Add labels, text fields and buttons
        // Temperature
        pane.add(currentTemp);
        pane.add(textCurrentTemp);
        pane.add(desiredTemp);
        pane.add(textDesiredTemp);
        pane.add(heatingRate);
        pane.add(textHeatingRate);
        pane.add(coolingRate);
        pane.add(textCoolingRate);
        pane.add(externalWeather);
        pane.add(textExternalWeatherRate);
        // Soil
        pane.add(soilMoisture);
        pane.add(textSoil);
        pane.add(lowMoisture);
        pane.add(textLowMoisture);
        pane.add(highMoisture);
        pane.add(textHighMoisture);
        pane.add(sprinklerRate);
        pane.add(textSprinklerRate);
        pane.add(externalSoilRate);
        pane.add(textExternalSoil);
        // Humidity
        pane.add(humidity);
        pane.add(textHumidity);
        pane.add(lowHumidity);
        pane.add(textLowHumidity);
        pane.add(highHumidity);
        pane.add(textHighHumidity);
        pane.add(humidityRate);
        pane.add(textHumidityRate);
        pane.add(externalHumidityRate);
        pane.add(textExternalHumidity);
        // Buttons
        pane.add(start);
        pane.add(end);
        // Output
        pane.add(outputs);
        pane.add(currentTempResult);
        pane.add(currentSoilMoistureResult);
        pane.add(currentHumidityResult);
        pane.add(furnaceStat);
        pane.add(airStat);
        pane.add(sprinklerStat);
        pane.add(humidifierStat);


        // Setting up window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Get method for desired temp
     * @return desired temp input
     */
    public double getDesiredTemp() {
        return Double.parseDouble(textDesiredTemp.getText());
    }

    /**
     * Get method for external weather temperature rate
     * @return external weather temp rate
     */
    public double getExternalWeatherRate() {
        return Double.parseDouble(textExternalWeatherRate.getText());
    }

    /**
     * Get method for current temp
     * @return current temp input
     */
    public double getCurrentTemp() {
        return Double.parseDouble(textCurrentTemp.getText());
    }

    /**
     * Get method for heating (furnace) rate
     * @return heating rate
     */
    public double getHeatingRate() {
        return Double.parseDouble(textHeatingRate.getText());
    }

    /**
     * Get method for cooling (air con) rate
     * @return air con rate
     */
    public double getCoolingRate() {
        return Double.parseDouble(textCoolingRate.getText());
    }

    /**
     * Get method for soil moisture
     * @return soil moisture
     */
    public double getSoilMoisture(){
        return Double.parseDouble(textSoil.getText());
    }

    /**
     * Get method for low soil moisture range
     * @return min soil moisture
     */
    public double getLowMoisture(){
        return Double.parseDouble(textLowMoisture.getText());
    }

    /**
     * Get method for high soil moisture range
     * @return max soil moisture
     */
    public double getHighMoisture() {
        return Double.parseDouble(textHighMoisture.getText());
    }

    /**
     * Get method for sprinkler rate
     * @return sprinkler rate
     */
    public double getSprinklerRate(){
        return Double.parseDouble(textSprinklerRate.getText());
    }

    /**
     * Get method for external weather soil rate
     * @return external weather soil rate
     */
    public double getExternalSoilRate(){
        return Double.parseDouble(textExternalSoil.getText());
    }

    /**
     * Get method for humidity
     * @return humidity
     */
    public double getHumidity(){
        return Double.parseDouble(textHumidity.getText());
    }

    /**
     * Get method for min humidity range
     * @return min humidity range
     */
    public double getLowHumidity(){
        return Double.parseDouble(textLowHumidity.getText());
    }

    /**
     * Get method for max humidity range
     * @return max humidity range
     */
    public double getHighHumidity(){
        return Double.parseDouble(textHighHumidity.getText());
    }

    /**
     * Get method for humidity rate
     * @return humidity rate
     */
    public double getHumidityRate(){
        return Double.parseDouble(textHumidityRate.getText());
    }

    /**
     * Get method for external weather humidity rate
     * @return external weather humidity rate
     */
    public double getExternalHumidityRate(){
        return Double.parseDouble(textExternalHumidity.getText());
    }

    /**
     * Set current temp method
     * @param currentTemp current temp
     */
    public void setCurrentTemp(double currentTemp){
        currentTempResult.setText("Current Temperature (°C): " + currentTemp);
    }

    /**
     * Set soil moisture method
     * @param soilMoisture current soil moisture
     */
    public void setCurrentSoilMoisture(double soilMoisture){
        currentSoilMoistureResult.setText("Soil Moisture (%): " + soilMoisture);
    }

    /**
     * Set humidity method
     * @param humidity current humidity
     */
    public void setCurrentHumidity(double humidity){
        currentHumidityResult.setText("Humidity (%): " + humidity);
    }

    /**
     * Set furnace status
     * @param furnaceState furnace on or off
     */
    public void setFurnaceStat(boolean furnaceState){
        if (!furnaceState){
            furnaceStat.setText("Furnace (on/off): off");
        }
        else {
            furnaceStat.setText("Furnace (on/off): on");
        }

    }

    /**
     * Set air con status
     * @param airState air con on or off
     */
    public void setAirStat(boolean airState){
        if (!airState){
            airStat.setText("Air Conditioner (on/off): off");
        }
        else{
            airStat.setText("Air Conditioner (on/off): on");
        }

    }

    /**
     * Set sprinkler status
     * @param sprinklerState sprinkler on or off
     */
    public void setSprinklerStat(boolean sprinklerState){
        if (!sprinklerState){
            sprinklerStat.setText("Sprinkler (on/off): off");
        }
        else{
            sprinklerStat.setText("Sprinkler (on/off): on");
        }
    }

    /**
     * Set humidifier status
     * @param humidifierState humidifier on or off
     */
    public void setHumidifierStat(boolean humidifierState){
        if (!humidifierState){
            humidifierStat.setText("Humidifier (on/off): off");
        }
        else{
            humidifierStat.setText("Humidifier (on/off): on");
        }
    }

    /**
     * Method to add start listener for start button
     * @param startListener start listener
     */
    public void startGreenhouseListener(ActionListener startListener){
        start.addActionListener(startListener);
    }

    /**
     * Method to add end listener for end button
     * @param endListener end listener
     */
    public void endGreenhouseListener(ActionListener endListener){
        end.addActionListener(endListener);
    }
}