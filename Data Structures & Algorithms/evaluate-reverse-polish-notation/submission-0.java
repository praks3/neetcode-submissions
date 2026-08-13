class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.matches("-?\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                int topElement = stack.pop();
                int secondTopElement = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(secondTopElement + topElement);
                        break;
                    case "-":
                        stack.push(secondTopElement - topElement);
                        break;
                    case "*":
                        stack.push(secondTopElement * topElement);
                        break;
                    case "/":
                        stack.push(secondTopElement / topElement);
                        break;
                }
            }
        }
        return stack.peek();

    }
}
