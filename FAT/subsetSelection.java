package FAT;
import java.util.*;
public class subsetSelection {
    
    public static boolean subset(int a[], int target,int ind,int dp[][]){
        if(target==0){
            return true;
        }
        if(target == 0){
            return (a[ind]==target);
        }
        else if(dp[ind][target]!=-1){
            return dp[ind][target] == 1;
        }
        boolean not_taken = subset(a, target, ind-1,dp);
        boolean taken = false;
        if(a[ind]<=target){
            taken = subset(a, target-a[ind], ind-1,dp);
        }
        if(taken || not_taken){
            dp[ind][target] = 1;
            return true;
        }
        dp[ind][target] = 0;
        return false;
    }

    public static void main(String[] sids){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int dp[][] = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(subset(arr, target, n-1, dp));
        sc.close();
    }
}
