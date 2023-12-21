import java.util.HashMap;

public class LRUCache2 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        newNode.next.prev = newNode;
        head.next = newNode;
    }

    private void deleteNode(Node delNode) {
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node resNode = map.get(key);
            int ans = resNode.val;

            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            map.put(key, head.next);

            return ans;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            map.remove(key);
            deleteNode(current);
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}
