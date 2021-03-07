import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class WorkSpace extends JPanel implements Observer{

	/**
	 * Create the panel.
	 */
	public WorkSpace() {

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		ArrayList<Icon> icons = Repository.getInstance().getIcons();
		for ( Icon icon : icons) {
			if(icon.state == 0) {
				icon.state = 2;
				icon.setLocation(100, 100);
				this.add(icon);
			}
		}
		repaint();
	}

}
