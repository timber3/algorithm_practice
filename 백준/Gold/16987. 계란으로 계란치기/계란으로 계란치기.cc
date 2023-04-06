#include <bits/stdc++.h>

using namespace std;

int n;
int Max;

typedef struct node {
	int hp;
	int dam;
};

vector<node> v;

void dfs(int left_egg)
{	
	// 집은 계란이 가장 오른쪽 위치면
	if (left_egg == n)
	{
		int result = 0;
		for (int i = 0; i < n; i++)
		{
			if (v[i].hp <= 0)
			{
				result++;
			}
		}

		Max = max(result, Max);

		return;
	}

	// 집은 계란이 깨져있다면 오른쪽 계란 고르기
	if (v[left_egg].hp <= 0)
	{
		dfs(left_egg + 1);
	}
	else
	{
		bool crash = false;
		for (int i = 0; i < n; i++)
		{
			// 맞을 계란이 깨져있으면 다음 계란 고르기 
			if (v[i].hp <= 0 || i == left_egg)
				continue;

			v[i].hp -= v[left_egg].dam;
			v[left_egg].hp -= v[i].dam;
			crash = true;
			dfs(left_egg + 1);

			v[i].hp += v[left_egg].dam;
			v[left_egg].hp += v[i].dam;

		}

		if (!crash) dfs(n);
	}
}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int d, w;
		cin >> d >> w;
		v.push_back({ d,w });
	}

	dfs(0);

	cout << Max;

	return 0;
}