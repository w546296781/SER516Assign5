
public class Hyphen extends Icon{
	public Hyphen(int state) {
		this.type = "-";
		lbl_type.setText("-");
		this.state = state;

		
		SubIcon outputIcon = new SubIcon(1, 1, this);
		outputIcon.setLocation(128, 16);
		this.subIcons.add(outputIcon);
		add(outputIcon);
		
		SubIcon inputIcon = new SubIcon(0, 1, this);
		inputIcon.setLocation(4, 16);
		this.add(inputIcon);
		this.subIcons.add(inputIcon);

	}
}
