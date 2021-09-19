import java.util.ArrayList;

public class VideoList implements StoreIterator{
private ArrayList<Video> theList;
    int currentItem = 0;
    
    public VideoList() {
	this.theList = new ArrayList<Video>();
    }
    
    public ArrayList<Video> getList() {
	return this.theList;
    }
    @Override
    public boolean hasNext(){
	if (currentItem >= theList.size()){
	    currentItem = 0;
	    return false;
	}
	return true;
    }
    
    @Override
    public Object next(){
	return theList.get(currentItem++);
    }

    //iterator replace for loop.
    public Video getVideo(String id) {
	//while has next StoreIterator.next() ...
	while (this.hasNext()){
	    //for (int i = 0; i < this.theList.size(); i++) {
	    Video temp = (Video) this.next();
	    if (temp.getID().equals(id))
		return temp;
	}
	System.out.println("Video " + id + " not found");
	return null;
    }
    
    public boolean addVideo(Video vid) {

	while (this.hasNext()){
	//same here... replace with iterator
	//for (int i = 0; i < this.theList.size(); i++) {
	    Video temp = (Video) this.next();    // this.theList.get(i);
	    if (temp.getID().equals(vid.getID()))
		return false;
	}
	theList.add(vid);
	return true;
    }
}
