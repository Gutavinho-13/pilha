package stack;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException(){
        super("Stack está vazia");
    }

}
