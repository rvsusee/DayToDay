import java.util.*;

public class LinkedListProgram {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		//Add one by one
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		linkedList.add(60);
		System.out.println(linkedList);
		//add first
		linkedList.addFirst(5);
		System.out.println(linkedList);
		//add last
		linkedList.addLast(70);
		System.out.println(linkedList);

		//remove first
		linkedList.removeFirst();
		System.out.println(linkedList);
		
		//remove last
		linkedList.removeLast();
		System.out.println(linkedList);
		
	}
}
