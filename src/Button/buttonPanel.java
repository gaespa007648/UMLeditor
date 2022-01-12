package Button;
import java.util.*;
import Mode.*;
import UMLeditor.*;

public class buttonPanel {
	//buttonPanel is used to manage all the button
	Vector<button> buttonControl;
	button currentButton=null;
	int buttonMargin=20;
	int buttonSize=70;
	
	public buttonPanel(){
		buttonControl = new Vector<button>();
		
		// Establish the buttons
		button SELECT = new SelectButton(this);
		button ASSOCIATION = new AssociationButton(this);
		button COMPOSITION = new CompositionButton(this);
		button GENERALIZATION = new GeneralizationButton(this);
		button CLASS = new ClassButton(this);
		button USECASE = new UsecaseButton(this);
		
		// Add all the buttons into buttonControl
		buttonControl.add(SELECT);
		buttonControl.add(ASSOCIATION);
		buttonControl.add(COMPOSITION);
		buttonControl.add(GENERALIZATION);
		buttonControl.add(CLASS);
		buttonControl.add(USECASE);
		
		// setBounds of all the button
		setBoundsOfButtons();
	}
	
	void setCurrentButton(button clickButton){
		this.currentButton=clickButton;
	}
	
	void clearAllButton(){
		//先清除所有非點擊按鈕的狀態
		for(int i=0;i<buttonControl.size();i++){
			buttonControl.elementAt(i).clearClick();
		}
	}
	
	void setBoundsOfButtons(){
		for(int i=0;i<buttonControl.size();i++){
			int j=i+1;
			buttonControl.elementAt(i).setVisible(true);
			buttonControl.elementAt(i).setBounds(buttonMargin, 
				buttonMargin*j+buttonSize*i, buttonSize, buttonSize);
		}
	}
	
	public Vector<button> getButtonControl(){
		return buttonControl;
	}
}
