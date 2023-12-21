public class LRUCache {
    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node[] map;
    public int count, capacity;
    public Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;

        map = new Node[10_000 + 1];

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (map[key] != null) {
            Node node = map[key];
            int nodeVal = node.value;

            deleteNode(node);
            addToHead(node);

            return nodeVal;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map[key] != null) {
            Node node = map[key];
            node.value = value;

            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map[key] = node;

            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map[tail.prev.key] = null;
                deleteNode(tail.prev);
                addToHead(node);
            }
        }

        return;
    }
}
