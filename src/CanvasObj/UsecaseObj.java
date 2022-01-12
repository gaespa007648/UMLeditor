package CanvasObj;

import java.awt.*;
import java.util.Vector;
import UMLeditor.Canvas;

public class UsecaseObj extends BasicObj{
	public UsecaseObj(Point p){
		super(p);
		//以下是設定port
		int x = p.x;
		int y = p.y;
		int portSize=12; 
		int North=1,East=2,South=3,West=4;
		port = new Vector<Port>();
		int width=objWidth+20,height=objHeight-20;
		Port p1 = new Port(x+width/2-portSize/2,y,portSize);
		Port p2 = new Port(x+width-portSize,y+height/2-portSize/2,portSize);
		Port p3 = new Port(x+width/2-portSize/2,y+height-portSize,portSize);
		Port p4 = new Port(x,y+height/2-portSize/2,portSize);
		p1.setOrient(North);
		p2.setOrient(East);
		p3.setOrient(South);
		p4.setOrient(West);
		port.add(p1);
		port.add(p2);
		port.add(p3);
		port.add(p4);
		drawObj(Canvas.getInstance().getGraphics());
	}
	@Override
	public void drawObj(Graphics g){
		int x=objLocation.x,y=objLocation.y;
		int width=objWidth+20,height=objHeight-20;
		int margin=4;
		int innerWidth=width-2*margin;
		int innerHeight=height-2*margin;
		g.setColor(Color.BLACK);
		g.fillOval(x, y, width, height);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x+margin, y+margin, innerWidth, innerHeight);
		if(name!=null){
			int WordBiasX=objWidth/3;
			g.setColor(Color.BLACK);
			((Graphics2D)g).drawString(name, x+WordBiasX, y+innerHeight/2);
		}
		if(clicked==true){
			drawPorts(g);
		}
	}
	
	@Override
	public boolean isInside(int x,int y){
		boolean inside=false;
		if( x>=objLocation.x && x<=objLocation.x+objWidth+20)
			if( y>=objLocation.y && y<=objLocation.y+objHeight-20)
				inside=true;
		return inside;
	}
	
	@Override
	public void resetPortLocation(){
		int portSize = port.elementAt(0).getPortSize();
		int width=objWidth+20,height=objHeight-20;
		port.elementAt(0).resetLocation(objLocation.x+width/2-portSize/2, objLocation.y);
		port.elementAt(1).resetLocation(objLocation.x+width-portSize,objLocation.y+height/2-portSize/2);
		port.elementAt(2).resetLocation(objLocation.x+width/2-portSize/2,objLocation.y+height-portSize);
		port.elementAt(3).resetLocation(objLocation.x,objLocation.y+height/2-portSize/2);	
	}
}
