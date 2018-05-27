package leetcode;




public class DuplicatesDeleter {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode out = new ListNode(Integer.MIN_VALUE);
        ListNode tbr = out;
        ListNode cur = head;
        
        while(cur != null) {
          
          if(cur.val != out.val) {
            out.next = new ListNode(cur.val);
            out = out.next;
          }
          
          cur = cur.next;
        }
        
        return tbr.next;
    }
    
    
    public ListNode deleteDuplicates2(ListNode head) {
      
      if(head == null || head.next == null){
        return head;
      }
      
      ListNode out = new ListNode(Integer.MIN_VALUE);
      ListNode tbr = out;
      ListNode cur = head;
      
      int freq = 0;
      
      while(cur != null) {
        
        if(cur.next != null && cur.next.val == cur.val) {
          freq++;
        }else {
          if(freq == 0) {
            out.next = new ListNode(cur.val);
            out = out.next;
          }else {
            freq = 0;
          }
        }
        
        cur = cur.next;
      }
      
      return tbr.next;
    }
}
