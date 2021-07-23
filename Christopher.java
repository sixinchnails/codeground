package john.john;

import java.util.Arrays;
import java.util.Scanner;

public class Christopher 
{
	static void printLetters(char[] alphs) {
		char[][] alphs2d = new char[2*alphs.length-1][2*alphs.length-1];
		int alphs_len = alphs.length, alphs2d_len = alphs2d.length; 
		
		for(int i=0;i<alphs2d_len;i++) {
			for(int j=0;j<alphs2d_len;j++) {
				int trans_i = i, trans_j = j;
				
				if(i>alphs_len-1 && j>alphs_len-1) {
					trans_i = 2*alphs_len-2-i;
					trans_j = 2*alphs_len-2-j;
				}else if(i>alphs_len-1) {
					trans_i = 2*alphs_len-2-i;
				}
				else if(j>alphs_len-1) {
					trans_j = 2*alphs_len-2-j;
				}
				
				alphs2d[i][j] = alphs[Math.min(trans_i, trans_j)];
			}
		}
		
		//printing part
		System.out.println("Result:");
		for(int i=0;i<alphs2d_len;i++) {
			System.out.println(Arrays.toString(alphs2d[i]));
		}
	}
	
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        char[] alphs;
        int num;
        
        System.out.println("How many alphabets?");
        
        do {
        	num = scanner.nextInt();
        }while(num<=0);
        
        alphs = new char[num];
        
        for(int i=0;i<alphs.length;i++) {
        	alphs[i] = (char)(97+i);
        }
        
        System.out.println("Alphabet Candidates:"+Arrays.toString(alphs));
        System.out.println();
        printLetters(alphs);
    }
}
