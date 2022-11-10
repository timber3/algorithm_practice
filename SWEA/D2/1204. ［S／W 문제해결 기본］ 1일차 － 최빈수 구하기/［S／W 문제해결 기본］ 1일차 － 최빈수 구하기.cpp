#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
	int T;
	cin >> T;
	int test_num;
	int temp;
	int result;

	/*
	* 1. sort 를 해서 다음거랑 비교할 것인가
	* 2. 점수에 해당하는 인덱스에 값을 더하기 할것인가.
	*/
	

	for (int a = 0; a < T; a++)
	{
		vector<int> arr(101);
		cin >> test_num;

		for (int i = 0; i < 1000; i++)
		{
			cin >> temp;
			arr[temp] ++;
		}

		int max_count = *max_element(arr.begin(), arr.end());

		for (int i = 0; i < 101; i++)
		{
			if (arr[i] == max_count)
			{
				result = i;
			}
		}

		cout << "#" << a+1 << " " << result << endl;
	}

	return 0;
}