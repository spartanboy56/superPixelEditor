/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.SuperPixelEditorView;
import javafx.scene.paint.Color;

/**
 *
 * @author Andrew
 */
public class SuperPixelEditorController {
  // This gets the color picker color for now. It will later be changed so that it
  // retrieves the color being used in the canvas & a function will be added that
  // retrieves the pixel position of where the mouse was clicked as well as the color
  // at that location.
  public static Color currentColorSelected(){
    return (SuperPixelEditorView.getColor() == null) ? Color.WHITE : SuperPixelEditorView.getColor();
  }
}
