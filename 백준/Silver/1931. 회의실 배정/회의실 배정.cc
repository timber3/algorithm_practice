#include <bits/stdc++.h>
#define ll long long

using namespace std;

int n;
int cur;
ll Min = LLONG_MAX;
int cnt;
pair<ll, ll> Time[100001];

int main()
{
	cin >> n;

	// 정렬을 하기 편하게 하기 위해 끝나는 시간을 먼저 넣어줌
	for (int i = 0; i < n; i++)
	{
		cin >> Time[i].second >> Time[i].first;
	}

	// 끝나는 시간을 기점으로 오름차순 정렬
	sort(Time, Time + n);

	// 현재 시점 <= 시작 시간 && 끝나는 시점이 가장 빠른 Task 선택
	for (int i = 0; i < n; i++)
	{
		if (cur <= Time[i].second)
		{
			cur = Time[i].first;
			cnt++;
		}
	}

	cout << cnt;

	return 0;
}