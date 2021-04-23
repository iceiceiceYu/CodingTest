import java.util.Scanner;

public class TestMeiTuan2021_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine());

        for (int i = 0; i < T; i++) {
            String Mei = input.nextLine();
            String Tuan = input.nextLine();
            int n = Integer.parseInt(input.nextLine());
            System.out.println(Mei + " " + Tuan + " " + n);
            play(Mei, Tuan, n);
        }
    }

    private static void play(String Mei, String Tuan, int n) {
        int round = 0;
        StringBuilder TuanBuilder = new StringBuilder(Tuan);
        while (round < n) {
            char m = Mei.charAt(0);
            char t = TuanBuilder.charAt(0);

            String sub = Mei.substring(0, Mei.indexOf(t));
            Mei = Mei.substring(Mei.indexOf(t));
            TuanBuilder.append(sub);
            round++;
        }

        if (Mei.length() > TuanBuilder.length()) {
            System.out.println("Mei");
        } else if (Mei.length() < TuanBuilder.length()) {
            System.out.println("Tuan");
        } else {
            System.out.println("Draw");
        }
    }
}
