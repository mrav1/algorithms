package set4;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    class CacheEntry {
        int frequency;
        String data;

        CacheEntry(int frequency, String data) {
            this.frequency = frequency;
            this.data = data;
        }

        @Override
        public String toString() {
            return "CacheEntry{" +
                    "frequency=" + frequency +
                    ", data='" + data + '\'' +
                    '}';
        }
    }

    private int capacity = 20;
    static LinkedHashMap<Integer, CacheEntry> cache = new LinkedHashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public void addEntry(int key, String value) {
        if (cache.size() >= capacity) {
            int _key = getLFUEntryKey();
            cache.remove(_key);
        }

        CacheEntry entry = new CacheEntry(0, value);
        cache.put(key, entry);
    }

    public String getEntry(int key) {
        String value = null;
        if (cache.containsKey(key)) {
            CacheEntry _value = cache.get(key);
            value = _value.data;
            _value.frequency++;
            cache.put(key, _value);
        }
        return value;
    }

    private int getLFUEntryKey() {
        int min = Integer.MAX_VALUE;
        int key = 0;
        for (Map.Entry<Integer, CacheEntry> entry : cache.entrySet()) {
            if (entry.getValue().frequency < min) {
                key = entry.getKey();
                min = entry.getValue().frequency;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        LFUCache c = new LFUCache(3);
        c.addEntry(1,"TEST1");
        c.getEntry(1);
        c.addEntry(2,"TEST2");
        c.addEntry(3,"TEST3");
        c.getEntry(2);
        c.getEntry(2);
        c.addEntry(4,"TEST4");

        System.out.println(LFUCache.cache);
    }
}
