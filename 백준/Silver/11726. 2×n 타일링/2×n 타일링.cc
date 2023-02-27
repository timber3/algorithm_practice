#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
    int D[1001];
	D[1]=1,D[2]=2;		// n=1, n=2일 때의 2xn 타일링 수
	for (int i=3; i<=n; i++) {	// n=3부터 n까지 반복
		D[i]=D[i-1]+D[i-2];
        D[i] %= 10007;		// 문제의 조건
	}
	cout << D[n];
	return 0;
}