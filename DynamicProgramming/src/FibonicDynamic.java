import java.util.Arrays;

public class FibonicDynamic {
    static int[] memo;
    //TOP-DOWN
    static int fib(int n){
        if(memo[n] == -1){
            int res;
            if(n == 0 || n== 1){
                return n;
            }else {
                res = fib(n-1)+fib(n-2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    //Bottom-UP
    static int fibB(int n){
        if(memo[n] != -1)
            return memo[n];
        memo[0] = 0; memo[1] =1;
        for(int i =2; i<=n;i++){
            memo[i]= memo[i-1]+memo[i-2];
        }
        return memo[n];
    }
}
