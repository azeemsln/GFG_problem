//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
         List<Integer> list1 = new ArrayList<>();
        // List to store in-order traversal of second BST
        List<Integer> list2 = new ArrayList<>();
        
        // Perform in-order traversal on the first BST
        inOrder(root1, list1);
        // Perform in-order traversal on the second BST
        inOrder(root2, list2);
        
        // Merge the two sorted lists and return the result
        return merge(list1, list2);
    }
    
    // Helper function to perform in-order traversal of a BST
    private void inOrder(Node root, List<Integer> list) {
        // Base case: if the root is null, return
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree
        inOrder(root.left, list);
        // Add the root data to the list
        list.add(root.data);
        // Traverse the right subtree
        inOrder(root.right, list);
    }
    
    // Helper function to merge two sorted lists
    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        // List to store the merged result
        List<Integer> ans = new ArrayList<>();
        
        int ind1 = 0, ind2 = 0;
        
        // Merge the lists by comparing elements one by one
        while (ind1 < list1.size() && ind2 < list2.size()) {
            if (list1.get(ind1) < list2.get(ind2)) {
                // Add the smaller element to the result list
                ans.add(list1.get(ind1));
                ind1++;
            } else {
                // Add the smaller element to the result list
                ans.add(list2.get(ind2));
                ind2++;
            }
        }
        
        // Add remaining elements from list1 (if any)
        while (ind1 < list1.size()) {
            ans.add(list1.get(ind1));
            ind1++;
        }
        
        // Add remaining elements from list2 (if any)
        while (ind2 < list2.size()) {
            ans.add(list2.get(ind2));
            ind2++;
        }
        
        // Return the merged list
        return ans;
    }
}
