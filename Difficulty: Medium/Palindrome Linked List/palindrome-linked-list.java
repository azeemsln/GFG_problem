//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        int n=0;
        Node temp=head;
        Stack<Integer> s=new Stack();
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        int m=n/2;
        if(n%2==0){
            for(int i=0;i<m;i++){
                s.push(temp.data);
                temp=temp.next;
            }
            for(int i=m;i<n;i++){
                if(s.peek()==temp.data){
                    s.pop();
                    temp=temp.next;
                }
            }
        }
        else{
            for(int i=0;i<m;i++){
                s.push(temp.data);
                temp=temp.next;
            }
            temp=temp.next;
            for(int i=m+1;i<n;i++){
                if(s.peek()==temp.data){
                    s.pop();
                    temp=temp.next;
                }
            }
        }
        
        if(s.isEmpty())
            return true;
        return false;
    }
}
