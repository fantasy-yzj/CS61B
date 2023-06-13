package deque;

public class LinkedListDeque<fantasy> implements Deque<fantasy>{
    private LLDNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new LLDNode();
        sentinel.item = 1;
        size = 0;
    }
    @Override
    public void addFirst(fantasy x) {
        LLDNode newNode = new LLDNode();
        newNode.item = x;
        newNode.next = sentinel.next;
        newNode.pre = sentinel;
        sentinel.next = newNode;
        if (newNode.next != null) {
            newNode.next.pre = newNode;
        }
        size += 1;
    }

    @Override
    public void addLast(fantasy x) {
        LLDNode newNode = new LLDNode();
        LLDNode lastNode = sentinel.pre;
        newNode.item = x;
        newNode.next = sentinel;
        newNode.pre = lastNode;
        lastNode.next = newNode;
        sentinel.pre = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LLDNode p = sentinel.next;
        int l = size;
        while (l > 0) {
            System.out.print(p.item);
            if (l > 1) {
                System.out.print(" ");
            } else if(l == 1) {
                System.out.println();
            }
            p = p.next;
            l--;
        }
    }

    @Override
    public fantasy removeFirst() {
        LLDNode firstNode = sentinel.next;
        if (firstNode == sentinel) {
            return null;
        }
        sentinel.next = firstNode.next;
        firstNode.next.pre = sentinel;
        firstNode.next = null;
        firstNode.pre = null;
        size --;
        return (fantasy) firstNode.item;
    }

    @Override
    public fantasy removeLast() {
        LLDNode lastNode = sentinel.pre;
        if (lastNode == sentinel) {
            return null;
        }
        sentinel.next = lastNode.next;
        lastNode.pre.next = sentinel;
        sentinel.pre = lastNode.pre;
        lastNode.next = null;
        lastNode.pre = null;
        size --;
        return (fantasy) lastNode.item;
    }

    @Override
    public fantasy get(int index) {
        LLDNode p = sentinel;
        if (index + 1 > size || index < 0) {
            return null;
        }
        while (index > 0) {
            p = p.next;
            index --;
        }
        return (fantasy) p.item;
    }
    public static void main (String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque();
        L.addFirst(1);
        L.addFirst(2);
        L.addLast(3);
        L.addLast(4);
        L.printDeque();
    }
}
