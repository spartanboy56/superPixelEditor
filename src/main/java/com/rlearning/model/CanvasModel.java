// TODO - Rename the package to suit with the whole Java skeleton thingy on github.

package model;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CanvasModel {
	
	// Group - container to hold the whole canvas.
	private Group CanvasGroup = null;
	private Scene CanvasScene = null;
	private Canvas CanvasObject = null;
	private GraphicsContext CanvasGraphics = null;
	
	// Not sure if we're using these variables yet...
	private Image CanvasImage = null;
	private ImageView CanvasImageView = null;
	
	// Simple method to setup the whole canvas. (Without graphics editing at the moment despite having GraphicsContext variable.)
	// Call this method first to create canvas.
	public void CreateCanvas(int WindowWidth, int WindowHeight, int CanvasWidth, int CanvasHeight, Color backgroundColor, Image image) {
		this.CanvasGroup = new Group();
		this.CanvasScene = new Scene(CanvasGroup, WindowWidth, WindowHeight, backgroundColor);
		this.CanvasObject = new Canvas(CanvasWidth, CanvasHeight);
		this.CHECK_IMAGE_NULL(image);
	}
	
	// Checking if image was sent through the CreateCanvas method.
	private void CHECK_IMAGE_NULL(Image img) {
		if(img != null) {
			// If image was sent through the method
			this.CanvasImage = img;
		}
		
		else {
			// If image wasn't set as the argument of CreateCanvas method...
			// Do nothing really...for now.
			// Question: Are we really going to use images?
		}
	}
	
	// Getters and Setters
	// Note: I hope I did the getters and setters correctly. My OOP is very noob like the way I play dota2.
	//		 This is how I kinda do getters and setters in python.
	//
	// Info : The getters and setters may help other functions in the program to access the variables for
	// 		  various modifications.
	
	// GETTERS
	public GraphicsContext GET_GRAPHICS() {
		return this.CanvasGraphics;
	}
	
	public Group GET_GROUP() {
		return this.CanvasGroup;
	}
	
	public Scene GET_SCENE() {
		return this.CanvasScene;
	}
	
	public Image GET_IMAGE() {
		return this.CanvasImage;
	}
	
	public ImageView GET_IMAGE_VEW() {
		return this.CanvasImageView;
	}
	
	public Canvas GET_CANVAS() {
		return this.CanvasObject;
	}
	
	
	// SETTERS
	public void SET_GROUP(Group g) {
		this.CanvasGroup = g;
	}
	
	public void SET_SCENE(Scene sc) {
		this.CanvasScene = sc;
	}
	
	public void SET_IMAGE(Image img) {
		this.CanvasImage = img;
	}
	
	public void SET_CANVAS(Canvas c) {
		this.CanvasObject = c;
	}
	
	public void SET_GRAPHICS(GraphicsContext gc) {
		this.CanvasGraphics = gc;
	}
	
	public void SET_IMAGE_VIEW(ImageView iv) {
		this.CanvasImageView = iv;
	}
}
