package dkc_ds_0402;
/*
 	给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	示例 1:
		给定链表 1->2->3->4, 重新排列为 1->4->2->3.
	示例 2:
		给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		//找到中间结点
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null&&fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//标记slow下一个结点，并让slow.next == null
		ListNode tmp = slow.next;
		slow.next = null;
		//逆转slow结点后面的结点
		ListNode s = reverse(tmp);
		ListNode f = head;
		//将逆序后的每一个结点进行插入
		while(s!=null) {
			ListNode cur = s.next;
			s.next = f.next;
			f.next = s;
			f = s.next;
			s = cur;
		}
	}
	
	public static ListNode reverse(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode f = head;
		ListNode s = f.next;
		while(s!=null) {
			f.next = s.next;
			s.next = dummyHead.next;
			dummyHead.next = s;
			s = f.next;
		}
		return dummyHead.next;
	}
}
