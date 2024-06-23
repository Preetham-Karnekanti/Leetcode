//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
        for (int i = (N - 2) / 2; i >= 0; --i)
            downHeapify(arr, i);
  }
  
  public static void downHeapify(int[] arr, int idx){
      int smallest = idx;
      int left = getLeftChild(idx);
      int right = getRightChild(idx);
      if(left < arr.length && arr[smallest] < arr[left]){
          smallest = left;
      }
      if(right < arr.length && arr[smallest] < arr[right])
          smallest = right;
      if(smallest != idx){
          swap(arr, idx, smallest);
          downHeapify(arr, smallest);
      }
  }
  
  public static void swap(int arr[], int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      
  }
  
  public static int getParent(int i){
      return (i - 1)/2;
  }
  
  public static int getLeftChild(int i){
      return 2 * i + 1;
  }
  public static int getRightChild(int i){
      return 2 * i + 2;
  }
  
}
     