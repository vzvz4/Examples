package org.example;


public abstract class BaseObject {
    private double x;
    private double y;
    private boolean isAlive;
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public BaseObject(double x, double y, double radius) {
        isAlive = true;
        this.x = x;
        this.y = y;
        this.radius = radius;
        
    }
    
    public void draw(){
        
    }
    
    public void move() {
        
    }
    
    public void die() {
        isAlive = false;
    }
    
    public boolean isIntersect(BaseObject o) {
        return  evalDistance(o) < (o.getRadius() + this.getRadius());
    }

    public double evalDistance(BaseObject o) {
        return Math.sqrt(Math.pow(o.getX() - this.getX(), 2) + Math.pow(o.getY() - this.getY(), 2));
    }
    
}