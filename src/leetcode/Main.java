package leetcode;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
//
//    String a = "abcda";
//    System.out.println(a.substring(2,4));
//    System.out.println(a.charAt(2));
//    System.out.println(a.charAt(1));
//    System.out.println(longestPalindrome(a));
    
//    int [][] m = generateMatrix(5);
//    print(m);
    
//    int A[] = {1,2,5,3,-1,1};
//    int A[] = {-5,1000};
//
//    System.out.println("missing index  " + firstMissingPositive(A));
    
//    String path = "/../";
//    
//    SimplifyPath simplifier = new SimplifyPath();
//    System.err.println(simplifier.simplifyPath(path));
    
//    String roman = "PIX";
//    Romans romans = new Romans();
//    System.err.println(romans.romanToInt(roman));
    
//    Atoi atoi = new Atoi();
//    System.err.println(atoi.myAtoi("2a9342"));
    
    
    String[] input = {"flower","flow","flight"};
    
    
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(input));
    
  }
  
  public static int[][] generateMatrix(int n) {
    
    int i = 0 ;
    int j = 0;
    int count = 1;
    
    int[][] out = new int[n][n];
    
    int size = n;
    
    while(count <= n*n) {
      
      out[i][j] = count++;
      System.out.println("Setting (" + i + "," + j +") as " + (count-1));
        
      if(i== n-size && j != size-1)  {
          j++;
          continue;
      }
      
      if(j == size-1 && i != size-1){
          i++;
          continue;
      }
    
      if(i == size-1 && j != n-size){
          j--;
          continue;
      }
        
      if(j == n-size && i != n-size)  {
          i--;
          
          if( i == n-size) {
            size--;
            j = j+1;
            i = i+1;
          }
          
          continue;
      }
        
    }
    
    return out;
    
}

  public static void print(int [][] array) {
    
    System.out.println("-------- printing data ---------");
    
    for(int i = 0 ; i < array[0].length ; i++) {
      
      for(int j = 0 ; j < array.length ; j++) {
        
        System.out.print(array [i][j] + ",");
      }
      
      System.out.println();
    }
    
  }
  
  public static String longestPalindrome(String s) {
    
    if(s.equals(new StringBuilder(s).reverse().toString())) {
      System.out.println("Already a palindrome");
      return s;
    }
    
    int n = s.length(); 
    boolean[][] data = new boolean[n][n];
    
    int initMax = 0;
    int endMax = 0; 
    int maxLength = 1;
     
    for(int i = 0 ; i < n ; i++) {
                   
        data[i][i] = true;
        
        if(i < n-1 && s.charAt(i) == (s.charAt(i+1))){
            data[i][i+1] = true;
            initMax = i;
            endMax = i+1;
            maxLength = 2;
        }
        
    }
    
//    print(data);
     
   
    
    
    for(int l = 3; l <= s.length() ; l++) {
      
      for(int i = 0 ; i < n - l +1 ; i++) {
        
        int j = i+l-1;
        
        System.out.println("i = " + i + " j = " + j + " l = " +l);
        
        if(s.charAt(i) == (s.charAt(j))) {
          
          if(data[i+1][j-1]) {
            
              data[i][j] = true;
              
              if(maxLength <= l){
                  maxLength = l;
                  initMax = i;
                  endMax = j;
                  
                  System.out.println(s.substring(initMax,endMax+1));
                  
//                  print(data);
              }
              
          }
          
      }
        
      }
      
      
    }
     
    
     
//     print(data);
     
     return s.substring(initMax,endMax+1);
     
 }
  
  
  public static int firstMissingPositive(int[] A) {
    System.out.println("Finding Missing positive");
    
    int n = A.length;
    
    
    for(int i = 0 ; i < n ; i++) {
      if(A[i] <= 0) {
        A[i] = Integer.MAX_VALUE;
      }
    }
    
   for(int i = 0 ; i< n ; i++) {
    
       int j = i;
       int sent = -1;
       
       if(A[j] > 0 && A[j] <= n ) {
           
           int k = -1;
           
           while((sent >= 0 && sent <= n && A[sent -1 ] > 0) || (sent < 0 && A[A[j] -1 ] > 0)) {
               
               
               if(sent < 0) {
                 
                 System.out.println("Setting " + A[j] + " as found");
                 
                 k = A[A[j] - 1];
                 A[A[j] - 1] = -1*A[A[j] - 1];
                 
                 
               }else {
                 
                 System.out.println("Setting " + sent + " as found");
                 
                 k = A[sent - 1];
                 A[sent - 1] = -1*A[sent - 1];
               }
               
               if(k != -1) {
                 j = k ; 
                 sent = j;
                 
              } else {
                break;
              }
               
           }
           
           
       }
       
   } 
   
   for(int i = 0 ; i< n ;i++) {
     System.out.print(A[i]+",");
   }
   
   System.out.println();
   
   for(int i = 0 ; i<n ;i++) {
     if(A[i] > 0) {
       return i+1;
     }
   }
    
   return n+1;
}
  
}
