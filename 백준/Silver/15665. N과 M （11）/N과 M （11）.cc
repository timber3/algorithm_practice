#include <bits/stdc++.h>
using namespace std;

int n, m;
int v[10];
int arr[10];
bool visited[10];

void func(int k)
{ // 현재 k개까지 수를 택했음.
	if (k == m)
	{
		for (int i = 0; i < m; ++i)
		{
			cout << v[i] << ' ';
		}
		cout << '\n';
		return;
	}

	int tmp = 0;  // 중복 수열인지 확인 하기 위해 필요한 임시 변수

	for (int i = 0; i < n; ++i)
	{
		if (tmp != arr[i])
		{ // 이전 수열의 마지막 항과 새로운 수열의 마지막 항이 같으면 중복 수열
			v[k] = arr[i];
			tmp = v[k];
			func(k + 1);
		}
	}
}

int main(void)
{
	cin >> n >> m;

	for (int i = 0; i < n; ++i)
		cin >> arr[i];

	sort(arr, arr + n);

	func(0);

	return 0;
}