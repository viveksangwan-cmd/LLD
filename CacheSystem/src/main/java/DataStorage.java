public interface DataStorage<K,V> {
    void addKey(K key,V value) throws FullStorageException;
    void remove(K key) throws NoSuchElementFoundException;
    V getValue(K key) throws NoSuchElementFoundException;
}
