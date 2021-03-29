
public class RightParenthesis extends Icon{
	public RightParenthesis(int state) {
		this.type = ")";
		lbl_type.setText(")");
		this.state = state;
		
		SubIcon inputIcon = new SubIcon(0, 1, this);
		inputIcon.setLocation(0, 16);
		this.subIcons.add(inputIcon);
		
		

	}
}
