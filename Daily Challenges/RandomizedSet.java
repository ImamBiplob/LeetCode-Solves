import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;

class RandomizedSet {
    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean search(int val) {
        return map.containsKey(val);
    }

    public boolean insert(int val) {
        if (search(val))
            return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!search(val))
            return false;

        int index = map.get(val);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

class RandomizedSet2 {

    public HashSet<Integer> hashSet;
    public Random random;

    public RandomizedSet2() {
        hashSet = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (hashSet.contains(val))
            return false;
        hashSet.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hashSet.contains(val))
            return false;
        hashSet.remove(val);
        return true;
    }

    public int getRandom() {
        Integer[] arrayNumbers = hashSet.toArray(new Integer[hashSet.size()]);
        return arrayNumbers[random.nextInt(hashSet.size())];
    }

}

class RandomizedSet3 {

    public HashSet<Integer> hashSet;
    public Random random;

    public RandomizedSet3() {
        hashSet = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        return hashSet.add(val);
    }

    public boolean remove(int val) {
        return hashSet.remove(val);
    }

    public int getRandom() {
        Iterator<Integer> iterator = hashSet.iterator();
        int i = random.nextInt(hashSet.size());
        while (iterator.hasNext()) {
            if (i == 0)
                return iterator.next();
            iterator.next();
            i--;
        }

        return 0;
    }

}

class RandomizedSet4 {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node[] nums;
    int capacity = 16;
    int size = 0;

    public RandomizedSet4() {
        nums = new Node[capacity];
    }

    public boolean insert(int val) {
        int bucket = hash(val);
        Node node = nums[bucket];

        if (node == null) {
            nums[bucket] = new Node(val);
            size++;
            return true;
        }

        Node prev = node;
        while (node != null) {
            if (node.value == val) {
                return false;
            }
            prev = node;
            node = node.next;
        }
        prev.next = new Node(val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        int bucket = hash(val);
        Node node = nums[bucket];

        if (node == null) {
            return false;
        }

        if (node.value == val) {
            nums[bucket] = node.next;
            size--;
            return true;
        }

        Node prev = node;
        while (node != null) {
            if (node.value == val) {
                prev.next = node.next;
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int getRandom() {
        int random = new Random().nextInt(size);
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            Node node = nums[i];
            while (node != null) {
                if (pointer == random) {
                    return node.value;
                }
                pointer++;
                node = node.next;
            }
        }
        return -1;
    }

    private int hash(int value) {
        if (value < 0) {
            value *= -1;
        }
        return value % capacity;
    }
}
