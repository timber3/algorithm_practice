#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char* argv[])
{
	int T;
	cin >> T;

	for (int a = 0; a < T; a++)
	{
		int N;
		cin >> N;

		vector<int> arr;
		long benefit = 0;
		int temp;

		for (int i = 0; i < N; i++)
		{
			cin >> temp;
			arr.push_back(temp);
		}

		int MAX = *max_element(arr.begin(), arr.end());
		int cost = 0;
		int amount = 0;

		//cout << " this is MAX value : " << MAX << endl;
		
		for (int i = 0; i < N; i++)
		{
			
 			if (arr[i] != MAX)
			{
				amount += 1;
				cost += arr[i];
				//cout << "present Cost : " << cost << endl;
			}
			else if (arr[i] == MAX)
			{
				benefit += (amount * MAX - cost);

				if (i + 1 >= N)
				{
					cost = 0;
					amount = 0;
					break;
				}
				else
				{
					MAX = *max_element(arr.begin() + i + 1, arr.end());
					cost = 0;
					amount = 0;
				}
				
			}
		}

		cout << "#" << a + 1 << " " << benefit << endl;

	}


	return 0;
}