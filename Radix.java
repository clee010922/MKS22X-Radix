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
    while (k > 0) {
      for (int i = 0; i < k; i++) {
      }
    }
  }

  private static int getNthDigit(int val, int n) {
    int result = (val / (int)Math.pow(10, n)) % 10;
    return result;
  }

}
