/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import static BackEnd.ExerciseManager.getMETVal;
import java.io.FileNotFoundException;

/**
 *
 * @author Aidan Duane
 */
public class test {
    public static void main(String[] args) throws FileNotFoundException {
        String currentUser = UserManager.getCurrentUser();
        String[] info = UserManager.getInfo(currentUser);
        
        double metVal = getMETVal("jogging");
        int bodyweight = Integer. parseInt(info[UserManager.WEIGHT]);
        int calorieburn = (int) ((50 * 3 * 3) / 200);
        System.out.println(calorieburn); 
    }
    
}
