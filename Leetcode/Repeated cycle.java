
public static int rc(String s) { 
	if( s == null ||s.length() == 0) return 0;

	int[] kmp = new int[s.length()];
    
	for(int i = 1; i < s.length(); i++)
	{
		int k = kmp[i-1];
		while(true){
			if(s.charAt(i) == s.charAt(k)){
				kmp[i] = k+1;
				break;
			}else if(k==0){
				kmp[i] = 0;
				break;
			}else{
				k = kmp[k-1];
			}
		}

		
	}
	
	int res = s.length()-kmp[s.length()-1];
	if(s.length()%res == 0) return s.length()/res;
	return 1;
}
