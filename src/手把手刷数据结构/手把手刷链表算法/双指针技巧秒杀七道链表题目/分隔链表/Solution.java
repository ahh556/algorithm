package 手把手刷数据结构.手把手刷链表算法.双指针技巧秒杀七道链表题目.分隔链表;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        ListNode rightRes = new ListNode(-1);
        ListNode cur = res;
        ListNode rightCur = rightRes;

        while (head != null) {
            if(head.val < x) {
                cur.next = head;
                cur = cur.next;
            } else {
                rightCur.next = head;
                rightCur = rightCur.next;
            }
            head = head.next;
        }
        cur.next = rightRes.next;
        rightCur.next = null;


        return res.next;
    }
}