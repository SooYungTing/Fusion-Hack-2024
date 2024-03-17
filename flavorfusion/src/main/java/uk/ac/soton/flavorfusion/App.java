package uk.ac.soton.flavorfusion;

import uk.ac.soton.flavorfusion.ui.MainMenu;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public WeatherAPI weatherAPI;
    public MealAPI mealAPI;
    public MealCalculator mealCalculator;

    public App()
    {
        this.weatherAPI = new WeatherAPI(this);
        this.mealAPI = new MealAPI(this);
        this.mealCalculator = new MealCalculator(this);
    }

    public static void main( String[] args )
    {
        App app = new App();
        //System.out.println( "Hello World!" );

        // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });

    }
}
