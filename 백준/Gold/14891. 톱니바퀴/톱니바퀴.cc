#include <bits/stdc++.h>

using namespace std;

// A B C D 톱니가 있을 때
// A를 시계방향으로 돌렸을 때 
// A 과 B가 맞닿은 부분이 극이 반대라면 B는 반시계방향으로 돈다.
// A 과 B가 맞닿은 부분이 극이 같다면 돌지 않는다.

vector<deque<int>> gear;

int k; // 회전 횟수
int t;
int number[100]; // 톱니바퀴 번호
int dir[100]; // 1 : 시계 방향 -1 : 반시계 방향
int visited[4] = { 0, };
int sum = 0;

void dfs(int num, int dir)
{
	// 1번 기어가 아니면서 왼쪽 기어의 극이 다를 경우
	if (num != 0 && !visited[num - 1] && gear[num][6] != gear[num - 1][2])
	{
		visited[num - 1] = 1;
		dfs(num - 1, dir * -1);
	}

	// 4번 기어가 아니면서 오른쪽 기어의 극이 다를 경우
	if (num != 3 && !visited[num + 1] && gear[num][2] != gear[num + 1][6])
	{
		visited[num + 1] = 1;
		dfs(num + 1, dir * -1);
	}

	// 시계 방향
	if (dir == 1)
	{
		int temp = gear[num].back();
		gear[num].pop_back();
		gear[num].push_front(temp);
	}
	// 반시계 방향
	if (dir == -1)
	{
		int temp = gear[num].front();
		gear[num].pop_front();
		gear[num].push_back(temp);
	}
}

int main()
{
	for (int i = 0; i < 4; i++)
	{
		deque<int> temp;
		gear.push_back(temp);

		cin >> t;

		for (int j = 0; j < 8; j++)
		{
			gear[i].push_front(t % 10);
			t = t / 10;
		}
	}

	cin >> k;

	for (int i = 0; i < k; i++)
	{
		cin >> number[i] >> dir[i];
	}

	for (int i = 0; i < k; i++)
	{
		memset(visited, 0, sizeof(visited));
		visited[number[i] - 1] = 1;
		dfs(number[i] -1, dir[i]);
	}

	for (int i = 0; i < 4; i++)
	{
		if (gear[i][0] == 1)
			sum += (1 << i);
	}

	cout << sum;

	return 0;
}