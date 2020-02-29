public class Main {

    public static void main(String[] args) {
        Car car = new Car(10, 80, 2, 2);
        Crossroad crossroad = new Crossroad(20, 4 );
        System.out.println(checkStatus(car,crossroad));

    }
    public static int checkStatus(Car car, Crossroad crossroad){
        int t = crossroad.getLightTime();
        double accPosition = car.getSpeed()*t + car.getPositiveAcc()*t*t/2;
        if (accPosition>=car.getDist()+crossroad.getWidth()){
            return 1;
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
        double stopPosition = car.getSpeed()*t + car.getNegativeAcc()*t0*t0/2;
        System.out.println(accPosition);
        System.out.println(stopVelocity);
        if(stopPosition <= car.getDist()){
            return 2;
        }
        System.out.println("Start stopping " + (t0-t) + " seconds earlier.");
        return 0;
    }
}
