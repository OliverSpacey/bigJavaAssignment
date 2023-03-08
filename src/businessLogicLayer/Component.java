package businessLogicLayer;

public abstract class Component {
	
	
	public int quantity;
	public int serialNum;
	public String brandName;
	public String productName;
	public double unitCost;
	
	public static boolean isStocked(Component comp) {
		if (comp.quantity > 0)
			return true;
		else
			return false;
	}
	
	
	public void addStock(Component comp) {
		comp.quantity++;
	}
	
	public void removeStock(Component comp) {
		comp.quantity--;
	}
}
