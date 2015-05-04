void HLD(int curNode, int cost, int prev){
	if(chainNode[chainNumber] == -1){
		chainNode[chainNumber] = curNode;
	}
	chainInd[curNode] = chainNumber;
	posInBase[curNode]= ptr; //position of current nide in base array
	baseArray[ptr++] = cost;

	int sc = -1;
	int ncost = 0;


}
