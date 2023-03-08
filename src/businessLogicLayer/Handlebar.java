package businessLogicLayer;

public class Handlebar extends Component {
	
	
	public enum Style {HIGH, DROPPED, STRAIGHT};
	
	public Style style;
	
	
	public Handlebar(int serialNum_, String brandName_, String productName_, double unitCost_, Style style_, int quantity_) {
		
		serialNum = serialNum_;
		brandName = brandName_;
		productName = productName_;
		unitCost = unitCost_;
		style = style_;
		quantity = quantity_;
		
	}
	
	
	
	
	
	
}
