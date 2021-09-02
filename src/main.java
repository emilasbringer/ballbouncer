import javax.swing.*;

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
    private static double hstop = 0.5;                  //Minimum required max height
    private static double k = 0.6;                      //Bounce coefficient
    private static double v = 0;                        //Velocity
    private static double vt = 0;                       //Velocity time

    public static void main(String[] arg){

        String inputtext = "";
        String inputmessage = "";
        valueinputter(inputtext, inputmessage);
        if (trueorfalse){
            System.out.println("Starting calculations");
            h();
        }
        else {
            valueinputter(inputtext, inputmessage);
        }
    }

    private static void h() {
        while (hmax > hstop) {
                System.out.println(h);
                if (fallingdown) {
                    v = -(9.82*(vt*vt));
                    vt += 0.01;
                    if (h <= 0) {
                        fallingdown = false;
                        t += ct;
                        v = -v * k;
                        vt = 0;
                        //System.out.println("made v negative");
                        if (t > 20) {
                            hmax = 0;
                            System.out.println("Took too long!");
                        }
                    }
                }
                else if (!contact){
                    v -= 9.82*(vt*vt);
                    vt += 0.01;
                    if (v <= 0) {
                        fallingdown = true;
                        hmax = h;
                        //System.out.println("Reached apex and set hmax to h = " + hmax);
                    }
                }
                h += v;
                t += dt;
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
