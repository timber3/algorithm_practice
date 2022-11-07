#include <iostream>
#include <vector>

using namespace std;

int main()
{

	int N;
	cin >> N;

	vector<vector<int>> vect_arr(N);
	int num = 0;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			cin >> num;
			vect_arr[i].push_back(num);
		}
			
	}

	for (int i = 0; i < N; i++)
	{
		int sum = 0;
		for (int j = 0; j < 10; j++)
		{
			if (vect_arr[i][j] % 2 == 1)
				sum += vect_arr[i][j];
		}

		cout << "#" << i+1 << " " << sum << endl;
	}

	return 0;
}