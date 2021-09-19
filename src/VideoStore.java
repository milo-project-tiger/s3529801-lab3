import java.util.ArrayList;

/*
2. The VideoStore maintains 2 lists: customerList and videoList. Refactor and update the source code to introduce the iterators for these two list objects using the Iterator design pattern. (2 marks)
   
 3. The VideoStore has different types of customers, Refactor the source code and introduce a CustomerFactory method that 
takes a string, which describes a type of customer (e.g. guest, vip, supervip) as an argument and returns the appropriate 
Customer object. (2 marks)
*/

public class VideoStore {
	private CustomerList customerList;
	private VideoList videoList;
	
	public VideoStore() {
		this.videoList = new VideoList();
		this.customerList = new CustomerList();
	}

	public Video getVideo(String ID) {
		return videoList.getVideo(ID);
	}
	
	public boolean addVideo(Video vid) {
		return videoList.addVideo(vid);
	}
	
	public Customer getCustomer(String ID) {
		return customerList.getCustomer(ID);
	}
	
	public boolean addCustomer(Customer cust) {
		return customerList.addCustomer(cust);
	}
	
	public static void main(String[] args) {
		VideoStore myStore = new VideoStore();

		//video iterator 

		//create 3 video items
		Video vid = new Video("VD001", "Divergent", "Action", 1, false);
		myStore.addVideo(vid);
		vid = new Video("VD002", "Green Eggs and Ham", "Comedy", 1, false);
		myStore.addVideo(vid);
		vid = new Video("VD003", "Gone with the wind", "Drama", 2, false);
		myStore.addVideo(vid);


		//create a VIP with factory method.
		Customer guest = CustomerFactory.create("VIP");
		
		
		//create 3 customers
		Customer cust = new VIPCustomer("Ngo Bao Chau", "12 Math Avenue", "VIP001", "0203050813");
		myStore.addCustomer(cust);
		cust.borrowVid(myStore.getVideo("VD001"));
		cust = new GuestCustomer("Pham Nhat Vuong", "12 Money Road", "G002", "0399999999");
		myStore.addCustomer(cust);
		cust.borrowVid(myStore.getVideo("VD002"));
		cust = new GuestCustomer("Nguyen Xuan Phuc", "12 Politics Street", "G003", "0311112222");
		myStore.addCustomer(cust);
		cust.borrowVid(myStore.getVideo("VD003"));

	}

    
}
