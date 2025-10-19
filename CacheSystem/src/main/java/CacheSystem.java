public class CacheSystem {
    static void main() throws NoSuchElementFoundException {
        DataStorage<Integer,String> dataStorage = new ConcurrentHashMapDataStorage(5);
        EvictionPolicy<Integer> evictionPolicy = new LRUEvictionPolicy<>();
        for(int i=0;i<10;i++){
            if(i==4) {
                dataStorage.getValue(2);
                evictionPolicy.getAccessed(2);
            }
            try {
                dataStorage.addKey(i,"Hello-"+i);
                evictionPolicy.getAccessed(i);
            } catch (FullStorageException e) {
                int keyToEvict = evictionPolicy.evict();
                try {
                    dataStorage.remove(keyToEvict);
                } catch (NoSuchElementFoundException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    dataStorage.addKey(i,"Hello-"+i);
                    evictionPolicy.getAccessed(i);
                } catch (FullStorageException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
