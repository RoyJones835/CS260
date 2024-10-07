package edu.bluecc.CS260.list;

public class LinkedList implements List{

  /**
   * Adds the given value to the end of the list
   * ADT List: APPEND(v) -> T/F
   *
   * @param val - value to be added
   * @return true if the value was added, false otherwise
   */
  @Override
  public boolean add(String val) {
    return false;
  }

  /**
   * Removes the first occurrence of the given value from the list
   * ADT List: DELETE(v) -> T/F
   *
   * @param val - The value to be removed
   * @return true if the value was removed, false otherwise
   */
  @Override
  public boolean remove(String val) {
    return false;
  }

  /**
   * Removes the value at the given index from the list
   * ADT List: DELETE(p) -> v
   *
   * @param index - the index of the value to be removed
   * @return the removed value
   * @throws IndexOutOfBoundsException index the index is invalid
   */
  @Override
  public String remove(int index) {
    return "";
  }

  /**
   * Inserts the given value at the given index
   * ADT list: INSERT(p,v)
   *
   * @param index - the index of where to insert the value
   * @param val   - the value to insert
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  @Override
  public void add(int index, String val) {

  }

  /**
   * Replaces the value at the given index with the given value
   * ADT List: REPLACE(p,v) -> v
   *
   * @param index - the index of the value to replace
   * @param val   - the replacement value
   * @return the original value
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  @Override
  public String set(int index, String val) {
    return "";
  }

  /**
   * Returns the value in the list at the given index
   * ADT List: RETRIEVE(p) -> v
   *
   * @param index - the index
   * @return the value at the given index
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  @Override
  public String get(int index) {
    return "";
  }

  /**
   * Returns the index of the first occurrence of the given value, or -1 if not found
   * ADT List: LOCATE(v) -> p
   *
   * @param val - the search value
   * @return the index of the first occurrence of the given value, or -1 if not found
   */
  @Override
  public int find(String val) {
    return 0;
  }

  /**
   * Returns the number of elements in this list
   * ADT List: LENGTH() -> int
   *
   * @return the number of elements in this list
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * Removes all elements from this list
   * ADT List: DELETE_ALL()
   */
  @Override
  public void clear() {

  }
}
