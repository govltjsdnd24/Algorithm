package edu.ssafy.dp;

public class dp3_dfs {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N = 3;
	static long[][] map;
	static boolean[][] v;
	static int total;
	static int cnt;
	public static void main(String[] args) {
		map = new long[N][N];
		v = new boolean[N][N];
		map[0][0] = 0;
		v[0][0]=true;
		total = 0;
		cnt = 1;
		dfs(0, 0);
		print(map);
		System.out.println("total : "+total);
		System.out.println("-----------dfs-----------");
		
		map = new long[N][N];
		v = new boolean[N][N];
		map[0][0] = 0;
		v[0][0]=true;
		total = 0;
		cnt = 1;
		dfs2(0, 0);
		print(map);
		System.out.println("total : "+total);
		System.out.println("-----------dfs2-----------");
		
		map = new long[N][N];
		v = new boolean[N][N];
		map[0][0] = 0;
		v[0][0]=true;
		total = 0;
		cnt = 1;
		dfs3(0, 0);
		print(map);
		System.out.println("total : "+total);
		System.out.println("-----------dfs3-----------");
		
		map = new long[N][N];
		v = new boolean[N][N];
		map[0][0] = 0;
		v[0][0]=true;
		total = 0;
		cnt = 1;
		dfs4(0, 0);
		print(map);
		System.out.println("total : "+total);
		System.out.println("-----------dfs4-----------");
		
	}
	private static long dfs4(int r, int c) {
		if(r==N-1&&c==N-1) {
			total++;
			map[r][c]=1;
			return 1;
		}
		for (int d = 0; d < dc.length; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
				v[nr][nc]=true;
				//map[r][c] = dfs3(nr,nc)+1;
				return map[r][c] = Math.max(map[r][c], dfs4(nr,nc)+1);
				// 백트레킹
				//v[nr][nc]=false;
			}
		}
		//System.out.println("111111");
		return 0;
		
	}
	private static long dfs3(int r, int c) {
		if(r==N-1&&c==N-1) {
			total++;
			map[r][c]=1;
			return 1;
		}
		for (int d = 0; d < dc.length; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
				v[nr][nc]=true;
				//map[r][c] = dfs3(nr,nc)+1;
				// map[r][c] = Math.max(map[r][c], dfs3(nr,nc)+1);
				// 백트레킹
				v[nr][nc]=false;
			}
		}
		return map[r][c];
	}
	private static void dfs2(int r, int c) {
		if(r==N-1&&c==N-1) {
			total++;
			return;
		}
		for (int d = 0; d < dc.length; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
				v[nr][nc]=true;
				map[nr][nc]=cnt++;
				dfs2(nr,nc);
				v[nr][nc]=false;
			}
		}
	}
	private static void dfs(int r, int c) {
		if(r==N-1&&c==N-1) {
			total++;
			return;
		}
		for (int d = 0; d < dc.length; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
				v[nr][nc]=true;
				map[nr][nc]=cnt++;
				dfs(nr,nc);
			}
		}
	}

	private static void print(long[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
