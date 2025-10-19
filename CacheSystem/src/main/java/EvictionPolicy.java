public interface EvictionPolicy<K> {
    void getAccessed(K key);
    K evict();
}
