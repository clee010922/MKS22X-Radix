public class Radix {

  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    int max = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] > max)
        max = data[i];
    }
    int k = 0;
    while (max > 0) {
      max /= 10;
      k++;
    }
    MyLinkedList temp = new MyLinkedList();
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < data.length; j++) {
        int digit = Math.abs(getNthDigit(data[j], i));
        if (data[j] > 0)
          buckets[digit+10].add(data[j]);
        else buckets[digit].add(data[j]);
      }
      for (int x = 0; x < buckets.length; i++) {
        temp.extend(buckets[i]);
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

}
