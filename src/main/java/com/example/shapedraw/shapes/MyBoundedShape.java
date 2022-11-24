package com.example.shapedraw.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyBoundedShape extends MyShape {
    private boolean toFill;

    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean toFill) {
        super(x1, y1, x2, y1, color);
        this.toFill = toFill;
    }

    public boolean isToFill() {
        return toFill;
    }

    public void setToFill(boolean toFill) {
        this.toFill = toFill;
    }

    @Override
    public abstract void draw(GraphicsContext graphicsContext);

    @Override
    public abstract boolean equals(Object obj);


}
