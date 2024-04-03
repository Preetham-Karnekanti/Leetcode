//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(nuts, bolts, n);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        quickSort(nuts, bolts, 0 , n-1);
    }
    
    public void quickSort(char nuts[], char bolts[], int low, int high){
        if(low>=high)
            return;
        int idx = partition(nuts, low, high, bolts[high]);
        partition(bolts, low, high, nuts[idx]);
        quickSort(nuts, bolts, low, idx-1);
        quickSort(nuts, bolts, idx+1, high); 
    }
    
    public int partition(char array[], int low, int high, char pivot){
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            } else if (array[j] == pivot) {
                swap(array, j, high);
                j--;
            }
        }
        swap(array,i, high);
        return i;
    }
    
    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}