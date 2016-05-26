package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SherlockAndMiniMax {

    public static void main(String[] args) {
        int n = 0;
        int[] numbers = null;
        int P = 0, Q = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> alist = new ArrayList<Integer>();
        try {
            n = Integer.parseInt(br.readLine());
            numbers = new int[n];
            String[] temp = null;
            temp = br.readLine().split(" ");
            for(int i = 0; i < n; i++){
                numbers[i] = Integer.parseInt(temp[i]);
            }
            temp = br.readLine().split(" ");
            P = Integer.parseInt(temp[0]);
            Q = Integer.parseInt(temp[1]);
            br.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Arrays.sort(numbers);
        
        int diff = 0;
        int minIndex = 0;
        int minNumber = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length; i++){
        	diff = numbers[i] - P;
        	if( Math.abs(diff) < Math.abs(minNumber)){
        		minNumber = diff;
        		minIndex = i;
        	}
        }
        int maxMin = minNumber;
        int maxMinNum = P;
        int diffUpper = 0;
        int diffLower = Integer.MAX_VALUE;
        for(int i = P+1; i <= Q ; i++){
        	diffLower = numbers[minIndex] - i;
        	if( minIndex + 1 < n){
        		diffUpper = numbers[minIndex+1] - i;

        		if( Math.abs(diffLower) <= Math.abs(diffUpper)){
        			if( Math.abs(diffLower) > Math.abs(maxMin) ){
        				maxMin = diffLower;
        				maxMinNum = i;
        			}
        		}else{
        			minIndex +=1;
        			if( Math.abs(diffUpper) > Math.abs(maxMin)){
        				maxMin = diffUpper;
        				maxMinNum = i;
        			}
        		}
        	}else{
        		if( Math.abs(diffLower) > Math.abs(maxMin) ){
        			maxMin = diffLower;
        			maxMinNum = i;
        		}
        	}
        }
        
        System.out.println(maxMinNum);
    }
}
