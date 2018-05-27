package leetcode;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    
    if(strs == null || strs.length == 0){
        return "";
    }
    
    if(strs.length == 1){
        return strs[0];
    }
    
    StringBuilder builder = new StringBuilder();
    
    int index = 0;
    
    while(true) {
      
      try {
        
        char a = strs[0].charAt(index);
        
        for(int i = 1 ; i<strs.length;i++) {
          if(strs[i].charAt(index) != a) {
            throw new StringIndexOutOfBoundsException();
          }
        }
        
        builder.append(a);
        index++;
        
      }catch(StringIndexOutOfBoundsException exception) {
        
       break;
        
      }
      
    }
    
    return builder.toString();
    
  }
  
}
