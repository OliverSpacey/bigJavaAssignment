package businessLogicLayer;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ButtonToggle {

//	disables all toggle buttons when one is selected - prevents selecting
//	multiple components of the same type
	public static void disableButtons(JPanel[] panels, Container activeContainer) {
//		array of toggle buttons
		Component[] component = new Component[panels.length];
//		"for every panel, if it's not the actionListener parent, add the toggle button to the array"
		for (int i = 0; i < panels.length; i++) {
			int numOfComponents = panels[i].getComponentCount();
			
			if (panels[i] != activeContainer) {
				component[i] = panels[i].getComponent(numOfComponents - 1);
				
			}			
		}
		
		for (int i = 0; i < component.length; i++) {
//			!= null prevents it freaking out when it comes to actionListener parent container
			if (component[i] != null) {
				component[i].setEnabled(false);
			}
		}
		
	}
	
//	enables all toggle buttons when a component is deselected
	public static void enableButtons(JPanel[] panels) {
//		array of toggle buttons
		JToggleButton[] button = new JToggleButton[panels.length];
//		"for every panel, if it's not the actionListener parent, add the toggle button to the array"
		
		for (int i = 0; i < panels.length; i++) {
			int numOfComponents = panels[i].getComponentCount();
			button[i] = (JToggleButton) panels[i].getComponent(numOfComponents - 1); 		
		}
		
		for (int i = 0; i < button.length; i++) {
//			!= null prevents it freaking out when it comes to actionListener parent container
			if (button[i] != null) {
				button[i].setEnabled(true);
				button[i].setSelected(false);
			}
		}
		
	}
}
