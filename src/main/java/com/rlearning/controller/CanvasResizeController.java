package main.java.com.rlearning.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//class used to make the canvas resize with the size of the window
public class CanvasResizeController extends Canvas{

    public CanvasResizeController(){

        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,52,width,height);
    }

    @Override
    public boolean isResizable(){
        return true;
    }

    @Override
    public double prefWidth(double height){
        return getWidth();
    }

    @Override
    public double prefHeight(double width){
        return getHeight();
    }


}
