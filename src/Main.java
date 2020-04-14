import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {
        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.print("Enter time T = ");
//        int time = myObj.nextInt();  // Read user input
//        int[] F = new int[time];
//        System.out.print("Enter force F =  " );
//        for (int i = 0; i<time; i++){
//            F[i] = myObj.nextInt();
//        }
//        int[] M = new int[3];
//        System.out.print("Enter masses M =  " );
//        for (int i = 0; i<3; i++){
//            M[i] = myObj.nextInt();
//        }
        int[] time = {1, 2, 3, 4, 5, 6};
        double[] F = {100, -50, 30, 40, -30, 150};
        double x2 = -2;
        double y2 = 15; //y1 = y2
        double y3 = 4;
        // L = x1-x2 + y1-y3 - constant
        double[] coeff = {0.1, 0.1, 0.1};

        Body M1 = new Body(0, y2, 10, coeff[0]);
        Body M2 = new Body(-x2, y2, 5, coeff[1]);
        Body M3 = new Body(0, y3, 3, coeff[2]);

        Machine machine = new Machine(M1, M2, M3);
        for (int i = 0; i<F.length; i++){
            machine.applyForce(-F[i], time[i]);
        }
    }


}
