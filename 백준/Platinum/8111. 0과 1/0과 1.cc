#include <iostream>
#include <queue>

#define endl "\n"

using namespace std;

int t;
int n;

int par[20001] = { 0, };
char result[20001];

void bfs()
{
	queue<int> q;
	int visited[20001] = { 0, };

	q.push(1);
	visited[1] = 1;
	par[1] = -1;

	result[1] = '1';

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();

		int node[2];
		node[0] = (10 * cur + 0) % n;
		node[1] = (10 * cur + 1) % n;

		for (int i = 0; i < 2; i++)
		{
			if (!visited[node[i]])
			{
				q.push(node[i]);
				visited[node[i]] = 1;

				par[node[i]] = cur;
				result[node[i]] = i + '0';

				if (node[i] == 0)
					return;
			}
		}
	}
}

void print_node(int parent)
{
	if (par[parent] != -1)
		print_node(par[parent]);
	
	cout << result[parent];
}


int main()
{
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		cin >> n;
		bfs();
		print_node(0);
		cout << endl;
	}

	return 0;
}