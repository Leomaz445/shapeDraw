package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Have the common attributes of shape,each shape has two set of coordinates (x1,y1),(x2,y2)
 * this class has a abstract methods draw and equals and in this
 * class we implement Cloneable to clone shapes.
 */
public abstract class MyShape implements Cloneable {
    private int x1, y1;
    private int x2, y2;
    private Color color;

    //Constructor
    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    //Get X1
    public int getX1() {
        return x1;
    }

    //Set X1
    public void setX1(int x1) {
        this.x1 = x1;
    }

    //Get Y1
    public int getY1() {
        return y1;
    }

    //Set Y1
    public void setY1(int y1) {
        this.y1 = y1;
    }

    //Get X2
    public int getX2() {
        return x2;
    }

    //Set X2
    public void setX2(int x2) {
        this.x2 = x2;
    }

    //Get Y2
    public int getY2() {
        return y2;
    }

    //Set Y2
    public void setY2(int y2) {
        this.y2 = y2;
    }

    //Get Color
    public Color getColor() {
        return color;
    }

    //Set Color
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * This abstract method force the other classes to implemnt it so they will have the
     * option to draw them self.
     *
     * @param graphicsContext - the gc that helps as draw on the canvas.
     */
    public abstract void draw(GraphicsContext graphicsContext);

    /**
     * Implementing the clone interface.
     *
     * @return cloned shape
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}