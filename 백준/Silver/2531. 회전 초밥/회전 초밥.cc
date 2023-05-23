#include <bits/stdc++.h>

using namespace std;

int n, d, k, c;
int arr[30001];
int visited[30001];
int Max;

int main()
{
	cin >> n >> d >> k >> c;

	// 배열은 컨베이어 벨트이므로 처음과 끝이 이어져있음.
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}


	// 연속된 k개 초밥이 종류가 가장 다양해야 하며
	// c가 안들어 있는 조합으로 선택해야 최고의 효율을 보임

	// 접시수 n 초밥 가짓 수 d 연속해서 먹는 수 k 쿠폰 번호 c

	for (int i = 0; i < n; i++)
	{
		int eat = 0;
		for (int j = i; j < i + k; j++)
		{
			if (visited[arr[j%n]] == 0)
			{
				eat++;
				visited[arr[j%n]] = 1;
			}
		}

		if (eat >= Max)
		{
			if (visited[c] == 1)
			{
				Max = eat;
			}
			else
			{
				Max = eat + 1;
			}
		}

		for (int j = i; j < i + k; j++)
		{
			visited[arr[j%n]] = 0;
		}
	}

	cout << Max << endl;

	return 0;
}