package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSYoutube {

    static class Graph{
        class Node{
            int data;
            LinkedList<Node> adjacent;
            boolean marked;
            public Node(int data){
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<>();
            }
        }
        Node[] nodes;
        Graph(int size){
            nodes = new Node[size];
            for(int i = 0; i< size; i++){
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int node1, int node2){
            Node n1 = nodes[node1];
            Node n2 = nodes[node2];

            if(!n1.adjacent.contains(n2)){
                n1.adjacent.add(n2);
            }
            if(!n2.adjacent.contains(n1)){
                n2.adjacent.add(n1);
            }
        }

        public void dfs(){
            dfs(0);
        }

        public void bfs(){
            bfs(0);
        }

        public void dfs(int index){
            Node head = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            head.marked = true;
            while (!stack.isEmpty()){
                Node r = stack.pop();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r);
            }
        }

        public void bfs(int index){
            Node head = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            head.marked = true;
            while(!queue.isEmpty()){
                Node r = queue.poll();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        queue.add(n);
                    }
                }
                visit(r);
            }
        }

        private void visit(Node n){
            System.out.print(n.data + " ");
        }

        public void dfsR(Node r){
            if(r == null) return;
            r.marked = true;
            visit(r);
            for(Node n : r.adjacent){
                if(n.marked == false){
                    dfsR(n);
                }
            }
        }

        public void dfsR(int index){
            Node head = nodes[index];
            dfsR(head);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,8);
        graph.dfsR(4);
    }
}
