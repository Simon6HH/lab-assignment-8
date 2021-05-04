//index is N of person
//trust[N][index] is whether i trusts j or not
//if(trust[i][j] == 1) : i trusts j
//person 1 is index 0...

public class Judge {

    int[][] trust;

    int[][] m;

    public Judge(int[][] trust){
        this.trust = trust;
    }

    public void init(int[][] trust){
        for(int i = 0; i < trust.length; i++){
            m[trust[i][0]-1][trust[i][1]-1] = 1;
        }
    }


    public int findJudge (int N, int [][] trust){
        m = new int[N][N];
        init(trust);
        print(m);
        int judge = -1;

        for(int j = 0; j < N; j++){// trust[i][j] means does i trust j? 1 = yes
            for(int i =0; i < N; i++){// does every i trust this j?
                if(i != j)//exception case: i doesn't need to trust itself
                {
                    judge = j+1;
                    if(m[i][j] != 1) {//then j is not trusted by i{
                        judge = -1;
                        break;//move on to next j
                    }

                }
            }

            if(judge != -1){//now check if judge trusts anyone
                for(int l = 0; l<N; l++){
                    if(m[judge-1][l] == 1) {//if the judge trusts anyone it is not the judge anymore
                        judge = -1;
                        break;
                    }
                    return judge;
                }
            }
        }

        return judge;
    }

    public void print(int[][] m){
        for(int x[] : m) {
            for (int y : x) {
                System.out.print(" " + y + " ");
            }
            System.out.println();
        }
    }

}