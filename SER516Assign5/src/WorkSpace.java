import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WorkSpace extends JPanel implements Observer{

	/**
	 * Create the panel.
	 */
	public WorkSpace() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ArrayList<SubIcon[]> connections = Repository.getInstance().getConnections();
		for (SubIcon[] entry : connections) {
			int x1 = entry[0].containerIcon.getLocation().x + entry[0].getLocation().x + 4;
			int y1 = entry[0].containerIcon.getLocation().y + entry[0].getLocation().y + 4;
			
			int x2 = entry[1].containerIcon.getLocation().x + entry[1].getLocation().x + 4;
			int y2 = entry[1].containerIcon.getLocation().y + entry[1].getLocation().y + 4;
			
			g.drawLine(x1, y1, x2, y2);
		}
		ArrayList<Icon> icons = Repository.getInstance().getIcons();
		for ( Icon icon : icons) {
			if(icon.state == 0) {
				icon.state = 2;
				icon.setLocation(icon.x, icon.y);
				this.add(icon);
			}
			if(icon.state == 2) {
				for(SubIcon subIcon : icon.subIcons) {
					if(subIcon.activated) {
						subIcon.setBackground(Color.GREEN);
					}else {
						subIcon.setBackground(Color.GRAY);
					}
					
				}
			}
		}
		if(Repository.getInstance().isLoad) {
			Repository.getInstance().isLoad = false;
			repaint();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Repository repo = Repository.getInstance();
		if(repo.isCompiled) {
			JOptionPane.showMessageDialog(this, "Compile success", "",JOptionPane.WARNING_MESSAGE);  
			return;
		}
		if(repo.isLoad) {
			removeAll();
		}
		repaint();
	}

}
