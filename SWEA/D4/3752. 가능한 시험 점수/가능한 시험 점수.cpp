#include <bits/stdc++.h>

using namespace std;

int n;
int result;
int visited[10001];
vector<int> v;

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		cin >> n;
		visited[0] = 1;
		for (int i = 0; i < n; i++)
		{
			int temp;
			cin >> temp;

			int size = v.size();

			// 숫자를 입력 받고 v에 있는 원소들과 더해보고 값이 없었으면
			// v에 추가해주고 visited 를 1로 해준다.

			for (int j = 0; j < size; j++)
			{
				if (visited[v[j] + temp] == 0)
				{
					visited[v[j] + temp] = 1;
					v.push_back(v[j] + temp);
				}
			}

			if (visited[temp] == 0)
			{
				visited[temp] = 1;
				v.push_back(temp);
			}
		}

		// 숫자를 입력 받을 때 마다 벡터에 저장 후 더하기를 해서 visited 확인 후 추가

		for (int i = 0; i < 10001; i++)
		{
			if (visited[n] == 1)
				result++;
		}

		cout << "#" << t + 1 << " " << v.size() + 1 << '\n';

		v.clear();
		result = 0;
		fill(visited, visited + 10001, 0);
	}

	return 0;
}