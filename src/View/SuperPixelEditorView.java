/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Andrew
 */
public class SuperPixelEditorView extends Application {

  @Override
  public void start(Stage primaryStage) {
    Stage colorPickerStage = new Stage();
    StackPane colorPickerLayout = new StackPane();
    Scene colorPickerScene = new Scene(colorPickerLayout, 200, 100);
    ColorPicker colorPicker = new ColorPicker();

    colorPickerLayout.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
    colorPickerLayout.getChildren().addAll(colorPicker);
    colorPickerStage.setTitle("Color Picker");
    colorPickerStage.setScene(colorPickerScene);

    Button btn = new Button();
    btn.setText("Color Picker");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        colorPickerStage.show();
      }
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

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
