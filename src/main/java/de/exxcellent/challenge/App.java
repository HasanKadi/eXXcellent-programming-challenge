package de.exxcellent.challenge;

import de.exxcellent.challenge.football.GoalSpread;
import de.exxcellent.challenge.weather.TempSpread;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software design. Read: create your own
 * classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        TempSpread ts = new TempSpread();
        GoalSpread gs=new GoalSpread();

        String dayWithSmallestTempSpread = ts.theSmallestTempSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = gs.theSmallestGoalSpread(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        System.out.println(ts.theSmallestSpread("weather.csv", "Day", "MxT", "MnT", ","));
        System.out.println(ts.theSmallestSpread("football.csv", "Team", "Goals Allowed", "Goals", ","));
    }
}
