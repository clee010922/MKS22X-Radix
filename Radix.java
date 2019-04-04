import java.util.*;
public class Radix {

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> myData = new MyLinkedList();
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    int k = 0;
    for (int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) > Math.pow(10, k)) {
        String val = "" + data[i];
        k = val.length()-1;
      }
      myData.add(data[i]);
    }
    System.out.println(k);
    MyLinkedList temp = new MyLinkedList();
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < data.length; j++) {
        int digit = Math.abs(getNthDigit(data[j], i));
        if (data[j] > 0)
          buckets[digit+10].add(data[j]);
        else buckets[9-digit].add(data[j]);
      }
      for (int x = 0; x < buckets.length; x++) {
        if (buckets[x].size() > 0)
          temp.extend(buckets[x]);
      }
      for (int y = 0; y < data.length; y++) {
        data[y] = (int)temp.removeFront();
      }
    }
  }

  private static int getNthDigit(int val, int n) {
    int result = (val / (int)Math.pow(10, n)) % 10;
    return result;
  }

  public static void main(String args[]) {
    int[] data = {0, 10, 342, -5452, 399, -12345678};
    radixsort(data);
    System.out.println(Arrays.toString(data));
  }

}
