import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //fibonic dynamic programming
        Scanner scanner = new Scanner(System.in);



//       //Fibonic Dynamic
//        int n = scanner.nextInt();
//        FibonicDynamic.memo = new int[n+1];
//        Arrays.fill(FibonicDynamic.memo,-1);

        //TOP-DOWN
//        System.out.println(FibonicDynamic.fib(n));

        //BOTTOM-UP/TABULATION
//        System.out.println(FibonicDynamic.fibB(n));


//       //LCS
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int m = s1.length();
        int n = s2.length();
        LongestCommonSubsequence.memo = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j=0;j<n;j++)
                LongestCommonSubsequence.memo[i][j] =-1;
        }
        System.out.println(LongestCommonSubsequence.lcs(s1,s2,m-1,n-1));

    }
}
