import java.util.*;
import java.io.*;

class Stri implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		int len1 =o1.length();
		int len2= o2.length();
		return Integer.compare(len1, len2);
	}
}

class so implements Comparable<String> {
	String o2;
	@Override
	public int compareTo(String o1) {
		return this.o2.compareTo(o1);
	}
}

public class prac {
	public static void main(String[] args) throws IOException {
		PipedOutputStream os;
		PipedInputStream is=new PipedInputStream();
		os=new PipedOutputStream(is);
		os.write(1);
		System.out.println(is.read());

		String s1=new String("1");
		String s2= new String("1");
		System.out.println(s1.hashCode()+" "+s2.hashCode());
	}
}
