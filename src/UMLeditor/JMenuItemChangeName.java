package UMLeditor;

import java.awt.event.*;

import javax.swing.JOptionPane;

import CanvasObj.*;

public class JMenuItemChangeName extends JMenuItemImp implements ActionListener{
	public JMenuItemChangeName(String name){
		super(name);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Canvas instance = Canvas.getInstance();
		CanvasObj selectObj = instance.getSelectedObj();
		if( selectObj!=null && selectObj.getGroupObjectSize()==-1){
			String name = JOptionPane.showInputDialog("��J����W��");
			if(name!=null){
				System.out.println("�]�w����W�٬� : "+name);
				selectObj.setName(name);
				instance.repaint();
			}
		}
	}
}
