#include <iostream>
#define endl "\n"

using namespace std;

int n;
int result = 0;
int visited[1001] = { 0, };
int redup = 0;
int value[] = { 1, 5, 10, 50 };

void dfs(int idx, int cnt, int total)
{
	if (cnt == n)
	{
		if (!visited[total])
		{
			visited[total] = 1;
			redup += 1;
		}
		return;
	}

	for (int i = idx; i < 4; i++)
	{
		dfs(i, cnt + 1, total + value[i]);
	}
}

int main()
{
	cin >> n;

	dfs(0, 0, 0);

	cout << redup;

	return 0;
}