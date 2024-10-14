package edu.bluecc.CS260.listgeneric;

public interface List<T> {

  /**
   * Adds the given value to the end of the list
   * ADT List: APPEND(v) -> T/F
   *
   * @param val - value to be added
   * @return true if the value was added, false otherwise
   */
  public boolean add(T val);


  /**
   * Removes the first occurrence of the given value from the list
   * ADT List: DELETE(v) -> T/F
   *
   * @param val - The value to be removed
   * @return true if the value was removed, false otherwise
   */
  public boolean remove(T val);

  /**
   * Removes the value at the given index from the list
   * ADT List: DELETE(p) -> v
   *
   * @param index - the index of the value to be removed
   * @return the removed value
   * @throws IndexOutOfBoundsException index the index is invalid
   */
  public T remove(int index);

  /**
   * Inserts the given value at the given index
   * ADT list: INSERT(p,v)
   *
   * @param index - the index of where to insert the value
   * @param val - the value to insert
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  public void add(int index, T val);

  /**
   * Replaces the value at the given index with the given value
   * ADT List: REPLACE(p,v) -> v
   *
   * @param index - the index of the value to replace
   * @param val - the replacement value
   * @return the original value
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  public T set(int index, T val);

  /**
   * Returns the value in the list at the given index
   * ADT List: RETRIEVE(p) -> v
   *
   * @param index - the index
   * @return the value at the given index
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  public T get(int index);

  /**
   * Returns the index of the first occurrence of the given value, or -1 if not found
   * ADT List: LOCATE(v) -> p
   *
   * @param val - the search value
   * @return the index of the first occurrence of the given value, or -1 if not found
   */
  public int find(T val);

  /**
   * Returns the number of elements in this list
   * ADT List: LENGTH() -> int
   *
   * @return the number of elements in this list
   */
  public int size();

  /**
   * Removes all elements from this list
   * ADT List: DELETE_ALL()
   */
  public void clear();


}