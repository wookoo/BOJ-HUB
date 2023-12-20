#include <stdio.h>
int main() {
	int h;
	int m;
	int mins;
	scanf("%d %d %d", &h, &m, &mins);
	h = (int)((mins + m) / 60 + h);
	m = mins + m;
	if (m >= 60) {
		m -= 60 * (int)(m / 60);
	}
	printf("%d %d", h % 24, m);
	

}