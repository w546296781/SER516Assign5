
public class LeftArrow extends Icon{
	public LeftArrow(int state) {
		this.type = "<";
		lbl_type.setText("<");
		this.state = state;
		
		SubIcon inputIcon = new SubIcon(0, 1, this);
		inputIcon.setLocation(4, 16);
		this.add(inputIcon);
		this.subIcons.add(inputIcon);
		
		
		SubIcon outIcon1 = new SubIcon(1, 1, this);
		SubIcon outIcon2 = new SubIcon(1, 1, this);
		outIcon1.setLocation(128, 6);
		outIcon2.setLocation(128, 24);
		this.add(outIcon1);
		this.add(outIcon2);
		this.subIcons.add(outIcon1);
		this.subIcons.add(outIcon2);

		

	}
}
