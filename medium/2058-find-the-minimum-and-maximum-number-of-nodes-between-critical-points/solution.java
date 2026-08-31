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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] critical = new int[100001];
        int i = 0, j = 0;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            i++;
            if(prev==null) {
                prev=curr;
                curr=curr.next;
                continue;
            }
            ListNode next = curr.next;
            if(next == null){
                prev = curr;
                curr = curr.next;
                continue;
            } 
            if(curr.val > prev.val && curr.val > next.val) critical[j++] = i;
            else if (curr.val < prev.val && curr.val < next.val) critical[j++]=i;
            prev = curr;
            curr = next;
        }
        if(j <= 1){
            return new int[]{-1,-1};
        }
        // if(j == 1){
        //     return new int[]{critical[0], critical[0]};
        // }
        int max_dist = critical[j-1] - critical[0];
        int min_dist = Integer.MAX_VALUE;
        for(int in = 1; in < j; in++){
            min_dist = Math.min(min_dist, critical[in] - critical[in-1]);
        }
        return new int[]{min_dist, max_dist};
    }
}