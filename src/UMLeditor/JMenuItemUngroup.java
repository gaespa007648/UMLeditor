package UMLeditor;

import java.awt.event.*;
import CanvasObj.*;

public class JMenuItemUngroup extends JMenuItemImp implements ActionListener{
	public JMenuItemUngroup(String name){
		super(name);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Canvas instance = Canvas.getInstance();
		CanvasObj selectObj = instance.getSelectedObj();
		System.out.println(selectObj);
		if( selectObj!=null && selectObj.getGroupObjectSize()>1 ){
			System.out.println("¸Ñ´²¸s²Õ");
			instance.removeObj(selectObj);
		}
	}
}
