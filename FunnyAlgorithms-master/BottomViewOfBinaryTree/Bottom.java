// this is the working solution for problem on geeks for geeks
// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

/* Tree node class
class Node {
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}*/
class GfG
{
    static void solve(Node root,Map<Integer,ArrayList<Integer>> m,int level)
    {
        if(root==null)
            return;
        ArrayList<Integer> v=m.get(level);
        if(v==null) {
            v = new ArrayList<>();
        }
        v.add(root.data);
        m.put(level,v);
        solve(root.left,m,level-1);
        solve(root.right,m,level+1);
    }
    
    public static void bottomView(Node root)
    {
        Map<Integer,ArrayList<Integer>> m= new TreeMap<>();
        solve(root,m,0);
        for( Entry<Integer,ArrayList<Integer>> e : m.entrySet())
        {
            ArrayList<Integer> ans= e.getValue();
            System.out.print(ans.get(ans.size()-1)+" ");
        }
    }
}
	