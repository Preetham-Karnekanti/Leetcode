//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        // while(low < mid && k <= high){
        //     if(arr[low] > first && arr[low] > second){
        //         int temp = first;
        //         first = arr[low];
        //         second = temp;
        //     }else if(arr[k] > first && arr[k] > second){
        //          int temp = first;
        //         first = arr[k];
        //         second = temp;
        //     }
            
        // }
        
        for(int i: arr){
            
            if(first < i){
                second = first;
                first =i;
            }else if(first != i && second < i){
                second = i;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
        
    }
}