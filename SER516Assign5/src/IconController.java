import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class IconController  extends MouseInputAdapter{	
	Point point=new Point(0,0); 
	Icon icon;
	
	public IconController(Icon icon) {
		this.icon = icon;
	}
	      
	public void mousePressed(MouseEvent e)
	{
		if(icon.state == 2) {
			point=SwingUtilities.convertPoint(icon,e.getPoint(),icon.getParent()); 
		}
	}
	      
	public void mouseDragged(MouseEvent e)
	{
		if(icon.state == 2) {
			  Point newPoint=SwingUtilities.convertPoint(icon,e.getPoint(),icon.getParent()); 
			  icon.x = icon.getX()+(newPoint.x-point.x);
			  icon.y = icon.getY()+(newPoint.y-point.y);
			  icon.setLocation(icon.x, icon.y);
			  point=newPoint;
			  WorkSpace ws = (WorkSpace)icon.getParent();
			  ws.repository.notifyCanvas();
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		   // TODO Auto-generated method stub
		   super.mouseClicked(arg0);
		   if(icon.state == 1) {
			   IconContainer ic = (IconContainer)icon.getParent();
			   WorkSpace ws = (WorkSpace)ic.jTabbedPane.getSelectedComponent();
			   ws.repository.newIcon(icon.type);
		   }
		   if (icon.state == 2 && arg0.getClickCount() == 2 && arg0.getButton() == MouseEvent.BUTTON1) {
			   String inputContent = JOptionPane.showInputDialog(
                       icon.getParent(),
                       "Value:",
                       icon.value
               );
               icon.value = inputContent;
		   }
		   
		   
	}
}
