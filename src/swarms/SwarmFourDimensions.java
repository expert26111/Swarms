/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swarms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author yoyo
 */
public class SwarmFourDimensions {
//finding max
    private static final int numberOfBees = 10000;
    private double BoundaryNegative = -1.99;
    private double BoundaryPositive = 1.99;
    private Random gen = new Random();
    private double zBest = -2000;
    private double moveStep = 0.001;
    List<Point4> bees = new ArrayList<>();
    Point4 bestChick = null;

    public Point4 getBestChick() {
        return bestChick;
    }

    public double cordinates() {
        return BoundaryNegative + (Math.random() * (BoundaryPositive - BoundaryNegative));
    }

    public static void main(String[] args) {

        SwarmFourDimensions test = new SwarmFourDimensions();
        test.populateBees();

        for (int i = 0; i < 10001; i++) {
            test.bestBee();
        }
        //System.out.println("my best chick "+(double)test.returnZ(test.getBestChick().getX(),test.getBestChick().getY()));
    }

    public void bestBee() {
        bees.forEach(point
                -> {
            if (zBest < returnZ(point.getX(), point.getY(), point.getU(), point.getW())) {
                zBest = returnZ(point.getX(), point.getY(), point.getU(), point.getW());
                System.out.println("the zBEst " + zBest);
                bestChick = point;
            }
        });

        bees.forEach(point
                -> {
            moveTowards(bestChick, point);
        });

    }

    public Point4 moveTowards(Point4 target, Point4 source) {
        double deltaX = Math.abs(target.getX() - source.getX());
        double deltaY = Math.abs(target.getY() - source.getY());
        double deltaU = Math.abs(target.getU() - source.getU());
        double deltaW = Math.abs(target.getW() - source.getW());

        double angle = Math.atan2(deltaY, deltaX);
        double angle2 = Math.atan2(deltaU, deltaW);
        //set with the new X and new Y and step is 0.2
        source.setX(source.getX() + moveStep * Math.cos(angle));
        source.setY(source.getY() + moveStep * Math.sin(angle));
        source.setU(source.getU() + moveStep * Math.cos(angle2));
        source.setW(source.getW() + moveStep * Math.sin(angle2));
        
        return source;

//        double deltaX = Math.abs(target.getX() - source.getX());
//        double deltaY = Math.abs(target.getY() - source.getY());
//        double deltaU = Math.abs(target.getU() - source.getU());
//        double deltaW = Math.abs(target.getW() - source.getW());
//        source.setX(source.getX() + moveStep * deltaX);
//        source.setY(source.getY() + moveStep * deltaY);
//        source.setU(source.getU() + moveStep * deltaU);
//        source.setW(source.getW() + moveStep * deltaW);
        // now you know how much far they are
        //this coefficient can be tweaked to decice how much near the two points will be after the update.. 0.5 = 50% of the previous distance

       // return source;
    }

    public void populateBees() {
        double x = 0;
        double y = 0;
        double u = 0;
        double w = 0;
        for (int i = 0; i < numberOfBees; i++) {
            x = cordinates();
            y = cordinates();
            u = cordinates();
            w = cordinates();
            Point4 newPoint = new Point4(x, y, u, w);
            bees.add(newPoint);
        }
    }

    public double returnZ(double x, double y, double u, double w) {
        double z = 2*x *(Math.exp(-x * x - y * y - (u - 1) * (u - 1) - w * w));
        //System.out.println("The value for z is " + z);
        return z;
    }
}
