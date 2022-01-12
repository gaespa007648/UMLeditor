package UMLeditor;

import java.awt.event.*;
import CanvasObj.*;

public class JMenuItemGroup extends JMenuItemImp implements ActionListener{
	public JMenuItemGroup(String name){
		super(name);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Canvas instance = Canvas.getInstance();
		CanvasObj groupObj = instance.getSelectedObj();
		if(groupObj.getGroupObjectSize()>1){
			System.out.println("加至群組成功");
			instance.addObj(groupObj);
		}
	}
}
