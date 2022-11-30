#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

char temp;
int l, c;
int visited[15] = { 0, };
char arr[15];
char input[15];

void dfs(int cnt)
{
	if (cnt == l)
	{
		int aeiou = 0;

		for (int i = 0; i < l ; i++)
		{
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
			{
				aeiou += 1;
			}
		}
		
		if (aeiou > 0 && (l - aeiou) > 1)
		{
			for (int i = 0; i < l; i++)
			{
				cout << arr[i];
			}
			cout << "\n";
		}

		return;
	}

	for (int i = 0; i < c; i++)
	{
		if (!visited[i])
		{
			if (arr[cnt - 1] >= input[i])
			{
				continue;
			}
			visited[i] = 1;
			arr[cnt] = input[i];
			dfs(cnt + 1);
			visited[i] = 0;
		}
	}
}

int main()
{
	cin >> l >> c;

	//ios::sync_with_stdio(false);
	//cin.tie(NULL);

	for (int i = 0; i < c; i++)
	{
		cin >> input[i];
	}

	sort(input, input+c);
	
	dfs(0);

	return 0;
}