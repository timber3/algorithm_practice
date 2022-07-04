#include <iostream>
#include <stack>
#include <string>

/// <summary>
/// 
/// 문제 풀이
/// 
/// 1. 여는 괄호를 받으면 ( [ 에 따라 temp에 곱해준다. ( 분배법칙을 활용 함 )

/// 2. 괄호가 닫히면 지금까지 곱해진 temp 값을 sum에 더해준다. ( 분배법칙 활용 )
/// - 여기서 중요한 점은 괄호가 닫힐 때 바로 앞의 문자가 닫는괄호의 짝으로 열어야 값으로 인정하고 더해준다
/// - ex )   [ ( ) ]  일 경우 ) 이 입력 될 경우 ) 바로 앞 문자가 ( 이기 때문에 3 x 2 의 값을 더해준다. 
/// 그리고 ] 이 입력 될 때는 바로 앞에 문자가 [ 이 아니기 때문에 temp 값을 더해주지 않는다.

/// 3. 예외처리를 확실하게 해준다.
/// 
/// </summary>
/// <param name=""></param>
/// <returns></returns>

using namespace std;

int main(void)
{
	string str;

	stack<char> st;
	int temp = 1;
	int sum = 0;
	cin >> str;

	for (int i = 0; i < str.length(); i++)
	{
		if (str[i] == '(')
		{
			st.push(str[i]);
			temp *= 2;
		}
		else if (str[i] == '[')
		{
			st.push(str[i]);
			temp *= 3;
		}
		else if (str[i] == ')')
		{
			if (st.empty() == 1 || st.top() != '(')
			{
				cout << 0 << endl;
				exit(0);
			}
			else
			{
				if (str[i - 1] == '(')
				{
					sum += temp;
					temp /= 2;
				}
				else
				{
					temp /= 2;
				}
				st.pop();
			}
		}
		else if (str[i] == ']')
		{
			if (st.empty() == 1 || st.top() != '[')
			{
				cout << 0 << endl;
				exit(0);
			}
			else
			{
				if (str[i - 1] == '[')
				{
					sum += temp;
					temp /= 3;
				}
				else
				{
					temp /= 3;
				}
				st.pop();
			}
		}
	}

	if (st.size() != 0)
	{
		cout << 0 << endl;
		return 0;
	}

	cout << sum << endl;
	return 0;
}
