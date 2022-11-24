package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyBoundedShape {

    public MyRectangle(int x1, int y1, int x2, int y2, Color color,boolean toFill) {
            super(x1,y1,x2,y2,color,toFill);
    }

    public void draw(GraphicsContext graphicsContext) {
        if(this.isToFill()){
            graphicsContext.setFill(getColor());
            graphicsContext.fillRect(getX1(), getY1(), getX2(), getY2());
        }
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeRect(getX1(), getY1(), getX2(), getY2());
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MyRectangle myRectangle))
            return false;

        return (this.getX2() == myRectangle.getX2())
                && (this.getY1() == myRectangle.getY1());

    }
}
