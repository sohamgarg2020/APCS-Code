import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello world");
    frame.setSize(300, 300);
    frame.setLocation(5, 5);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label = new JLabel("Hello world", SwingConstants.CENTER);
    frame.add(label);

    frame.show();
    ArrayTester.main(args);
  }
}