import java.util.Stack;

public class MinMaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public MinMaxStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int value) {

        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }

        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }

        System.out.println("Push(" + value + ")");
        showStatus();
    }

    public int pop() {

        if (stack.isEmpty()) {
            throw new RuntimeException("Erro: Pilha vazia!");
        }

        int removed = stack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }

        if (removed == maxStack.peek()) {
            maxStack.pop();
        }

        System.out.println("Pop() -> Elemento removido: " + removed);
        showStatus();

        return removed;
    }

    public int min() {
        return minStack.peek();
    }

    public int max() {
        return maxStack.peek();
    }

    public void showStatus() {

        System.out.println("Pilha atual: " + stack);

        if (!stack.isEmpty()) {
            System.out.println("Menor valor: " + min());
            System.out.println("Maior valor: " + max());
        } else {
            System.out.println("Pilha vazia.");
        }

        System.out.println("--------------------------------");
    }
}