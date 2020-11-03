package arithmetic;

import java.util.Stack;

/**
 * Create with Darcula IDEA
 * Description:
 * 最小栈的实现
 * @Author CJP
 * @Date 2020/11/2
 * @Time 19:48
 */
public class MinStack {
    private Stack<Integer>  mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    /**
     * 入栈操作
     */
    public void push(int element) {
        mainStack.push(element);
        //如果辅助栈为空，或者新元素小于或等于辅助栈栈顶元素，则将新元素压入辅助栈
        if(mainStack == null || element <= mainStack.peek()) {
            minStack.push(element);
        }
    }
    /**
     * 出栈操作
     */
    public int pop() {
        //如果出栈元素和辅助栈栈顶元素相等，则辅助栈元素出栈
        if(mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }
    /**
     * 获取栈的最小元素
     */
    public int getMin() throws Exception {
        if(mainStack.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(9);
        stack.push(6);
        stack.push(7);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());

    }
}
