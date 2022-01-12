package CanvasObj;

import UMLeditor.Canvas;
import java.awt.*;

public class AssociationLineObj extends LineObj{
	public AssociationLineObj(Port p1,Port p2){
		super(p1,p2);
	}
	
	@Override
	public void drawObj(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f));
		g2.setColor(Color.BLACK);
		int halfSize = port.elementAt(0).getPortSize()/2;
		int CenterX1 = port.elementAt(0).p.x+halfSize;
		int CenterY1 = port.elementAt(0).p.y+halfSize;
		int CenterX2 = port.elementAt(1).p.x+halfSize;
		int CenterY2 = port.elementAt(1).p.y+halfSize;
		g2.drawLine(CenterX1, CenterY1, CenterX2, CenterY2);
	}
}
