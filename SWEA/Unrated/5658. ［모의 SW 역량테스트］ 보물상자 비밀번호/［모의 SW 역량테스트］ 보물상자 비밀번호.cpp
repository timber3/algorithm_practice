#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <string>
#include <stdlib.h>
#include <cmath>

typedef long long ll;

using namespace std;


// 문자열 치환은 replace로 가능 replace(0, win_size, "");
// 문자열 검색해서 치환은 regex_replace( 대상 문자열, regex("바꿀 문자열"),"바뀔 문자열");
// #include <regex> 필요
int main()
{

	int T;
	cin >> T;


	for (int t = 0; t < T; t++)
	{
		// 숫자의 개수 N, 크기 순서 K
		int N, K;
		string input;
		string _input;
		int result = 0;


		cin >> N >> K >> input;

		_input = input;
		int str_size = input.size();
		// 내림차순 정렬하기.
		map< string, string, greater<string>> mapset;
		int win_size = N / 4;

		for (int i = 0; i < win_size; i++)
		{
			ll pass = 0;

			for (int j = 0; j < 4; j++)
			{
				// string을 나누고
				string temp = input.substr(0, win_size);
				// 문자열을 지우는건 erase로 가능
				input.erase(0, win_size);
				// 저장
				mapset.insert({ temp, temp });
			}

			// 마지막 문자 저장했다가.
			char temp = _input[str_size-1];
			// 마지막 문자 지워주고.
			_input.erase(str_size - 1, str_size - 1);
			// 마지막 문자를 맨앞에다 붙이기.
			_input = temp + _input;
			//_input.insert(0, to_string(temp)); 이렇게 저장하니까 'E' 값이 char69 로 들어감 ;

			input = _input;

		}
		int index = 0;

		for (auto a = mapset.begin(); a != mapset.end(); a++)
		{
			if (index == K - 1)
			{
				int k = 0;
				for (int i = win_size - 1; i >= 0 ; i--)
				{
					char temp = a->first[i];
					int _temp;

					if (temp >= 65)
					{
						_temp = temp - 55;
					}
					else
					{
						// atoi 대신 char 0의 값을 빼 준다.
						// atoi 는 cstdlib 헤더에 있음.
						_temp = temp - '0';
					}

					result += _temp * pow(16, k);

					k++;
				}
			}

			index++;
		}
		cout << "#" << t + 1 << " " << result << endl;
	}


	return 0;
}
