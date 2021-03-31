package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Back1991 {

    static Map<String, Node> nodeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String firstNode = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();
            addNodeifNotExistInMap(firstNode);
            addNodeifNotExistInMap(leftNode);
            addNodeifNotExistInMap(rightNode);
            if(nodeMap.containsKey(leftNode)) {
                nodeMap.get(firstNode).leftNode = nodeMap.get(leftNode);
            }
            if(nodeMap.containsKey(rightNode)) {
                nodeMap.get(firstNode).rightNode = nodeMap.get(rightNode);
            }
        }


        nodeMap.get("A").preOrder(nodeMap.get("A"));
        System.out.println();
        nodeMap.get("A").inOrder(nodeMap.get("A"));
        System.out.println();
        nodeMap.get("A").postOrder(nodeMap.get("A"));
    }

    private static void addNodeifNotExistInMap(String nodeName) {
        if(!nodeMap.containsKey(nodeName) && !nodeName.equals(".")) {
            nodeMap.put(nodeName, new Node(nodeName));
        }
    }

    private static class Node {
        String data;
        Node leftNode;
        Node rightNode;

        public Node(String data) {
            this.data = data;
        }

        public void inOrder(Node node) {
            if(node != null) {
                inOrder(node.leftNode);
                System.out.print(node.data);
                inOrder(node.rightNode);
            }
        }

        public void preOrder(Node node) {
            if(node != null) {
                System.out.print(node.data);
                preOrder(node.leftNode);
                preOrder(node.rightNode);
            }
        }

        public void postOrder(Node node) {
            if(node != null) {
                postOrder(node.leftNode);
                postOrder(node.rightNode);
                System.out.print(node.data);
            }
        }
    }

}
