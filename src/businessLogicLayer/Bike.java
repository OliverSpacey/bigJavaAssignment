package businessLogicLayer;

import java.text.DecimalFormat;

import ui.MainFrame;

public class Bike extends Component {
	
	public Wheel wheel;
	public Handlebar handlebar;
	public FrameSet frameSet;
	public double totalCost;
	public String customName;
	public String customBrand;
	
	public Bike(Wheel wheel_, Handlebar handlebar_, FrameSet frameSet_) {
		
		wheel = wheel_;
		handlebar = handlebar_;
		frameSet = frameSet_;
		unitCost = 10.00;

		totalCost = getBikeCost(wheel, handlebar, frameSet);
		customBrand = frameSet.brandName + MainFrame.capitaliseString(wheel.tyreStyle.toString());
		
	}
	
	private double getBikeCost(Wheel wheel_, Handlebar handlebar_, FrameSet frameSet_) {
		double frameSet = frameSet_.unitCost;
		double handlebar = handlebar_.unitCost;
		double wheel = wheel_.unitCost;
		
		double total = frameSet + handlebar + wheel + 10.0;
		
		DecimalFormat roundedTotal = new DecimalFormat("##.00");
		
		return Double.parseDouble(roundedTotal.format(total));
	}
	
	
}
