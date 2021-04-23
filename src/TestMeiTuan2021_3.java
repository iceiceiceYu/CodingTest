import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestMeiTuan2021_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] instructions = new String[n];
        for (int i = 0; i < n; i++) {
            instructions[i] = input.nextLine();
        }

        Map<String, String> map = new HashMap<>();
        // StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        for (String instruction : instructions) {
            String[] split = instruction.split(" ");
            if (split[0].equals("1")) {
                if (map.containsKey(split[2])) {
                    String old = map.get(split[2]);
                    map.put(split[2], old + " " + split[1]);
                } else {
                    map.put(split[2], split[1]);
                    list.add(split[2]);
                }
            } else if (split[0].equals("2")) {
                int first = list.indexOf(split[1]);
                int second = list.indexOf(split[2]);

                String temp = list.get(first);
                list.set(first, list.get(second));
                list.set(second, temp);
            }
        }

        StringBuilder output = new StringBuilder();
        for (String str : list) {
            output.append(map.get(str)).append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        System.out.println(output);
    }
}
