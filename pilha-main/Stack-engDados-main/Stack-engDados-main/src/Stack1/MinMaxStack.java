package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

public class MinMaxStack<T extends Comparable<T>> {
    private final Deque<T> mainStack = new ArrayDeque<>();
    private final Deque<T> minStack = new ArrayDeque<>();
    private final Deque<T> maxStack = new ArrayDeque<>();

    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Valores nulos não são permitidos na Stack.MinMaxStack.");
        }

        mainStack.push(value);

        // Atualiza minStack: empilha o menor entre o novo valor e o mínimo atual.
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            T currentMin = minStack.peek();
            minStack.push(value.compareTo(currentMin) <= 0 ? value : currentMin);
        }

        // Atualiza maxStack: empilha o maior entre o novo valor e o máximo atual.
        if (maxStack.isEmpty()) {
            maxStack.push(value);
        } else {
            T currentMax = maxStack.peek();
            maxStack.push(value.compareTo(currentMax) >= 0 ? value : currentMax);
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // As três pilhas são sempre sincronizadas; basta remover o topo de cada uma.
        minStack.pop();
        maxStack.pop();
        return mainStack.pop();
    }


    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack.peek();
    }

    public T min() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public T max() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }


    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack.MinMaxStack[]";
        }
        // ArrayDeque itera do topo para a base; invertemos para exibição natural.
        var elements = mainStack.stream()
                .toList()
                .reversed();
        return "Stack.MinMaxStack" + elements;
    }
}
