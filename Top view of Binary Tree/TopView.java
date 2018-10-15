import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TopView {
    public static class Node {
        public int data;
        public Node left;
        public Node right;
    }

    private class Pair {
        Node node;
        int position;

        Pair(Node node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public void topView(Node root) {
        if(root == null) {
            return;
        }

        Map<Integer, Integer> ocupatedPositions = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {
            Pair currentElement = queue.poll();
            Node node = currentElement.node;
            int position = currentElement.position;
            if(!ocupatedPositions.containsKey(position)) {
                ocupatedPositions.put(position, node.data);
                System.out.printf("%d ", node.data);
            }

            if(node.left != null) {
                queue.add(new Pair(node.left, position - 1));
            }

            if(node.right != null) {
                queue.add(new Pair(node.right, position + 1));
            }
        }
    }
}