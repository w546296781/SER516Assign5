import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
/**
 * @author Xinkai Wang, Weixiang Zhang, Huijing Liang
 * @Created on 03/02/2021.
 */

public class MainController implements MouseListener{
	private JFileChooser jfilechooser = new JFileChooser("."); 
	private JTabbedPane jTabbedPane;
	private JTextPane jTextPane;
	
	public MainController(JTabbedPane jTabbedPane, JTextPane jTextPane) {
		this.jTabbedPane = jTabbedPane;
		this.jTextPane = jTextPane;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		WorkSpace ws = (WorkSpace)jTabbedPane.getSelectedComponent();
		ws.repository.deactivateAllPossibleSubIcon();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public ActionListener saveListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					String filePath = jfilechooser.getSelectedFile().getPath();
					WorkSpace ws = (WorkSpace)jTabbedPane.getSelectedComponent();
					ws.repository.save(filePath);
				}
			}
		};
	}
	
	public ActionListener loadListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = jfilechooser.showOpenDialog(null); 
				if(a == JFileChooser.APPROVE_OPTION){
					String filePath = jfilechooser.getSelectedFile().getPath();
					WorkSpace ws = (WorkSpace)jTabbedPane.getSelectedComponent();
					ws.repository.load(filePath);
				}
			}
		};
	}
	
	public ActionListener compileListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkSpace ws = (WorkSpace)jTabbedPane.getSelectedComponent();
			   	String compileName = JOptionPane.showInputDialog(
	               		ws,
	               		"Name:",
	               		""
				);
				jTextPane.setText(GenerateFile(compileName));
			}
		};
	}
	
	public String GenerateFile(String name) {
		String result = "";
		result += "digraph " +name + " {\n";
		for (int i = 0; i < jTabbedPane.getTabCount(); i++) {
			result += "\n";
			WorkSpace ws = (WorkSpace)jTabbedPane.getComponent(i);
			result += "    subgraph cluster_" + i + " {\n";
			result += "        label = \"" + ws.tabName + "\";\n";
			ArrayList<SubIcon[]> connections = ws.repository.getConnections();
			ArrayList<Icon>icons = ws.repository.getIcons();
			for (SubIcon[] entry : connections) {
				Icon startIcon = entry[0].containerIcon;
				Icon endIcon = entry[1].containerIcon;
				String start = ws.tabName + "_" + startIcon.type + "_" + icons.indexOf(startIcon);
				String end = ws.tabName + "_" + endIcon.type + "_" + icons.indexOf(endIcon);
				result += "        \"" + start + "\" -> \"" + end + "\";\n";
			}
			result += "    }\n";
		}
		result += "\n";
		
		for (int i = 0; i < jTabbedPane.getTabCount(); i++) {
			WorkSpace ws = (WorkSpace)jTabbedPane.getComponent(i);
			ArrayList<Icon>icons = ws.repository.getIcons();
			Icon startIcon = icons.get(0);
			Icon endIcon = icons.get(1);
			result += "    " + "start -> \"" + ws.tabName + "_" + startIcon.type + "_" + icons.indexOf(startIcon) +"\";\n";
			result += "    \"" +  ws.tabName + "_" + endIcon.type + "_" + icons.indexOf(endIcon) +"\" -> end" + ";\n";
		}
		result += "}";
		return result;
	}
}
