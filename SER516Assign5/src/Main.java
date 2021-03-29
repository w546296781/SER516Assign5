import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
/**
 * @author Xinkai Wang, Weixiang Zhang, Huijing Liang
 * @Created on 03/02/2021.
 */

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int tabIndex = 1;
	public JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Assign5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		WorkSpace ws = new WorkSpace();
		ws.setBorder(new LineBorder(new Color(0, 0, 0)));
		ws.setBackground(Color.WHITE);
		ws.setLocation(307, 134);
		ws.setSize(867, 481);
		ws.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setBounds(170, 50, 968, 564);
		contentPane.add(tabbedPane);
		tabbedPane.add("Tab" + tabIndex, ws);
		
		MainController controller = new MainController(tabbedPane);
		ws.addMouseListener(controller);
		
		IconContainer ic = new IconContainer();
		ic.setBorder(new LineBorder(new Color(0, 0, 0)));
		ic.setBackground(Color.WHITE);
		ic.setSize(170, 565);
		ic.setLocation(0, 50);
		contentPane.add(ic);
		ic.setLayout(null);
		ic.jTabbedPane = tabbedPane;
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1138, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1138, 50);
		panel.add(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setHorizontalAlignment(SwingConstants.CENTER);
		fileMenu.setPreferredSize(new Dimension(200, 40));
		menuBar.add(fileMenu);
		
		JMenuItem btn_newSpace = new JMenuItem("New Space");
		btn_newSpace.addActionListener(new ActionListener() { public void
			 actionPerformed(ActionEvent e) { 
			 	tabIndex++;
			 	WorkSpace newws = new WorkSpace(); 
			 	newws.setBackground(Color.WHITE); 
			 	newws.setLocation(307, 134);
			 	newws.setSize(867, 481); 
			 	newws.setLayout(null); 
			 	newws.addMouseListener(controller);
			 	tabbedPane.add("Tab" + tabIndex, newws);
			 	newws.addMouseListener(controller);
			 } 
		});
		fileMenu.add(btn_newSpace);
		
		JMenuItem btn_save = new JMenuItem("Save");
		btn_save.addActionListener(controller.saveListener());
		fileMenu.add(btn_save);
		
		JMenuItem btn_load = new JMenuItem("Load");
		btn_load.addActionListener(controller.loadListener());
		fileMenu.add(btn_load);
		
		JMenu actionMenu = new JMenu("Action");
		actionMenu.setHorizontalAlignment(SwingConstants.CENTER);
		actionMenu.setPreferredSize(new Dimension(200, 40));
		menuBar.add(actionMenu);
		
		JMenuItem btn_run = new JMenuItem("Run");
		btn_run.addActionListener(controller.compileListener());
		actionMenu.add(btn_run);
		
	}
}
