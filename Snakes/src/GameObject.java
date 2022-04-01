import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Generic GameObject.  This has all the BASIC attributes and behaviors that 
 * ALL game objects should have.  Many of these can be overridden in subclasses.
 * Those behaviors and attributes include:
 * 
 * Location and size (using a Rectangle for that)
 * Color (used for testing but not used in the final version)
 * speed in the x and speed in the y direction
 * The GameObject has the ability to move, detect collisions with 
 * another GameObject and the ability to draw itself on a Graphics
 * 
 * @author RHanson
 *
 */
public class GameObject {
	
	/** rect has info about location and dimension of this game object*/
	private Rectangle rect;
	/** Color of this object */
	private Color color;
	/** dx is how far this object moves this Rectangle each time I move
	 *  dy is how far this object moves the Rectangle each time I move
	 *  If dy or dx change between moves, it will look like this object is 
	 *  accelerating or decelerating in that direction.
	 */
	private double dx, dy;
	
	
	public GameObject(int x, int y, int w, int h, Color c) {
		this(x,y,w,h,c,0,0);
	}
	public GameObject(int x, int y, int w, int h, Color c, int dx, int dy) {
		rect = new Rectangle(x,y,w,h);
		color = c;
		this.dx = dx;
		this.dy = dy;
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public void move() {
		moveX();
		moveY();
	}
	public void moveY() {
		rect.setLocation(rect.x+0, (int) (rect.y+dy));
	}
	public void moveX() {
		rect.setLocation((int) (rect.x+dx), rect.y+0);
	}
	public Rectangle getRect() {
		return rect;
	}
  
	/** Pretty basic right now, but can make this way better!*/
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fill(rect);
	}
	
	public boolean collidedWith(GameObject go) {
		return this.rect.intersects(go.rect);
	}
}
