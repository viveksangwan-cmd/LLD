import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDataStorage<K,V> implements DataStorage<K,V>{

    final ConcurrentHashMap<K,V> hashMapDataStorage = new ConcurrentHashMap<>();
    final int limit;

    public ConcurrentHashMapDataStorage(final int limit){
        this.limit = limit;
    }

    @Override
    public void addKey(K key, V value) throws FullStorageException {
        if(hashMapDataStorage.containsKey(key) || hashMapDataStorage.size()<=limit){
            hashMapDataStorage.put(key, value);
            return;
        }
        System.out.println("DS - Storage is full");
        throw  new FullStorageException("DS - Storage is full");
    }

    @Override
    public void remove(K key) throws NoSuchElementFoundException {
        if(!hashMapDataStorage.containsKey(key)) {
            System.out.println("DS - No such element found");
            throw new NoSuchElementFoundException("DS - No such element found");
        }
        hashMapDataStorage.remove(key);
    }

    @Override
    public V getValue(K key) throws NoSuchElementFoundException {
        if(!hashMapDataStorage.containsKey(key)) {
            System.out.println("DS - No such element found");
            throw new NoSuchElementFoundException("DS - No such element found");
        }
        return hashMapDataStorage.get(key);
    }
}
