package base.doublePointer;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode234 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = node.next = new ListNode(2);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(1, null);
        System.out.println(isPalindrome2(node));
    }

    /**
     *  执行用时：8 ms, 在所有 Java 提交中击败了39.04%的用户
     * 内存消耗：53.1 MB, 在所有 Java 提交中击败了86.17%的用户
     * 通过测试用例：
     * 90 / 90
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        // 首先将单链表放入list数组中
        if (head == null) {
            return false;
        }
        List<Integer> valueList = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            valueList.add(node.val);
            node = node.next;
        }
        int left = 0;
        int right = valueList.size() -1;
        // 然后头尾比较是否相同，不相同则返回false并退出
        while (left <= right) {
            if (!Objects.equals(valueList.get(left), valueList.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转链表，得到快链表的反转链表
        ListNode pre = null;
        ListNode cur = slow;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 然后与自身比较
        while(head != null && pre!= null){
            if(head.val != pre.val){
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
