
public class LeftParenthesis extends Icon{	
	public LeftParenthesis(int state) {
		this.type = "(";
		lbl_type.setText("(");
		this.state = state;
		
		SubIcon outputIcon = new SubIcon(1, 1, this);
		outputIcon.setLocation(128, 16);
		this.subIcons.add(outputIcon);
		
		
	}
}
