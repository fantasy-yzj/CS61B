package deque;

public class LLDNode<fantasy> {
    fantasy item;
    LLDNode pre, next;
    public LLDNode() {
        pre = this;
        next = this;
    }
}
