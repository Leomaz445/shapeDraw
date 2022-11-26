package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Representing Oval with two set of coordinates (x1,y1) and (x2,y2)
 * the class is inherent from MyBoundedShape and implements the draw function from MyShape
 * implementing the equals function from the Object class.
 */
public class MyOval extends MyBoundedShape {
    //Constructor , implementing the MyBoundedShape constructor
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean toFill) {
        super(x1, y1, x2, y2, color, toFill);
    }

    /**
     * Function that draw the shape of the Oval and setting
     * the color of the fill if needed
     *
     * @param graphicsContext - the gc that helps as draw on the canvas.
     */
    public void draw(GraphicsContext graphicsContext) {
        if (this.getFillingColor()) {
            graphicsContext.setFill(getColor());
            graphicsContext.fillOval(getX1(), getY1(), getX2(), getY2());
        }
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeOval(getX1(), getY1(), getX2(), getY2());

    }
}
