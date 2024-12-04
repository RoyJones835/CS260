package edu.bluecc.CS260.map;

public class HashTableTester {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashTable<>();
    map.put(42,"Homer");
    map.put(37,"Marge");
    map.put(50,"Mary");
    map.put(4,"Jack");
    System.out.println(map.size());
    System.out.println(map.get(42));
    System.out.println(map.get(37));
    System.out.println(map.get(50));
    System.out.println(map.get(4));
    System.out.println(map.get(100));
  }
}
