/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import static BackEnd.UserManager.countUsers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidand
 */
public class ExerciseManager {
// finds the users MET value

    public static double getMETVal(String exNameIN) throws FileNotFoundException {
        File f = new File("Data\\Exercise.txt");
        Scanner fileScanner = new Scanner(f);

        double output = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineSc = new Scanner(line).useDelimiter("#");

            //dependent on file columns
            String exerciseName = lineSc.next();
            double METval = lineSc.nextDouble();

            //do stuff with line data
            if (exerciseName.equals(exNameIN)) {
                output = METval;
            }
        }
        return output;
    }

    //fetches all the different excersise names from the exsercise txt file
    public static String[] getExercises() {
        Scanner sc;
        ArrayList<String> usernameArrayList = new ArrayList<String>();

        try {
            File f = new File("Data\\Exercise.txt");
            Scanner fileScanner = new Scanner(f);
            String excersises[] = new String[countExercise()];
            int count = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineSc = new Scanner(line).useDelimiter("#");

                //dependent on file columns
                String exercise = lineSc.next();

                usernameArrayList.add(exercise);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);

        }

        String[] usernameStringArray = usernameArrayList.toArray(new String[0]);

        return usernameStringArray;
    }

    //counts the number of exercises in the txt file
    private static int countExercise() {
        int count = 0;
        try {
            File f = new File("Data\\Exercise.txt");
            Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                count++;
            }
            return count;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    //gets the exercises that the user has completed today
    public static String[] getUserExercises(String user) {
        String[] test = {"Ex1", "Ex2", "Ex3"};
        return test;

    }

    //calucates the caloric loss for a day
    public static double calcCalLoss(String exercise, int duration, double weight) throws FileNotFoundException {

        double metVal = getMETVal(exercise);
        return metVal;
    }

}
