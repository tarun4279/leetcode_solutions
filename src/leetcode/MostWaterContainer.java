package leetcode;

public class MostWaterContainer {

  
  
  public int maxArea(int[] height) {
    
    int i = 0;
    int j = height.length -1;
    
    int maxArea = area(i,j,height);
    
    while(i != j-1) {
      
      if(height[i] < height[j]) {
        i++;
      }else {
        j--;
      }
      
      maxArea = Math.max(maxArea, area(i,j,height));
      
    }
    
    return maxArea;
  }
  
  private int area(int a, int b , int[] height) {
    
    return Math.abs(a-b)*Math.min(height[a], height[b]);
    
  }
  
}
