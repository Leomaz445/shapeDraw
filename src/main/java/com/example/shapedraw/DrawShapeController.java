package com.example.shapedraw;

import com.example.shapedraw.shapes.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class DrawShapeController {

    private final static int NUMBER_OF_SHAPES = 6;
    private final static int UPPER_RANDOM_BOUND = 201;
    private final static int MOVE_SHAPE_BY_VALUE = 10;
    public static final int LINE = 0;
    public static final int OVAL = 1;
    public static final int RECTANGLE = 2;
    public static final int TYPE_OF_SHAPES = 3;


    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        makeDrawings(gc);
    }

    private void makeDrawings(GraphicsContext gc) {
        ArrayList<MyShape> myShapes = new ArrayList<>();
        ArrayList<MyShape> myShapesClone = new ArrayList<>();
        generateShapes(myShapes);
        cloneShapes(myShapes, myShapesClone);
        modifiedClonedShapes(myShapesClone);
        for (int i = 0; i < NUMBER_OF_SHAPES; i++) {
            myShapes.get(i).draw(gc);
            myShapesClone.get(i).draw(gc);
        }
    }

    private void modifiedClonedShapes(ArrayList<MyShape> myShapesClone) {
        for (MyShape shape : myShapesClone) {
            shape.setX1(shape.getX1() + MOVE_SHAPE_BY_VALUE);
            shape.setY2(shape.getY2() + MOVE_SHAPE_BY_VALUE);
            shape.setColor(Color.GREEN);
            if (shape instanceof MyBoundedShape) {
                ((MyBoundedShape) shape).setToFill(false);
            }
        }
    }

    private void cloneShapes(ArrayList<MyShape> myShapes, ArrayList<MyShape> myShapesClone) {
        for (MyShape shape : myShapes) {
            myShapesClone.add(shape.clone());
        }
    }

    private void generateShapes(ArrayList<MyShape> myShapes) {
        Random rand = new Random();
        int x1, y1;
        int x2, y2;
        for (int i = 0; i < NUMBER_OF_SHAPES; i++) {
            x1 = rand.nextInt(UPPER_RANDOM_BOUND);
            y1 = rand.nextInt(UPPER_RANDOM_BOUND);
            x2 = rand.nextInt(UPPER_RANDOM_BOUND);
            y2 = rand.nextInt(UPPER_RANDOM_BOUND);
            switch (i % TYPE_OF_SHAPES) {
                case LINE:
                    myShapes.add(new MyLine(x1, y1, x2, y2, Color.RED));
                    break;
                case OVAL:
                    myShapes.add(new MyOval(x1, y1, x2, y2, Color.RED, true));
                    break;
                case RECTANGLE:
                    myShapes.add(new MyRectangle(x1, y1, x2, y2, Color.RED, true));
                    break;
            }
        }
    }


}
