public class Node {

  Node next, prev;
  Integer data;

  public Node(Integer dataInteger, Node nextNode, Node prevNode) {
    next = nextNode;
    prev = prevNode;
    data = dataInteger;
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

  public Integer setData(Integer i) {
    Integer oldData = data;
    data = i;
    return oldData;
  }

  public Integer getData() {
    return data;
  }


}
