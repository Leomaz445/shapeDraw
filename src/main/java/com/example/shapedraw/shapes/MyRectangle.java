package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Representing MyRectangle with two set of coordinates (x1,y1) and (x2,y2)
 * the class is inherent from MyBoundedShape and implements the draw function from MyShape
 * implementing the equals function from the Object class.
 */
public class MyRectangle extends MyBoundedShape {
    //Constructor using the MyBoundedShape constructor.
    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean toFill) {
        super(x1, y1, x2, y2, color, toFill);
    }

    /**
     * Drawing the Rectangle shape - we're checking if we need to fill with color before.
     *
     * @param graphicsContext - the gc that helps as draw on the canvas.
     */
    public void draw(GraphicsContext graphicsContext) {
        if (this.getFillingColor()) {
            graphicsContext.setFill(getColor());
            graphicsContext.fillRect(getX1(), getY1(), getX2(), getY2());
        }
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeRect(getX1(), getY1(), getX2(), getY2());
    }
}

