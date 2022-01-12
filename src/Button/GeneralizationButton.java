package Button;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.*;

public class GeneralizationButton extends button{
	public GeneralizationButton(buttonPanel BP){
		super(BP);
		icon = new ImageIcon("icon/generalization_line.jpg");
		iconChoose = new ImageIcon("icon/generalization_line_reverse.jpg");
		this.setIcon(icon);
		this.setPressedIcon(iconChoose);
		Mode = new GeneralizationMode();
	}
}
