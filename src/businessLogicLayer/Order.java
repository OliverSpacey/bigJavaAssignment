package businessLogicLayer;


public class Order {


    public enum Status {PENDING, CONFIRMED, FULFILLED};
    public Bike bike;
    public Status status;
    public String customName;
    public Customer customer;
    public Address address;
    public String bikeName;
    public int orderNum;

    public Order(Bike bike, Status status, Customer customer, Address address, String bikeName, int orderNum) {
        this.bike = bike;
        this.status = status;
        this.customer = customer;
        this.address = address;
        this.bikeName = bikeName;
        this.orderNum = orderNum;
    }


}