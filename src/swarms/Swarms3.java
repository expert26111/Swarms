/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swarms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author yoyo
 */
public class Swarms3 {
//finding minimum
    private static final int numberOfBees = 10000;
    private double BoundaryNegative = -1.99;
    private double BoundaryPositive = 1.99;
    private Random gen = new Random();
    private double zBest = 2000;
    private double moveStep = 0.001;
    List<Point> bees = new ArrayList<>();
    Point bestChick = null;

    public Point getBestChick() {
        return bestChick;
    }
    
    

    public double cordinates() {
        return BoundaryNegative + (Math.random() * (BoundaryPositive - BoundaryNegative));
    }
    
    
    public static void main(String[] args) {
    
        Swarms3 test = new Swarms3();
        test.populateBees();
        
        for(int i = 0; i<1001 ; i++)
        {
            test.bestBee();
        }
        //System.out.println("my best chick "+(double)test.returnZ(test.getBestChick().getX(),test.getBestChick().getY()));
    }
    
    public  void bestBee()
    {
          bees.forEach(point->
         {
              if (zBest > returnZ(point.getX(), point.getY())) 
              {
                zBest = returnZ(point.getX(), point.getY());
                  System.out.println("the zBEst "+zBest);
                bestChick = point;
              }
         });
          
          
                bees.forEach(point->
         {
            moveTowards(bestChick,point);
         });
          

    }
    
    
        public Point moveTowards(Point target,Point source)
    {
        double deltaX = Math.abs(target.getX() - source.getX());
        double deltaY = Math.abs(target.getY() - source.getY());
        double angle = Math.atan2( deltaY, deltaX );
        //set with the new X and new Y and step is 0.2
        source.setX(source.getX() + moveStep* Math.cos(angle));
        source.setY(source.getY() + moveStep* Math.sin(angle));
        return source;
    }
    
    
    public void populateBees() {
        double x = 0;
        double y = 0;
        for (int i = 0; i < numberOfBees; i++) {
            x = cordinates();
            y = cordinates();
            Point newPoint = new Point(x, y);
            bees.add(newPoint);
        }
    }

    public double returnZ(double x, double y) {
        double z = x * (Math.exp(-x * x - y * y));
        //System.out.println("The value for z is " + z);
        return z;
    }
}
