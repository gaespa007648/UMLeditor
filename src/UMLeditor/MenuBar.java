package UMLeditor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import UMLeditor.JMenuItemChangeName;
import UMLeditor.JMenuItemGroup;
import UMLeditor.JMenuItemUngroup;

public class MenuBar {
	private JMenuBar mb;
	private JMenu File;
	private JMenu Edit;
	private JMenuItemGroup group;
	private JMenuItemUngroup ungroup;
	private JMenuItemChangeName change_object_name;
	
	public MenuBar(){
		mb=new JMenuBar();
		File=new JMenu("File");
		Edit=new JMenu("Edit");
		group=new JMenuItemGroup("group");
		ungroup=new JMenuItemUngroup("ungroup");
		change_object_name=new JMenuItemChangeName("Change Object Name");
		
		mb.add(File);
		mb.add(Edit);
		Edit.add(group);
		Edit.add(ungroup);
		Edit.add(change_object_name);
	}
	
	public JMenuBar getJMenuBar(){
		return mb;
	}
}
