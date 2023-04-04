#include <bits/stdc++.h>

using namespace std;


int n, m;
vector<int> arr;
vector<int> v;

void bt(int cnt, int idx)
{
	if (cnt == m)
	{
		for (int i = 0; i < v.size(); i++)
		{
			cout << v[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = idx; i < n; i++)
	{
		v.push_back(arr[i]);
		bt(cnt + 1, i);
		v.pop_back();
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		arr.push_back(temp);
	}

	sort(arr.begin(), arr.end());
	
	bt(0, 0);


	return 0;
}