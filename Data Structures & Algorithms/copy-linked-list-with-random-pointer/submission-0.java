/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldtoCopy = new HashMap<>();
        Node current = head;
        while(current !=null){
            Node copy = new Node(current.val);
            oldtoCopy.put(current,copy);
            current = current.next;
        }
        current = head;
        
        while(current != null){
            Node copy = oldtoCopy.get(current);
            copy.next = oldtoCopy.get(current.next);
            copy.random = oldtoCopy.get(current.random);
            current = current.next;
            
        }
        return oldtoCopy.get(head);

        
        
    }
}
