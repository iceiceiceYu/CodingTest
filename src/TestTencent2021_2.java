import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TestTencent2021_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        TreeMap<Util, Integer> treeMap = new TreeMap<>((o1, o2) -> {
            if (o1.currTime != o2.currTime) {
                return o1.currTime - o2.currTime;
            } else {
                return o1.id - o2.id;
            }
        });

        for (int i = 1; i <= n; i++) {
            Util util = new Util(i, input.nextInt());
            treeMap.put(util, util.time);
        }

        int cnt = 0;
        while (cnt < k) {
            Map.Entry<Util, Integer> tmp = treeMap.pollFirstEntry();
            Util tmpUtil = tmp.getKey();
            tmpUtil.currTime += tmpUtil.time;
            treeMap.put(tmpUtil, tmpUtil.time);
            System.out.println(tmpUtil.id);
            cnt++;
        }
    }

    static class Util {
        int id;
        int time;
        int currTime;

        Util(int id, int time) {
            this.id = id;
            this.time = time;
            this.currTime = time;
        }
    }
}
