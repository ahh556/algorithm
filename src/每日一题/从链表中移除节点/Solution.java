package 每日一题.从链表中移除节点;

import java.util.Date;

/**
 * @Classname Solution
 * @Description https://leetcode.cn/problems/remove-nodes-from-linked-list/description/
 * @Date 2024/1/3 22:14
 * @Created by ahh
 */


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(new Date().getTime());
    }

    /**
     * 时间超限
     * @param head
     * @return
     */
    public ListNode removeNodes3(ListNode head) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode cur = head;
        ListNode pre = d;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null) {
                if (cur.val < next.val) {
                    pre.next = cur.next;
                    cur = pre;
                    break;

                }
                next = next.next;
            }
            pre = cur;
            cur = cur.next;

        }
        return d.next;
    }

    /**
     * 时间超限
     * @param head
     * @return
     */
    public ListNode removeNodes1(ListNode head) {
        ListNode d = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = d.next;
            d.next = cur;
            cur = head;
        }
        cur = d.next;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode pre = cur;
            while (next != null) {
                if (cur.val > next.val) {
                    pre.next = next.next;
                    next = next.next;

                } else {
                    pre = next;
                    next = next.next;
                }

            }
            cur = cur.next;
        }
        ListNode d2 = new ListNode(-1);
        head = d.next;
        cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = d2.next;
            d2.next = cur;
            cur = head;
        }
        return d2.next;
    }
    public ListNode removeNodes2(ListNode head) {
        ListNode d = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = d.next;
            d.next = cur;
            cur = head;
        }
        cur = d.next;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode pre = cur;
            while (next != null) {
                if (cur.val > next.val) {
                    pre.next = next.next;

                }
                pre = next;
                next = next.next;
            }
            cur = cur.next;
        }
        ListNode d2 = new ListNode(-1);
        head = d.next;
        cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = d2.next;
            d2.next = cur;
            cur = head;
        }
        return d2.next;
    }

    public ListNode removeNodes(ListNode head) {
        // 翻转链表
        ListNode reversedHead = reverse(head);

        // 移除节点
        ListNode dummy = new ListNode(0);
        dummy.next = reversedHead;
        ListNode current = dummy.next;
        int maxVal = current.val;
        ListNode prev = dummy;

        while (current != null) {
            if (current.val < maxVal) {
                // 移除节点
                prev.next = current.next;
            } else {
                // 更新最大值
                maxVal = current.val;
                prev = current;
            }
            current = current.next;
        }

        // 再次翻转链表
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}