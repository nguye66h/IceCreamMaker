import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;

/**
 * IceCreamCone class describes an ice cream
 * @author Haimi Nguyen
 * @date 04/03/17
 * */
public class IceCreamCone extends JComponent{

	/** Four flavors of the ice cream scoop */
	final String[] FLAVORS = {"vanilla", "strawberry", "green tea", "burnt caramel"};

	/** Four colors of the flavors */
	final Color[] PAINT_COLORS = {new Color(255, 255, 153), Color.pink, Color.green, new Color(153, 76, 0)};

	/** Height of the cone */
	final int CONE_HEIGHT = 400;

	/** Diameter of the scoop */
	final int SCOOP_DIAMETER = 120;

	/** The overlapping distance of the scoops */
	final int SCOOP_OVERLAP = 20;

	/** Stack that holds the scoop */
	private StackLL<String> scoopFlavorStack = new StackLL<String>();

	/** Constructor of the class, do nothing */
	public IceCreamCone(){

	}

	/** addScoop method adds a new scoop to the top
	 *  @param flavor the flavor of the newly added scoop
	 */
	public void addScoop(String flavor){
		for (int i = 0; i < FLAVORS.length; i++){
			if (flavor.equals(FLAVORS[i])){
				scoopFlavorStack.push(flavor);
			}
		}
	}

	/** 
	*	addScoop method with no parameter adds a random scoop to the top
	*/
	public void addScoop(){
		String flavor;
		int ran = (int)(Math.random()*4);
		scoopFlavorStack.push(FLAVORS[ran]);
	}

	/** 
	*	popTopScoop method removes the top scoop and return flavor of the removed scoop
	* 	@return flavor of the removed scoop
	*/
	public String popTopScoop(){
		if (!scoopFlavorStack.isEmpty()){
			return scoopFlavorStack.pop();
		}
		else{
			return null;
		}
	}

	/** 
	*	findFlavorIndex method finds the index of the string in FLAVORS array that matches with the parameter
	*	@param flavor flavor of the scoop
	* 	@return index index of the flavor in FLAVORS array (return -1 if not in array)
	*/
	private int findFlavorIndex(String flavor){
		for (int i = 0; i < FLAVORS.length; i++){
			if (flavor == FLAVORS[i]){
				return i;
			}
		}
		return -1;
	}

	/**
	*	paint method that paints the cone and the stack of scoops
	*	@param g graphics
	*/
	public void paint(Graphics g){
		paintCone(g);
		paintScoops(g);
	}

	/**
	*	paintScoops method paints the stack of scoops
	*	@param g Graphics
	*/
	private void paintScoops(Graphics g){
		StackLL<String> newStack = new StackLL<String>();;
		while (!scoopFlavorStack.isEmpty()){
			newStack.push(scoopFlavorStack.pop());
		}
		int i = 0;
		while (!newStack.isEmpty()){
			String iceCreamFlavor = newStack.pop();
			scoopFlavorStack.push(iceCreamFlavor);
			paintScoop(g, findFlavorIndex(iceCreamFlavor), i*50);
			i++;
		}
	}

	/**
	 *	paintCone method paints the cone
	 * 	@param g graphics
	*/
	public void paintCone(Graphics g){
		g.setColor(new Color(255, 178, 102));
		g.fillArc(10, 300, CONE_HEIGHT, CONE_HEIGHT, 70, 40);
	}

	/**
	*   paintScoop method paints one scoop
	*	@param g graphics
	*	@param index the index of the flavor of the scoop
	*	@param start to put the scoop where it should be in the stack
	*/
	private void paintScoop(Graphics g, int index, int start){
		g.setColor(PAINT_COLORS[index]);
		g.fillOval(150, 650 - CONE_HEIGHT - start, SCOOP_DIAMETER, SCOOP_DIAMETER);
	}
}