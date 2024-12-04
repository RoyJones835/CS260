package edu.bluecc.CS260.map;

import java.util.List;
import java.util.LinkedList;

public class HashTable<K,V> implements Map<K,V> {

  private List<Entry<K,V>>[] a = (List<Entry<K,V>>[])new List[1000];
  private int size = 0;

  /**
   * Put the given value into this map using the given key
   * @param key The key of the entry
   * @param value The value of the entry
   */
  @Override
  public void put(K key, V value) {
    int location = locationFor(key);
    if(a[location] == null) {
      a[location] = new LinkedList<>(); // bootstrapping
    }
    // there is now a List here
    a[location].add(new Entry<K,V>(key,value));
    size++;
  }

  /**
   * Retrieve the value in the map located by the given key,
   * or null if the key does exist in the map
   * @param key The key
   * @return The value at the given key, or null if the key does not exist
   */
  @Override
  public V get(K key) {
    int location = locationFor(key);
    if(a[location] == null) {
      return null;
    }

    List<Entry<K,V>> list = a[location];
    // Loop through each Entry in the list
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getKey() == key)
        return list.get(i).getValue();
    }
    return null;
  }

  /**
   * Returns true if the map contains the given key, false otherwise
   * @param key The key
   * @return true if the map contains the given key, false otherwise
   */
  @Override
  public boolean containsKey(K key) {
    return get(key) != null;
  }

  /**
   * Returns true if this map contains no keys, false otherwise
   * @return true if this map contains no keys, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the number of entries in the map
   * @return the number of entries in the map
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the corresponding location in the array for the given key
   * @param key the key
   * @return the corresponding location in the array for the given key
   */
  private int locationFor(K key) {
    return Math.abs(key.hashCode()) % a.length;
  }


}
