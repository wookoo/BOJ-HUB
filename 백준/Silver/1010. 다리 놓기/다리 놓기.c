#include <stdio.h>
int collect(int x,int y){
	
}

int main(){
	int count;
	scanf("%d",&count);
	for (int i = 0; i<count; i ++){
		int n,m;
		scanf("%d %d",&n,&m);
		int result = 1;
		
		for (int i = m, j = 1; i > n; i--,j++){
			result *= i;
			result /= j;
		}
		printf("%d\n",result);
	}
}