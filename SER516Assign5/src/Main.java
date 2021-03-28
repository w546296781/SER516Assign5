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
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
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
		Repository repository = new Repository();
		ws.repository = repository;
		repository.addObserver(ws);
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
		
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu menu1 = new JMenu("Action Menu");
		JMenuItem btn_save = new JMenuItem("Save");
		JMenuItem btn_load = new JMenuItem("Load");
		JMenuItem btn_new = new JMenuItem("New Space");
		JMenuItem btn_compile = new JMenuItem("Compile");
		btn_save.addActionListener(controller.saveListener());
		btn_save.setFont(new Font("SimSun", Font.BOLD, 20));
		
		btn_load.addActionListener(controller.loadListener());
		btn_load.setFont(new Font("SimSun", Font.BOLD, 20));
		
		
		btn_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabIndex++;
				WorkSpace newws = new WorkSpace();
				newws.setBackground(Color.WHITE);
				newws.setLocation(307, 134);
				newws.setSize(867, 481);
				Repository newrepo = new Repository();
				newws.repository = newrepo;
				newrepo.addObserver(newws);
				newws.setLayout(null);
				newws.addMouseListener(controller);
				tabbedPane.add("Tab" + tabIndex, newws);
			}
		});
		btn_new.setFont(new Font("SimSun", Font.BOLD, 20));
		
		btn_compile.addActionListener(controller.compileListener());
		btn_compile.setFont(new Font("SimSun", Font.BOLD, 20));
		
		
		menu1.add(btn_save);
		menu1.addSeparator();
		menu1.add(btn_load);
	    menu1.addSeparator();
		menu1.add(btn_new);
		menu1.addSeparator();
		menu1.add(btn_compile);
		menubar.add(menu1);
		menu1.setFont(new Font("SimSun", Font.BOLD, 20));
		menubar.setBounds(10, 10, 1138, 50);

	
		panel.add(menubar);
		
	}
}
