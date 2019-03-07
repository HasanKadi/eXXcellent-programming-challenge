/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.football;

import de.exxcellent.challenge.model.FootballTeam;
import de.exxcellent.challenge.weather.TempSpread;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hhasan
 */
public class GoalSpread {

//    public String theSmallestSpread(String filename, String firstcolumnname, String secoundcolumnname, String thirdcolumnname, String splitRegex) {
//        double min = Double.MAX_VALUE;
//        String day = null;
//        int col1 = 0;
//        int col2 = 0;
//        int col3 = 0;
//        List<String> records = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/de/exxcellent/challenge/" + filename))) {
//            String firstline = br.readLine();
//            String[] columnnames = firstline.split(splitRegex);
//            for (int i = 0; i < columnnames.length; i++) {
//                if (columnnames[i].equals(firstcolumnname)) {
//                    col1 = i;
//                } else if (columnnames[i].equals(secoundcolumnname)) {
//                    col2 = i;
//                } else if (columnnames[i].equals(thirdcolumnname)) {
//                    col3 = i;
//                }
//
//            }
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                records.add(line);
//            }
//
//            for (String s : records) {
//                String[] values = s.split(splitRegex);
//                String tmpday = values[col1];
//                double avg = Math.abs(Double.parseDouble(values[col3]) - Double.parseDouble(values[col2]));
//
//                if (avg < min) {
//                    min = avg;
//                    day = tmpday;
//                }
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return day;
//
//    }
    public String theSmallestGoalSpread() {
        int min = Integer.MAX_VALUE;
        String name = null;
        String line;
        String teamname;
        int diffrance;
        List<FootballTeam> records;

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/de/exxcellent/challenge/football.csv"))) {
            br.readLine();
            records = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                FootballTeam ft = new FootballTeam();
                ft.setTeamname(values[0]);
                ft.setGames(Integer.parseInt(values[1]));
                ft.setWins(Integer.parseInt(values[2]));
                ft.setLoses(Integer.parseInt(values[3]));
                ft.setDraws(Integer.parseInt(values[4]));
                ft.setGoals(Integer.parseInt(values[5]));
                ft.setGoalsallowed(Integer.parseInt(values[6]));
                ft.setPoints(Integer.parseInt(values[7]));

                records.add(ft);
            }

            for (FootballTeam f : records) {

                //teamname = f.getTeamname();
                diffrance = Math.abs(f.getGoals() - f.getGoalsallowed());

                if (diffrance < min) {
                    min = diffrance;
                    name = f.getTeamname();
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;

    }

}
