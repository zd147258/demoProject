package com.xx.test.algorithm;

public class RotateRight {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(3);
        ListNode thirdNode = new ListNode(4);
        ListNode fourthNode = new ListNode(5);
        head.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
//        System.out.println("fourthNode 的值为："+head.next.next.next.next.val);
//        while(head != null){
//            System.out.print(head.val);
//            head = head.next;
//        }
        RotateRight rotateRight = new RotateRight();
        ListNode listNode = rotateRight.rotateRight(head, 2);
        while(listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {return head;}
        ListNode lastNode = head,cursor = head;
        int count = 0; // 存储链表结点个数
        while(lastNode != null){
            ++count;
            if(lastNode.next == null){
                lastNode.next = head; // 变为单向循环链表
                break;
            }
            lastNode = lastNode.next;
        }
        int mod = k % count; // 真正需要旋转的个数
        // 遍历链表结点总个数-需要旋转的结点个数-1=不需要旋转的结点个数,断开不需要旋转的结点个数的next指针
        for(int i=1;i<count-mod;i++) {cursor = cursor.next;}
        // 保存需要旋转的结点cursor.next
        head = cursor.next;
        // 断开指针
        cursor.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
