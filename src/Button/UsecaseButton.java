package Button;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.*;

public class UsecaseButton extends button{
	public UsecaseButton(buttonPanel BP){
		super(BP);
		icon = new ImageIcon("icon/use_case.jpg");
		iconChoose = new ImageIcon("icon/use_case_reverse.jpg");
		this.setIcon(icon);
		this.setPressedIcon(iconChoose);
		Mode = new UsecaseMode();
	}
}
