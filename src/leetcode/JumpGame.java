package leetcode;

public class JumpGame {

  private static int[] data ;

  
  public boolean canJump(int[] nums) {
    
    if(nums.length == 0) {
      return false;
    }

    data = new int[nums.length];
    
    return canReach(0,nums);
    
}

private boolean canReach(int start, int[] nums){
    
    if(data[start] == -1) {
      return false;
    }
  
    if(start + nums[start] >= nums.length -1){
        return true;
    }
    
    if(nums[start] == 0){
        return false;
    }
    
    for(int i = start+1 ; i <= start + nums[start] ; i++) {
        
        if(canReach(i,nums)){
            return true;
        }else {
          data[i] = -1;
        }
        
    }
    
    return false;
}
  
}
