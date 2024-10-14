package edu.bluecc.CS260.list;

public class LinkedList implements List{

  public static void main(String[] args) {
    List list = new LinkedList();
    list.add("Q"); // 0
    list.add("A"); // 1
    list.add("B"); // 2
    list.add("C"); // 3
    list.add("D"); // 4
    list.add("R"); // 5
    list.add("Z"); // 6
    print(list); // Q A B C D R Z
    System.out.println(list.size()); // 7
    System.out.println(list.find("R")); // 5
    System.out.println(list.find("SSS")); // -1
    list.remove("Z");
    list.remove(0);
    list.remove("D");
    list.remove("A");
    print(list); // B C R
    list.add(0,"AAAH");
    list.add(3,"banana");
    list.add(4, "apple");
    print(list); // AAAH B C banana apple R
    list.set(0,"dolphin");
    list.set(2,"monkey");
    list.set(5,"cat");
    print(list); // dolphin B monkey bannana apple cat
    list.clear();
    list.add("a");
    print(list); // a
  }

  public static void print(List list) {
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i)+" ");
    System.out.println();
  }

  private Node start;
  private Node end;
  private int size = 0;

  /**
   * Adds the given value to the end of the list
   * ADT List: APPEND(v) -> T/F
   *
   * @param val - value to be added
   * @return true if the value was added, false otherwise
   */
  @Override
  public boolean add(String val) {
    Node node = new Node(val);
    if (end == null)
      start = node;
    else
      end.setNext(node);
    end = node;
    size++;
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
    if (start.getValue().equals(val)) {
      start = start.getNext();
      size--;
      return true;
    }

    Node n = start;
    for (int i = 0; i < size-1; i++) {
      if (n.getNext().getValue().equals(val)) {
        n.setNext(n.getNext().getNext());
        size--;
        if (n.getNext() == null)
          end = n;
        return true;
      }
      n = n.getNext();
    }
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
    if (index < 0 || index > size-1)
      throw new IndexOutOfBoundsException(String.format("index %d is out of bounds for list of size %d", index, size));

    String value;
    if (index == 0) {
      value = start.getValue();
      start = start.getNext();
    }
    else {
      Node n = start;
      for (int i = 0; i < index-1; i++)
        n = n.getNext();
      value = n.getNext().getValue();
      n.setNext(n.getNext().getNext());
      if(index == size-1)
        end = n;
    }
    size--;
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
    if (index < 0 || index > size-1)
      throw new IndexOutOfBoundsException(String.format("index %d is out of bounds for list of size %d", index, size));

    if (index == 0) {
      Node node = new Node(val);
      node.setNext(start);
      start = node;
    }
    else {
      Node n = start;
      for (int i = 0; i < index-1; i++)
        n = n.getNext();
      Node node = new Node(val);
      node.setNext(n.getNext());
      n.setNext(node);
    }
    size++;
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
    if (index < 0 || index > size-1)
      throw new IndexOutOfBoundsException(String.format("index %d is out of bounds for list of size %d", index, size));

    String value; // value to return
    if (index == 0) {
      value = start.getValue();
      Node node = new Node(val);
      node.setNext(start.getNext());
      start = node;
    }
    else {
      Node n = start;
      for (int i = 0; i < index-1; i++)
        n = n.getNext();
      value = n.getNext().getValue();

      Node node = new Node(val);
      node.setNext(n.getNext().getNext());
      n.setNext(node);
      if (index == size-1)
        end = node;
    }
    return value;
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
    if (index < 0 || index > size-1)
      throw new IndexOutOfBoundsException(String.format("index %d is out of bounds for list of size %d", index, size));
    Node n = start;
    for (int i = 0; i < index; i++)
      n = n.getNext();
    return n.getValue();
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
    Node n = start;
    for (int i = 0; i < size; i++) {
      if (n.getValue().equals(val))
        return i;
      n = n.getNext();
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
    return size;
  }

  /**
   * Removes all elements from this list
   * ADT List: DELETE_ALL()
   */
  @Override
  public void clear() {
    start = null;
    end = null;
    size = 0;
  }
}
