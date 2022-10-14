/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidand
 */
public class ExerciseLogManager {

    public static String getCals(String userToFind, LocalDate dateToFind) {
        String output = "";
        try {
            File f = new File("Data\\ExerciseLog.txt");
            Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(fileScanner.nextLine()).useDelimiter("#").useLocale(Locale.ENGLISH);

                String username = lineScanner.next();
                String exercise = lineScanner.next();
                LocalDate date = LocalDate.parse(lineScanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int timeInMins = lineScanner.nextInt();

                if (username.equals(userToFind) && date.isEqual(dateToFind)) {
                    output = exercise;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return output;
    }

    public static double getMETval(String selectedExercise) {
        double METval = 0;
        try {
            File f = new File("Data\\Exercises.txt");
            Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(fileScanner.nextLine()).useDelimiter("#").useLocale(Locale.ENGLISH);

                String scanExercise = lineScanner.next();
                double scanMETval = lineScanner.nextDouble();

                if (scanExercise.equals(selectedExercise)) {
                    METval = scanMETval;
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return METval;
    }

    public static int calculateCals(int METval, int timeInMins) {

        return 0;
    }

}
