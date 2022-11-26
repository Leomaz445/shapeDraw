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


    /**
     * Equal Method
     * we measure the shape with (x2,y2) coordinate when x2 - represent the length and y2 the height.
     *
     * @param obj - the shape we want to check if its equal
     * @return true - if the shapes are equal in size, false if another
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj == null))
            return false;
        if (!(obj instanceof MyShape))
            return false;

        return (this.getX2() == ((MyShape) obj).getX2())
                && (this.getY2() == ((MyShape) obj).getY2() && super.equals(obj));
    }
}
