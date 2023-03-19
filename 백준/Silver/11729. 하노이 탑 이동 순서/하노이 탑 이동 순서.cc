#include <bits/stdc++.h>

using namespace std;

vector<pair<int, int>> v;

void hanoi(int a, int b, int n)
{
	if (n == 1)
	{
		v.push_back({ a, b });
		return;
	}

	hanoi(a, 6 - a - b, n - 1);
	v.push_back({ a, b });
	hanoi(6 - a - b, b, n - 1);
}

int main()
{
	// 과정.
	// n-1 개의 원판을 기둥 a 에서 6-a-b 로 이동한다. (6-a-b) 는 출발지 목적지를 제외한 나머지 기둥
	// a 에서 n번째 원판을 b로 이동한다.
	// 6-a-b 기둥에서 n-1개의 원판을 b로 이동한다.
	int n;

	cin >> n;

	hanoi(1, 3, n);

	cout << v.size() << "\n";

	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i].first << " " << v[i].second << "\n";
	}

	return 0;
}