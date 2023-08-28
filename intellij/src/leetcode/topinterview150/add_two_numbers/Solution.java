package src.leetcode.topinterview150.add_two_numbers;

class Solution {
    // l1, l2의 next가 있거나 올림 수 가 있는 경우 Node 생성
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, currentNode = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            int current = sum % 10;

            if (result == null) {
                result = new ListNode(current);
                currentNode = result;
            } else {
                currentNode.next = new ListNode(current);
                currentNode = currentNode.next;
            }

            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}