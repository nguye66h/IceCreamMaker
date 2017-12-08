import javax.swing.JFrame;

/**
*	IceCreamMakerApplication class is the application class of the ice cream
*	@author Haimi Nguyen
*	@date 4/5/17
*/
public class IceCreamMakerApplication{

	/** 
	* main method of the class, making a JFrame and add buttons and ice cream to the frame
	* @param args the argument passed
	*/
	public static void main(String[] args) {
		JFrame f = new JFrame("Ice Cream");
		f.setSize(800, 600);
		f.add(new IceCreamMaker());
		f.setVisible(true);
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}