#include <iostream>

using namespace std;

int n;
int result = 0;

int arr[15] = { 0, };

bool check(int cnt)
{
	for (int i = 0; i < cnt; i++)
	{
		// 두개가 같으면 행이 같은 값이 나오기 때문에 조건 부합
		// ( X,Y ) 와 ( A,B )가 대각선 상에 있으려면
		// X-A 와 Y-B가 같을 경우 대각선상에 있다.

		if ((arr[cnt] == arr[i]) || ((cnt - i) == abs(arr[cnt] - arr[i])))
		{
			//둘 수 없는 경우
			return false;
		}
	}
	return true;
}

void dfs(int cnt)
{
	if (cnt == n)
	{
		result++;
		return;
	}

	else
	{
		for (int i = 0; i < n; i++)
		{
			arr[cnt] = i;

			if (check(cnt))
				dfs(cnt + 1);
		}
	}
}

int main()
{
	cin >> n;

	dfs(0);

	cout << result;

	return 0;
}