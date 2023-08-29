package src.leetcode.topinterview150.min_stack;

import java.util.LinkedList;
import java.util.PriorityQueue;

class MinStack {
    LinkedList<Integer> data;
    int index;
    PriorityQueue<Integer> queue;

    public MinStack() {
        this.data = new LinkedList<>();
        this.queue = new PriorityQueue<>();
        this.index = 0;
    }

    public void push(int val) {
        data.add(val);
        queue.add(val);
        index++;
    }

    public void pop() {
        queue.remove(data.pollLast());
        index--;
    }

    public int top() {
        return data.get(index - 1);
    }

    public int getMin() {
        return queue.peek();
    }
}
