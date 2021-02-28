package stack;

public class ArrayStack {

	public static void main(String[] args) {
		MyStack stack1 = new MyStack();
		stack1.push(new Object());
		stack1.push(new Object());
		stack1.push(new Object());
		stack1.push(new Object());
		stack1.push(new Object());
		stack1.push(new Object());
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
	}

}

class MyStack {
	private int index = -1;
	private int size = 5;
	private Object[] elements = new Object[size];
	
	public void setElements(Object[] elements) {
		this.elements = elements;
	}
	
	public Object[] getElements() {
		return elements;
	}
	
	public void push(Object obj) {
		if (index >= elements.length - 1) {   //注意判断条件
			System.out.println("push(error).");
			return;
		}
		else {
			index++;  //特别注意这两句的顺序，index先加
			elements[index] = obj;
			System.out.println("push " + obj + ", index: " + index + "(done).");
		}
	}
	
	public void pop() {
		if (index == -1) {
			System.out.println("pop(error).");
			return;
		}
		else {
			System.out.println("pop " + elements[index] + ", index: " + index + "(done)."); //弹出了一个已有的元素
			index--;
		}
	}
	
}