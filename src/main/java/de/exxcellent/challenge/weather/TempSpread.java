/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.weather;

import de.exxcellent.challenge.model.Weather;
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
 * @author Hasan
 */
public class TempSpread {

    public String theSmallestSpread(String filename, String firstcolumnname, String secoundcolumnname, String thirdcolumnname, String splitRegex) {
        double min = Double.MAX_VALUE;
        String day = null;
        int col1 = 0;
        int col2 = 0;
        int col3 = 0;
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/de/exxcellent/challenge/" + filename))) {
            String firstline = br.readLine();
            String[] columnnames = firstline.split(splitRegex);
            for (int i = 0; i < columnnames.length; i++) {
                if (columnnames[i].equals(firstcolumnname)) {
                    col1 = i;
                } else if (columnnames[i].equals(secoundcolumnname)) {
                    col2 = i;
                } else if (columnnames[i].equals(thirdcolumnname)) {
                    col3 = i;
                }

            }
            String line;

            while ((line = br.readLine()) != null) {
                records.add(line);
            }

            for (String s : records) {
                String[] values = s.split(splitRegex);
                String tmpday = values[col1];
                double avg = Math.abs(Double.parseDouble(values[col3]) - Double.parseDouble(values[col2]));

                if (avg < min) {
                    min = avg;
                    day = tmpday;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return day;

    }

    public String theSmallestTempSpread() {
        
        
        double min = Double.MAX_VALUE;
        double avgtemp;
        int day = 0;
        int daynumber;
        String line;
        List<Weather> records ;
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/de/exxcellent/challenge/weather.csv"))) {
            br.readLine();
            records= new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Weather w= new Weather();
                w.setDay(Integer.parseInt(values[0]));
                w.setMxt(Double.parseDouble(values[1]));
                w.setMnt(Double.parseDouble(values[2]));
                w.setAvt(Double.parseDouble(values[3]));
                w.setAvdp(Double.parseDouble(values[4]));
                w.setFirsthrp_tpcpn(Double.parseDouble(values[5]));
                w.setPdir(Double.parseDouble(values[6]));
                w.setAvsp(Double.parseDouble(values[7]));
                w.setDir(Double.parseDouble(values[8]));
                w.setMxs(Double.parseDouble(values[9]));
                w.setSkyc(Double.parseDouble(values[10]));
                w.setMxr(Double.parseDouble(values[11]));
                w.setMn(Double.parseDouble(values[12]));
                w.setR_avslp(Double.parseDouble(values[13]));
                records.add(w);
            }

            for (Weather s : records) {
                
                
                
                 daynumber = s.getDay();
                 avgtemp = s.getMxt() - s.getMnt();

                if (avgtemp < min) {
                    min = avgtemp;
                    day = daynumber;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TempSpread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.toString(day);

    }

}
