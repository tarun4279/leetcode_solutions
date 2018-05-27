package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {

public int myAtoi(String str) {
    
    if(str == null || str.trim().equals("")){
        return 0;
    }
    
    str = str.trim();
        
    char firstChar = str.charAt(0);
    char secondChar = str.length()>1?str.charAt(1):0;
    
    if(!Character.isDigit(firstChar)) {
      
      if(firstChar!= '-' && firstChar != '+') {
        return 0;
      }else {
        
        if(!Character.isDigit(secondChar)) {
          return 0;
        }
        
      }
            
    }
    
    String regex = "[-+]?\\d+";
    
    List<String> allMatches = new ArrayList<String>();
    Matcher m = Pattern.compile(regex).matcher(str);
    while (m.find()) {      
      allMatches.add(m.group());
    }
    
    if(allMatches.size() == 0) {
      return 0;
    }
    
    try {      
      return Integer.valueOf(allMatches.get(0));
    } catch (NumberFormatException ex) {
      return allMatches.get(0).charAt(0) == '-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
    }
    
  }

  private boolean isCorrectChar(char firstChar) {
    return firstChar!= '-' && firstChar != '+' &&  !Character.isDigit(firstChar);
  }

}
