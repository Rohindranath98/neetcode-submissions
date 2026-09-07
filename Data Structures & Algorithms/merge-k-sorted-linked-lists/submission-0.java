/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       List<Integer> node=new ArrayList<>();
       for(ListNode lst: lists){
        while(lst!=null){
            node.add(lst.val);
            lst=lst.next;
        }
       }
       Collections.sort(node);
       ListNode res=new ListNode(0);
       ListNode curr=res;
       for(int n:node){
        curr.next=new ListNode(n);
        curr=curr.next;
       }
       return res.next;

    }
}
