package july_20;

import java.util.Scanner;

class HopperPond{
    private int [][]pond;
    private final static int []dr= {-1,1,0,0};
    private final static int []dc= {0,0,-1,1};

    public HopperPond() {}

    public HopperPond(int dim) {
        pond= new int[dim][dim];
    }

    public int[][] getPond() {
        return pond;
    }
    public void setPond(int i,int j, int value) {
        this.pond[i][j] = value;
    }

    public int processJumps(int[][]hoppers) {
        int output=0;
        boolean checker;
        int i,j;
        int sr,sc;
        int r,c;

        for(i=0;i<hoppers.length;i++) {
            //starting location of a hopper

        sr=hoppers[i][0];
        sc=hoppers[i][1];
        checker=true;
        
        for(j=3;j>0;j--) {
            //update row and column for hoppers
            r=sr+dr[hoppers[i][2]-1]*j;
            c=sc+dc[hoppers[i][2]-1]*j;
            
            //if there's already a hopper at the tile or the hopper goes out of bounds, break
            if((r>=pond.length || r<0 || c>=pond.length || c<0) || pond[r][c]==1) {
                pond[sr][sc]=0;
                checker=false;
                break;
            }
            
            //put zero on the old tile and one on the new tile
            pond[sr][sc]=0;
            pond[r][c]=1;
            
            //update starting row and column
            sr=r;
            sc=c;
        }
        if(checker)
            output++;
    }
    return output;
}
}

public class Solution22 {

public static void main(String[] args) {
    int test_case,t;
    int i,j;
    int N,O;
    int jumps;
    
    Scanner sc= new Scanner(System.in);
    t=sc.nextInt();
    
    for(test_case=1;test_case<=t;test_case++) {
        jumps=0;
        N=sc.nextInt();
        O=sc.nextInt();
        HopperPond hp= new HopperPond(N);
        int [][] hoppers=new int[O][3];
        
        //read hoppers' info and plot their starting positions on the pond
        for(i=0;i<O;i++) {
            for(j=0;j<3;j++) {
                hoppers[i][j]=sc.nextInt();
            }
            hp.setPond(hoppers[i][0],hoppers[i][1], 1);
        }
        
        //compute the jumps
        jumps=hp.processJumps(hoppers);        
        
        System.out.println("#"+test_case+" "+jumps);
    }

}
}