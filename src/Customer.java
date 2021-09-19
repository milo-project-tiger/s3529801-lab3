import java.util.ArrayList;

//Perhaps the Iterator is best, partially, implemented in an abstract class-- I am a little unpracticed.

public class Customer implements StoreIterator{
	private String name;
	private String address;
	private String ID;
	private String phone;
	private ArrayList<Video> rentals;
        private int currentItem;
    
    //default method to make factory pattern faster to implement.
       public Customer(){}
       public Customer(String name, String address, String iD, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.ID = iD;
		this.phone = phone;
		this.rentals = new ArrayList<Video>();
	}
       
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPhone() {
		return phone;
	}
	public int getNumRentals() {
		return this.rentals.size();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

    //Iterator is introduced not refactored
    public boolean hasNext(){
	if (currentItem >= rentals.size()){
	    currentItem = 0;
	    return false;
	}
	return true;
    }

    
    public Object next(){
	return this.rentals.get(currentItem++);
    }
      public boolean borrowVid(Video rental) {
	    for (int i = 0; i < this.rentals.size(); i++) {
			Video temp = this.rentals.get(i);
			if (temp.getID().equals(rental.getID())) {
				System.out.println("Customer " + this.getName() + " has already borrowed video item "+rental.getTitle());
				return false;
			}
		}
		this.rentals.add(rental);
		rental.setRental_status(true);
		System.out.println("Customer " + this.getName() + " now borrowed video item "+rental.getTitle());
		return true;
	}
	public boolean returnVid(Video rental) {
		for (int i = 0; i < this.rentals.size(); i++) {
			Video temp = this.rentals.get(i);
			if (temp.getID().equals(rental.getID())) {
				this.rentals.remove(i);
				rental.setRental_status(false);
				System.out.println("Customer " + this.getName() + " returned the video item " + rental.getTitle());
				return true;
			}
		}
		System.out.println("Customer " + this.getName() + " did not borrow the video item " + rental.getTitle());
		return false;
	}
}
