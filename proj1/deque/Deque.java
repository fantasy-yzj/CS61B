package deque;

public interface Deque<fantasy> {
    public void addFirst (fantasy x);
    public void addLast (fantasy x);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public fantasy removeFirst();
    public fantasy removeLast();
    public fantasy get(int index);
}
