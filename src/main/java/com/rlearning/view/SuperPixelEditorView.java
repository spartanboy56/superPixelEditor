/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlearning.view;

import com.rlearning.controller.ColorPaletteController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
<<<<<<< master:src/View/SuperPixelEditorView.java
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
=======
import javafx.scene.control.*;
import javafx.scene.layout.*;
>>>>>>> Re-organizing code folders and implementing gradle build mechanism:src/main/java/com/rlearning/view/SuperPixelEditorView.java
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Andrew
 */
public class SuperPixelEditorView extends Application {


  @Override
  public void start(Stage primaryStage) {
    //new window opens after btnNewWindow is clicked
    Stage newWindowStage = new Stage();
    StackPane newWindowLayout = new StackPane();
    Scene newWindowScene = new Scene(newWindowLayout, 620, 480);
    Button btnNewWindow = new Button("Open a window with this color");
    Button btnColorReset = new Button("Reset Window Color");
    Button btn = new Button("Color Picker");

    newWindowStage.setScene(newWindowScene);
    newWindowStage.setTitle("");
        //Create menu bar
        MenuBar menuBar = new MenuBar();
<<<<<<< master
        menuBar.setStyle("-fx-background-color: white;");
=======
        //Creates menu separator
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem3 = new SeparatorMenuItem();
<<<<<<< master
>>>>>>> Update SuperPixelEditorView.java
=======
        SeparatorMenuItem separatorMenuItem4 = new SeparatorMenuItem();
>>>>>>> Update SuperPixelEditorView.java
        //Creates menus
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        //File menu items
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem saveAsItem = new MenuItem("Save As");
        MenuItem saveColorItem = new MenuItem("Save Color Palette");
        MenuItem loadColorItem = new MenuItem("Load Color Palette");
        MenuItem optionsItem = new MenuItem("Options...");
        MenuItem exitItem = new MenuItem("Exit");
        //Edit menu items
        MenuItem undoItem = new MenuItem("Undo");
        MenuItem redoItem = new MenuItem("Redo");
        //Help menu items
        MenuItem controlsItem = new MenuItem("Controls");
        MenuItem aboutItem = new MenuItem("About");
        //Adds menu items to the menus
        menuFile.getItems().addAll(openItem,separatorMenuItem1,saveItem,saveAsItem,separatorMenuItem2,saveColorItem,loadColorItem,separatorMenuItem3,optionsItem,separatorMenuItem4,exitItem);
        menuEdit.getItems().addAll(undoItem,redoItem);
        menuHelp.getItems().addAll(controlsItem,aboutItem);
        //Adds all the menus to the menu bar
        menuBar.getMenus().addAll(menuFile,menuEdit,menuHelp);

    Stage colorPickerStage = new Stage();
    VBox colorPickerLayout = new VBox();
    Scene colorPickerScene = new Scene(colorPickerLayout, 300, 150);
    ColorPicker colorPicker = new ColorPicker();

    colorPickerLayout.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
    colorPickerLayout.setSpacing(10.0);
    colorPickerLayout.alignmentProperty().setValue(Pos.CENTER);
    colorPickerLayout.getChildren().addAll(colorPicker, btnNewWindow, btnColorReset);

    colorPickerStage.setTitle("Color Picker");
    colorPickerStage.setScene(colorPickerScene);

    //Popup window
    HBox hbButtons = new HBox();
    hbButtons.setSpacing(10.0);
    hbButtons.setAlignment(Pos.CENTER);
    Stage popupStage = new Stage();
    popupStage.setTitle("Popup Dialog");
    StackPane popupLayout = new StackPane();
    Scene popupScene = new Scene(popupLayout, 300, 50);
    Text popupText = new Text("A window is already open.");

    popupLayout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    popupStage.setScene(popupScene);
    popupLayout.getChildren().addAll(popupText);

    //handlers - may be better suited in control
    colorPicker.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        newWindowLayout.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), null, null)));
      }
    });

    btnColorReset.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        newWindowLayout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        colorPicker.setValue(Color.WHITE);
      }
    });

    btnNewWindow.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if (!newWindowStage.isShowing()) {
          newWindowStage.show();
          newWindowLayout.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), null, null)));
        } else popupStage.show();
      }
    });

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
<<<<<<< master
    BorderPane root = new BorderPane();
    root.setTop(menuBar);
    //color picker
=======

    // Menu Item Functions

    saveColorItem.setOnAction(new EventHandler<ActionEvent>(){
    	@Override
    	public void handle(ActionEvent event){
    		ColorPaletteController.saveColorPalette(colorPicker);
    	}
    });

    loadColorItem.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        ColorPaletteController.loadColorPalette(colorPicker);
      }

    });
    
    exitItem.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.exit(0);
      }

    });

    // Still using a StackPane as root for the main Scene, as I'm unsure if there's a reason to keep it like that instead of using a BorderPane as root.
    StackPane root = new StackPane();
    // BorderPane might be better suited for this design, as it allows more precise positioning of UI elements.
    BorderPane contentPane = new BorderPane();
    contentPane.setTop(menuBar);
    contentPane.setCenter(hbButtons);


>>>>>>> Update SuperPixelEditorView.java
    hbButtons.getChildren().add(btn);
    //Save custom colors
    hbButtons.getChildren().add(saveBtn);
    //Load custom colors
    hbButtons.getChildren().add(loadBtn);
<<<<<<< master
    root.setCenter(hbButtons);
=======

    root.getChildren().addAll(contentPane);
>>>>>>> Update SuperPixelEditorView.java

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
