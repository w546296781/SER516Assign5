import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SubIcon extends JPanel{
	// 0 for input, 1 for output
	int status; 
	
	// 0 for unlimited, 1 for single
	int connections; 
	
	boolean connected = false;
	
	boolean activated = false;
	
	Icon containerIcon;
	
	ArrayList<SubIcon> inputs = new ArrayList<>();
	ArrayList<SubIcon> outputs = new ArrayList<>();
	
	public SubIcon(int status, int connections, Icon icon) {
		if(connections == 1) {
			this.setSize(8, 8);
		}else {
			this.setSize(8, 24);
		}
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		this.status = status;
		this.connections = connections;
		this.containerIcon = icon;
		
		
		SubIconController controller = new SubIconController(this);
		this.addMouseListener(controller);
		this.addMouseMotionListener(controller);
		
		
		
		
	}
	
	public int getStatus(){
		return status;
	}
	
	public int get(){
		return connections;
	}
	
	
}
