package 每日一题.从链表中移除节点;

/**
 * @Classname Solution
 * @Description TODO
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
    public ListNode removeNodes(ListNode head) {
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
}