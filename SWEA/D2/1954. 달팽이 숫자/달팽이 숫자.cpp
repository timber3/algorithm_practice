#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int T;
	cin >> T;

	for (int a = 0; a < T; a++)
	{
		int N;
		cin >> N;

		// 원소가 N개이고 0으로 초기화된 벡터를 N개 만든다. NxN    ,0 안붙여도 0으로 초기화 됨

		vector<vector<int>> arr(N, vector<int>(N,0));


		int dx[4] = { 1, 0, -1, 0 };
		int dy[4] = { 0, 1, 0, -1 };

		int i = 0;
		int j = -1;
		int number = 1;

		int counter = 0;
		int count = 1;
		int rest_count = N-1;

		// 첫줄은 채워놓고 그다음 줄부터 rest_count를 통해 인덱스 이동함

		for (int i = 0; i < N; i++)
		{
			arr[0][i] = number++;
			j++;	// real x scope
		}


		while (number != ((N * N) + 1))
		{
			counter = count % 4;
			for (int p = 0; p < rest_count; p++)
			{
				j += dx[counter];
				i += dy[counter];
				arr[i][j] = number++;
			}
			count++;
			counter = count % 4;

			for (int p = 0; p < rest_count; p++)
			{
				j += dx[counter];
				i += dy[counter];
				arr[i][j] = number++;
			}
			count++;
			rest_count--;

		}

		cout << "#" << a + 1 << " " << endl;

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				cout << arr[i][j] << " ";
			}
			cout << endl;
		}
	}

	return 0;
}