package com.example.shapedraw;

import com.example.shapedraw.shapes.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

import static com.example.shapedraw.shapes.ShapeTypeCode.*;

/**
 * The Controller from here we initialize the canvas and drawing the shapes
 * as required.
 */
public class DrawShapeController {

    private static final int NUMBER_OF_SPECIFIC_SHAPE = 2;
    private static final int NUMBER_OF_TOTAL_SHAPES = 6;
    private static final int UPPER_RANDOM_BOUND = 201;
    private final static int MOVE_SHAPE_BY_VALUE = 10;
    public static final boolean FILL_WITH_COLOR = true;


    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    //initialize the canvas and called the drawing methond.
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        makeDrawings(gc);
    }

    /**
     * The main class that is generating the shapes
     * and we using cloneShape to clones and shapes after that we modify and printing the shapes.
     *
     * @param gc - the gc that helps as draw on the canvas
     */
    private void makeDrawings(GraphicsContext gc) {
        ArrayList<MyShape> myShapes = new ArrayList<>();
        ArrayList<MyShape> myShapesClone = new ArrayList<>();
        generateShapes(myShapes);
        cloneShapes(myShapes, myShapesClone);
        modifiedClonedShapes(myShapesClone);
        for (int i = 0; i < NUMBER_OF_TOTAL_SHAPES; i++) {
            myShapes.get(i).draw(gc);
            myShapesClone.get(i).draw(gc);
        }
    }

    /**
     * Here me modify the shapes and moving them as required.
     *
     * @param myShapesClone - the list of shapes we want to move.
     */
    private void modifiedClonedShapes(ArrayList<MyShape> myShapesClone) {
        for (MyShape shape : myShapesClone) {
            shape.setX1(shape.getX1() + MOVE_SHAPE_BY_VALUE);
            shape.setY1(shape.getY1() + MOVE_SHAPE_BY_VALUE);
            shape.setColor(Color.GREEN);
            if (shape instanceof MyBoundedShape) {
                ((MyBoundedShape) shape).setFillingColor(false);
            }
            if (shape instanceof MyLine) {
                shape.setX2(shape.getX2() + MOVE_SHAPE_BY_VALUE);
                shape.setY2(shape.getY2() + MOVE_SHAPE_BY_VALUE);
            }
        }
    }

    /**
     * Cloning the ArrayList of shapes and added them to a special array that will hold the
     * copied shapes.
     *
     * @param myShapes      - the original array
     * @param myShapesClone - the array of copied shapes.
     */
    private void cloneShapes(ArrayList<MyShape> myShapes, ArrayList<MyShape> myShapesClone) {
        for (MyShape shape : myShapes) {
            try {
                myShapesClone.add((MyShape) shape.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This function is for generating the shapes
     *
     * @param myShapes - the array of shapes we want to fill
     */
    private void generateShapes(ArrayList<MyShape> myShapes) {
        createShape(myShapes, MY_LINE);
        createShape(myShapes, MY_RECTANGLE);
        createShape(myShapes, MY_OVAL);
    }

    /**
     * Generating the shapes we asked to create each shape created as NUMBER_OF_SPECIFIC_SHAPE Value
     *
     * @param myShapes      - the array that hold the shapes
     * @param shapeTypeCode - the code of the shapes
     */
    private void createShape(ArrayList<MyShape> myShapes, ShapeTypeCode shapeTypeCode) {
        Random rand = new Random();
        int x1, y1;
        int x2, y2;
        for (int i = 0; i < NUMBER_OF_SPECIFIC_SHAPE; i++) {
            x1 = rand.nextInt(UPPER_RANDOM_BOUND);
            y1 = rand.nextInt(UPPER_RANDOM_BOUND);
            x2 = rand.nextInt(UPPER_RANDOM_BOUND);
            y2 = rand.nextInt(UPPER_RANDOM_BOUND);
            switch (shapeTypeCode) {
                case MY_LINE -> myShapes.add(new MyLine(x1, y1, x2, y2, Color.RED));
                case MY_OVAL -> myShapes.add(new MyOval(x1, y1, x2, y2, Color.RED, FILL_WITH_COLOR));
                case MY_RECTANGLE -> myShapes.add(new MyRectangle(x1, y1, x2, y2, Color.RED, FILL_WITH_COLOR));
            }
        }
    }
}

