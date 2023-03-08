package businessLogicLayer;

public class FrameSet extends Component {
	
	
	public int size;
	public boolean shocks;
	public String frame;
	public String forks;
	
	
	public FrameSet(int serialNum_, String brandName_, String productName_, double unitCost_, 
					int size_, boolean shocks_, String frame_, String forks_, int quantity_) {
		
		serialNum = serialNum_;
		brandName = brandName_;
		productName = productName_;
		unitCost = unitCost_;
		size = size_;
		shocks = shocks_;
		frame = frame_;
		forks = forks_;
		quantity = quantity_;
		
	}
	
	public static String parseShocks(boolean shocks) {
		if (shocks)
			return "Yes";
		else
			return "No";
	}
	
	
}
