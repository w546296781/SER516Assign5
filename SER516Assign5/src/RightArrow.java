
public class RightArrow extends Icon{
	public RightArrow(int state) {
		this.type = ">";
		lbl_type.setText(">");
		this.state = state;
		
		SubIcon inputIcon1 = new SubIcon(0, 1, this);
		SubIcon inputIcon2 = new SubIcon(0, 1, this);
		inputIcon1.setLocation(4, 6);
		inputIcon2.setLocation(4, 24);
		this.subIcons.add(inputIcon1);
		this.subIcons.add(inputIcon2);
		
		SubIcon outputIcon = new SubIcon(1, 1, this);
		outputIcon.setLocation(128, 16);
		this.subIcons.add(outputIcon);
		
	

	}
}
