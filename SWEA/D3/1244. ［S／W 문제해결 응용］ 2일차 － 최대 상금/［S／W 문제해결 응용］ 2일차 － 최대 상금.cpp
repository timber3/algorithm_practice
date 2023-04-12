#include <bits/stdc++.h>

using namespace std;

int t;
int arr[7];
int best_case[7];
int arr_size;
int get_best;
int Max = 0;
int ch;

void dfs(int cnt)
{
	if (cnt == ch)
	{
		int num = 0;
		int temp = 1;
		// 숫자 만들기
		for (int i = arr_size-1 ; i >= 0 ; i --)
		{
			num += temp * arr[i];
			temp *= 10;
		}

		Max = max(Max, num);
		return;
	}

	for (int i = 0; i < arr_size - 1; i++)
	{
		for (int j = i + 1; j < arr_size; j++)
		{
			swap(arr[i], arr[j]);

			bool best = true;
			// 내림차순 배열인지 확인하기 (최적해인지)
			for (int k = 0; k < arr_size; k++)
			{
				if (arr[k] != best_case[k])
					best = false;
			}

			if (best)
			{
				get_best = 1;

				if ((ch - cnt) % 2 == 1)
				{
					int num = 0;
					int temp = 1;
					// 숫자 만들기
					for (int i = arr_size - 1; i >= 0; i--)
					{
						num += temp * arr[i];
						temp *= 10;
					}

					Max = num;
					return;
				}
				else
				{
					int num = 0;
					int temp = 1;
					// 숫자 만들기
					swap(arr[arr_size - 1], arr[arr_size - 2]);

					for (int i = arr_size - 1; i >= 0; i--)
					{
						num += temp * arr[i];
						temp *= 10;
					}

					Max = num;

					return;
				}
			}

			if (get_best) return;

			dfs(cnt + 1);

			if (get_best) return;

			swap(arr[i], arr[j]);
		}
	}

}

int main()
{
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		int temp;

		int idx = 0;
		
		cin >> temp >> ch;

		string str = to_string(temp);
		idx = str.length();
		arr_size = idx;

		while (temp != 0)
		{
			idx--;
			arr[idx] = temp % 10;
			temp = temp / 10;
		}

		for (int j = 0; j < arr_size; j++)
			best_case[j] = arr[j];

		sort(best_case, best_case + arr_size, greater<>());

		dfs(0);

		cout << "#" << i + 1 << " " << Max << '\n';

		Max = 0;
		get_best = 0;
	}


	return 0;
}