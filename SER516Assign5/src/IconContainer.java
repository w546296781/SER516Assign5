import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class IconContainer extends JPanel {
	public JTabbedPane jTabbedPane;

	/**
	 * Create the panel.
	 */
	public IconContainer() {
		LeftArrow la = new LeftArrow(1);
		la.setLocation(15,20);
		add(la);
		RightArrow ra = new RightArrow(1);
		ra.setLocation(15,100);
		add(ra);
		CommercialAt ca = new CommercialAt(1);
		ca.setLocation(15,180);
		add(ca);
		LeftVerticalBar lv = new LeftVerticalBar(1);
		lv.setLocation(15,260);
		add(lv);
		RightVerticalBar rv = new RightVerticalBar(1);
		rv.setLocation(15,340);
		add(rv);
		Hyphen hy = new Hyphen(1);
		hy.setLocation(15,420);
		add(hy);
	}

}
