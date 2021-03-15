import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
/**
 * @author Xinkai Wang, Weixiang Zhang, Huijing Liang
 * @Created on 03/02/2021.
 */

public class MainController implements MouseListener{
	private JFileChooser jfilechooser = new JFileChooser("."); 
	
	public MainController() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Repository.getInstance().deactivateAllPossibleSubIcon();
		
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
					Repository.getInstance().save(filePath);
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
					Repository.getInstance().load(filePath);
				}
			}
		};
	}
	
	public ActionListener newSpaceListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Repository.getInstance().newTab();
			}
		};
	}
	
	public ActionListener compileListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Repository.getInstance().compile();
			}
		};
	}

}
