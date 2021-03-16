import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class IconContainer extends JPanel {
	public JTabbedPane jTabbedPane;

	/**
	 * Create the panel.
	 */
	public IconContainer() {
		LeftParenthesis icon1 = new LeftParenthesis(1);
		icon1.setLocation(15,20);
		add(icon1);
		RightParenthesis icon2 = new RightParenthesis(1);
		icon2.setLocation(15,100);
		add(icon2);
		LeftArrow icon3 = new LeftArrow(1);
		icon3.setLocation(15,180);
		add(icon3);
		RightArrow icon4 = new RightArrow(1);
		icon4.setLocation(15,260);
		add(icon4);
		CommercialAt icon5 = new CommercialAt(1);
		icon5.setLocation(15,340);
		add(icon5);
		VerticalBar icon6 = new VerticalBar(1);
		icon6.setLocation(15,420);
		add(icon6);
		Hyphen icon7 = new Hyphen(1);
		icon7.setLocation(15,500);
		add(icon7);
	}

}
