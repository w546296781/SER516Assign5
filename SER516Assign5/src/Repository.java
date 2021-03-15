import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Xinkai Wang, Weixiang Zhang, Huijing Liang
 * @Created on 03/02/2021.
 */

public class Repository extends Observable{
	private static Repository instance;
	private ArrayList<Icon> icons;
	private ArrayList<SubIcon[]> connections;
	private ArrayList<SubIcon> activatedSubIcons;
	public Repository() {
		icons = new ArrayList<Icon>();
		activatedSubIcons = new ArrayList<>();
		connections = new ArrayList<>();
		
	}
	
    public static Repository getInstance(){  
    	if (instance == null) {  
    			instance = new Repository();  
    	}  
    	return instance;  
    }
	
	public void notifyCanvas() {
		setChanged();
		notifyObservers();
	}

	public void createNewIcon(String type) {
		Icon newIcon;
		switch (type) {
		case "(":
			newIcon = new LeftParenthesis(0);
			break;
		case ")":
			newIcon = new RightParenthesis(0);
			break;
		case "<":
			newIcon = new LeftArrow(0);
			break;
		case ">":
			newIcon = new RightArrow(0);
			break;
		case "@":
			newIcon = new CommercialAt(0);
			break;
		case "||":
			newIcon = new VerticalBar(0);
			break;
		case "-":
			newIcon = new Hyphen(0);
			break;
		default:
			return;
		}
		icons.add(newIcon);
		notifyCanvas();
	}
	
	public ArrayList<Icon> getIcons() {
		return icons;
	}
	
	public void addActivatedSubIcon(SubIcon icon) {
		activatedSubIcons.add(icon);
		
		if(activatedSubIcons.size() == 2) {
			SubIcon subIcon1 = activatedSubIcons.get(0);
			subIcon1.connected = true;
			
			SubIcon subIcon2 = activatedSubIcons.get(1);
			subIcon2.connected = true;
			
			connections.add(new SubIcon[]{subIcon1, subIcon2});
			activatedSubIcons.clear();
			deactivateAllPossibleSubIcon();
			
		}
		notifyCanvas();
	}
	
	public void activateAllPossibleSubIcon(int status, Icon thisIcon) {
		for(Icon icon : icons) {
			if(!icon.equals(thisIcon)) {
				for(SubIcon subIcon : icon.subIcons) {
					if(subIcon.status != status && (subIcon.connections == 0 || !subIcon.connected)) {
						subIcon.activated = true;
					}
				}
			}	
		}
		notifyCanvas();
	}
	
	public void deactivateAllPossibleSubIcon() {
		for(Icon icon : icons) {
			for(SubIcon subIcon : icon.subIcons) {
				subIcon.activated = false;
			}	
		}
		activatedSubIcons.clear();
		notifyCanvas();
	}
	
	public ArrayList<SubIcon> getActivatedSubIcons(){
		return activatedSubIcons;
		
	}
	public ArrayList<SubIcon[]> getConnections() {
		return connections;
	}
}

