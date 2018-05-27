package leetcode;

class AddBinary {
  public String addBinary(String a, String b) {
      
      StringBuilder out = new StringBuilder("");
      int al = a.length();
      int bl = b.length();
      
      char zero = '0';
      char one = '1';
      
      int sizeDiff = al-bl;
      
      if(sizeDiff > 0){
          b = prependNtimes(b,Math.abs(sizeDiff));
      }else{
          a = prependNtimes(a,Math.abs(sizeDiff));
      }
      
      boolean carry = false;

      
      for(int i = 0 ; i< a.length() ;i++) {
          
          char as = a.charAt(a.length()-i-1);
          char bs = b.charAt(b.length()-i-1);
          
          char tbprep;
          
          if(as == zero && bs == zero){
              
              tbprep = carry?one:zero;
              carry = false;
              
          } else if(as == one && bs == zero){
              
              tbprep = carry?zero:one;
              
              
          } else if(as == zero && bs == one) {
              
              tbprep = carry?zero:one;
              
          } else {
              
              tbprep = carry?one:zero;
              carry = true;
          }
          
          out.insert(0,tbprep);
          
      }
      
      return carry?"1"+out.toString():out.toString();
      
  }
  
  private String prependNtimes(String input , int times){
      
      StringBuilder builder = new StringBuilder(input);
      char zero = '0';
      
      
      for(int i = 0 ; i< times ; i++){
          builder.insert(0,zero);
      }
      
      return builder.toString();
  }
  
}
