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
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidand
 */
public class UserManager {

    //gets all the usersnames from the Users text file
    public static String[] getUsernames() {
        Scanner sc;
        ArrayList<String> usernameArrayList = new ArrayList<String>();

        try {
            File f = new File("Data\\Users.txt");
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

    //gets the number of existing users
    public static int countUsers() {
        int count = 0;
        try {
            File f = new File("Data\\Users.txt");
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

//gets all the info about each user
    public static String[] getInfo(String selectedUsername) {

        String[] info = new String[5];

        try {
            File f = new File("Data\\Users.txt");
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

    //creates a new user in the Users txt file
    public static void newUser(String name, double weight, double height, String sex, int goal, int age) throws IOException {
        String newUser = (name + "#" + weight + "#" + height + "#" + sex + "#" + goal + "#" + age);
        FileWriter write = new FileWriter(new File("Data\\Users.txt"), true);

        write.append('\n' + newUser);

        write.flush();

        write.close();
    }

}
