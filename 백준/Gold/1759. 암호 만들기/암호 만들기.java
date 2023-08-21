import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading k

        String[] data = scanner.nextLine().split(" ");
        Arrays.sort(data);

        List<String> result = new ArrayList<>();

        generateCombinations(data, n, 0, new StringBuilder(), result);

        for (String combination : result) {
            int cnt = 0;
            for (char ch : combination.toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i') {
                    cnt++;
                }
            }
            if (n - cnt >= 2 && cnt >= 1) {
                System.out.println(combination);
            }
        }
    }

    private static void generateCombinations(String[] data, int n, int start, StringBuilder current, List<String> result) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        for (int i = start; i < data.length; i++) {
            current.append(data[i]);
            generateCombinations(data, n, i + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}