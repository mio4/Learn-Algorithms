//两个节点p和q在同一个连通分量下当且仅当p和q有相同的root
//采用树的数据结构存储而不是数组
//不足之处是在树太高时查询的时间开销还是很大
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for(int i=0; i < N; i++) id[i] = i;
    }

    private int root(int i){ //chase parent pointers until reach the root
        while(i!=id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q){ //check if p and q have the same root
        return root(p)==root(q);
    }

    public void union(int p, int q){ //change root of p to root of q
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
