/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidand
 */
public class MealManager {

    public static int getCals(String selectedMeal) throws FileNotFoundException {

        int calories = 0;

        try {
            File f = new File("Data\\Meals.txt");
            Scanner fileScanner = new Scanner(f);

            while (fileScanner.hasNextLine()) {
                Scanner lineScanner = new Scanner(fileScanner.nextLine()).useDelimiter("#").useLocale(Locale.ENGLISH);

                String scanName = lineScanner.next();
                int scanCalories = lineScanner.nextInt();

                if (scanName.equals(selectedMeal)) {
                    calories = scanCalories;
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return calories;
    }

}
