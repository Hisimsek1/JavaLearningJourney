import java.util.NoSuchElementException;

public class IteratorPattern {

    interface Iterator<T> {
        boolean hasNext();
        T next();
    }

    interface Iterable<T> {
        Iterator<T> iterator();
        Iterator<T> reverseIterator();
    }

    static class LinkedList<T> implements Iterable<T> {
        private Node<T> head;
        private int size;

        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> cur = head;
                while (cur.next != null) cur = cur.next;
                cur.next = newNode;
            }
            size++;
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private Node<T> current = head;

                public boolean hasNext() { return current != null; }

                public T next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        public Iterator<T> reverseIterator() {
            Object[] arr = new Object[size];
            Node<T> cur = head;
            for (int i = 0; i < size; i++) {
                arr[i] = cur.data;
                cur = cur.next;
            }

            return new Iterator<T>() {
                private int index = size - 1;

                public boolean hasNext() { return index >= 0; }

                @SuppressWarnings("unchecked")
                public T next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    return (T) arr[index--];
                }
            };
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Java");
        list.add("Design");
        list.add("Patterns");
        list.add("Iterator");

        System.out.print("Forward:  ");
        Iterator<String> fwd = list.iterator();
        while (fwd.hasNext()) {
            System.out.print(fwd.next() + " ");
        }

        System.out.print("%nReverse:  ".formatted());
        Iterator<String> rev = list.reverseIterator();
        while (rev.hasNext()) {
            System.out.print(rev.next() + " ");
        }
        System.out.println();
    }
}
