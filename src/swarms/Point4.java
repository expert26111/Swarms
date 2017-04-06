/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swarms;

/**
 *
 * @author yoyo
 */
public class Point4 {

    private double x;
    private double y;
    private double u;
    private double w;

    public double getU() {
        return u;
    }

    public double getW() {
        return w;
    }

    public void setU(double u) {
        this.u = u;
    }

    public void setW(double w) {
        this.w = w;
    }

    public Point4(double x, double y, double u, double w) {
        this.x = x;
        this.y = y;
        this.u = u;
        this.w = w;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return ("(" + x + "," + y + ")");
    }
}
