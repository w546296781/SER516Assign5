
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;



public class Icon extends JPanel{

	int x = 0;
	int y = 0;

	String type = "";
	ArrayList<SubIcon> subIcons = new ArrayList<>();
	

	JLabel lbl_type;
	int state;   //0-new, 1-on container, 2-on work space
	String value = "null";
	
	public Icon() {
		

		setSize(140, 40);
		setLayout(null);
		lbl_type = new JLabel("");
		lbl_type.setFont(new Font("SimSun", Font.BOLD, 14));
		lbl_type.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_type.setBounds(50, 10, 40, 20);
		add(lbl_type);
		
		IconController iconController = new IconController(this);
		this.addMouseListener(iconController);
		this.addMouseMotionListener(iconController);
	}
	 protected void paintComponent(Graphics g) {
	        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height - 1);
	        
	 }
	
	
}
