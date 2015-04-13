import java.io.*;
import java.util.*;

class TWTCLOSE{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		boolean arr[] = new boolean[N];
		while(K--!=0){
			String input = reader.readLine();
			if(input.equals("CLOSEALL")){Arrays.fill(arr,false);}
			else{
				int i = Integer.parseInt(input.split("")[1]);
				arr[i-1] = !arr[i-1];
			}
			int count = 0;
			for(int j=0;j<N;j++){
				if(arr[j])count++;
			}
			System.out.println(count);
		}
		
	}
}
