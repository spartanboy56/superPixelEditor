package Controller;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ColorPaletteController {
  public static void saveColorPalette(ColorPicker colorPicker) {
    final FileChooser fileChooser = new FileChooser();
    final Stage saveFileStage = new Stage();

    List<Color> customColors = colorPicker.getCustomColors();

    PrintWriter pw = null;
    try {
//      pw = new PrintWriter(new File("resources/custom_palette"));
      pw = new PrintWriter(fileChooser.showSaveDialog(saveFileStage));
      for (Color color : customColors)
        pw.println(String.valueOf(color.getRed()) + " " +
                String.valueOf(color.getGreen()) + " " +
                String.valueOf(color.getBlue()) + " " +
                String.valueOf(color.getOpacity()));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      pw.close();
    }
  }

  public static void loadColorPalette(ColorPicker colorPicker) {
    final FileChooser fileChooser = new FileChooser();
    final Stage openFileStage = new Stage();

    List<Color> customColors = colorPicker.getCustomColors();
    colorPicker.getCustomColors().addAll(customColors);

    Scanner scanner = null;
    try {
//      scanner = new Scanner(new File("resources/custom_palette"));
      scanner = new Scanner(fileChooser.showOpenDialog(openFileStage));
      while (scanner.hasNextLine()) {
        String[] colorParamsStr = scanner.nextLine().split(" ");
        double[] colorParams = Arrays.stream(colorParamsStr)
                .mapToDouble(Double::parseDouble)
                .toArray();
        colorPicker.getCustomColors().add(new Color(colorParams[0], colorParams[1], colorParams[2], colorParams[3]));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }
  }
}
