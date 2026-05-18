package stack;

// tem visibilidade de pacote
class Node {
    int value;
    Node next;
    public Node(){}
    public Node(int value){
        this(value,null);
    }
    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
}
