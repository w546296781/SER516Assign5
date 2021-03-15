
public class CommercialAt extends Icon{
	public CommercialAt(int state) {
		this.type = "@";
		lbl_type.setText("@");
		this.state = state;

		
		SubIcon inputIcon1 = new SubIcon(0, 1, this);
		SubIcon inputIcon2 = new SubIcon(0, 1, this);
		inputIcon1.setLocation(4, 6);
		inputIcon2.setLocation(4, 24);
		this.add(inputIcon1);
		this.add(inputIcon2);
		this.subIcons.add(inputIcon1);
		this.subIcons.add(inputIcon2);
		
		SubIcon outputIcon1 = new SubIcon(1, 1, this);
		SubIcon outputIcon2 = new SubIcon(1, 1, this);
		outputIcon1.setLocation(128, 6);
		outputIcon2.setLocation(128, 24);
		this.add(outputIcon1);
		this.add(outputIcon2);
		this.subIcons.add(outputIcon1);
		this.subIcons.add(outputIcon2);

	}
}
