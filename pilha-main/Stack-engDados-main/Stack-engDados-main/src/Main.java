import Stack.MinMaxStack;



    private static final String SEPARATOR  = "─".repeat(60);
    private static final String THIN_SEP   = "·".repeat(60);

    static void main(String[] args) {

        System.out.println(SEPARATOR);
        System.out.println("   Stack.MinMaxStack — Demonstração de Uso");
        System.out.println(SEPARATOR);

        MinMaxStack<Integer> stack = new MinMaxStack<>();

        printSection("BLOCO 1: Inserções em ordem variada");

        push(stack, 10);
        push(stack, 3);
        push(stack, 7);
        push(stack, 1);   // ← novo mínimo global
        push(stack, 15);  // ← novo máximo global

        printSection("BLOCO 2: Inserção de valores repetidos");

        push(stack, 1);   // repetição do mínimo atual (1)
        push(stack, 15);  // repetição do máximo atual (15)
        push(stack, 7);   // repetição de valor intermediário


        printSection("BLOCO 3: Pop das repetições — min/max devem permanecer iguais");

        pop(stack);  // remove 7  → min=1, max=15  (inalterados)
        pop(stack);  // remove 15 → min=1, max=15  (ainda há outro 15)
        pop(stack);  // remove 1  → min=1, max=15  (ainda há outro 1)


        printSection("BLOCO 4: Pop dos mínimos/máximos globais — valores devem se atualizar");

        pop(stack);  // remove 15 → max cai para 10
        pop(stack);  // remove 1  → min sobe  para 3


        printSection("BLOCO 5: Redução até elemento único, depois pilha vazia");

        pop(stack);  // remove 7
        pop(stack);  // remove 3 → resta apenas 10
        pop(stack);  // remove 10 → pilha vazia


        printSection("BLOCO 6: Tentativa de pop() em pilha vazia → EmptyStackException esperada");

        try {
            stack.pop();
            System.out.println("  ERRO: Exceção não foi lançada!");
        } catch (java.util.EmptyStackException e) {
            System.out.println("  ✓ EmptyStackException capturada corretamente.");
        }

        printSection("BLOCO 7: Reutilização da pilha após esvaziamento");

        push(stack, 42);
        push(stack, 17);
        push(stack, 99);
        pop(stack);
        push(stack, 5);

        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("   Demonstração concluída com sucesso.");
        System.out.println(SEPARATOR);
    }

    private static <T extends Comparable<T>> void push(MinMaxStack<T> stack, T value) {
        stack.push(value);
        printState("PUSH(" + value + ")", stack);
    }

    private static <T extends Comparable<T>> void pop(MinMaxStack<T> stack) {
        T removed = stack.pop();
        printState("POP () → " + removed, stack);
    }


    private static <T extends Comparable<T>> void printState(String operation, MinMaxStack<T> stack) {
        String minVal   = stack.isEmpty() ? "—" : String.valueOf(stack.min());
        String maxVal   = stack.isEmpty() ? "—" : String.valueOf(stack.max());
        String topVal   = stack.isEmpty() ? "—" : String.valueOf(stack.peek());

        System.out.printf("  %-18s │ %-28s │ topo=%-4s │ min=%-4s │ max=%-4s │ size=%d%n",
                operation,
                stack.toString(),
                topVal,
                minVal,
                maxVal,
                stack.size());
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println(THIN_SEP);
        System.out.println("  " + title);
        System.out.println(THIN_SEP);
    }

