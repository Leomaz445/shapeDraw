package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Representing a line with two set of coordinates (x1,y1) and (x2,y2)
 * the class is inherent from MyShape and implements the draw function
 * and this class is also implementing the equals function from the Object class.
 */
public class MyLine extends MyShape {

    //Constructor - using the constructor of MyShape
    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);

    }

    /**
     * Drawing the line and setting the color of the line.
     *
     * @param graphicsContext - the graphicsContext that helps as draw on the canvas.
     */
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeLine(getX1(), getY1(), getX2(), getY2());
    }

    /**
     * Equal Method that we override from the Object class
     *
     * @param obj - the shape we want to check if its equal
     * @return true - if the shapes are equal in size, false if another
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MyLine myLine))
            return false;

        return ((calcLineLength(this) == calcLineLength(myLine)) && super.equals(obj));
    }

    //Private function that implements Pythagoras to check if the line are equals in length.
    private double calcLineLength(MyLine myLine) {
        return Math.sqrt((Math.pow(Math.abs(myLine.getX2() - myLine.getX1()), 2)) +
                (Math.pow(Math.abs(myLine.getY2() - myLine.getY1()), 2)));
    }
}
