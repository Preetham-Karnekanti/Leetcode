//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] entry=new int[n];
			for(int i=0;i<n;i++)
				entry[i]=sc.nextInt();
			int[] exit=new int[n];
			for(int i=0;i<n;i++)
				exit[i]=sc.nextInt();
			Solution ob= new Solution();
			int[] res=ob.findMaxGuests(entry,exit,n);
			for(int i=0;i<2;i++){
				System.out.print(res[i]);
			    System.out.print(" ");
			}
			System.out.println();
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        // add code here.
        int max = 0;
        for(int i : Exit){
            max = Math.max(max, i);
        }
        int line[] = new int[max + 2];
        for(int i = 0;i<N;i++){
            line[Entry[i]]++;
            line[Exit[i] + 1]--;
        }
        int maxPeople = line[0];
        int time = 0;
        for(int i = 1;i<line.length;i++){
            line[i] += line[i-1];
            if(line[i] > maxPeople){
                maxPeople = line[i];
                time = i;
            }
        }
        return new int[]{maxPeople, time};
	}
}