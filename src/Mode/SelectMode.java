package Mode;
import UMLeditor.Canvas;
import CanvasObj.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SelectMode extends mode{
	//MouseMotionListener
	public void mouseClicked(MouseEvent e){
		System.out.println("SelectMode click");
		Canvas instance = Canvas.getInstance();
		int index = instance.checkInside(e.getX(), e.getY());
		/* group */
		if(index!=-1){
			CanvasObj Obj = instance.getObjAtIndex(index);
			if(instance.belongGroup(Obj)!=null){
				//表示點擊物件屬於某個group
				instance.belongGroup(Obj).drawGroup();
				instance.setSelectedObj(instance.belongGroup(Obj));
			}else{
				instance.setStateOfObj(index);
			}
		}else{
			instance.setStateOfObj(index);
		}
	}
	public void mousePressed(MouseEvent e){
		System.out.println("SelectMode press");
		Canvas instance = Canvas.getInstance();
		int index = instance.checkInside(e.getX(), e.getY());
		if(index!=-1){
			// index!=-1表示有選到物件
			CanvasObj obj = instance.getObjAtIndex(index); //取得點擊下的物件
		}else{
			// 沒選到物件的情況 : 做多選
			instance.setClickPoint(new Point(e.getX(),e.getY()));
		}
	}
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		Canvas instance=Canvas.getInstance();
		Point p1 = instance.getClickPoint();
		if(p1!=null){
			Point p2 = e.getPoint();
			CanvasObj groupObj = new GroupObj();
			Vector<CanvasObj> objs = instance.rectInsideObj(p1, p2);
			for(int i=0;i<objs.size();i++){
				groupObj.addObj(objs.elementAt(i));
			}
			if(groupObj.getGroupObjectSize()>1){
				groupObj.drawGroup();
				instance.setSelectedObj(groupObj);
			}
			instance.setClickPoint(null);
		}
	}
	public void mouseExited(MouseEvent e){
		
	}
	
	//MouseListener
	public void mouseDragged(MouseEvent e){
		Canvas instance = Canvas.getInstance();
		CanvasObj obj = instance.getSelectedObj(); //得到被拖移的物件
		if(obj!=null){
			obj.resetObjLocation(e.getX(), e.getY());
			instance.repaint();
		}
	}
	public void mouseMoved(MouseEvent e){
			
	}
}
