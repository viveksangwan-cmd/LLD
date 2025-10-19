import java.util.HashMap;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{


    DoubleLinkedList<K> linkedList = new DoubleLinkedList<>();
    HashMap<K,DoubleLinkedListNode<K>> hashMap = new HashMap<>();

    @Override
    public void getAccessed(K key) {
        if(!hashMap.containsKey(key)){
            System.out.println("EP - No key present: "+key);
            hashMap.put(key,linkedList.addNodeWithKey(key));
            return;

        }
        linkedList.detachNode(hashMap.get(key));
        linkedList.addNodeAtEnd(hashMap.get(key));
    }

    @Override
    public K evict() {
        DoubleLinkedListNode<K> leastUsed = hashMap.get(linkedList.getFirstNodeKey());
        System.out.println("EP - Least Used key: "+leastUsed.value);
        linkedList.detachNode(leastUsed);
        return leastUsed.value;
    }
}
