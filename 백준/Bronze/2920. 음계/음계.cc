#include <iostream>

using namespace std;

int arr[8];

int solve()
{
	int as_cnt = 0;
	int ds_cnt = 0;

	for (int i = 0; i < 7; i++)
	{
		if (arr[i] + 1 == arr[i + 1])
			as_cnt++;
		if (arr[i] - 1 == arr[i + 1])
			ds_cnt++;
	}

	if (as_cnt == 7)
		return 1;
	else if (ds_cnt == 7)
		return 2;
	else
		return 0;

}

int main()
{
	for (int i = 0; i < 8; i++)
		cin >> arr[i];

	int val = solve();

	if (val == 0)
		cout << "mixed";
	else if (val == 1)
		cout << "ascending";
	else if (val == 2)
		cout << "descending";

	return 0;
}