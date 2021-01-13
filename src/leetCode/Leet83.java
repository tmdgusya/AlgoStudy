package leetCode;

public class Leet83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;

            while(cur != null && cur.next != null){
                ListNode nextNode = cur.next;
                if(cur.val == cur.val){
                    cur.next = cur.next;
                    nextNode = null;
                }else{
                    cur = nextNode;
                }
            }
            return head;
        }
    }
}
