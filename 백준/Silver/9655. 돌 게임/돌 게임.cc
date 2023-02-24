#include <bits/stdc++.h>

using namespace std;

int n;

int main()
{
	cin >> n;

	// 돌이 1개면 내가 이김
	// 돌이 2개면 앞에 사람이 이김
	// 돌이 3개면 내가 이김
	// 돌이 4개면 앞에 사람이 이김
	// 돌이 5개면 내가 이김
	// 돌이 6개면 앞에 사람이 이김
	// 돌이 7개면 내가 이김
	// 돌이 8개면 앞에 사람이 이김

	// 즉 4개를 맞추기만 하면 상대방이 무조건 이김 ( -> 짝수면 상대가 이김 )

	if (n % 2 == 0)
		cout << "CY";
	else
		cout << "SK";

	return 0; 
}