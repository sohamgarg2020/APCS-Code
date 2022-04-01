import javax.swing.*;

public class SwingGraphicsGame {

	    public static void main(String[] args) {

	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                GameFrame wnd = new GameFrame("Game on!");
	                
	                wnd.setVisible(true);
	                
	            }
	        });
	    }
	}