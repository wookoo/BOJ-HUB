import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int[] op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        char[] temp = new char[op[0] + op[1] + op[2] + op[3]];
        int tempIndex = 0;
        for (int i = 0; i < op[0]; i++) {
            temp[tempIndex++] = '+';
        }
        for (int i = 0; i < op[1]; i++) {
            temp[tempIndex++] = '-';
        }
        for (int i = 0; i < op[2]; i++) {
            temp[tempIndex++] = '*';
        }
        for (int i = 0; i < op[3]; i++) {
            temp[tempIndex++] = '/';
        }

        int maxResult = Integer.MIN_VALUE;
        int minResult = Integer.MAX_VALUE;

        Set<String> ops = new HashSet<>();
        permuteOps(temp, 0, temp.length - 1, ops);

        for (String strOp : ops) {
            int s = arr[0];
            for (int index = 0; index < strOp.length(); index++) {
                char symbol = strOp.charAt(index);
                int num = arr[index + 1];
                if (symbol == '+') {
                    s += num;
                } else if (symbol == '-') {
                    s -= num;
                } else if (symbol == '*') {
                    s *= num;
                } else {
                    s = s / num;
                }
            }

            if (s > maxResult) {
                maxResult = s;
            }
            if (s < minResult) {
                minResult = s;
            }
        }

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void permuteOps(char[] arr, int l, int r, Set<String> result) {
        if (l == r) {
            result.add(new String(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permuteOps(arr, l + 1, r, result);
                swap(arr, l, i); // backtrack
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


