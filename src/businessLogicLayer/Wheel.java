package businessLogicLayer;

public class Wheel extends Component {
	
	public enum TyreStyle {ROAD, MOUNTAIN, HYBRID};
	public enum BrakeStyle {RIM, DISK};
	
	public int diameter;
	public TyreStyle tyreStyle;
	public BrakeStyle brakeStyle;
	
	
	public Wheel (int serialNum_, String brandName_, String productName_, double unitCost_,
				  int diameter_, TyreStyle tyreStyle_, BrakeStyle brakeStyle_, int quantity_) {
		
		serialNum = serialNum_;
		brandName = brandName_;
		productName = productName_;
		unitCost = unitCost_;
		diameter = diameter_;
		tyreStyle = tyreStyle_;
		brakeStyle = brakeStyle_;
		quantity = quantity_;
		
		
	}
		
	
	
	
}
