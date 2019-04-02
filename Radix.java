public class Radix {

  public static void radixsort(int[] data) {
    int max = 0;
    MyLinkedList values = new MyLinkedList();
    for (int i = 0; i < data.length; i++) {
      values.add(data[i]);
      if (data[i] > max)
        max = data[i];
    }
    int k = 1;
    while (k > 10) {
      max /= 10;
      k++;
    }
    int n = k;
    while (k > 0) {
      for (int i = 0; i < k; i++) {
        MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
        buckets[getNthDigit(data[i], n++)].add(data[i]);
      }
    }
  }

  private static int getNthDigit(int val, int n) {
    int temp = (int)Math.pow(10, n);
    return val % temp;
  }

}
