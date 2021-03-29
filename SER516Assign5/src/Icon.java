
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;



public class Icon extends JPanel{

	int x = 0;
	int y = 0;

	String type = "";
	ArrayList<SubIcon> subIcons = new ArrayList<>();
	boolean activated = false;

	JLabel lbl_type;
	int state;   //0-new, 1-on container, 2-on work space
	String value = "null";
	
	public Icon() {
		

		setSize(140, 40);
		setOpaque(false);
		setLayout(null);
		lbl_type = new JLabel("");
		lbl_type.setFont(new Font("SimSun", Font.BOLD, 14));
		lbl_type.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_type.setBounds(50, 10, 40, 20);
		add(lbl_type);
		
		this.setBackground(Color.WHITE);
		IconController iconController = new IconController(this);
		this.addMouseListener(iconController);
		this.addMouseMotionListener(iconController);
	}
	
	@Override
	 protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(activated) {
				g.setColor(Color.GREEN);
			}
			else {
				g.setColor(Color.BLACK);
			}
	        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height - 1);
	 }
	
	public SubIcon getFreeSubIcon(int status) {
		SubIcon res = null;
		for(SubIcon item : subIcons) {
			if(item.status == status) {
				if(!item.connected || item.connections == 0) {
					res = item;
					break;
				}
			}
		}
		return res;
	}
}
