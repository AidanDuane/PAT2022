/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidand
 */
public class test {

    public static void main(String[] args) throws FileNotFoundException {
        String exercise = "running";
        double duration = 2;
        System.out.println(ExerciseManager.calcCalLoss(exercise, duration));
    }
}
