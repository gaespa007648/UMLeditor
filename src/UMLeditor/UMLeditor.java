package UMLeditor;
import javax.swing.*;
import java.awt.*;
import Button.*;
import Mode.*;
import java.util.*;

public class UMLeditor{
	static int frameWidth=1000,frameHeight=720;
	static Container c;
	static buttonPanel BP;
		
	public static void main(String args[]){	
		JFrame frm = new JFrame("UML Editor");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frm.setLayout(null);
		frm.setSize(frameWidth, frameHeight);
		
		c = frm.getContentPane();
		Canvas canvas=Canvas.getInstance();
		c.add(canvas);
		BP=new buttonPanel();
		setButton(c,BP);
		MenuBar mb = new MenuBar();
		frm.setJMenuBar(mb.getJMenuBar());
		
		frm.setVisible(true);
	}
	
	public static void setButton(Container c,buttonPanel BP){
		Vector<button> buttonControl=BP.getButtonControl();
		for(int i=0;i<buttonControl.size();i++){
			c.add(buttonControl.elementAt(i));
		}
	}
}
