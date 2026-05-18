package stack;

public class Stack {
    private Node top;
    private int size;

    // Adiciona um novo elemento no topo
    public void push(int e){
        if(isEmpty()){
            top = new Node(e);
        }else {
            // O next do newTop
            // é o nó topo atual
            var newTop = new Node(e, top);
            // atualiza a referência do top
            top = newTop;
        }
        size++;
    }

    // remover o topo e retornar o elemento
    public int pop(){
        if(isEmpty()) throw new EmptyStackException();
        var e = top.value;
        // atualizar a lista ligada
        // removendo o topo atual
        top = top.next;
        size--;
        return e;
    }

    // retorna o elemento sem retirar da pilha
    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Stack{size=");
        builder.append(size);
        builder.append(", [");
        var temp = top;
        while(temp != null){
            builder.append(temp.value);
            if(temp.next != null){
                builder.append(", ");
            }
            temp = temp.next;
        }
        builder.append("]}");
        return builder.toString();
    }

}
