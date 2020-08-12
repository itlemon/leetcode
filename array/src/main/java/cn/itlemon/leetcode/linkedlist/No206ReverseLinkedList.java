package cn.itlemon.leetcode.linkedlist;

import cn.itlemon.leetcode.model.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangpingping
 * @date 2020/7/16 14:06
 */
public class No206ReverseLinkedList {

    /**
     * 迭代法
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    /**
     * 递归法
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    /**
     * 栈方法
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
            // 设置进入到栈中的ListNode下一个节点为null，必须设置，否则成环
            stack.peek().next = null;
        }
        ListNode result = stack.pop();
        ListNode temp = result;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return result;
    }

}
