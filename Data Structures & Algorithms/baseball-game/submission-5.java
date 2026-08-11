class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalScore = 0;
        for (String op : operations) {
            if (op.matches("-?\\d+")) {
                stack.push(Integer.parseInt(op));
            } else if (op.equals("+")) {
                int n = stack.size();
                stack.push(stack.get(n - 1) + stack.get(n - 2));
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                int element = stack.peek();
                stack.push(element * 2);
            }
        }
        for (int x : stack) {
            totalScore += x;
        }
        return totalScore;
    }
}