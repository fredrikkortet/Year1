import java.util.*;
// ArrayStack class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void push( x )         --> Insert            --> Remove most recently inserted item
// AnyType peek( )         --> Return most recently inserted item
// AnyType topAndPop( )   --> Return and remove most recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// top, pop, or topAndPop on empty stack

public class ArrayStack<AnyType>

{

	private AnyType[] theArray;
	private int topOfStack;

	/**
	 * Construct the stack.
	 */
	public ArrayStack() {
		theArray = (AnyType[]) new Object[10];
		topOfStack = -1;
	}

	/**
	 * Test if the stack is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return topOfStack == -1;
	}

	/**
	 * Make the stack logically empty.
	 */
	public void makeEmpty() {
		topOfStack = -1;
	}

	/**
	 * Get the most recently inserted item in the stack. Does not alter the stack.
	 * 
	 * @return the most recently inserted item in the stack.
	 * @throws UnderflowException if the stack is empty.
	 */
	public AnyType peek() {
		if (isEmpty())
			throw new UnderflowException("ArrayStack top"); // UnderflowException
		return theArray[topOfStack];
	}

	/**
	 * Return and remove the most recently inserted item from the stack.
	 * 
	 * @return the most recently inserted item in the stack.
	 * @throws Underflow if the stack is empty.
	 */
	public AnyType pop() {
		if (isEmpty())
			throw new UnderflowException("ArrayStack pop");
		return theArray[topOfStack--];
	}

	/**
	 * Insert a new item into the stack.
	 * 
	 * @param x the item to insert.
	 */
	public void push(AnyType x) {
		if (topOfStack + 1 == theArray.length)
			doubleArray();
		theArray[++topOfStack] = x;
	}

	/**
	 * Internal method to extend theArray.
	 */
	@SuppressWarnings("unchecked")
	private void doubleArray() {
		AnyType[] newArray;

		newArray = (AnyType[]) new Object[theArray.length * 2];
		for (int i = 0; i < theArray.length; i++)
			newArray[i] = theArray[i];
		theArray = newArray;
	}

	public ArrayStack copy() {
		ArrayStack<AnyType> copyStack = new ArrayStack<AnyType>();
		
		int i = 0;
		while(i<theArray.length) {
			if(theArray[i]!=null) {
				copyStack.push(theArray[i]);
			}
			i++;
		}
		
		return copyStack;
	}

	public static void main(String[] arg) {
		ArrayStack<String> s = new ArrayStack<String>();
		ArrayStack<String> c = new ArrayStack<String>();

		try {

			s.push("A");
			s.push("B");
			s.push("C");

			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			
			c=s.copy();
			System.out.println(c.pop());
			System.out.println(c.pop());
			System.out.println(c.pop());

		} catch (UnderflowException e) {
			System.out.println(e);
			System.out.println("Stack empty");

		}

	}

}