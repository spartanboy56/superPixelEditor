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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
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

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        //template had stack pane. Researched to find stackpane doesn't work well with menubars. Changed to Borderpane
        BorderPane root = new BorderPane();
        //Adds menu bar to pane
        root.setTop(menuBar);
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
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
