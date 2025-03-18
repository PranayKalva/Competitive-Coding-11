//Time Complexity - O(n)
//Space Complexity - O(n)
class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty()) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            int curr = c - '0';
            if (!stack.isEmpty() && curr < stack.peek() && k > 0) {
                while (!stack.isEmpty() && curr < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(curr);
            } else {
                stack.push(curr);
            }
        }

        while (k > 0) {
            k--;
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for (int digit : stack) {
            if (leadingZero && digit == 0)
                continue;
            leadingZero = false;
            result.append(digit);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
