//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
    static HashMap<Integer, Node> hm;
    static int size;
    static LinkedList dll;
    LRUCache(int cap)
    {
        //code here
        size = cap;
        dll = new LinkedList();
        hm = new HashMap<>();
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        if(hm.get(key) == null)
            return -1;
        int value = hm.get(key).data;
        dll.makeNodeAsHead(hm.get(key));
        return value;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        if(hm.get(key) == null){
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            dll.addFirst(newNode);
            if(hm.size() > size){
                Node deleted = dll.removeTail();
                hm.remove(deleted.key);
            }
        }else{
            Node curNode = hm.get(key);
            curNode.data = value;
            dll.makeNodeAsHead(curNode);
        }
    }
}

class LinkedList{
    Node head, tail;
    LinkedList(){
        head = tail = null;
    }
    
    public void addFirst(Node newNode){
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
            return;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void makeNodeAsHead(Node node){
        if(node == head)
            return;
        if(node == tail){
            Node prev = node.prev;
            tail = prev;
            prev.next = null;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    public Node removeTail(){
        Node deleted = tail;
        tail = tail.prev;
        tail.next = null;
        return deleted;
    }
}

class Node{
        Node next, prev;
        int key, data;
        Node(int key, int data){
            this.data = data;
            this.key = key;
            next = prev = null;
        }
    }
