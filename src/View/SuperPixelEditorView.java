/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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


    //color picker window
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

    StackPane root = new StackPane();
    root.getChildren().addAll(btn);
    Scene scene = new Scene(root, 300, 250);

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
