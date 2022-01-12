package CanvasObj;
import java.util.*;
import java.awt.*;
import UMLeditor.Canvas;

public class GroupObj extends CanvasObj{
	public GroupObj(){
		groupObj = new Vector<CanvasObj>();
	}
	public void drawGroup(){
		for(int i=0;i<groupObj.size();i++){
			groupObj.elementAt(i).setClicked(true);
			groupObj.elementAt(i).drawObj(Canvas.getInstance().getGraphics());
		}
	}
	public void addObj(CanvasObj obj){
		groupObj.add(obj);
	}
	public boolean isInsideGroup(CanvasObj obj){
		boolean inside=false;
		for(int i=0;i<groupObj.size();i++){
			if(groupObj.elementAt(i).equals(obj)==true){
				inside=true;
			}
		}
		return inside;
	}
}
