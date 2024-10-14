package edu.bluecc.CS260.list;

import java.util.Arrays;

public class UniqueList implements List {

  private String[] a = new String[1000];
  private int end = -1;

  public static void main(String[] args) {
    List list = new UniqueList();
    list.add("Q");
    list.add("A");
    // list.add("A");
    // list.add(1, "Q");
    // list.set(0,"Q");

  }
  public static void print(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i)+" "); // x, tomato, a, b, c
    }
    System.out.println();
  }

  /**
   * Adds the given value to the end of the list, unless the value is
   * already in the list. if the value is in the list, this method
   * throws a new IllegalArgumentException
   * ADT List: APPEND(v) -> T/F
   *
   * @param val - value to be added
   * @return true if the value was added, false otherwise
   * @throws IllegalArgumentException if the value is already in the list
   */
  @Override
  public boolean add(String val) {
    if (find(val) >= 0)
      throw new IllegalArgumentException(String.format("Value '%s' is already in the list. This list accepts unique values only", val));

    if(end > 0.8*a.length) {
      a = Arrays.copyOf(a, (int)(1.5*a.length));
//      String[] b = new String[(int) (1.5 * a.length)];
//      for (int i=0; i <= end; i++) {
//        b[i]=a[i];
//      }
//      a = b;
    }
    a[++end] = val;
    return true;
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
    int index = find(val);
    if (index == -1) {
      return false;
    }
    remove(index);
    return true;
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
    if (index < 0 || index > end) {
      throw new IndexOutOfBoundsException("index not valid");
    }
    String value = a[index];
    for (int i = index+1; i <= end; i++)
      a[i-1]=a[i];
    end--;
    return value;
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
    if (index < 0 || index > end) {
      throw new IndexOutOfBoundsException("index not valid");
    }

    if (find(val) >= 0)
      throw new IllegalArgumentException(String.format("Value '%s' is already in the list. This list accepts unique values only", val));

    for(int i = end; i >= index; i--) {
      a[i+1]=a[i];
    }
    a[index] = val;
    end++;
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
    if (index < 0 || index > end) {
      throw new IndexOutOfBoundsException("index not valid");
    }
    if (find(val) >= 0)
      throw new IllegalArgumentException(String.format("Value '%s' is already in the list. This list accepts unique values only", val));
    a[index] = val;
    return val;
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
    if (index < 0 || index > end) {
      throw new IndexOutOfBoundsException("index not valid");
    }
    return a[index];
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
    for (int i = 0; i <= end; i++) {
      if (a[i].equals(val)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the number of elements in this list
   * ADT List: LENGTH() -> int
   *
   * @return the number of elements in this list
   */
  @Override
  public int size() {
    return end+1;
  }

  /**
   * Removes all elements from this list
   * ADT List: DELETE_ALL()
   */
  @Override
  public void clear() {
    String[] b = new String[a.length];
    a=b;
    end=-1;
  }
}
