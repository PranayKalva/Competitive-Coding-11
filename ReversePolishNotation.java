//Time Complexity - O(n)
//Space Complexity - O(n)
class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for(String curr: tokens){
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")){
                Integer second = stack.pop();
                Integer first = stack.pop();
                if(curr.equals("+")){
                    stack.push(first + second);
                }
                else if(curr.equals("-")){
                    stack.push(first - second);
                }
                else if(curr.equals("*")){
                    stack.push(first * second);
                }
                else if(curr.equals("/")){
                    stack.push(first / second);
                }
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        return stack.pop();
    }
}
