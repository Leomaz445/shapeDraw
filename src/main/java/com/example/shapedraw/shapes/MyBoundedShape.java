package com.example.shapedraw.shapes;

import javafx.scene.paint.Color;

/**
 * Abstract class for Bounded shape, its extends MyShape class and here
 * we added an attributes of filing color
 */
public abstract class MyBoundedShape extends MyShape {
    private boolean fillingColor;

    //Constructor
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fillingColor) {
        super(x1, y1, x2, y2, color);
        this.fillingColor = fillingColor;
    }

    //Get filling color
    public boolean getFillingColor() {
        return fillingColor;
    }

    //Set filling Color
    public void setFillingColor(boolean fillingColor) {
        this.fillingColor = fillingColor;
    }

}
