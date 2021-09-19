//As this is a Customer I would think to extend it, but I have figured out solution. Cheers.

//Maybe a delegate pattern?
public class SuperVIP {
    
    private static SuperVIP OneAndOnlySuperVIP = new SuperVIP();

    private SuperVIP(){

    }

    public SuperVIP getTheSuperVIP(){
	return this.OneAndOnlySuperVIP;
    }
}
