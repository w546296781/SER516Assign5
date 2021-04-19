import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WorkSpace extends JPanel implements Observer{
	public Repository repository;
	public String tabName;

	/**
	 * Create the panel.
	 */
	public WorkSpace() {
		LeftParenthesis lp = new LeftParenthesis(2);
		lp.x = 20;
		lp.y = 20;
		lp.setLocation(20,20);
		this.add(lp);
		RightParenthesis rp = new RightParenthesis(2);
		rp.x = 800;
		rp.y = 460;
		rp.setLocation(800,460);
		this.add(rp);
		
		repository = new Repository();
		repository.addObserver(this);
		repository.addIcons(lp);
		repository.addIcons(rp);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ArrayList<SubIcon[]> connections = repository.getConnections();
		for (SubIcon[] entry : connections) {
			int x1 = entry[0].containerIcon.getLocation().x + entry[0].x + 4;
			int y1 = entry[0].containerIcon.getLocation().y + entry[0].y + 4;
			
			int x2 = entry[1].containerIcon.getLocation().x + entry[1].x + 4;
			int y2 = entry[1].containerIcon.getLocation().y + entry[1].y + 4;
			
			g.drawLine(x1, y1, x2, y2);
			drawAL(x1, y1, x2, y2, (Graphics2D)g);
		}
		ArrayList<Icon> icons = repository.getIcons();
		for ( Icon icon : icons) {
			if(icon.state == 0) {
				icon.state = 2;
				icon.setLocation(icon.x, icon.y);
				this.add(icon);
			}
		}
		if(repository.isLoad) {
			repository.isLoad = false;
			repaint();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(repository.isLoad) {
			removeAll();
		}
		repaint();
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "",JOptionPane.WARNING_MESSAGE);  
	}
	
	/**
	 * Reference from https://blog.csdn.net/wqjsir/article/details/6095277?utm_medium=distribute.
	 * pc_relevant.none-task-blog-searchFromBaidu-6.control&dist_request_id=&
	 * depth_1-utm_source=distribute.pc_relevant.none-task-blog-searchFromBaidu-6.control
	 */
	public static void drawAL(int sx, int sy, int ex, int ey, Graphics2D g2)
	{

		double H = 15;
		double L = 6;
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		double awrad = Math.atan(L / H);
		double arraow_len = Math.sqrt(L * L + H * H);
		double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double x_3 = ex - arrXY_1[0];
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0];
		double y_4 = ey - arrXY_2[1];

		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();
		g2.drawLine(sx, sy, ex, ey);
		GeneralPath triangle = new GeneralPath();
		triangle.moveTo(ex, ey);
		triangle.lineTo(x3, y3);
		triangle.lineTo(x4, y4);
		triangle.closePath();
		g2.fill(triangle);
	}

	public static double[] rotateVec(int px, int py, double ang,
			boolean isChLen, double newLen) {

		double mathstr[] = new double[2];
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		if (isChLen) {
			double d = Math.sqrt(vx * vx + vy * vy);
			vx = vx / d * newLen;
			vy = vy / d * newLen;
			mathstr[0] = vx;
			mathstr[1] = vy;
		}
		return mathstr;
	}

}
