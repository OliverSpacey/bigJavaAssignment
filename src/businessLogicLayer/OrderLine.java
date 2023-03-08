package businessLogicLayer;

public class OrderLine {

	public Component component;
	public int quantity;
	public double lineCost;
	
	public OrderLine(Component component, int quantity) {
		this.component = component;
		this.quantity = quantity;
		
		lineCost = component.unitCost * quantity;
	}
	
	public static OrderLine[] generateOrderLines(Order order) {
		OrderLine[] orderlines = new OrderLine[4];
		
		Bike orderBike = order.bike;
		
		orderlines[0] = new OrderLine(orderBike.frameSet, 1);
		orderlines[1] = new OrderLine(orderBike.handlebar, 1);
		orderlines[2] = new OrderLine(orderBike.wheel, 2);
		orderlines[3] = new OrderLine(orderBike, 1);
		
		return orderlines;
	}
}
