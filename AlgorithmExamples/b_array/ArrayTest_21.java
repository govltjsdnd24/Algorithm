package com.ssafy.b_array;

public class ArrayTest_21 {
    private static int R = 4, C = 5;
    private static char[][] map;
    private static StringBuilder output = new StringBuilder();

    private static void setup() {
        map = new char[R][C];
        // TODO: 위 배열을 알파벳 대문자 A ~ T로 초기화 하시오.
        for(int i=0;i<4;i++) {
        	for(int j=0;j<5;j++) {
        		map[i][j]=(char)((i*5+j+17)+'0');
        	}
        }
    }

    public static void main(String[] args) {
        setup();
        rowFirst();
        colFirst();
        zigzag();
    }

    private static void rowFirst() {
        // TODO: 행우선 탐색을 작성하시오.
    	output.delete(0,output.length());
        for(int i=0;i<4;i++) {
        	for(int j=0;j<5;j++) {
        		output.append(map[i][j]);
        	}
        }
        // END
        System.out.println(output.toString().equals("ABCDEFGHIJKLMNOPQRST"));
    }

    private static void colFirst() {
        // TODO: 열우선 탐색을 작성하시오.
    	output.delete(0,output.length());
        for(int i=0;i<5;i++) {
        	for(int j=0;j<4;j++) {
        		output.append(map[j][i]);
        	}
        }
        // END
        System.out.println(output.toString().equals("AFKPBGLQCHMRDINSEJOT"));
    }

    private static void zigzag() {
        // TODO: zigzag 탐색을 작성하시오.
    	output.delete(0,output.length());
        for(int i=0;i<4;i++) {
        	for(int j=0;j<5;j++) {
        		if(i%2==0) {
        			output.append(map[i][j]);
        		}
        		else
        			output.append(map[i][map[i].length-j-1]);
        	}
        }

        // END
        System.out.println(output.toString().equals("ABCDEJIHGFKLMNOTSRQP"));
    }
    
    private static void snail() {
     // TODO: 달팽이 탐색을 작성하시오.
    	int h_tracker=0;
    	int v_tracker=0;
    	while(h_tracker!=output.length()/2 ||  v_tracker!=output.length()/2) {
    		
    	}
        // END
        System.out.println(output.toString().equals("ABCDEJOTSRQPKFGHINML"));
    }
    
}
