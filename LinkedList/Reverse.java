class Reverse{
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode prev = head;
        ListNode curr = head;
        ListNode next = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}