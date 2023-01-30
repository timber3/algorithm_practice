#include <bits/stdc++.h>

using namespace std;

int n, m;

// 0:빈칸 1:집 2:치킨집
int Map[51][51] = { 0, };
int house_Map[51][51] = { 0, };
int chicken_selected[13] = { 0, };

int Min = 99999;

vector<pair<int, int>> house;
vector<pair<int, int>> chicken;

int city_dis()
{
	int all_sum = 0;

	for (int i = 0; i < house.size(); i++)
	{
		int sum = 999;

		for (int j = 0; j < 13; j++)
		{
			int hx = house[i].first;
			int hy = house[i].second;

			if (chicken_selected[j])
			{
				int cx = chicken[j].first;
				int cy = chicken[j].second;

				int temp = abs(hx - cx) + abs(hy - cy);

				sum = min(temp, sum);
			}
		}

		all_sum += sum;
	}

	// 여기까지 돌면 도시 치킨 거리 구함.
	return all_sum;
}

void dfs(int cnt, int idx)
{
	// 남겨둘 m개의 치킨집을 정했으면 치킨 거리를 구한다.
	if (cnt == m)
	{
		Min = min(city_dis(), Min);
		return;
	}

	for (int i = idx; i < chicken.size(); i++)
	{
		if (chicken_selected[i] != 1)
		{
			chicken_selected[i] = 1;
			dfs(cnt + 1, i);
			chicken_selected[i] = 0;
		}
	}

}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> Map[i][j];

			if (Map[i][j] == 2)
			{
				chicken.push_back(make_pair(i, j));
			}
			if (Map[i][j] == 1)
			{
				house.push_back(make_pair(i, j));
			}
		}
	}

	for (int i = 0; i < house.size(); i++)
	{
		int x = house[i].first;
		int y = house[i].second;

		house_Map[x][y] = 1;
	}

	dfs(0, 0);

	cout << Min;

	return 0;
}