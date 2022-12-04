#include <iostream>
#include <vector>
#include <algorithm>

#define endl "\n"

using namespace std;

// dfs 사용

int n;
vector<long long> a;
vector<long long> b;

void dfs(long long x, int cnt)
{
	if (cnt == n)
	{
		for (int i = 0; i < n; i++)
		{
			cout << a[i] << " ";
		}
		return;
	}

	// 3으로 나누어 떨어지고 3으로 나누었을 때의 값이 b에 존재 할 경우
	if ((x % 3 == 0) && find(b.begin(), b.end(), x / 3) != b.end())
	{
		a.push_back(x / 3);
		dfs(x / 3, cnt + 1);
		a.pop_back();
	}

	// 2를 곱했을 때 그 결과가 b에 존재할 경우
	if (find(b.begin(), b.end(), x * 2) != b.end())
	{
		a.push_back(x * 2);
		dfs(x * 2, cnt + 1);
		a.pop_back();
	}

	return;
}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		long long temp;
		cin >> temp;
		b.push_back(temp);
	}

	for (int i = 0; i < n; i++)
	{
		a.push_back(b[i]);
		dfs(b[i], 1);
		a.pop_back();
	}

	return 0;
}