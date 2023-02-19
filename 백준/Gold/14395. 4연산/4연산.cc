#include <bits/stdc++.h>
#define Max 1000000001
using namespace std;

struct node {
	long long cur;
	int cnt;
	string code;
};

queue<node> q;
set<int> visited;

int s, t;

int bfs()
{

	while (!q.empty())
	{
		long long cur = q.front().cur;
		int cnt = q.front().cnt;
		string code = q.front().code;

		visited.insert(cur);

		q.pop();

		if (cur == t)
		{
			cout << code;
			return 0;
		}

		if (cur * cur < Max && visited.find(cur*cur) == visited.end() )
			q.push(node{ cur * cur, cnt + 1, code + '*' });

		if (cur + cur < Max && visited.find(cur + cur) == visited.end())
			q.push(node{ cur + cur, cnt + 1, code + '+' });
 
		if (cur != 0 && visited.find(cur / cur) == visited.end())
			q.push(node{ cur / cur, cnt + 1, code + '/' });
	}
	return -1;
}

int main()
{
	cin >> s >> t;

	if (s == t)
	{
		cout << "0";
		return 0;
	}
	
	q.push(node{ s, 0, ""});


	int result = bfs();

	if (result == -1)
	{
		cout << "-1";
		return 0;
	}

	return 0;
}