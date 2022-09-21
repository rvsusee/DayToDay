import java.util.Scanner;

public class StackProgram {
	static int pos = -1;
	static int stack[] = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\nEnter Below Option "
				+ "\n1.Push \n2.Pop \n3.Peek \n4.Display \n5.isEmpty \n6.Exit");
			switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter Value: ");
					push(sc.nextInt());
					break;
				case 2:
					pop();
					break;
				case 3:
					peek();
					break;
				case 4:
					display();
					break;
				case 5:
					isEmpty();
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("Wrong Option!");
			}
		}
	}

	static void isEmpty() {
		if (pos < 0) {
			System.out.println("Stack is Empty!");
		}else {
			System.out.println("Stack is not Empty!");
			display();
		}
	}

	static void peek() {
		if (pos<0) {
			System.out.println("Stack is Empty");
		}else {
			System.out.println("Peek Value is: "+stack[pos]);
		}
	}

	static void pop() {
		if (pos < 0) {
			System.out.println("Stack is Empty");
		}else {
			System.out.println("Pop Value : "+stack[pos--]);
		}
	}

	static void push(int value) {
		if(pos<stack.length) {
			stack[++pos] = value;
		}else {
			System.out.println("Stack is Full");
		}
	}

	private static void display() {
		if (pos>=0) {
			System.out.println("Stack is:");
			for (int i = 0; i <= pos; i++) {
				System.out.print(stack[i]+" ");
			}			
		}else {
			System.out.println("Stack is Empty");
		}
	}
}
