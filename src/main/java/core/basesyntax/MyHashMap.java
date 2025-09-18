package core.basesyntax;

import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Entry<K, V>>[] table;
    int initialCapacity = 16;
    double loadFactor = 0.75;

    @Override
    public void put(K key, V value) {
        table[getIndex(key)].add((Entry<K, V>) value);
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    public void resize(int initialCapacity) {
        while (initialCapacity > table.length) {
            int newCapacity = (int)(table.length * loadFactor);
            LinkedList<Entry<K, V>>[] newTable;
            System.arraycopy(array, 0, newArray, 0, size);
            initialCapacity = newCapacity;
        }
    }

    public int getIndex(K key) {
        int position = 0;
        if (key != null) {
            position = key.hashCode() % table.length;
        }
        return position;
    }
}
