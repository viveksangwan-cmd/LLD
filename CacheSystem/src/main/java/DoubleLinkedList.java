public class DoubleLinkedList<K> {

    DoubleLinkedListNode<K> head;
    DoubleLinkedListNode<K> tail;
    public DoubleLinkedList(){
        head = new DoubleLinkedListNode<>();
        tail = new DoubleLinkedListNode<>();

        head.next = tail;
        tail.prev = head;
    }


    public void detachNode(DoubleLinkedListNode<K> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DoubleLinkedListNode<K> addNodeWithKey(K key){
        DoubleLinkedListNode<K> current = new DoubleLinkedListNode<>(key);
        addNodeAtEnd(current);
        return current;
    }


    public void addNodeAtEnd(DoubleLinkedListNode<K> node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public K getFirstNodeKey(){
        return head.next.value;
    }

}
