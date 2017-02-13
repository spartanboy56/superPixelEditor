/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ColorPaletteController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Andrew
 */
public class SuperPixelEditorView extends Application {


  @Override
  public void start(Stage primaryStage) {
   //Create menu bar
        MenuBar menuBar = new MenuBar();
        //Creates menus
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        //File menu items
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem saveAsItem = new MenuItem("Save As");
        //Edit menu items
        MenuItem undoItem = new MenuItem("Undo");
        MenuItem redoItem = new MenuItem("Redo");
        //Help menu items
        MenuItem controlsItem = new MenuItem("Controls");
        MenuItem aboutItem = new MenuItem("About");
        //Adds menu items to the menus
        menuFile.getItems().addAll(openItem,saveItem,saveAsItem);
        menuEdit.getItems().addAll(undoItem,redoItem);
        menuHelp.getItems().addAll(controlsItem,aboutItem);
        //Adds all the menus to the menu bar
        menuBar.getMenus().addAll(menuFile,menuEdit,menuHelp);
    Stage colorPickerStage = new Stage();
    StackPane colorPickerLayout = new StackPane();
    Scene colorPickerScene = new Scene(colorPickerLayout, 200, 100);
    ColorPicker colorPicker = new ColorPicker();

    colorPickerLayout.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
    colorPickerLayout.getChildren().addAll(colorPicker);

    colorPickerStage.setTitle("Color Picker");
    colorPickerStage.setScene(colorPickerScene);

    HBox hbButtons = new HBox();

    Button btn = new Button();
    btn.setText("Color Picker");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        colorPickerStage.show();
      }
    });

    Button saveBtn = new Button();
    saveBtn.setText("Save Custom Colors");
    saveBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        ColorPaletteController.saveColorPalette(colorPicker);
      }

    });

    Button loadBtn = new Button();
    loadBtn.setText("Load Custom Colors");
    loadBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        ColorPaletteController.loadColorPalette(colorPicker);
      }

    });

    StackPane root = new StackPane();
    hbButtons.getChildren().add(btn);
    hbButtons.getChildren().add(saveBtn);
    hbButtons.getChildren().add(loadBtn);
    root.getChildren().add(hbButtons);

    Scene scene = new Scene(root, 400, 250);

    primaryStage.setTitle("Super Pixel Art Editor");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
