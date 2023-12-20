#include <stdio.h>


int main(){
	int fib[42][2];
	fib[0][0] = 1;
	fib[0][1] = 0;
	fib[1][0] = 0;
	fib[1][1] = 1;
	
	for(int i = 2; i<42; i++){
		fib[i][0] = fib[i-1][0] + fib[i - 2][0];
		fib[i][1] = fib[i-1][1] + fib[i - 2][1];
	}
	int count;
	scanf("%d",&count);
	for(int i = 0; i < count; i++){
		int data;
		scanf("%d",&data);
		printf("%d %d\n",fib[data][0],fib[data][1]);
	}
	
	
}