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
        k = val.length();
      }
      myData.add(data[i]);
    }
    //System.out.println(k);
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

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tradix/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Radix.radixsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }

}
