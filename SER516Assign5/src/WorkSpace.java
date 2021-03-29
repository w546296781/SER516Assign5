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
	public Repository repository;

	/**
	 * Create the panel.
	 */
	public WorkSpace() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ArrayList<SubIcon[]> connections = repository.getConnections();
		for (SubIcon[] entry : connections) {
			int x1 = entry[0].containerIcon.getLocation().x + entry[0].x + 4;
			int y1 = entry[0].containerIcon.getLocation().y + entry[0].y + 4;
			
			int x2 = entry[1].containerIcon.getLocation().x + entry[1].x + 4;
			int y2 = entry[1].containerIcon.getLocation().y + entry[1].y + 4;
			
			g.drawLine(x1, y1, x2, y2);
		}
		ArrayList<Icon> icons = repository.getIcons();
		for ( Icon icon : icons) {
			if(icon.state == 0) {
				icon.state = 2;
				icon.setLocation(icon.x, icon.y);
				this.add(icon);
			}
			if(icon.activated) {
				icon.setBackground(Color.GREEN);
			}
			else {
				icon.setBackground(Color.WHITE);
			}
		}
		if(repository.isLoad) {
			repository.isLoad = false;
			repaint();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(repository.isCompiled) {
			JOptionPane.showMessageDialog(this, "Compile success", "",JOptionPane.WARNING_MESSAGE);  
			return;
		}
		if(repository.isLoad) {
			removeAll();
		}
		repaint();
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "",JOptionPane.WARNING_MESSAGE);  
	}

}
