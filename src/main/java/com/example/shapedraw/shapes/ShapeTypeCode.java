package com.example.shapedraw.shapes;

/**
 * This class is an enum holds the Shapes type code
 */
public enum ShapeTypeCode {
    MY_LINE(1),
    MY_OVAL(2),
    MY_RECTANGLE(3);

    private final int shapeName;

    //Constructor
    ShapeTypeCode(int shapeName) {
        this.shapeName = shapeName;
    }

}
