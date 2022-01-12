package Button;

import java.awt.event.ActionEvent;
import Mode.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SelectButton extends button{
	public SelectButton(buttonPanel BP){
		super(BP);
		icon = new ImageIcon("icon/select.jpg");
		iconChoose = new ImageIcon("icon/select_reverse.jpg");
		this.setIcon(icon);
		Mode = new SelectMode();
	}
}
