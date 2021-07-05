package ax;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class asd {
	static int Answer;
	static List<Integer[]> lst = new ArrayList<>(); 
	
	static void getSubArrs(Integer []arr, int start, int end)
	{       
	    if (end == arr.length)
	        return;

	    else if (start > end)
	        getSubArrs(arr, 0, end + 1);
	    
	    else
	    {
	        lst.add(Arrays.copyOfRange(arr, start, end + 1));
	        getSubArrs(arr, start + 1, end);
	    }
	    
	    return;
	}
	
	public static void main(String args[]) throws Exception	{
		//long s = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("C:/Users/PC/Desktop/ladder.txt"));

		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			System.out.println("Case #"+(test_case+1));
			
			 int[] params = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			 int N = params[0], K = params[1], m = params[2];
			 int[][] joints = new int[K][2];
			 int[][] routes = new int[m][2];
			 Integer[] arr = new Integer[K];
					 
			 for(int i=0;i<K;i++) {
				 params = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				 joints[i][0] = params[0]; joints[i][1] = params[1];
				 arr[i] = i;
			 }
			 
			 for(int i=0;i<m;i++) {
				 params = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				 routes[i][0] = params[0];
				 routes[i][1] = params[1];
			 }
			 
			 getSubArrs(arr, 0, 0);
			 
			 lst.add(0, new Integer[0]);
			 
			 for(int k=0;k<routes.length;k++) {
				 int min = 5000;

				 for(int j=0;j<lst.size();j++) {
					 int start = routes[k][0];
					 int end = routes[k][1];
					 for(int i=0;i<joints.length;i++) {
						 //Integer[] tmp = lst.get(j);
						 if(Arrays.asList(lst.get(j)).indexOf(i)!=-1) continue;
						 /*
						 if(Arrays.equals(Arrays.copyOfRange(lst.get(i), 0, ), lst.get(i-1))) {
							 
						 }*/
						 
						 if(joints[i][0]==start) {
							 start = joints[i][1];
						 }else if(joints[i][1]==start) {
							 start = joints[i][0];
						 }
					 }

					 if(start==end) {
						 int len = lst.get(j).length;
						 if(min>len) {
							 min = len;
							 if(min==0) break;
						 }
					 }
				 }
				 
				 if(min==5000) min = -1;
				 Answer += min;
			 }
			 
			System.out.println(Answer);
			lst.clear();
			Answer = 0;
		}
		//System.out.println(System.currentTimeMillis()-s);
	}
}
