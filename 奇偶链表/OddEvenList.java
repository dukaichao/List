package dkc_ds_0402;
/*
 	给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
 	而不是节点的值的奇偶性。

	示例 1:
		输入: 1->2->3->4->5->NULL
		输出: 1->3->5->2->4->NULL
	示例 2:
		输入: 2->1->3->5->6->4->7->NULL 
		输出: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        //cur,f,s分别指向第一个，第二个，第三个结点
        ListNode cur = head;
        ListNode f = cur.next;
        ListNode s = f.next;
        while(s!=null){
            f.next = s.next;
            s.next = cur.next;
            cur.next = s;
            cur = cur.next;
            f = f.next;
            //这块一定要判断
            if(f == null) break;
            s = f.next;
        }
        return head;
    }
	
}
