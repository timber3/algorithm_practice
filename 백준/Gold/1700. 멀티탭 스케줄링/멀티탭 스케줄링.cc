#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N, K;
	cin >> N >> K;

	vector<int> multitap(N);
	vector<int> item(K);

	int ans = 0;

	for (int i = 0; i < K; i++)
	{
		cin >> item[i];
	}

	int multicount = 0;

	for (int i = 0; i < K; i++)
	{
		if ( find(multitap.begin(), multitap.end(), 0 ) != multitap.end() ) // 만약 multitap에 0 ( 빈공간) 이 있다면
		{
			bool dup = false;
			// 중복 확인
			for (int j = 0; j < N; j++)
			{
				if (multitap[j] == item[i]) // 중복이 있을 경우
				{
					dup = true;
					break;
				}
			}

			if (dup == false) // 중복이 없을 경우
			{
				multitap[multicount++] = item[i];
			}
		}
		else // multitap에 빈공간이 없다면
		{
			bool dup = false;
			// 중복 확인
			for (int j = 0; j < N; j++)
			{
				if (multitap[j] == item[i]) // 중복이 있을 경우
				{
					dup = true;
					break;
				}
			}

			if (dup == false) // 중복이 없을 경우
			{
				// 빼야하는데 그 기준이 애매하다. -> 
				// 1. 앞으로 사용할 제품이 아니면 뽑아도 상관없다. 
				// 2. 오랫동안 사용하지 않을 물건을 뽑는다.
				int result = 0;
				int repl_idx = 0;
				int change_idx = 101;
				for (int j = 0; j < N; j++)
				{
					for (int k = i; k < K; k++)
					{
						if (multitap[j] != item[k])
						{
							repl_idx++;
						}
						else
						{
							break;
						}
					}

					if (repl_idx > result)
					{
						result = repl_idx;
						change_idx = j;
					}

					repl_idx = 0;
				}

				multitap[change_idx] = item[i];
				ans++;
			}
		}
	}

	cout << ans << endl;

	return 0;
}