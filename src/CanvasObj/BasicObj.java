package CanvasObj;
import java.awt.*;
import java.util.Vector;

public class BasicObj extends CanvasObj{
	public BasicObj(Point p){
		this.objLocation=p;
		this.objWidth=80;
		this.objHeight=80;
	}
	
	public void resetObjLocation(int x,int y){
		objLocation.setLocation(x, y);
		resetPortLocation();
	}
	
	public boolean isInside(int x,int y){
		// It will be override
		return false;
	}
	
	public void resetPortLocation(){
		// It will be override	
	}
	
	public void drawObj(){
		// It will be override
	}
	
	public void setClicked(boolean click){
		clicked = click;
	}
	
	public void drawPorts(Graphics g){
		System.out.println("Clicked state : "+clicked);
		for(int i=0;i<port.size();i++){
			port.elementAt(i).drawPort(clicked,g);
		}
	}
	
	public Port checkPortInside(int x,int y){
		Port p=null;
		for(int i=0;i<port.size();i++){
			if(port.elementAt(i).isInside(x, y)){
				p=port.elementAt(i);
			}
		}
		return p;
	}
}
