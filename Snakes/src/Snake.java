import java.util.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class Snake{
    private ArrayList<Segment> body;
    public static final int SQ = 10;
    private int dir;

    public Snake(){

    }
    public Snake(int x, int y, Color color, int dir) {
        body.add(new Segment(x, y, SQ, SQ, color));
        this.dir = dir;
    }
    public void move() {
        
    }

    public void draw(Graphics g){

    }
    
}
