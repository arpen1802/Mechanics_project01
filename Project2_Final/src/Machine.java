public class Machine {

    private Body M1;
    private Body M2;
    private Body M3;
    private final int g = 10;

    public Machine( Body m1, Body m2, Body m3) {

        M1 = m1;
        M2 = m2;
        M3 = m3;
    }

    public void applyForce(double F, int time){
        double m1 = M1.getMass();
        double m2 = M2.getMass();
        double m3 = M3.getMass();

        double f1 = M1.getFriction();
        double f2 = M2.getFriction();
        double f3 = M3.getFriction();

        double a1 = ((m2+m3)/(m1*(m2+m3)+m2*m3*(1+f1)))*(F - m2*g*(f1+f1*f2+f2) - f1*m1*g -
                ((f1*m2+m2)/(m2+m3))*(-f2*m2*g + m3*g + F*f3));

        double a2 = (1/(m2+m3))*(m3*a1 - f2*m2*g + m3*g + F*f3);
        double a3x = a1;
        double a3y = a2-a1;
        M1.setX(M1.getX()+(a1/2)*time*time);
        M2.setX(M2.getX()+(a2/2)*time*time);
        M3.setX(M3.getX()+(a3x/2)*time*time);
        M3.setY(M3.getY()+(a3y/2)*time*time);

        System.out.println(M1.getX());
        System.out.println(M2.getX());
        System.out.println(M3.getX());
        System.out.println(M3.getY());


//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a3x);
//        System.out.println(a3y);

    }
}
