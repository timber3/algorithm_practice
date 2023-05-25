#include <bits/stdc++.h>

using namespace std;

int n;
int arr[4000001];
vector<int> v;


// 에라토스테네스의 체
/**
* 2는 소수이다. 그러면 2의 배수들은 전부 소수가 아니다
* 3은 소수이다. 그러면 3의 배수들은 전부 소수가 아니다
* ...
* 소수가 아닌 수만 남게됨.
*/

void chae(int n)
{
	fill(arr, arr + 4000001, 1);

	arr[1] = 0;

	for (int i = 2; i <= n; i++)
	{
		if (arr[i] == 1) // 해당 수가 소수라면
		{
			v.push_back(i);
			for (int j = i * 2; j <= n; j += i) // 해당 수의 배수들은 전부 소수가 아님
			{
				arr[j] = 0;
			}
		}
	}
}

int main()
{
	cin >> n;

	chae(n);

	int st = 0;
	int en = 0;
	int sum = 0;
	int result = 0;

	while (1)
	{
		if (sum > n)
		{
			sum -= v[st++];
		}
		else if (sum < n)
		{
			if (en >= v.size())
				break;

			sum += v[en++];
		}
		else
		{
			result++;

			if (en >= v.size())
				break;

			sum += v[en];
			en++;
		}
	}

	cout << result;

	return 0;
}