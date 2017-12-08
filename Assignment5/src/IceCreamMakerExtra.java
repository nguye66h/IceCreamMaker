import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;

/**
* 	IceCreamMaker method displays buttons to manipulate the ice cream
* 	@author Haimi Nguyen
*	@date 4/5/17
*/
public class IceCreamMaker extends JPanel{

	private IceCreamCone cone;
	private JButton[] flavorButtons;

	/**
	*	Constructor adds buttons and ice cream to the JPanel
	*/
	public IceCreamMaker(){
		super(new BorderLayout());
		cone = new IceCreamConeExtra();
		JButton trashScoop = new JButton("Trash the top scoop!");
		trashScoop.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cone.popTopScoop();
				cone.repaint();
			}
		});

		JButton vanillaBtn = new JButton ("vanilla");
		vanillaBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cone.addScoop("vanilla");
				cone.repaint();
			}
		});
		JButton strawberryBtn = new JButton ("strawberry");
		strawberryBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cone.addScoop("strawberry");
				cone.repaint();
			}
		});
		JButton teaBtn = new JButton ("green tea");
		teaBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cone.addScoop("green tea");
				cone.repaint();
			}
		});
		JButton caramelBtn = new JButton ("burnt caramel");
		caramelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cone.addScoop("burnt caramel");
				cone.repaint();
			}
		});
		JPanel panel1 = new JPanel(new GridLayout(2, 4));
		panel1.add(vanillaBtn);
		panel1.add(strawberryBtn);
		panel1.add(teaBtn);
		panel1.add(caramelBtn);
		panel1.add(trashScoop);
		add(panel1, BorderLayout.NORTH);
		add(cone, BorderLayout.CENTER);
	}

	public IceCreamCone getCone(){
		return cone;
	}

	
}