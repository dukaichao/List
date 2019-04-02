package dkc_ds_0402;
/*
 	给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	示例：
		给定一个链表: 1->2->3->4->5, 和 n = 2.
		当删除了倒数第二个节点后，链表变为 1->2->3->5.
	说明：
		给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        //定义头结点的前驱结点
        ListNode cur = new ListNode(-1);
        cur.next = head;
        //定义两个结点，分别指向cur，其中sign用来移动，m用来返回链表
        ListNode sign = cur;
        ListNode back = cur;
        //先将cur移动n次
        while(n>0){
            cur = cur.next;
            n--;
        }
        //同时移动cur和sign，找到倒数第n个结点的前驱结点
        while(cur.next!=null){
            cur = cur.next;
            sign = sign.next;
        }
        //让它指向倒数第n个结点的下一个结点
        sign.next = sign.next.next;
        return back.next;
    }
}
