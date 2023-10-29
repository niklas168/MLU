

public class Stack<T> {
    private StackNode<T> topElement;
    private int counter;

    public Stack() {
        topElement = null;
        counter = 0;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);
        newNode.next = topElement;
        topElement = newNode;
        counter++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot perform pop operation.");
        }
        topElement = topElement.next;
        counter--;
    }

    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot perform top operation.");
        }
        return topElement.data;
    }

    public boolean isEmpty() {
        return topElement == null;
    }

    public int size() {
        return counter;
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }
}
