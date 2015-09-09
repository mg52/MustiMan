package musti;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MusAna {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Musti-Man");
		
		MusPanel panel = new MusPanel();
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		
		frame.setVisible(true);
		frame.setSize(500,350);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

}
