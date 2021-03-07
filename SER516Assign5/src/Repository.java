import java.awt.List;
import java.util.ArrayList;
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
	
	public Repository() {
		icons = new ArrayList<Icon>();
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
}
