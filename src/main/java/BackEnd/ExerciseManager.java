/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import static BackEnd.UserManager.countUsers;
import static BackEnd.UserManager.userProfilesPath;
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
    public static String exerciseLogPath = "Data\\ExerciseLog.txt";
    public static String exerciseListPath = "Data\\Exercises.txt";
    
    // finds the users MET value
    public static double getMETVal(String exNameIN) throws FileNotFoundException {
        File f = new File(exerciseListPath);
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

    //fetches all the different excersise 
    //names from the exercise list text file
    public static String[] getExercises() {
        Scanner sc;
        ArrayList<String> usernameArrayList = new ArrayList<String>();

        try {
            File f = new File(exerciseListPath);
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

    //counts the number of exercises in the exercise lit text file
    private static int countExercise() {
        int count = 0;
        try {
            File f = new File(exerciseListPath);
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

    //gets the exercises that the user has completed on a certain day
    public static String[] getUserExercises(String user, String date) {
        Scanner sc;
        ArrayList<String> userExerciseList = new ArrayList<String>();

        try {
            File f = new File(exerciseLogPath);
            Scanner fileScanner = new Scanner(f);
            String userExercises[] = new String[countLogs()];
            int count = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineSc = new Scanner(line).useDelimiter("#");

                //dependent on file columns
                String username = lineSc.next();
                String exercise = lineSc.next();
                String logdate = lineSc.next();
                
                if (username.equals(user) && logdate.equals(date)){
                    userExerciseList.add(exercise);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);

        }

        String[] exerciseStringArray = userExerciseList.toArray(new String[0]);

        return exerciseStringArray;

    }

    //calucates the total caloric loss for a certain day
    public static double calcCalLoss(String exercise, double duration) throws FileNotFoundException {
        String currentUser = UserManager.getCurrentUser();
        String[] info = UserManager.getInfo(currentUser);
        
        double metVal = getMETVal(exercise);
        int bodyweight = Integer.parseInt(info[UserManager.WEIGHT]);
        int calorieburn = (int) ((duration * metVal * bodyweight) / 200);
        return calorieburn;
    }
        
    //counts the total amount of user logs in the 
    //exercise log text file
        public static int countLogs() {
        int count = 0;
        try {
            File f = new File(exerciseLogPath);
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

}
