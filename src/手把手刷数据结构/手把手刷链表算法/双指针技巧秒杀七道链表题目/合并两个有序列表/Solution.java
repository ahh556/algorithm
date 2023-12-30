package 手把手刷数据结构.手把手刷链表算法.双指针技巧秒杀七道链表题目.合并两个有序列表;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description https://leetcode.cn/problems/merge-two-sorted-lists/
 * @Date 2023/12/30 18:04
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while (!(list1 == null || list2 == null)) {

            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;

            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }


        return res.next;

    }
}