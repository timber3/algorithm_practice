#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

typedef long long ll;
using namespace std;

ll map[100][100] = { 0, };
// int c_map[16][16];
bool visited[100][100];

int answer = 0;

int startx;
int starty;
int desx;
int desy;

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };


void DFS(int x, int y)
{
	visited[x][y] = true;

	if (answer == 1)
		return;

	if (map[x][y] == 3)
	{
		answer = 1;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		if ((map[x + dx[i]][y + dy[i]] == 0 || map[x + dx[i]][y + dy[i]] == 3) && visited[x + dx[i]][y + dy[i]] == false)
		{
			DFS(x + dx[i], y + dy[i]);
		}
	}

}

void input()
{
	string temp;
	for (int i = 0; i < 100; i++)
	{
		cin >> temp;
		for (int j = 0; j < 100; j++)
		{
			map[i][j] = stoi(temp.substr(0, 1));
			temp.erase(0, 1);

			if (map[i][j] == 2)
			{
				startx = i;
				starty = j;
			}
			if (map[i][j] == 3)
			{
				desx = i;
				desy = j;
			}
		}
	}
}

void clear_circum()
{
	for (int i = 0; i < 100; i++)
	{
		for (int j = 0; j < 100; j++)
		{
			visited[i][j] = false;
			map[i][j] = 0;
		}
	}

	answer = 0;
}

int main()
{
	int T;
	for (int t = 0; t < 10; t++)
	{
		clear_circum();
		cin >> T;
		input();
		DFS(startx, starty);

		cout << "#" << T << " " << answer << endl;
	}


	return 0;
}