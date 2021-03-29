import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SubIcon{
	// 0 for input, 1 for output
	int status; 
	
	// 0 for unlimited, 1 for single
	int connections; 
	int x;
	int y;
	boolean connected = false;
	
	Icon containerIcon;
	
	ArrayList<SubIcon> inputs = new ArrayList<>();
	ArrayList<SubIcon> outputs = new ArrayList<>();
	
	public SubIcon(int status, int connections, Icon icon) {
		this.status = status;
		this.connections = connections;
		this.containerIcon = icon;
	}
	
	public int getStatus(){
		return status;
	}
	
	public int get(){
		return connections;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
