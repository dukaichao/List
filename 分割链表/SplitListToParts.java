package dkc_ds_0402;
/*
 	给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
返回一个符合上述规则的链表的列表。
举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
	示例 1：
		输入: 
			root = [1, 2, 3], k = 5
		输出:
			[[1],[2],[3],[],[]]
		解释:
			输入输出各部分都应该是链表，而不是数组。
			例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
			第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
			最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
	示例 2：
		输入: 
			root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
		输出: 
			[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
		解释:
			输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 */
public class SplitListToParts {
	public ListNode[] splitListToParts(ListNode head, int k) {
		//根据k值，定义数组长度
		ListNode[] node = new ListNode[k];
		//获取链表长度
		int len = getLength(head);
		//比较链表和所给k的大小，根据不同结果进行操作
		if(k>=len) {
			ListNode cur = head;
			int index = 0;
			while(cur!=null) {
				//标记此时cur
				ListNode tmp = cur;
				node[index++] = cur;
				//cur指向下一个结点
				cur = cur.next;
				//标记位tmp下一个结点置空
				tmp.next = null;
			}
			//此时如果k>len,则向里面继续添加空结点
			while(k>len) {
				ListNode tmp = null;
				node[index++] = tmp;
				k--;
			}
		}else {
			//判断每组最少几个元素
			int t = len / k;
			//根据余数判断有几个node[i]可以多加1个元素
			int mod = len % k;
			ListNode cur = head;
			for(int i = 0;i<k;i++) {
				int sign = t;
				node[i] = cur;
				//判断下一个cur在那个位置
				while(cur!=null&&sign>1) {
					cur = cur.next;
					sign--;
				}
				//这个是个重点，此时cur指向每组添加最少元素的位置
				//判断mod是否大于0，如果大于0，向该位置在添加一个结点
				if(mod>0) {
					//让cur指向cur的下一个结点，此时cur指向node[i]所添加最后一个元素
					cur = cur.next;
					//标记此时cur
					ListNode tmp = cur;
					//让cur指向cur下一个结点，方便node[i+1]添加
					cur = cur.next;
					//让标记位tmp下一个位置置空
					tmp.next = null;
					//让mod减一，
					mod--;
				}else {
					//标记cur
					ListNode tmp = cur;
					//让cur指向cur下一个结点，方便node[i+1]添加
					cur = cur.next;
					//让标记位tmp下一个位置置空
					tmp.next = null;
				}
			}
		}
		return node;
	}
	
	public static int getLength(ListNode head) {
		ListNode cur = head;
		int count = 0;
		while(cur!=null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
}
