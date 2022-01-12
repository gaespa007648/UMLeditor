package Mode;

import java.awt.event.MouseEvent;

import CanvasObj.*;

import UMLeditor.Canvas;

public class AssociationMode extends mode{
	//MouseMotionListener
	public void mouseClicked(MouseEvent e){
		System.out.println("AssociationMode clicked");
	}
	public void mousePressed(MouseEvent e){
		System.out.println("AssociationMode pressed");
		Canvas instance = Canvas.getInstance();
		int index = instance.checkInside(e.getX(), e.getY());
		if(index!=-1){
			//有選擇到物件時檢查該位置是否位於Port內
			instance.setSelectedObj(instance.getObjAtIndex(index));
			Port p1 = instance.getObjAtIndex(index).checkPortInside(e.getX(), e.getY());
			if(p1!=null){
				CanvasObj line = new AssociationLineObj(p1,null);
				instance.addObj(line);
			}
		}
	}
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		System.out.println("AssociationMode release");
		Canvas instance = Canvas.getInstance();
		int index = instance.checkInside(e.getX(), e.getY());
		CanvasObj line = instance.getLastObject();
		CanvasObj obj2 = instance.getObjAtIndex(index);
		if( (index!=-1) && (obj2!=instance.getSelectedObj())){
			//有選擇到物件時檢查該位置是否位於Port內
			Port p2 = instance.getObjAtIndex(index).checkPortInside(e.getX(), e.getY());
			if(p2!=null){
				Port p1 = line.getPortAtIndex(0);
				line.setPort(p1, p2);
				line.drawObj(instance.getGraphics());
			}
			else{
				instance.removeLastObject();
			}
		}
		else{
			instance.removeLastObject();
		}
		instance.getSelectedObj().setClicked(false);
	}
	public void mouseExited(MouseEvent e){
		
	}
	
	//MouseListener
	public void mouseDragged(MouseEvent e){
			
	}
	public void mouseMoved(MouseEvent e){
			
	}
}
