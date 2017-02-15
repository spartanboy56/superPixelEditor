package main.java.com.rlearning.model;
import javafx.scene.paint.Color;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveColorArray {

  private Color[] ColorArray = null;
  private String FileDir = null;
  private BufferedWriter BWriter = null;
  private FileWriter FWriter = null;
  private String FileContent = null;


  // Gets the color array and directory and set it to the FileWriter and BufferWriter.
  // Added exception errors.
  // Call this method first to save the color array to file.
  public void SaveArray(Color[] _color, String _dir) {
    // Set file directory
    this.FileDir = _dir;

    // Set color array
    for (int i = 0; i < _color.length; i++) {
      this.ColorArray[i] = _color[i];
    }

    // Setup content to be put in the file. Check 'SETUP_FILE_CONTENT' method for more details.
    SETUP_FILE_CONTENT();

    try {
      // Open FileWriter and BufferWriter streams
      this.FWriter = new FileWriter(this.FileDir);
      this.BWriter = new BufferedWriter(this.FWriter);
      this.BWriter.write(this.FileContent);
    } catch (IOException e) {
      // If this happens, I'm moving to C#
      e.printStackTrace();
    } finally {
      try {
        // If the BufferWriter or the FileWriter streams are still open, close them
        if (this.BWriter != null) {
          BWriter.close();
        }
        if (this.FWriter != null) {
          FWriter.close();
        }
      } catch (IOException ex) {
        // Uhhh, I don't know why they are closed. Something happened.
        ex.printStackTrace();
      }
    }


  }

  private void SETUP_FILE_CONTENT() {
    for (int i = 0; i < this.ColorArray.length; i++) {
      // Format of each line in the file:
      // R-value, G-value, B-value, A-value
      // Each line would represent each pixel "Color"
      this.FileContent = this.FileContent + this.ColorArray[i].getRed() + ", " + this.ColorArray[i].getGreen() + ", " + this.ColorArray[i].getBlue() + ", " + this.ColorArray[i].getOpacity() + "\n";
    }
  }


  // Getters and Setters

  // Setters
  public void SET_FILE_DIR(String directory) {
    this.FileDir = directory;
  }

  public void SET_COLOR_ARRAY(Color[] color) {
    this.ColorArray = color;
  }

  public void SET_SPECIFIC_COLOR(Color color, int position) {
    this.ColorArray[position] = color;
  }

  // Getters
  public Color[] GET_COLOR_ARRAY() {
    return this.ColorArray;
  }

  public Color GET_SPECIFIC_COLOR(int position) {
    return this.ColorArray[position];
  }

  public String GET_FILE_DIR() {
    return this.FileDir;
  }
}
