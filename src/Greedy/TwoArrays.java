package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoArrays {

	public static void main(String[] args) {
		int t;
		int n;
		int k;
		int[] A = null;
		int[] B = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			t = Integer.parseInt(br.readLine());
			String[] temp = null;
			while( t-- > 0 ){
				temp = br.readLine().split(" ");
				n = Integer.parseInt(temp[0]);
				k = Integer.parseInt(temp[1]);
				
				temp = br.readLine().split(" ");
				A = getIntArray(temp);
				
				temp = br.readLine().split(" ");
				B = getIntArray(temp);
				
				int aMax = getMax(A);
				int bMax = getMax(B);
				
				if(aMax + bMax >= k){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[] getIntArray(String[] temp){
		int[] tempInt = new int[temp.length];
		for( int i = 0; i < temp.length; i++){
			tempInt[i] = Integer.parseInt(temp[i]);
		}
		return tempInt;
	}
	
	private static int getMax(int[] ary){
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < ary.length; i++){
			if( ary[i] > max){
				max = ary[i];
			}
		}
		return max;
	}
}
