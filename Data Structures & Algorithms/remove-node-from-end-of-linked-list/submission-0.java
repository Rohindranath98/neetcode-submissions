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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     List<ListNode> node=new ArrayList<>();
     ListNode curr=head;
     while(curr!=null){
        node.add(curr);
       curr=curr.next;
     }
     int N=node.size()-n;
      if(N==0){
        return head.next;
      }
      node.get(N-1).next=node.get(N).next;
      return head;
    }
}
