/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Liangshuxiangjia {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        int flag = 0;
        while (l1 != null && l2 != null) {
            //和小于10
            if (l1.val + l2.val + flag < 10) {
                ListNode listNode = new ListNode(l1.val + l2.val + flag);
                p.next = listNode;
                p = p.next;
                flag = 0;
            } else {
                ListNode listNode = new ListNode(l1.val + l2.val + flag - 10);
                p.next = listNode;
                p = p.next;
                flag = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //l1的长度大于l2的长度
        while (l1 != null) {
            if (l1.val + flag < 10) {
                ListNode listNode = new ListNode(l1.val + flag);
                p.next = listNode;
                p = p.next;
                l1 = l1.next;
                flag = 0;//将flag重新置0，这一步很关键，一个flag只用用一次，不能重复使用，用完立即重置
            }else {
                ListNode listNode = new ListNode(l1.val + flag - 10);
                p.next = listNode;
                p = p.next;
                l1 = l1.next;
                flag = 1;
            }
        }
        while (l2 != null) {
            if(l2.val + flag < 10){
                ListNode listNode = new ListNode(l2.val + flag);
                p.next = listNode;
                p = p.next;
                l2 = l2.next;
                flag = 0;
            }else {
                ListNode listNode = new ListNode(l2.val + flag - 10);
                p.next = listNode;
                p = p.next;
                l2 = l2.next;
                flag = 1;
            }

        }
        if (flag == 1) {
            ListNode listNode = new ListNode(1);
            p.next = listNode;
            p = p.next;
        }
        return result.next;


    }
}
