public class Main {

    public static void main(String[] args) {

        MinMaxStack pilha = new MinMaxStack();

        System.out.println("===== DEMONSTRAÇÃO DAS OPERAÇÕES =====\n");

        // Inserções
        pilha.push(10);
        pilha.push(5);
        pilha.push(20);
        pilha.push(5);   // repetido
        pilha.push(30);
        pilha.push(30);  // repetido
        pilha.push(2);

        // Remoções
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();
    }
}