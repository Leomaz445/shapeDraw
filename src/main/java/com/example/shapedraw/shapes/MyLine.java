package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);

    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeLine(getX1(), getY1(), getX2(), getY2());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MyLine myLine))
            return false;

        return calcLineLength(this) == calcLineLength(myLine);
    }

    private double calcLineLength(MyLine myLine) {
        return Math.sqrt((Math.pow(Math.abs(myLine.getX2() - myLine.getX1()), 2)) +
                (Math.pow(Math.abs(myLine.getY2() - myLine.getY1()), 2)));
    }
}
