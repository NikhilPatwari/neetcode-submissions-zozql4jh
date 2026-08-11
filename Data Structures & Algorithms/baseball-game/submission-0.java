class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> score = new Stack<>();
        for(String i : operations){
            if(i.equals("+") || i.equals("C") || i.equals("D")){
                if(i.equals("+")){
                    int num2 = score.pop();
                    int num1 = score.peek();
                    score.push(num2);
                    score.push(num1+num2);
                }else if(i.equals("D")){
                    score.push(score.peek() *2);
                }else{
                    score.pop();
                }

            }else{
                score.push(Integer.valueOf(i));
            }
        }
        int result = 0;
        while(!score.isEmpty()){
            result += score.pop();
        }
        return result;
    }
}