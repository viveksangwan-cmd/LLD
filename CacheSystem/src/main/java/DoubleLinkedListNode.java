public class DoubleLinkedListNode<K> {
    DoubleLinkedListNode<K> prev;
    DoubleLinkedListNode<K> next;
    K value;

    public DoubleLinkedListNode(K key){
        this.value = key;
        prev = null;
        next = null;
    }

    public DoubleLinkedListNode() {
    }
}
