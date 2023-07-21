#include <stdio.h>
int IsHan(int data){
	if(data <=99){
		return 1;
	}
	int N2,N1,N0;
	N2 = data / 100;
	N1 = (data % 100)/10;
	N0 = data %10;
	
	return ((N2 - N1) == (N1 - N0));
}
int main(){
	int count = 0;
	int time;
	scanf("%d",&time);
	for (int i = 1 ; i <=time; i++){
		count += IsHan(i);
	}
	printf("%d",count);
	
	
}