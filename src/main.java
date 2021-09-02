import com.sun.tools.jconsole.JConsoleContext;

import javax.swing.*;
import java.awt.desktop.SystemEventListener;

public class main {
    public static Boolean trueorfalse = null;
    private static boolean fallingdown = true;          //Direction
    private static boolean contact = false;             //Is ball in contact with surface
    private static double ct = 0.1;                     //Contact Time
    private static double t = 0;                        //Time
    private static double dt = 0.01;                    //Time step
    private static double h0;                           //Start Height
    private static double h;                            //Height
    private static double g = 9.82;                     //Gravity
    private static double hf = 0;                       //Horizontal Force
    private static double hmax;                         //Max bounce Height
    private static double hstop = 0.01;                 //Minimum required max height
    private static double k = 0.9;                      //Bounce coefficient
    private static double v = 0;                        //Velocity

    public static void main(String[] arg){

        String inputtext = "";
        String inputmessage = "";
        valueinputter(inputtext, inputmessage);
        if (trueorfalse){
            h(t);
        }
        else {
            valueinputter(inputtext, inputmessage);
        }
    }

    private static void h(double t) {
        while (hmax > hstop) {
            if (!contact) {
                System.out.println(h + " " + t + " " + v);
                if (fallingdown) {
                    
                }
                h += v/100;
                t += dt;

            }
        }
    }
    static boolean valueinputter(String inputtext, String inputmessage) {
        inputmessage = "Please input desired dropheight in meters: ";
        inputtext = JOptionPane.showInputDialog("Ball weight: " + g + "\n" + "Ball dropheight: " + h + "\n" + "Plane angle: " + hf + "\n" + "\n" + inputmessage);
        h = Float.parseFloat(inputtext);
        h0 = h;
        hmax = h;
        inputmessage = "Please input desired horizontal force in Newtons : ";
        inputtext = JOptionPane.showInputDialog("Ball weight: " + g + "\n" + "Ball dropheight: " + h + "\n" + "Plane angle: " + hf + "\n" + "\n" + inputmessage);
        hf = Float.parseFloat(inputtext);

        String a = JOptionPane.showInputDialog("Ball weight: " + g + "\n" + "Ball dropheight: " + h + "\n" + "Plane angle: " + hf + "\n" + "\n" + "Are you satisfied with this input data? (y/n)");

        if(a.equals("y")) {trueorfalse = true;}
        if(a.equals("n")) {trueorfalse = false;}
        return trueorfalse;
    }
}
