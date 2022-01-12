package CanvasObj;
import java.awt.*;
import UMLeditor.Canvas;

public class Port {
	Point p;
	int size;    //Port size
	int orient;  //orient用來標示Port位於Object的方位
	public Port(int x,int y,int size){
		p = new Point(x,y);
		this.size=size;
		this.orient=0; 
	}	
	public void resetLocation(int x,int y){
		p.setLocation(x, y);
	}
	public int getPortSize(){
		return size;
	}
	public void drawPort(boolean clicked,Graphics g){
		if(clicked==true){
			g.setColor(Color.BLACK);
		}
		else{
			g.setColor(Color.WHITE);
		}
		g.fillRect(p.x, p.y, size, size);
	}
	public boolean isInside(int x, int y){
		boolean inside=false;
		if( x>=p.x && x<=(p.x+size)){
			if( y>=p.y && y<=(p.y+size)){
				inside=true;
			}
		}
		return inside;
	}
	public void setOrient(int orient){
		this.orient=orient;
	}
	public int getOrient(){
		return this.orient;
	}
}
