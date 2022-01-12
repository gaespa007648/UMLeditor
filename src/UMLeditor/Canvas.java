package UMLeditor;
import javax.swing.*;
import java.awt.*;
import Mode.*;
import CanvasObj.*;
import java.util.*;

public class Canvas extends JPanel{
	private static Canvas canvasInstance;
	int CanvasMarginX=135,CanvasMarginY=20;
	int CanvasWidth=800,CanvasDepth=600;
	mode currentMode;
	CanvasObj selected;
	Vector<CanvasObj> canvasObj;
	Point clickPoint;
	
	private Canvas(){
		//設定Canvas的大小及位置
		this.setBounds(CanvasMarginX, CanvasMarginY, CanvasWidth, CanvasDepth);
		this.setBackground(Color.WHITE);
		canvasObj = new Vector<CanvasObj>();
		//設定成員資料
		currentMode=null;
		selected=null;
		clickPoint=null;
	}
	
	public static Canvas getInstance(){
		// Singleton design pattern
		if(canvasInstance==null){
			canvasInstance=new Canvas();
		}
		return canvasInstance;
	}
	
	
	public void setCurrentMode(mode m){
		this.removeMouseListener(currentMode);
		this.removeMouseMotionListener(currentMode);
		System.out.println(m);
		currentMode=m;
		this.addMouseListener(currentMode);
		this.addMouseMotionListener(currentMode);
	}
	
	public void paint(Graphics g){
		Canvas instance=Canvas.getInstance();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, CanvasWidth, CanvasDepth);
		for(int i=0;i<instance.canvasObj.size();i++){
			instance.canvasObj.elementAt(i).drawObj(g);
		}
	}
	
	public void addObj(CanvasObj obj){
		canvasObj.add(obj);
	}
	
	public void removeObj(CanvasObj obj){
		for(int i=0;i<canvasObj.size();i++){
			if(canvasObj.elementAt(i)==obj){
				canvasObj.remove(canvasObj.elementAt(i));
			}
		}
	}
	
	public int checkInside(int x,int y){
		int index=-1;
		for(int i=0;i<canvasObj.size();i++){
			if(canvasObj.elementAt(i).isInside(x, y)==true){
				index=i;
			}
		}
		return index;
	}
	
	public void setStateOfObj(int index){
		if(index==-1){
			// index==-1表示無選到任何東西，全部選擇清空
			System.out.println("Nothing inside");
			selected = null;
			for(int i=0;i<canvasObj.size();i++){
				canvasObj.elementAt(i).setClicked(false);
				canvasObj.elementAt(i).drawObj(Canvas.getInstance().getGraphics());
			}
		}
		else{
			// index!=-1表示有選擇到一個物件
			System.out.println("Object"+index+" is inside");
			selected = canvasObj.elementAt(index);
			for(int i=0;i<canvasObj.size();i++){
				if(i==index)
					canvasObj.elementAt(i).setClicked(true);
				else
					canvasObj.elementAt(i).setClicked(false);
				canvasObj.elementAt(i).drawObj(Canvas.getInstance().getGraphics());
			}
		}
	}
	
	public void setSelectedObj(CanvasObj obj){
		this.selected=obj;
	}
	
	public CanvasObj getSelectedObj(){
		return this.selected;
	}
	
	public CanvasObj getObjAtIndex(int index){
		return canvasObj.elementAt(index);
	}
	
	public CanvasObj getLastObject(){
		return canvasObj.lastElement();
	}
	
	public void removeLastObject(){
		canvasObj.remove(canvasObj.lastElement());
	}
	
	public void setClickPoint(Point p){
		clickPoint=p;
	}
	
	public Point getClickPoint(){
		return clickPoint;
	}
	
	public Vector<CanvasObj> rectInsideObj(Point p1,Point p2){
		Vector<CanvasObj> rectObjs = new Vector<CanvasObj>();
		for(int i=0;i<canvasObj.size();i++){
			Point objLocation = canvasObj.elementAt(i).getLocation();
			if(objLocation!=null){
				if( p2.x>p1.x && p2.y>p1.y){		//左上到右下圈選
					if( objLocation.x>p1.x && objLocation.x<p2.x ){
						if( objLocation.y>p1.y && objLocation.y<p2.y){
							rectObjs.add(canvasObj.elementAt(i));
						}
					}
				}else if( p2.x<p1.x && p2.x<p1.x ){	//右下到左上圈選
					if( objLocation.x>p2.x && objLocation.x<p1.x ){
						if( objLocation.y>p2.y && objLocation.y<p1.y){
							rectObjs.add(canvasObj.elementAt(i));
						}
					}
				}
			}
		}
		return rectObjs;
	}
	public CanvasObj belongGroup(CanvasObj obj){
		CanvasObj belong=null;
		for(int i=0;i<canvasObj.size();i++){
			if(canvasObj.elementAt(i).isInsideGroup(obj)){
				belong = canvasObj.elementAt(i);
			}
		}
		return belong;
	}
}
