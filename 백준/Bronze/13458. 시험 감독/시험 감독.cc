#include <bits/stdc++.h>

using namespace std;

int n;
int b, c;
long long sum = 0;

int main()
{
	cin >> n;

	vector<int> v;

	for (int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	cin >> b >> c;

	// v[i] : 각 시험장에 있는 응시자의 수
	// b : 총감독이 감시하는 사람 수
	// c : 부감독이 감시하는 사람 수


	// 시험장 마다 총감동은 한명씩 있으므로 v[i] - b 해준다.
	// 총감독 수 : v.size();
	// 부감독 수 : a % c 해서 0이 아니면 a/c +1 해주기 

	sum += n;
	
	for (int i = 0; i < n; i++)
	{
		v[i] = v[i] - b;
	}

	for (int i = 0; i < n; i++)
	{
		if (v[i] > 0)
		{
			if (v[i] % c == 0)
				sum += v[i] / c;
			else
				sum += v[i] / c + 1;
		}
	}

	cout << sum;

	return 0;
}