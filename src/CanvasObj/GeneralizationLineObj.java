package CanvasObj;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import UMLeditor.Canvas;

public class GeneralizationLineObj extends LineObj{
	public GeneralizationLineObj(Port p1,Port p2){
		super(p1,p2);
	}
	
	@Override
	public void drawObj(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f));
		g2.setColor(Color.BLACK);
		
		int Size = port.elementAt(0).getPortSize();
		int halfSize = Size/2;
		int CenterX1 = port.elementAt(0).p.x+halfSize;
		int CenterY1 = port.elementAt(0).p.y+halfSize;
		int CenterX2 = port.elementAt(1).p.x+halfSize;
		int CenterY2 = port.elementAt(1).p.y+halfSize;
		int X2 = port.elementAt(1).p.x;
		int Y2 = port.elementAt(1).p.y;
		
		int orient=port.elementAt(1).getOrient();
		int North=1,East=2,South=3,West=4;
		int adjust=3;
		if(orient == North){
			g2.drawLine(CenterX1, CenterY1, CenterX2, CenterY2-halfSize);
			//畫三角形
			Y2=Y2+adjust;
			g2.drawLine(X2, Y2, X2+Size, Y2);
			g2.drawLine(X2, Y2, X2+halfSize, Y2+Size);
			g2.drawLine(X2+Size, Y2, X2+halfSize, Y2+Size);
		}else if(orient == East){
			g2.drawLine(CenterX1, CenterY1, CenterX2+halfSize, CenterY2);
			//畫三角形
			X2=X2-adjust;
			g2.drawLine(X2, Y2+halfSize, X2+Size, Y2);
			g2.drawLine(X2, Y2+halfSize, X2+Size, Y2+Size);
			g2.drawLine(X2+Size, Y2, X2+Size, Y2+Size);
		}else if(orient == South){
			g2.drawLine(CenterX1, CenterY1, CenterX2, CenterY2+halfSize);
			//畫三角形
			Y2=Y2-adjust;
			g2.drawLine(X2+halfSize, Y2, X2, Y2+Size);
			g2.drawLine(X2+halfSize, Y2, X2+Size, Y2+Size);
			g2.drawLine(X2, Y2+Size, X2+Size, Y2+Size);
		}else if(orient == West){
			g2.drawLine(CenterX1, CenterY1, CenterX2-halfSize, CenterY2);
			//畫三角形
			X2=X2+adjust;
			g2.drawLine(X2, Y2, X2, Y2+Size);
			g2.drawLine(X2, Y2, X2+Size, Y2+halfSize);
			g2.drawLine(X2, Y2+Size, X2+Size, Y2+halfSize);
		}
	}
}
