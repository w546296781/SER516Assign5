import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class SubIconController extends MouseInputAdapter{
	SubIcon subIcon;
	
	public SubIconController(SubIcon subIcon) {
		this.subIcon = subIcon;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(subIcon.containerIcon.state == 2) {
			WorkSpace ws = (WorkSpace)subIcon.containerIcon.getParent();
			Repository repo = ws.repository;
			if(repo.getActivatedSubIcons().size() == 0) {
				if(!subIcon.connected || subIcon.connections == 0) {
					repo.addActivatedSubIcon(subIcon);
					subIcon.activated = true;
					repo.activateAllPossibleSubIcon(subIcon.status, subIcon.containerIcon);
				}
			}else if(subIcon.activated == true && !repo.getActivatedSubIcons().contains(subIcon)){
				repo.addActivatedSubIcon(subIcon);
			}
			
			
			
		}
	}
	
	
}
