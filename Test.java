public class Test {

    public void print(int[][] trust){
        for(int x[] : trust) {
            for (int y : x) {
                System.out.print(" " + y + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] trust = new int[][] {{1,2}};

        int[][] test2 = new int[][] {{1,3},{2,3}};

        int[][] test3 = new int[][] {{1,3},{2,3},{3,1}};

        int[][] test4 = new int[][] {{1,2},{2,3}};

        int[][] test5 = new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}};

        Judge j = new Judge(trust);

        Judge t2 = new Judge(test2);

        Judge t3 = new Judge(test2);

        Judge t4 = new Judge(test2);

        Judge t5 = new Judge(test2);

        System.out.println(j.findJudge(2,trust));

        System.out.println(j.findJudge(3,test2));

        System.out.println(j.findJudge(3,test3));

        System.out.println(j.findJudge(3,test4));

        System.out.println(j.findJudge(4,test5));

    }

}