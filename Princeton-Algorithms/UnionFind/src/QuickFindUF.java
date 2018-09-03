//两个节点处于一个连通分量下当且仅当p和q在id数组中的值相同
//不足之处：对于N个节点的N次union操作时间复杂度为O（n2）
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N){ //set id of each object to itself
        id = new int[N];
        for(int i=0; i < N;i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){ //check whether p and q in the same component
        return (id[p] == id[q]);
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i=0; i < id.length; i++){
            if(id[i] == pid) id[i] = qid;
        }
    }
}

