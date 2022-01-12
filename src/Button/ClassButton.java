package Button;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.*;

public class ClassButton extends button{
	public ClassButton(buttonPanel BP){
		super(BP);
		icon = new ImageIcon("icon/class.jpg");
		iconChoose = new ImageIcon("icon/class_reverse.jpg");
		this.setIcon(icon);
		this.setPressedIcon(iconChoose);
		Mode = new ClassMode();
	}
}
