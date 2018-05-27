package leetcode;

import java.util.HashMap;

public class Romans {
  
  public int romanToInt(String s) {
    
    HashMap<Character,Integer> data = new HashMap<>();
    
    char [] array = s.toCharArray();
    
    int i = 0;
    
    while(i <= array.length-1) {
      
      char base = array[i];
      char next = i == array.length-1?'T':array[i+1];
      int size = getSize(base,next);
      
      data.put(base, data.containsKey(base)?data.get(base)+size:size);
      i = i+ (size==1?1:2);
      
    }
    
    int out = 0;
    
    out += 1*(data.containsKey('I')?data.get('I'):0);
    out += 5*(data.containsKey('V')?data.get('V'):0);
    out += 10*(data.containsKey('X')?data.get('X'):0);
    out += 50*(data.containsKey('L')?data.get('L'):0);
    out += 100*(data.containsKey('C')?data.get('C'):0);
    out += 500*(data.containsKey('D')?data.get('D'):0);
    out += 1000*(data.containsKey('M')?data.get('M'):0);
    
    return out;
}
  
  private int getSize(char base, char next) {
    
    if(next == 'T') {
      return 1;
    }
    
    if(base == 'I' && next == 'V') {
      return 4;
    } else if (base == 'I' && next == 'X') {
      return 9;
    } else if (base == 'X' && next == 'L') {
      return 4;
    } else if (base == 'X' && next == 'C') {
      return 9;
    } else if (base == 'C' && next == 'D') {
      return 4;
    } else if (base == 'C' && next == 'M') {
      return 9;
    }
    
    return 1;
  }
  
  
}
