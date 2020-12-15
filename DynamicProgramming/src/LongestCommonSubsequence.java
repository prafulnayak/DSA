public class LongestCommonSubsequence {
    static int[][]memo;
    static int lcs(String s1, String s2, int m, int n){

        if((m>=0 && n>=0) && memo[m][n]!=-1)
            return memo[m][n];
        if(m ==-1 || n ==-1)
            return 0;
        else{
            if(s1.charAt(m)== s2.charAt(n))
                memo[m][n] = 1+ lcs(s1,s2,m-1,n-1);
            else
                memo[m][n] = Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
        }
        return memo[m][n];
    }
}
