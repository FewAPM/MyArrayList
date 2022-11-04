package module_nine;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int capacity; // 16

    private int size = 0;

    private double lf = 0.75;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[this.capacity];
    }

    public void clear() {
        buckets = new Entry[0];
        size = 0;
    }

    public void put(K key, V value) {
        if (buckets == null || buckets.length == 0) {
            buckets = new Entry[capacity];
        }
        if (size == lf * capacity) {

            Entry<K, V>[] old = buckets;

            capacity *= 2;
            size = 0;
            buckets = new Entry[capacity];

            for (Entry<K, V> e : old) {
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }
        Entry<K, V> entry = new Entry<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {

            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (key == bucket.key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : buckets) {
            sb.append("[");
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append(", ");
                }
                entry = entry.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }

    }

    public void remove(K key) {
        if (size == 0) {
            System.out.println("The map is empty!");
            return;
        }
        if (get(key) == null) {
            System.out.println("There isn't this Key in the map!");
            return;
        }

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucket];

        while (buckets[bucket].next != null) {
            if (buckets[bucket].key.equals(key)) {
                buckets[bucket] = buckets[bucket].next;
                size--;
                return;
            }
            buckets[bucket] = buckets[bucket].next;

        }
        if (buckets[bucket].key.equals(key)) {
            size--;
            buckets[bucket] = null;
        } else {
            buckets[bucket] = existing;
        }
    }


}


class MyMapTester {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        System.out.println("map.get(\"MSI\") = " + map.get("MSI"));
        map.remove("MSI");
        map.put("MSI", 100);
        map.clear();
        System.out.println("map.size() = " + map.size());
        map.put("MSI", 100);
        map.put("King", 100);
        map.put("BLAKE", 10);
        map.put("Den", 10000);
        map.remove("Yarik");
        System.out.println("map.get(\"Den\") = " + map.get("Den"));
        map.put("MSI", 100);
        map.remove("MSI");
        map.remove("King");
        map.remove("BLAKE");
        map.remove("Den");
        System.out.println("map = " + map);

    }
}