public class CustomerFactory{

    public static Customer create(String customerType){
	if(customerType.equals("VIP")){
	    return new VIPCustomer();
	}
        else if (customerType.equals("Guest")){
	    return new GuestCustomer();
	/*if(customerType.equals("Student")){
	  return new Student();
	  }*/
	}
	else if (customerType.equals("default")){
	    return new Customer();
	}
	else{
	    return null;
	}
    }
    
    /*
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
	System.out.println("what obj to create:");
	String type = sc.nextLine();
	Customer lecturer = CustomerFactory.create(type);
	System.out.println(lecturer.toString());
	}*/
}
