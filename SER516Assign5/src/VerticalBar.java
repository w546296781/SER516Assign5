
public class VerticalBar extends Icon{
	public VerticalBar(int state) {
		this.type = "||";
		lbl_type.setText("||");
		this.state = state;

		SubIcon inputIcon = new SubIcon(0, 0, this);
		inputIcon.setLocation(4, 10);
		this.subIcons.add(inputIcon);

		SubIcon outputIcon = new SubIcon(1, 0, this);
		outputIcon.setLocation(128, 10);
		this.subIcons.add(outputIcon);
		

	}
}
