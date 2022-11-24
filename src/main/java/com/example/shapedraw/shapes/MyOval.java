package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyBoundedShape {
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean toFill) {
        super(x1, y1, x2, y2, color, toFill);
    }

    public void draw(GraphicsContext graphicsContext) {
        if (this.isToFill()) {
            graphicsContext.setFill(getColor());
            graphicsContext.fillOval(getX1(), getY1(), getX2(), getY2());
        }
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeOval(getX1(), getY1(), getX2(), getY2());

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MyOval myOval))
            return false;

        return (this.getX2() == myOval.getX2())
                && (this.getY2() == myOval.getY2());

    }


}
