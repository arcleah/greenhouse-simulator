package lab5;
import java.awt.event.*;

public class GreenhouseController {
    /**
     * Variable for view Greenhouse
     */
    private GreenhouseView view;

    private TempController tempController;
    private SoilMoistureController soilMoisterController;
    private HumidityController humidityController;
    private Thread tempThread;
    private Thread soilThread;
    private Thread humidThread;


    /**
     * @param view from GreenhouseView
     */

    public GreenhouseController(GreenhouseView view) {
        this.view = view;

        view.startGreenhouseListener(new GreenhouseListener());
        view.endGreenhouseListener(new EndListener());


    }


    /**
     * GreenhouseListener class to handle events
     */
    class GreenhouseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Temperature variables
            double desiredTemperature = view.getDesiredTemp();
            double currentTemperature = view.getCurrentTemp();
            double coolingRate = view.getCoolingRate();
            double heatingRate = view.getHeatingRate();
            double externalWeather = view.getExternalWeatherRate();
            // Soil variables
            double currentSoilMoisture = view.getSoilMoisture();
            double lowMoisture = view.getLowMoisture();
            double highMoisture = view.getHighMoisture();
            double sprinklerRate = view.getSprinklerRate();
            double externalSoilRate = view.getExternalSoilRate();
            // Humidity variables
            double currentHumidity = view.getHumidity();
            double lowHumidity = view.getLowHumidity();
            double highHumidity = view.getHighHumidity();
            double humidityRate = view.getHumidityRate();
            double externalHumidityRate = view.getExternalHumidityRate();
            tempController = new TempController(desiredTemperature, coolingRate, heatingRate, currentTemperature, externalWeather, view);
            soilMoisterController = new SoilMoistureController(currentSoilMoisture, lowMoisture, highMoisture, sprinklerRate, externalSoilRate, view);
            humidityController = new HumidityController(currentHumidity, lowHumidity, highHumidity, humidityRate, externalHumidityRate, view);
            tempThread = new Thread(tempController);
            soilThread = new Thread(soilMoisterController);
            humidThread = new Thread(humidityController);

            tempThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            soilThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            humidThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }

    }


    /**
     * End Listener stops the threads
     */
    class EndListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("end simulation");

            tempController.kill();
            if (tempThread.getState() == Thread.State.NEW) {
                tempThread.start();
            }
            try {
                tempThread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            humidityController.kill();
            if (humidThread.getState() == Thread.State.NEW) {
                humidThread.start();
            }
            try {
                humidThread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            soilMoisterController.kill();
            if (soilThread.getState() == Thread.State.NEW) {
                soilThread.start();
            }
            try {
                soilThread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    /**
     * Main Method
     * @param args arguments
     */
    public static void main(String[] args) {
        GreenhouseView view = new GreenhouseView();
        GreenhouseController controller = new GreenhouseController(view);
    }
}

