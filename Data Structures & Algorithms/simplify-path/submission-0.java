class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String directory : directories){
            if(directory.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }else if(!directory.equals("") && !directory.equals(".")){
                stack.push(directory);
            }
        }
        return "/" + String.join("/", stack);
    }
}