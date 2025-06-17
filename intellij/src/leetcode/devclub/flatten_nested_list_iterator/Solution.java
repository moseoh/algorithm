package src.leetcode.devclub.flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//public class NestedIterator implements Iterator<Integer> {
//    private Queue<Integer> queue;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.queue = init(new LinkedList<>(), 0, nestedList);
//    }
//
//    public Queue<Integer> init(Queue<Integer> queue, int index, List<NestedInteger> nestedList) {
//        for (int i = index; i < nestedList.size(); i++) {
//            if (nestedList.get(i).isInteger()) {
//                queue.add(nestedList.get(i).getInteger());
//            } else {
//                init(queue, 0, nestedList.get(i).getList());
//            }
//        }
//
//        return queue;
//    }
//
//    @Override
//    public Integer next() {
//        if (queue.isEmpty()) {
//            return null;
//        }
//        return queue.poll();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }
//}
