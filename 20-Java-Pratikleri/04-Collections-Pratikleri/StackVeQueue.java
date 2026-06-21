import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackVeQueue {
    public static void main(String[] args) {

        // STACK (LIFO - Son giren ilk çıkar)
        System.out.println("=== STACK ===");
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack: " + stack);
        System.out.println("Peek (en üst): " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Kalan stack: " + stack);

        // QUEUE (FIFO - İlk giren ilk çıkar)
        System.out.println("\n=== QUEUE ===");
        Queue<String> queue = new LinkedList<>();

        queue.offer("Birinci");
        queue.offer("İkinci");
        queue.offer("Üçüncü");
        queue.offer("Dördüncü");

        System.out.println("Queue: " + queue);
        System.out.println("Peek (ön): " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Kalan queue: " + queue);

        // Stack ile parantez kontrolü
        System.out.println("\n=== Parantez Kontrolü ===");
        String[] ifadeler = {"(a+b)*(c-d)", "((x+y)", "(a+(b*c))", ")(a+b)("};
        for (String ifade : ifadeler) {
            System.out.println("\"" + ifade + "\" -> " + (parantezKontrol(ifade) ? "Geçerli" : "Geçersiz"));
        }
    }

    static boolean parantezKontrol(String ifade) {
        Stack<Character> stack = new Stack<>();
        for (char c : ifade.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
