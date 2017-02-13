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
import javafx.geometry.Pos;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.scene.layout.HBox;

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
    Button btnColorPicker = new Button("Color Picker");

    newWindowStage.setScene(newWindowScene);
    newWindowStage.setTitle("");
    //Create menu bar
    StackPane stackPaneMenuBar = new StackPane();
    stackPaneMenuBar.alignmentProperty().setValue(Pos.TOP_CENTER);
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
    MenuItem copyItem = new MenuItem("Copy");
    MenuItem pasteItem = new MenuItem("Paste");
    //Help menu items
    MenuItem controlsItem = new MenuItem("Controls");
    MenuItem aboutItem = new MenuItem("About");
    //Adds all the menus to the menu bar
    menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);
    //Adds menu items to the menus
    menuFile.getItems().addAll(openItem, saveItem, saveAsItem);
    menuEdit.getItems().addAll(undoItem, redoItem, copyItem, pasteItem);
    menuHelp.getItems().addAll(controlsItem, aboutItem);
    //Shows menus
    menuFile.show();
    menuEdit.show();
    menuHelp.show();
    //Creates color picker and color picker window
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

    //Buttons - TODO: Find a better, nicer looking way to layout the buttons
    HBox hbButtons = new HBox();
    hbButtons.alignmentProperty().setValue(Pos.CENTER);
    //Popup window
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

    btnColorPicker.setOnAction(new EventHandler<ActionEvent>() {
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
    root.getChildren().addAll(btnColorPicker);
    hbButtons.getChildren().add(btnColorPicker);
    hbButtons.getChildren().add(saveBtn);
    hbButtons.getChildren().add(loadBtn);
    stackPaneMenuBar.getChildren().addAll(menuBar);
    root.getChildren().addAll(hbButtons, stackPaneMenuBar);

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
