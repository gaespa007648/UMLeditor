package Button;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import Mode.*;
import UMLeditor.Canvas;

public class button extends JButton implements ActionListener{
	protected buttonPanel BP;
	protected mode Mode;
	protected ImageIcon icon;       //未被點擊時呈現的影像
	protected ImageIcon iconChoose; //被點擊時呈現的影像
	protected boolean clicked;
	
	public button(buttonPanel BP){
		this.BP=BP;
		this.addActionListener(this);
		this.setBackground(Color.WHITE);
		this.clicked=false;
	}
	
	public void actionPerformed(ActionEvent e){
		BP.clearAllButton();
		if(clicked==false){
			this.setBackground(Color.BLACK);
			this.setIcon(iconChoose);
			Canvas.getInstance().setCurrentMode(Mode);
			clicked=true;
		}
	}
	
	public void clearClick(){
		this.setBackground(Color.WHITE);
		this.setIcon(icon);
		clicked=false;
	}
	
	public boolean getClicked(){
		return clicked;
	}
	
	public mode getMode(){
		return Mode;
	}
}
