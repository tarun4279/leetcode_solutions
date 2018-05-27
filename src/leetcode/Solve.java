package leetcode;

public class Solve {

  public static void main(String[] args) {

//    AddBinary addBinary = new AddBinary();
//    System.out.println(addBinary.addBinary("1011", "1"));
    
//    int [] nums = {0};    
//    JumpGame jumpGame = new JumpGame();
//    System.out.println(jumpGame.canJump(nums));
    
      ListNode a = new ListNode(1);
      a.next = new ListNode(2);
      a.next.next = new ListNode(3);
      a.next.next.next = new ListNode(5);
      a.next.next.next.next = new ListNode(5);
      a.next.next.next.next.next = new ListNode(6);
      
      DuplicatesDeleter del = new DuplicatesDeleter();
      ListNode uniques = del.deleteDuplicates2(a);
      
      a.print();
      System.out.println("");
      uniques.print();
  }

}
