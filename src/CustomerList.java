import java.util.ArrayList;

public class CustomerList implements StoreIterator{
	private ArrayList<Customer> theList;
    private int currentItem;

    @Override
    public boolean hasNext(){
	
	if (currentItem >= theList.size()){
	    currentItem = 0;
	    return false;
	}
	else{
	return true;
        }
    }
    
    @Override
    public Object next(){
	return theList.get(currentItem);

    }

	public CustomerList() {
		this.theList = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getList() {
		return this.theList;
	}

    
	public Customer getCustomer(String id) {
	    //for (int i = 0; i < this.theList.size(); i++) {
	    while (this.hasNext()){
		Customer temp =  (Customer) this.next();        //this.theList.get(i);
		if (temp.getID().equals(id)){
		    return temp;
		}
	    }
	    System.out.println("Customer " + id + " not found");
	    return null;
	}
    
    public boolean addCustomer(Customer cust) {
	while (this.hasNext()){
	//for (int i = 0; i < this.theList.size(); i++) {
	    Customer temp = (Customer) this.next();        //this.theList.get(i);
	    if (temp.getID().equals(cust.getID()))
		return false;
	}
	this.theList.add(cust);
	return true;
    }
}
