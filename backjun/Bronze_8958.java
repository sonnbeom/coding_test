package backjun;

import java.util.Scanner;

public class Bronze_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int sum = 0;

            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O'){
                    count++;
                }
                else {
                    count = 0;
                }
                sum += count;
            }
            System.out.println(sum);
        }

    }
}
