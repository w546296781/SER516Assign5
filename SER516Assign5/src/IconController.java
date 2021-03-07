import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class IconController  extends MouseInputAdapter{
	Icon icon;
	public IconController(Icon icon) {
		this.icon = icon;
	}

	Point point=new Point(0,0); 
	      
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
			  icon.setLocation(icon.getX()+(newPoint.x-point.x),icon.getY()+(newPoint.y-point.y));
			  point=newPoint;
		}
	}
	   
	   @Override
	public void mouseClicked(MouseEvent arg0) {
		   // TODO Auto-generated method stub
		   super.mouseClicked(arg0);
		   if(icon.state == 1) {
			   Repository.getInstance().createNewIcon(icon.type);
		   }
		   else {
               String inputContent = JOptionPane.showInputDialog(
                       icon.getParent(),
                       "Value:",
                       ""
               );
               icon.value = inputContent;
		   }
	}
}
