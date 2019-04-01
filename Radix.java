public class Radix {

  public static void radixsort(int[] data) {
    int max = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] > max)
        max = data[i];
    }
    int k = 1;
    while (k > 10) {
      max /= 10;
      k++;
    }
    for (int i = 0; i < k; i++) {
      MyLinkedList[] buckets = new MyLinkedList<E>[10];

    }
  }

}
