package CanvasObj;
import java.awt.*;
import java.util.Vector;

import UMLeditor.Canvas;

public class ClassObj extends BasicObj{
	public ClassObj(Point p){
		super(p);
		//以下是設定port
		int x = p.x;
		int y = p.y;
		int portSize=12; 
		int North=1,East=2,South=3,West=4;
		port = new Vector<Port>();
		Port p1 = new Port(x+objWidth/2-portSize/2,y,portSize);
		Port p2 = new Port(x+objWidth-portSize,y+objHeight/2-portSize/2,portSize);
		Port p3 = new Port(x+objWidth/2-portSize/2,y+objHeight-portSize,portSize);
		Port p4 = new Port(x,y+objHeight/2-portSize/2,portSize);
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
		int width=objWidth,height=objHeight;
		int margin=4;
		int innerWidth=objWidth-2*margin;
		int innerHeight=(height-4*margin)/3;
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x+margin, y+margin, innerWidth, innerHeight);
		g.fillRect(x+margin, y+2*margin+innerHeight, innerWidth, innerHeight);
		g.fillRect(x+margin, y+3*margin+2*innerHeight, innerWidth, innerHeight);
		if(name!=null){
			int WordBiasX=objWidth/5;
			g.setColor(Color.BLACK);
			((Graphics2D)g).drawString(name, x+WordBiasX, y+innerHeight);
		}
		if(clicked==true)
			drawPorts(g);
	}
	
	
	@Override
	public boolean isInside(int x,int y){
		boolean inside=false;
		if( x>=objLocation.x && x<=objLocation.x+objWidth)
			if( y>=objLocation.y && y<=objLocation.y+objHeight)
				inside=true;
		return inside;
	}
	
	@Override
	public void resetPortLocation(){
		int portSize = port.elementAt(0).getPortSize();
		port.elementAt(0).resetLocation(objLocation.x+objWidth/2-portSize/2, objLocation.y);
		port.elementAt(1).resetLocation(objLocation.x+objWidth-portSize,objLocation.y+objHeight/2-portSize/2);
		port.elementAt(2).resetLocation(objLocation.x+objWidth/2-portSize/2,objLocation.y+objHeight-portSize);
		port.elementAt(3).resetLocation(objLocation.x,objLocation.y+objHeight/2-portSize/2);	
	}
}
