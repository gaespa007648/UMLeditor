package CanvasObj;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CanvasObj {
	protected Point objLocation;
	protected Vector<Port> port;
	protected Vector<CanvasObj> groupObj;
	protected int objWidth,objHeight;
	protected boolean clicked;
	protected String name;
	public CanvasObj(){
		clicked = false;
		objLocation = null;
		name = null;
	}
	public void drawObj(Graphics g){
		// It will be override
	}
	public void drawGroup(){
		// It will be override
	}
	public void resetPortLocation(){
		// It will be override
	}
	public void resetObjLocation(int x,int y){
		// It will be override
	}
	public boolean isInside(int x,int y){
		// It will be override
		return false;
	}
	public boolean isInsideGroup(CanvasObj obj){
		// It will be override by GroupObj
		return false;
	}
	public void setClicked(boolean click){
		// It will be override
	}
	public Port checkPortInside(int x,int y){
		// It will be override
		return null;
	}
	public Port getPortAtIndex(int index){
		return port.elementAt(index);
	}
	public void setPort(Port p1,Port p2){
		// It will be override
	}
	public Point getLocation(){
		return this.objLocation;
	}
	public void addObj(CanvasObj obj){
		// It will be override
	}
	public int getGroupObjectSize(){
		if(groupObj==null){
			return -1;
		}else{
			return this.groupObj.size();
		}
	}
	public void setName(String name){
		this.name=name;
	}
}
