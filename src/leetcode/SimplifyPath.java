package leetcode;

import java.util.Stack;

public class SimplifyPath {

  public String simplifyPath(String path) {
    
    if(path == null || path.length() == 0) {
      return path;
    }
    
    path = path.replaceAll("//", "/");
    
    System.out.println(path);
    
    StringBuilder out = new StringBuilder();
    
    Stack<String> stack = new Stack<>();
    
    String[] dirs = path.split("/");
    
    for(String dir : dirs) {
      
      if(!dir.equals("") && !dir.equals(".") && !dir.equals("..")) {
        stack.push(dir);
      }
      
      if(dir.equals("..") && !stack.isEmpty()) {
        stack.pop();
      }
      
    }
    
    while(!stack.isEmpty()) {
      out.insert(0, "/"+stack.pop());
    }
    
    return out.toString().isEmpty()?"/":out.toString();
  }
  
}
