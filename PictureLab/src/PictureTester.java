import java.awt.Color;
import java.util.ArrayList;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test. This is a great lesson for learning about 2D arrays and the Color
 * class.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {

	private static final double MAX_WID = 1200;

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		/*
		 * You will write the methods that do the following
		 * 
		 */
     System.out.println("here!");
		// testZeroBlue();
     
		// testKeepOnlyBlue(); done
		// testKeepOnlyRed(); done
		// testKeepOnlyGreen(); done
		// testNegate(); done
		// testGrayscale(); done
		// testEdgeDetection(); <=
		// testFaceDetect(); <=
		// testFixUnderwater(); <=
		// testMirrorVertical(); <=
		// testMirrorTemple(); <=
		// testMirrorArms(); <
		// testMirrorGull(); <=
		// testMirrorDiagonal(); <=
		// testCollage(); <=
		// testCopy(); <=

		// testChromakey(); <=
		// testEncodeAndDecode(); // use png, gif or bmp because of compression <=
		testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf(); <=
		// testClearBlueOverValue(200); <=
		// Color avgColor = testGetAverageForColumn(pic, col);// specified column <=
		// testDiagonal(); <=
		// testQuads(); <=
		// testPixelate(); <=
	}

	private static void testPixelate() {
		// opens the image so that it can be manipulated
		Picture mrH = new Picture("images/beach.jpg");


		
		// shows the current version of the pic in a new window
		mrH.explore();
	}

	private static void testQuads() {

		// opens the image so that it can be manipulated
		Picture mrH = new Picture("images/beach.jpg");
		double sclF = MAX_WID / mrH.getWidth();
		mrH = mrH.scale(sclF, sclF);
		mrH.explore();// shows the picture in a window before

		
		// shows the current version of the pic in a new window
		//mrH.explore();
	}

	private static void testDiagonal() {
		// opens the image so that it can be manipulated
		Picture mrH = new Picture("images/beach.jpg");
		// Pictures taken on a phone tend to be very large
		// sometimes too large for the Picture class
		// so I have scaled the one's that are too big
		if(mrH.getWidth() > MAX_WID){
			double sclF = MAX_WID / mrH.getWidth();
			mrH = mrH.scale(sclF, sclF);
		}
		
		mrH.explore();// shows the picture in a window before
		

		// shows the current version of the pic in a new window
		//mrH.explore();
	}

	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		// opens the image so that it can be manipulated
		Picture beach = new Picture("images/beach.jpg");
		beach.explore();// shows the picture in a window before

		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setBlue(0);
			}
		}

		// shows the current version of the pic in a new window
		beach.explore();
	}

	private static void testKeepOnlyBlue() {
		// should get a fairly blue pic
		// this method will look a lot like testZeroBlue method
		Picture beach = new Picture("images/beach.jpg");

		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel p : rowArray) {
				p.setRed(0);
        		p.setGreen(0);
			}
		}

		// shows the current version of the pic in a new window
		beach.explore();
	}

	private static void testKeepOnlyGreen() {
		// pretty obvious...
		Picture beach = new Picture("images/beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel p : rowArray) {
				p.setBlue(0);
				p.setRed(0);
			}
		}

		beach.explore();

	}

	private static void testKeepOnlyRed() {
		// turns the pic quite red
		Picture beach = new Picture("images/beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel p : rowArray) {
				p.setBlue(0);
				p.setGreen(0);
			}
		}

		beach.explore();
	}

	/**
	 * Because this is a task commonly invoked on a Picture, it makes sense to add
	 * this method to the Picture class. If we are doing things that won't likely be
	 * used often, we can write these algorithms in this class.
	 */
	private static void testNegate() {
		Picture swan = new Picture("images/swan.jpg");
		// write this in Picture class
		swan.explore();
		swan.negate();
		swan.explore();

	}

	/**
	 * Again, like the method above, this is pretty common, so let's add this method
	 * to the Picture class.
	 */
	private static void testGrayscale() {
		Picture swan = new Picture("images/swan.jpg");
		// write this method in Picture class
		swan.explore();
		swan.grayScale();
		swan.explore();

	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {

		Picture swan = new Picture("images/swan.jpg");

		// written in Picture class
		swan.explore();
		swan.edgeDetection(10);// bigger number means fewer edges
		swan.explore();
		swan.write("swan outline.jpg");// writes the new picture to a new file
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		// this should take the left-hand half of the picture and reflect it across
		// the vertical midline.
		caterpillar.mirrorVertical();// need to write this method in the picture class
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		// This method makes a mirror image of a section of this picture
		// If this picture is of the temple, it mirror images the top.
		// what if this picture is of a different image?
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		// this method creates a mirror image for a section of its
		// pixels. What would happen if we used a different starting
		// image? Is mirrorTemple a useful method in the long run? How
		// could you change it so that it would be more useful?
		Pixel[][] pixels = temple.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}

		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();// this method has been written in the Picture class
		// how can it be changed so that we could pass in
		// pictures that could be added to a collage?
		canvas.explore();
	}

	/*
	 * so, you have a choice for this one and the methods that follow. You can write
	 * the code in the methods below or you can add functionality to the picture
	 * class. Sometimes it makes sense to add it to the class for reusability
	 * reasons. Sometimes it is too unique a need to add to the class.
	 */

	// So, you can create a Picture Object and find the average value of
	// the component in that column
	private static Color testGetAverageForColumn(Picture pic, int col) {
		Color avg = null;

		return avg;
	}

	// so for this one, any pixels that have blue over a certain value are set
	// to no blue at all. Or for a different effect, have those pixels set to black.
	private static void testClearBlueOverValue(int i) {

	}

	// goes to each pixel in the top half and cuts the red component in half
	// So, bottom half of pic should look normal
	private static void testSetRedToHalfValueInTopHalf() {

	}

	// displays the number of pixels in the pic that have a red component
	// greater than the specifies int.
	private static void testGetCountRedOverValue(int i) {
		Picture beach = new Picture("images/beach.jpg");
		int count = 0;
		if (i > 255 || i < 0){
			System.out.println("Give a number between 0 and 255, inclusive.");
		} else {
			Pixel[][] pixels = beach.getPixels2D();
			for (Pixel[] row : pixels){
				for (Pixel p : row){
					if (p.getRed() > i){
						count++;
					}
				}
			}
			System.out.println("There are " + count + " pixels that have a red value over " + i + ".");
		}
	}

	/**
	 * The method below is really cool!! Use the following approach: go through the
	 * entire Picture (the one to carry the message), and make the red component of
	 * every pixel an even number. To do this, mod by 2 and see if remainder>0. If
	 * so, add or subtract one (subtracting is safer. Why?) Then, using a Picture of
	 * a message (one color on white background), any pixel from Picture of message
	 * that is not white causes you to add one to the corresponding pixel's red
	 * component of the encoded picture (the one with all even red components).
	 * 
	 * Then you can send along the encoded picture to someone else and they should
	 * be able to decode it by looking for Pixels with odd red components.
	 */
	private static void testEncodeAndDecode() {

		Picture moto = new Picture("blueMotorcycle.jpg"),
		        message = new Picture("msg3.PNG");
		moto.explore();
		message.explore();
		
		normalize(moto);// set all red components to even vals
		
		// superimpose message onto moto by changing all pixels
		// that are part of the message to have odd red component
		hide(moto, message);

		moto.explore();// moto should look pretty much the same
		
		// traverse each pixel.  If it has a red component that is 
		// odd, set color of the pixel to BLACK, otherwise WHITE
		decode(moto).explore();
	}

	private static SimplePicture decode(Picture moto) {
		Picture pic = new Picture(moto);// makes a clone of moto
		
		return pic;
	}

	private static void hide(Picture pic, Picture msg) {
		Pixel[][] img = pic.getPixels2D(), msgp = msg.getPixels2D();
		

	}
	/**
	 * Sets the red component of every pixel to an even number
	 * by subtracting by 1 if it is odd.
	 * @param moto
	 */
	private static void normalize(Picture moto) {
		
	}

	/**
	 * chroma key means to superimpose one image over another. The image to be drawn
	 * over the other one, only draws the pixels that aren't the chroma key The
	 * common name for this is green screen
	 */

	private static void testChromakey() {
		Picture background = new Picture("butterfly1.jpg"), 
		        foreground = new Picture("spidey.jpg");

		foreground = foreground.scale(.3, .3);
		// foreground.copy(foreground, 0, 100);

		background.explore();
		foreground.explore();
		Pixel[][] img = background.getPixels2D(), fgd = foreground.getPixels2D();
		int row = 245, col = 360, offsetR = 0, offsetC = 100;
		for (int r = 0; r < fgd.length - offsetR - 1; r++) {
			for (int c = 0; c < fgd[0].length - offsetC - 1; c++) {
				Pixel p = fgd[r + offsetR][c + offsetC];
				if (p.colorDistance(Color.green) > 60) {
					try {
						img[row + r][col + c].setColor(p.getColor());
					} catch (Exception e) {

					}
				}
			}
		}
		background.explore();
	}

	/**
	 * use edge detection and search for an oval... HARD!!!
	 */
	private static void testFaceDetect() {

	}

	// copies a picture onto another
	private static void testCopy() {

	}

	// Creates a new Picture that creates a mirror image along one diagonal
	private static void testMirrorDiagonal() {

	}

	private static void testMirrorGull() {
		// creates a mirror image of a bird making image look like bird is over water

	}

	private static void testMirrorArms() {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is an effort to make a Picture taken underwater look more like it
	 * would be if the water were drained
	 */
	private static void testFixUnderwater() {
		Picture pic = new Picture("water.jpg");
		pic.explore();
	}

	/**
	 * Checks to see if row and col are within the Picture pic
	 * 
	 * @param pic Picture we are checking
	 * @param row Row in pic
	 * @param col Col in pic
	 * @return true if row and col are valid for pic, false otherwise
	 */
	public boolean inbounds(Picture pic, int row, int col) {
		return false;
	}

	/**
	 * Uses Chromakey to "paste" front onto back, excluding Colors that are closer
	 * to rem than threshold.
	 * 
	 * @param back      The Picture onto which front is pasted
	 * @param front     The Picture to be pasted onto back
	 * @param rowStart  Row where the top of front is pasted onto back
	 * @param colStart  Col where the left side of front is pasted onto back
	 * @param rem       Color to use as transparency. Colors closer than threshold
	 *                  to rem are not copied onto back
	 * @param threshold Color distance beyond which the colors of front will be
	 *                  copied onto back.
	 */
	public void chromakey(Picture back, Picture front, int rowStart, int colStart, Color rem, double threshold) {

	}
}