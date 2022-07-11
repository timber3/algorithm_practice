#include <iostream>
#include <vector>
#include <string>

using namespace std;

int max_word = 0;
int N, K;
vector<bool> alph(26);
vector<string> words;

int readable()
{
	int result = 0;

	for (int i = 0; i < words.size(); i++)
	{
		int flag = 0;

		for (int j = 0; j < words[i].length(); j++)
		{
			if (alph[words[i][j] - 'a'] != true)
			{
				flag = 1;
				break;
			}
		}

		if (flag == 0)
		{
			result++;
		}
	}

	return result;
}

// 단어의 글자 수 만큼 카운트를 지정해준다.
void DFS(int idx, int count)
{
	if (count == K)
	{
		max_word = max(max_word, readable());
	}

	// 21 : 26 : 알파벳 개수  - 5 : a n t i c
	for (int i = idx; i < 26 ; i++)
	{
		if (alph[i] == true)
			continue;
		alph[i] = true;
		DFS(i, count + 1);
		alph[i] = false;
	}
}

int main()
{
	// 단어 N개, 배우는 글자 K 개
	// anta ~ tica
	cin >> N >> K;

	alph['a' - 97] = true;
	alph['n' - 97] = true;
	alph['t' - 97] = true;
	alph['i' - 97] = true;
	alph['c' - 97] = true;

	K = K - 5;

	string temp;

	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		words.push_back(temp);
	}

	if (K < 0)
	{
		cout << 0 << endl;
		exit(0);
	}

	DFS(0, 0);

	cout << max_word << endl;

	return 0;
}