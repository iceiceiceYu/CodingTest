import java.util.*;

public class TestMeiTuan2021_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] instructions = new String[n];
        int[] ids = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            if ((instructions[i] = input.next()).equals("append")) {
                ids[i] = input.nextInt();
                values[i] = input.nextInt();
            }
        }

        Map<Integer, Util> map = new HashMap<>();
        PriorityQueue<Util> heap = new PriorityQueue<>(new Comparator<Util>() {
            @Override
            public int compare(Util o1, Util o2) {
                if (o1.value != o2.value) {
                    return o2.value - o1.value;
                } else {
                    return o1.id - o2.id;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            if (instructions[i].equals("append")) {
                Util util;
                if ((util = map.get(ids[i])) != null) {
                    heap.remove(util);
                    util.value += values[i];
                } else {
                    util = new Util(ids[i], values[i]);
                }
                map.put(ids[i], util);
                heap.add(util);
            } else {
                int size = heap.size();
                StringBuilder sb = new StringBuilder();
                if (size == 0) {
                    System.out.println("null");
                } else if (size <= 10) {
                    Util[] utils = new Util[size];
                    for (int j = 0; j < size; j++) {
                        utils[j] = heap.poll();
                        sb.append(utils[j].id).append(" ");
                    }
                    heap.addAll(Arrays.asList(utils));

                    System.out.println(sb.deleteCharAt(sb.length() - 1));
                } else {
                    Util[] utils = new Util[10];
                    for (int j = 0; j < 10; j++) {
                        utils[j] = heap.poll();
                        sb.append(utils[j].id).append(" ");
                    }
                    heap.addAll(Arrays.asList(utils));

                    System.out.println(sb.deleteCharAt(sb.length() - 1));
                }
            }
        }
    }

    static class Util {
        int id;
        int value;

        Util(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}
