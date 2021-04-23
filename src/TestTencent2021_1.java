import java.util.ArrayList;
import java.util.List;

public class TestTencent2021_1 {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param S ListNode类 val表示权值，next指向下一个元素
     * @return ListNode类
     */
    public ListNode solve(ListNode S) {
        // write code here

        List<Integer> vals = new ArrayList<>();
        List<Integer> minValIndex = null;
        int min = Integer.MAX_VALUE;
        int index = 0;
        ListNode tmp = S;

        while (tmp != null) {
            vals.add(tmp.val);
            if (tmp.val < min) {
                minValIndex = new ArrayList<>();
                min = tmp.val;
                minValIndex.add(index);
            } else if (tmp.val == min) {
                minValIndex.add(index);
            }
            index++;
            tmp = tmp.next;
        }
        if (minValIndex.size() == 1) {
            int id = minValIndex.get(0);
            tmp = S;
            int cnt = 0;
            while (cnt < id - 1) {
                tmp = tmp.next;
                cnt++;
            }
            ListNode minNode = tmp.next;
            tmp.next = null;

            tmp = minNode;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = S;
            return minNode;
        } else {

            judge(vals, minValIndex, index);
            ListNode minNode = S;
            return minNode;
        }
    }

    private int judge(List<Integer> vals, List<Integer> index, int length) {
//        int size = index.size();
//        for (int i = 1; i < length; i++) {
//            for (int j = 0; j < size; j++) {
//                vals.get((index.get(j) + i) % length);
//
//            }
//        }
        return 0;
    }


    static class ListNode {
        int val;
        ListNode next = null;
    }
}
