public class Main {

    public static void main(String[] args) {
        //Problem 1
        Crossroad crossroad = new Crossroad(20, 4);
        for (double speed = 5.5; speed< 22.2; speed+=1.5){
            Car car = new Car(speed, 50, 2, 2);
            time_distance(speed, car.getPositiveAcc());
            System.out.print("Initial speed is " + speed + ". ");
            checkStatus(car,crossroad, false);
        }

        //Problem 2
//        Car boundedSpeedCar = new Car(19, 50, 3, 2);
//        checkStatus(boundedSpeedCar, crossroad, true);

        //Problem 3
//        Car carFront = new Car(40, 50, 1, 1);
//        Car carBehind = new Car(40, 10, 3, 3);
//        Crossroad crossroad1 = new Crossroad(10, 3 );
//        checkFor2Cars(carFront, carBehind, crossroad1);

    }

    private static double getPosition(Car car, Crossroad crossroad, boolean bounded){
        int t = crossroad.getLightTime();
        double initialSpeed = car.getSpeed();
        double accPosition = 0;
        if(bounded){
            for(int i = 1; i<=t; i++){
                accPosition += initialSpeed;
                if (initialSpeed+car.getPositiveAcc() < 27.7){
                    initialSpeed +=car.getPositiveAcc();
                }
            }
        }
        else {
            accPosition = car.getSpeed()*t + car.getPositiveAcc()*t*t/2;
        }
        return accPosition;
    }

    public static void checkStatus(Car car, Crossroad crossroad, boolean boundedSpeed){
        int t = crossroad.getLightTime();
        double accPosition = getPosition(car, crossroad, boundedSpeed);
        if (accPosition>=car.getDist()+crossroad.getWidth()){
            System.out.println("Drive!");
            return;
        }
        int t0 = 1;
        double stopVelocity;
        while (true){
            stopVelocity = car.getSpeed() - car.getNegativeAcc()*t0;
            if(stopVelocity<=0){
                break;
            }
            t0+=1;
        }
        double stopPosition = car.getSpeed()*t0 + car.getNegativeAcc()*t0*t0/2;

        if(stopPosition <= car.getDist()){
            System.out.println("Stop!");
        }
        else {
            System.out.println("Start stopping " + ((t0-t)>t0?t0:(t0-t)) + " seconds earlier.");
        }
    }


    public static void checkFor2Cars(Car car1, Car car2, Crossroad crossroad){
        int t = crossroad.getLightTime();
        double accPosition1 = car1.getSpeed()*t + car1.getPositiveAcc()*t*t/2;
        double accPosition2 = car2.getSpeed()*t + car2.getPositiveAcc()*t*t/2;
        if (accPosition1>=car1.getDist()+crossroad.getWidth()){
            System.out.println("Car1 Drive!");
        }
        else {
            System.out.println("Car1 Stop!");
        }
        if(accPosition2<accPosition1+car1.getDist() && accPosition2 >= car1.getDist()+car2.getDist()+crossroad.getWidth()){
            System.out.println("Car2 Drive!");
            return;
        }

        double relativeAcceleration = car1.getPositiveAcc()-car2.getPositiveAcc();
        double relativeVelocity = car1.getSpeed() - car2.getSpeed() + t*(relativeAcceleration);

        int t0 = 1;
        double relativePos;

        while (t0<100){
            relativePos = -relativeVelocity * t0 + relativeAcceleration *t0*t0/2;
            if(relativePos>-crossroad.getWidth()){
                System.out.println("Car2 Stop!");
                return;
            }
            t0+=1;
        }
    }
     public static void time_distance(double speed, double acceleration){
        for(int t = 1; t<= 10; t++){
            double dist = speed*t + acceleration*t*t/2;
            System.out.println("For t = " + t + ", distance  = "+ dist+".");
        }
    }
}
