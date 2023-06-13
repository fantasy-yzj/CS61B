package deque;

public class ArrayDeque<fantasy> implements Deque<fantasy>{
    private fantasy[] item;
    private int size, front, rear;
    public ArrayDeque () {
        item = (fantasy[]) new Object[8];
        size = 0;
        front = 0;
        rear = 1;
    }
    @Override
    public void addFirst(fantasy x) {
        item[front] = x;
        front = (front - 1 + item.length) % item.length;
        size ++;
        if (size == item.length) {
            resize(size * 2);
        }
    }

    @Override
    public void addLast(fantasy x) {
        item[rear] = x;
        rear = (rear + 1) % item.length;
        size ++;
        if (size == item.length) {
            resize(size * 2);
        }
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
        if (!isEmpty()) {
            int p = (front + 1) % item.length;
            int n = size;
            while (n > 0) {
                System.out.print(item[p]) ;
                p = (p + 1) % item.length;
                n --;
            }
            System.out.println();
        }
    }

    @Override
    public fantasy removeFirst() {
        if (size == 0) {
            return null;
        }
        int pos = (front + 1) % item.length;
        fantasy temp = item[pos];
        front = pos;
        size --;
        if (size < item.length / 4) {
            resize(item.length / 2);
        }
        return temp;
    }

    @Override
    public fantasy removeLast() {
        if (size == 0) {
            return null;
        }
        int pos = (rear - 1 + item.length) % item.length;
        fantasy temp = item[pos];
        rear = pos;
        size --;
        if (size < item.length / 4) {
            resize(item.length / 2);
        }
        return temp;
    }

    @Override
    public fantasy get(int index) {
        if (index + 1 > size || index < 0) {
            return null;
        }
        int p = front;
        while (index > 0) {
            p = (p + 1) % item.length;
            index --;
        }
        return item[p];
    }

    public void resize(int n) {
        fantasy[] newArray = (fantasy[]) new Object[n];
        int p = front, x = size, index = 0;
        while (x > 0) {
            newArray[index ++] = item[p];
            p = (p + 1) % item.length;
            x --;
        }
        item = newArray;
        front = item.length - 1;
        rear = size - 1;
    }
    public static void main (String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque();
        L.addFirst(1);
        L.addLast(2);
        L.addFirst(3);
        L.addFirst(4);
        L.addLast(5);
        L.printDeque();
        L.removeFirst();
        L.printDeque();
        L.removeLast();
        L.printDeque();
        System.out.println(L.get(2));
    }
}
