public class Judge {

    int[][] trust; /** Global trust double array variable **/
    int[][] n; /** Global m double array variable **/

    public Judge(int[][] trust) { /** Judge contructor**/
        this.trust = trust;
    }

    public void in(int[][] trust) { /** loops through to see who is in it **/
        for (int i = 0; i < trust.length; i++) {
            n[trust[i][0]-1][trust[i][1]-1] = 1;
        }
    }

    public void NbyNDesign(int[][] trust){ /** interface to see whos who and who trusts who **/
        for (int i[] : trust) {
            for (int j : i) {
                System.out.print(" [" + j + "] ");
            }
            System.out.println();
        }
    }


    public int findJudge(int N, int [][] trust) { /** N is number of people in the town, trust is the trust array**/
        n = new int[N][N];
        int judge = -1;
        in(trust); /** calls in it method **/
        NbyNDesign(n); /** calls design method **/

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != i) { /** exception case testing if j is a judge himself **/
                    judge = i+1;
                    if (n[j][i] != 1) {
                        judge = -1;
                        break; /** if they don't equal 1, move on **/
                    }
                }
            }
            if (judge != -1) { /** checks if judge trusts anyone **/
                for (int b = 0; b < N; b++) {
                    if (n[judge-1][b] == 1) {
                        judge = -1;
                        break;
                    }
                    System.out.println("Label of Town Judge: ");
                    return judge;
                }
            }
        }
        return judge;
    }

    public static void main(String[] args) { /** main test **/
        int[][] trust = new int[][] {{1,2}};
        int[][] testTWO = new int[][] {{1,3},{2,3}};
        int[][] testTHREE = new int[][] {{1,3},{2,3},{3,1}};
        int[][] testFOUR = new int[][] {{1,2},{2,3}};
        int[][] testFIVE = new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}};

        Judge judge = new Judge(trust);

        System.out.println(judge.findJudge(2,trust));
        System.out.println(judge.findJudge(3,testTWO));
        System.out.println(judge.findJudge(3,testTHREE));
        System.out.println(judge.findJudge(3,testFOUR));
        System.out.println(judge.findJudge(4,testFIVE));

    }
}