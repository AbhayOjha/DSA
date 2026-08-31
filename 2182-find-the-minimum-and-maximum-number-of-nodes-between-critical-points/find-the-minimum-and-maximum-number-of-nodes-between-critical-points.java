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

        int idx = 1;
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode nxt = curr.next;

        List<Integer> critical = new ArrayList<>();

        while(nxt != null){
            idx++;
            if(curr.val > prev.val && curr.val > nxt.val || curr.val < prev.val && curr.val < nxt.val){
                critical.add(idx);
            }
            prev = curr;
            curr = nxt;
            nxt = curr.next;
        }

        int size = critical.size();
        if(size < 2){
            return new int[]{-1, -1};
        }
        int maxDis = critical.get(size-1) - critical.get(0);
        int minDis = Integer.MAX_VALUE;

        for(int i=1; i<size; i++){
            minDis = Math.min(minDis, critical.get(i) - critical.get(i-1));
        }
        
        return new int[]{minDis, maxDis};
    }
}