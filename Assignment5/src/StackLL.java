/**
 * StackLL class that describes stack of generic type
 * @author Haimi Nguyen
 * @date 04/03/17
 * */
public class StackLL<T> implements Stack<T>{
	LinkedList<T> linkedList = new LinkedList<T>();

	/**
	 * Pushes an element onto the top of the stack.
	 * @param data data of the next node
	 */
	public void push( T data ){
		linkedList.insertFirst(data);
	}
 
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	public T pop(){
		T nodeData = linkedList.getFirst();
		linkedList.deleteFirst();
		return nodeData;
	}
 
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	public T peek(){
		return linkedList.getFirst();
	}
 
	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
 
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	public String toString(){
		return linkedList.toString();
	}
}