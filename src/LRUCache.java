import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private class Node {
        public int key;
        public int value;
        public Node next;

        public Node (int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node (int key, int value) {
            this(key, value, null);
        }
    }

    private Map<Integer, Node> map;
    private Node front;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.front = null;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // if front value
            if (front == node) {
                return node.value;
            }

            // if middle, move to the front;
            Node current = front;
            while (current.next != node) {
                current = current.next;
            }

            Node temp = current.next;
            current.next = current.next.next;
            temp.next = front;
            front = temp;

            return front.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            front = new Node(key, value, front);
            Node node = map.get(key);
            Node current = front;

            while (current.next != node) {
                current = current.next;
            }

            current.next = current.next.next;
        } else if (map.size() == capacity) {
            // if capacity exceeded -> eject LRU
            if (capacity == 1) {
                map.remove(front.key);

                front = new Node(key, value);
            } else {
                front = new Node(key, value, front);
                Node current = front;

                while (current.next.next != null) {
                    current = current.next;
                }

                map.remove(current.next.key);
                current.next = null;
            }
        } else {
            front = new Node(key, value, front);
        }
        map.put(key, front);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */