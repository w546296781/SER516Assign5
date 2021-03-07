import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.omg.CORBA.PRIVATE_MEMBER;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Icon extends JPanel{

	int x = 0;
	int y = 0;
	int width = 140;
	int height = 40;
	String type = "";
	boolean[] input = null;
	boolean[] output = null;
	JLabel lbl_type;
	int state;   //0-new, 1-on container, 2-on work space
	String value = "";
	
	public Icon() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
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
	
}
