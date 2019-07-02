package ru.geekbrains.lesson8;

public class LinkedHashTableImpl<I extends Item, V> implements HashTable<I, V> {
    private class LinkedEntry {
        private final I key;
        private V value;
        private LinkedEntry next;

        public LinkedEntry(I key, V value) {
            this.key = key;
            this.value = value;
        }

        public I getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }


        public LinkedEntry getNext() {
            return next;
        }

        public void setNext(LinkedEntry next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Object[] data;
    private int size;
    private int maxSize;


    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    private int hashFunc(I key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(I item, V cost) {
        if (size == maxSize) {
            return false;
        }


        LinkedEntry newItem = new LinkedEntry(item, cost);
        int index = hashFunc(item);

        LinkedEntry dataItem = (LinkedEntry) data[index];

        if (dataItem == null) {
            data[index] = newItem;
        } else {
            LinkedEntry previous = null;
            while (dataItem != null) {
                if (dataItem.getKey().equals(item)) {
                    dataItem.setValue(cost);
                    return true;
                }
                previous = dataItem;
                dataItem = dataItem.getNext();
            }
            previous.setNext(newItem);
        }
        size++;
        return true;
    }

    @Override
    public V get(I item) {
        int index = hashFunc(item);
        LinkedEntry dataItem = (LinkedEntry) data[index];

        if (isEmpty() || dataItem == null) {
            return null;
        }

        do {
            if (dataItem.getKey().equals(item)) {
                return dataItem.getValue();
            }
            dataItem = dataItem.getNext();
        } while (dataItem != null);

        return null;
    }

    @Override
    public boolean remove(I item) {
        if (isEmpty()) return false;

        int index = hashFunc(item);

        if (data[index] != null) {
            LinkedEntry prevEntry = null;
            LinkedEntry entry = (LinkedEntry) data[index];

            while (entry.getNext() != null && !entry.getKey().equals(item)) {
                prevEntry = entry;
                entry = entry.getNext();
            }

            if (entry.getKey().equals(item)) {
                if (prevEntry == null) {
                    data[index] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
            }
            size--;
            return true;
        }
        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        for (int i = 0; i < data.length; i++) {
            System.out.println("[" + i + "] \t- " + data[i]);
            LinkedEntry le = (LinkedEntry) data[i];
            while (le != null && le.getNext() != null) {
                le = le.getNext();
                System.out.println("\t \t" + le);
            }
        }

        System.out.println("-----------");
    }
}
