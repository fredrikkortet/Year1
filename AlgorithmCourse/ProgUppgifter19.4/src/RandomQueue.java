import java.util.LinkedList;
public class RandomQueue {
	private LinkedList<Object> linked;
	private int size;
	private Object front;
	private Object back;
	
public RandomQueue() {
	linked = new LinkedList<Object>();
	size = 0;
}
	public Boolean isEmpty() {
		
		return size==0;
	}
	public void enqueued(Object o) {
		if(o != null) {
		size++;
		linked.addFirst(o);
		back = linked.getFirst();
		}
	}
	public Object dequeued() {
		size--;
		int rand = (int)(Math.random()*size);
		Object temp = linked.remove(rand);
		if(size !=0) {
		front = linked.getLast();
		}
		return temp;
		
	}
	public static void main(String[] args) {
		RandomQueue gnome = new RandomQueue();
		System.out.println(gnome.isEmpty());
		gnome.enqueued("Fredrik");
		gnome.enqueued("Andre");
		gnome.enqueued("Krille");
		gnome.enqueued("Rolle");
		System.out.println(gnome.isEmpty());
		System.out.println(gnome.dequeued());
		System.out.println(gnome.dequeued());
		System.out.println(gnome.dequeued());	
		System.out.println(gnome.dequeued());	
		
		
	}
	
}
