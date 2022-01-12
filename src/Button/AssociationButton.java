package Button;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.*;

public class AssociationButton extends button{
	public AssociationButton(buttonPanel BP){	
		super(BP);
		icon = new ImageIcon("icon/association_line.jpg");
		iconChoose = new ImageIcon("icon/association_line_reverse.jpg");
		this.setIcon(icon);
		this.setPressedIcon(iconChoose);
		Mode = new AssociationMode();
	}
}
