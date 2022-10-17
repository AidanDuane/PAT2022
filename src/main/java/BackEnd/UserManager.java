/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidand
 */
public class UserManager {
    public static final int WEIGHT = 0;
    public static final int HEIGHT = 1;
    public static final int SEX = 2;
    public static final int GOAL = 3;
    public static final int AGE = 4;

    public static String userProfilesPath = "Data\\UsersProfiles.txt";
    public static String currentUserPath = "Data\\CurrentUser.txt";

    //returns an array of every username from the Users text file
    public static String[] getUsernames() {
        Scanner sc;
        ArrayList<String> usernameArrayList = new ArrayList<String>();

        try {
            File f = new File(userProfilesPath);
            Scanner fileScanner = new Scanner(f);
            String usernames[] = new String[countUsers()];
            int count = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineSc = new Scanner(line).useDelimiter("#");

                //dependent on file columns
                String username = lineSc.next();

                usernameArrayList.add(username);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);

        }

        String[] usernameStringArray = usernameArrayList.toArray(new String[0]);

        return usernameStringArray;
    }

    //returns the total number of existing users
    public static int countUsers() {
        int count = 0;
        try {
            File f = new File(userProfilesPath);
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

//returns all the info about a specific user
    public static String[] getInfo(String selectedUsername) {

        String[] info = new String[5];

        try {
            File f = new File(userProfilesPath);
            Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(fileScanner.nextLine()).useDelimiter("#").useLocale(Locale.ENGLISH);

                String scanUsername = lineScanner.next();
                double scanWeight = lineScanner.nextDouble();
                double scanHeight = lineScanner.nextDouble();
                String scanSex = lineScanner.next();
                double scanGoal = lineScanner.nextDouble();
                int scanAge = lineScanner.nextInt();

                if (scanUsername.equals(selectedUsername)) {
                    info[0] = scanWeight + "";
                    info[1] = scanHeight + "";
                    info[2] = scanSex;
                    info[3] = scanGoal + "";
                    info[4] = scanAge + "";
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return info;
    }

    //creates a new user in the Users txt file, with 
    //all the appropriate information(sex,weight,height,etc...)
    public static void newUser(String name, double weight, double height, String sex, int goal, int age) throws IOException {
        String newUser = (name + "#" + weight + "#" + height + "#" + sex + "#" + goal + "#" + age);
        FileWriter write = new FileWriter(new File("Data\\Users.txt"), true);

        write.append('\n' + newUser);

        write.flush();

        write.close();
    }

    //returns the current user that is logged in
    public static String getCurrentUser() {
        String name = "";
        try {
            File f = new File(currentUserPath);
            Scanner fileScanner = new Scanner(f);

            name = fileScanner.next();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    //sets a user to the current user(logs the user in)
    public static void setCurrentUser(String user) throws IOException {
        FileWriter fw = new FileWriter(currentUserPath);

        PrintWriter pw = new PrintWriter(fw);
        pw.print(user);
        pw.close();
    }
    

}
