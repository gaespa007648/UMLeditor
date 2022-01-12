package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import CanvasObj.CanvasObj;
import UMLeditor.Canvas;
import CanvasObj.*;

public class UsecaseMode extends mode{
	//MouseMotionListener
	public void mouseClicked(MouseEvent e){
		System.out.println("UsecaseMode click "+e.getX()+" "+e.getY());
		Point p = new Point(e.getX(),e.getY());
		CanvasObj obj = new UsecaseObj(p);
		Canvas.getInstance().addObj(obj);
	}
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){
		
	}
	
	//MouseListener
	public void mouseDragged(MouseEvent e){
			
	}
	public void mouseMoved(MouseEvent e){
			
	}
}
