#include <bits/stdc++.h>

using namespace std;

int n, k;
int arr[1000001];

int main()
{
	cin >> n >> k;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	int st = 0;
	int en = 0;
	int cnt = (arr[st] & 1) ? 1 : 0; // 현재 구간의 홀수 개수
	int Max = 0;

	while (1)
	{
		while (en < n - 1) // en을 뒤로 이동시킬 수 이씅ㄹ 경우
		{
			if (arr[en + 1] & 1) // en의 다음 요소가 홀수인 경우
			{
				if (cnt < k) // 홀수를 삭제할 수 있는 경우,
				{
					cnt++;
				}
				else // 홀수를 삭제할 수 없는 경우
				{
					break;
				}
			}

			en++;
		}
		
		if (st >= n || en >= n) // 범위를 벗어나면
			break;

		Max = max(Max, en - st + 1 - cnt);

		if (arr[st] & 1)
			cnt--;
		
		st++;

	}

	cout << Max;

	return 0;
}