package BasicAlgorithm.unionFind;

public class UnionFind {

    static int[] parents;

    public static void main(String[] args) {
        parents = new int[11];
        for(int i = 1; i <= 10; i++) {
            parents[i] = i;
        }
        connect();
        System.out.println(findParent(parents, 1, 2));
        System.out.println(findParent(parents, 1, 9));
    }

    /**
     * 그니까 결국에 부모 노드에 도착하면 부모 Node 랑 해당 가르키는 인덱스가 같을꺼임!
     */
    public static int getParent(int[] parent,  int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    /*
    부모를 합칠때는 일반적으로 더 작은 쪽의 값으로 합친다.
     */
    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    /*
    부모가 같은지를 테스트 한다.
     */
    static boolean findParent(int[] parent, int a, int b) {
        return getParent(parent, a) == getParent(parent, b);
    }

    static void connect() {
        unionParent(parents, 1, 2);
        unionParent(parents, 3, 4);
        unionParent(parents, 5, 6);
        unionParent(parents, 7, 9);
    }
}
