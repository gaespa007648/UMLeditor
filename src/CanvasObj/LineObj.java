package CanvasObj;
import java.util.*;

public class LineObj extends CanvasObj{
	public LineObj(Port p1,Port p2){
		port = new Vector<Port>();
		port.add(p1);
		port.add(p2);
	}
	public void drawObj(){
		// It will be override
	}
	public void setPort(Port p1,Port p2){
		port.setElementAt(p1, 0);
		port.setElementAt(p2, 1);
	}
}
