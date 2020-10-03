// problem link https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */
class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
	    //return -1 in the end
        Set<Node> a=new HashSet<>();
        Node temp=headA;
        while(temp!=null)
        {
            a.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null)
        {
            if(!a.add(temp))
                return temp.data;
            temp=temp.next;
        }
        return -1;
	}
}
