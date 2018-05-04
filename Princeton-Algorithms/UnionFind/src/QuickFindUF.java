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
