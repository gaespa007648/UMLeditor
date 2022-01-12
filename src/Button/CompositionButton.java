package Button;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.*;

public class CompositionButton extends button{
	public CompositionButton(buttonPanel BP){
		super(BP);
		icon = new ImageIcon("icon/composition_line.jpg");
		iconChoose = new ImageIcon("icon/composition_line_reverse.jpg");
		this.setIcon(icon);
		this.setPressedIcon(iconChoose);
		Mode = new CompositionMode();
	}
}
