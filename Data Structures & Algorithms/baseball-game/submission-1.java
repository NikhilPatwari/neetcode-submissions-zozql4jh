class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> score = new Stack<>();
        for (String i : operations) {
            switch (i) {
                case "+":
                    int num2 = score.pop();
                    int num1 = score.peek();
                    score.push(num2);
                    score.push(num1 + num2);
                    result += num1 + num2;
                    break;
                case "D":
                    score.push(score.peek() * 2);
                    result += score.peek();
                    break;
                case "C":
                    result -= score.pop();
                    break;
                default:
                    score.push(Integer.valueOf(i));
                    result += Integer.valueOf(i);
            }
        }
        return result;
    }
}