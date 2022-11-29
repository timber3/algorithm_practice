#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
int result[9];
int visited[9] = { 0, };

void DFS(int cnt)
{
	if (cnt == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout << result[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= N; i++)
	{
		if (!visited[i])
		{
			visited[i] = 1; // true
			result[cnt] = i;
			DFS(cnt + 1);
			visited[i] = 0; // false
		}
	}
}

int main()
{
	cin >> N >> M;
	DFS(0);
	return 0;
}