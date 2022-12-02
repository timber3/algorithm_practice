#include <iostream>
#include <queue>

using namespace std;

int n;
int mid;
int flag = 0;
int result[100001];

priority_queue<int> max_q;
priority_queue<int, vector<int>, greater<int>> min_q;

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		flag++;

		int temp;
		cin >> temp;

		if (flag % 2 == 1) // 홀수
		{
			max_q.push(temp);
			if (i != 0)
			{
				if (max_q.top() > min_q.top())
				{
					int temp1 = max_q.top();
					int temp2 = min_q.top();

					max_q.pop();
					min_q.pop();

					max_q.push(temp2);
					min_q.push(temp1);
				}
			}
		}
		else // 짝수
		{
			min_q.push(temp);
			if (max_q.top() > min_q.top())
			{
				int temp1 = max_q.top();
				int temp2 = min_q.top();

				max_q.pop();
				min_q.pop();

				max_q.push(temp2);
				min_q.push(temp1);
			}
		}

		result[i] = max_q.top();
	}

	for (int i = 0; i < n; i++)
	{
		cout << result[i] << "\n";
	}


	return 0;
}