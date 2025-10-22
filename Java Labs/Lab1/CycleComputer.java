import sheffield.*;

public class CycleComputer {
    public static void main(String[] args) {
        EasyReader mydata = new EasyReader("timings.txt");
        int numReadings = mydata.readInt();
        System.out.println("Number of Readings: " + numReadings);

        double[] a = new double[numReadings]; // create array to hold readings
        for (int i = 0; i < numReadings; i++) {
            a[i]= mydata.readDouble();
        //     System.out.println("displays each item in the array: " + a[i]);   
        }
        // System.out.println("total readings: " + numReadings);

        double wheelDiameter = 0.665; // 車輪直徑 in metres
        double wheelCircumference = wheelDiameter * Math.PI; //車輪周長
        double[] timings = a; 
        double[] speeds = new double[timings.length];


        //使用 for 迴圈計算每圈速度
        for (int i = 0; i < timings.length; i++) {
            double speedMS = wheelCircumference / timings[i]; // m/s
            double speedKMH = speedMS * 3.6; // 轉換成 km/h
            speeds[i] = speedKMH;
            System.out.printf("Instantaneous speed for rotation %d: %.2f km/h%n", i + 1, speedKMH);
        }
        //找出最大速度
        double maxSpeed = speeds[0];
        for (double s : speeds) {
            if (s > maxSpeed) {
                maxSpeed = s;
            }
        }
        System.out.printf("Maximum speed: %.2f km/h%n", maxSpeed);

        //總距離與時間
        double totalDistance = wheelCircumference * timings.length; // 單位 m
        double totalTime = 0;
        for (double t : timings) {
            totalTime += t;
        }
        System.out.printf("Total distance: %.2f m%n", totalDistance);
        System.out.printf("Total time: %.2f s%n", totalTime);

    }
    
}
