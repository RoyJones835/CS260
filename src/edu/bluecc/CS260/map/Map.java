package edu.bluecc.CS260.map;

public interface Map<K,V> {

  /**
   * Put the given value into this map using the given key
   * @param key The key of the entry
   * @param value The value of the entry
   */
  public void put(K key, V value);

  /**
   * Retrieve the value in the map located by the given key,
   * or null if the key does exist in the map
   * @param key The key
   * @return The value at the given key, or null if the key does not exist
   */
  public V get(K key);

  /**
   * Returns true if the map contains the given key, false otherwise
   * @param key The key
   * @return true if the map contains the given key, false otherwise
   */
  public boolean containsKey(K key);

  /**
   * Returns true if this map contains no keys, false otherwise
   * @return true if this map contains no keys, false otherwise
   */
  public boolean isEmpty();

  /**
   * Returns the number of entries in the map
   * @return the number of entries in the map
   */
  public int size();
}