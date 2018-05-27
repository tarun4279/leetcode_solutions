package leetcode;

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
  
  public void print() {
    ListNode tbp = this;
    
    while(tbp != null) {
      System.out.print(tbp.val+"->");
      tbp = tbp.next;
    }
    
  }
}