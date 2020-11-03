package arithmetic;

/**
 * Create with Darcula IDEA
 * Description: 判断链表是否有环
 * @Author CJP
 * @Date 2020/11/2
 * @Time 19:26
 */

public class IsCycle {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(isCycle(node1));
    }
    private  static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while(p2 != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
