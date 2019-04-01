public class MyLinkedList<E>{

  private class Node {

    private Node next, prev;
    private E data;

    public Node(E dataa, Node nextNode, Node prevNode) {
      next = nextNode;
      prev = prevNode;
      data = dataa;
    }

    public Node() {
      data = null;
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public void setNext(Node other) {
      next = other;
    }

    public void setPrev(Node other) {
      prev = other;
    }

    public String toString() {
      return "" + data;
    }

    public E setData(E i) {
      E oldData = data;
      data = i;
      return oldData;
    }

    public E getData() {
      return data;
    }

  }

  private Node start;
  private Node end;
  private int length;

  public MyLinkedList(){
    length = 0;
  }

  public void clear() {
    length = 0;
    start = null;
    end = null;
  }

  public boolean add(E value) {
    if (length == 0) {
      Node n = new Node(value, null, null);
      start = n;
      end = n;
      length++;
    }
    else {
      Node n = new Node(value, null, end);
      n.prev().setNext(n);
      end = n;
      length++;
    }
    return true;
  }

  public int size() {
    return length;
  }

  public String toString() {
    if (length == 0)
      return "[]";
    String result = "[";
    Node i = start;
    while(i.next() != null) {
      result += i.getData() + ", ";
      i = i.next();
    }
    result += i.getData() + "]";
    return result;
  }

  private Node getNthNode(int index) {
    Node result = start;
    for (int i = 0; i < index; i++) {
      result = result.next();
    }
    return result;
  }

  public E get(int index) {
    if (index < 0 || index >= length)
      throw new IndexOutOfBoundsException();
    return getNthNode(index).getData();
  }

  public E set(int index, E value) {
    if (index < 0 || index >= length)
      throw new IndexOutOfBoundsException();
    Node temp = getNthNode(index);
    E oldData = temp.getData();
    temp.setData(value);
    return oldData;
  }

  public boolean contains(E value) {
    boolean temp = false;
    Node current = start;
    for (int i = 0; i < length; i++) {
      if (current.getData() == value)
        temp = true;
      current = current.next();
    }
    return temp;
  }

  public int indexOf(E value) {
    Node current = start;
    for (int i = 0; i < length; i++) {
      if (current.getData() == value) {
        return i;
      }
      current = current.next();
    }
    return -1;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= length)
      throw new IndexOutOfBoundsException();
    Node n = new Node(value, null, null);
    if (index == 0) {
      n.setPrev(null);
      n.setNext(getNthNode(0));
      start = n;
      length++;
    }
    else {
      Node next = getNthNode(index);
      Node prev = getNthNode(index - 1);
      n.setPrev(prev);
      n.setNext(next);
      prev.setNext(n);
      next.setPrev(n);
      length++;
    }
  }

  public E remove(int index) {
    if (index < 0 || index >= length)
      throw new IndexOutOfBoundsException();
    Node n = getNthNode(index);
    Node prev, next;
    E oldData = n.getData();
    if (index == 0) {
      next = n.next();
      next.setPrev(null);
      start = next;
      length--;
    }
    else if (index == length-1) {
      prev = n.prev();
      prev.setNext(null);
      end = prev;
      length--;
    }
    else {
      prev = getNthNode(index-1);
      next = getNthNode(index+1);
      prev.setNext(next);
      next.setPrev(prev);
      length--;
    }
    return oldData;
  }

  public E removeFront() {
    return remove(0);
  }

  public boolean remove(E value) {
    if (contains(value)) {
      remove(indexOf(value));
      return true;
    }
    return false;
  }

  public void extend(MyLinkedList<E> other) {
    if (length == 0) {
      end = other.end;
      start = other.start;
    }
    else if (other.size() == 0) {
      end = other.end;
    }
    else {
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
    }
    length += other.size();
    MyLinkedList temp = new MyLinkedList();
    other = temp;
  }

}
