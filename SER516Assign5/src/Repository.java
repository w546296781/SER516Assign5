import java.awt.Color;
import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Xinkai Wang, Weixiang Zhang, Huijing Liang
 * @Created on 03/02/2021.
 */

public class Repository extends Observable{
	private ArrayList<Icon> icons;
	private ArrayList<SubIcon[]> connections;
	private ArrayList<SubIcon> activatedSubIcons;
	private int incrementer = 0;
	public boolean isLoad = false;
	public boolean isCompiled = false;
	public Repository() {
		icons = new ArrayList<Icon>();
		activatedSubIcons = new ArrayList<>();
		connections = new ArrayList<>();
		
	}
	
	public void notifyCanvas() {
		setChanged();
		notifyObservers();
	}

	public void newIcon(String type) {
		Icon newIcon = createNewIcon(type, 100 + incrementer++, 100 + incrementer++);
		icons.add(newIcon);
		notifyCanvas();
	}
	
	public Icon createNewIcon(String type, int x, int y) {
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
			return null;
		}
		newIcon.x = x;
		newIcon.y = y;
		return newIcon;
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
	
	public void activateAllPossibleIcon() {
		for(Icon icon : icons) {
			if(icon.getFreeSubIcon(0) != null) {
				icon.activated = true;
			}
			else {
				icon.activated = false;
			}
		}
		notifyCanvas();
	}
	
	public void deactivateAllPossibleSubIcon() {
		for(Icon icon : icons) {
			icon.activated = false;	
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
	
	public void save(String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(icons.size() + " " + connections.size() + "\r\n");
			for (Icon icon : icons) {
				writer.write(icon.type+ " " + icon.value+ " " + icon.x + " " + icon.y + "\r\n");
			}
			for(SubIcon[] item : connections) {
				int icon1Index = icons.indexOf(item[0].containerIcon);
				int subIcon1Index = item[0].containerIcon.subIcons.indexOf(item[0]);
				int icon2Index = icons.indexOf(item[1].containerIcon);
				int subIcon2Index = item[1].containerIcon.subIcons.indexOf(item[1]);
				writer.write(icon1Index + "-" + subIcon1Index + " " + icon2Index + "-" + subIcon2Index + "\r\n");
			}
			writer.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void load(String filePath) {
		isLoad = true;
		icons = new ArrayList<Icon>();
		connections = new ArrayList<>();
		activatedSubIcons = new ArrayList<>();
		try{
			File input = new File(filePath);
			Scanner myReader = new Scanner(input);
			String[] tmp = myReader.nextLine().split(" ");
			int iconsNum = Integer.parseInt(tmp[0]);
			int connNum = Integer.parseInt(tmp[1]);
			for(int i = 0; i < iconsNum; i++) {
				String[] temp = myReader.nextLine().split(" ");
				Icon newIcon = createNewIcon(temp[0], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
				newIcon.value = temp[1];
				icons.add(newIcon);
			}
			for(int i = 0; i < connNum; i++) {
				String[] temp = myReader.nextLine().split(" ");
				String[] subIcon1Array = temp[0].split("-");
				String[] subIcon2Array = temp[1].split("-");
				SubIcon subIcon1 = icons.get(Integer.parseInt(subIcon1Array[0])).subIcons.get(Integer.parseInt(subIcon1Array[1]));
				SubIcon subIcon2 = icons.get(Integer.parseInt(subIcon2Array[0])).subIcons.get(Integer.parseInt(subIcon2Array[1]));
				subIcon1.connected = true;
				subIcon2.connected = true;
				connections.add(new SubIcon[]{subIcon1, subIcon2});
			}
			myReader.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		notifyCanvas();
	}
	
	public void compile() {
		isCompiled = true;
		notifyCanvas();
	}
}

