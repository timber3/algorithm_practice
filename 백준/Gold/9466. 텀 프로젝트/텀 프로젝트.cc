#include <iostream>
#include <algorithm>


using namespace std;

int n, t, answer;
int choose[100010];
bool visited[100010];
bool done[100010];

void check_cycle(int cur){    
    visited[cur] = true;
    
    int next = choose[cur];
    
    if(!visited[next]){
        check_cycle(next);
    }
    else if(!done[next]){
        for(int i=next;i!=cur;i=choose[i]){
            answer++;
        }
        answer++;
    }
    
    done[cur] = true;
}


int main(int argc, char* argv[]) {
	ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    
    while(t--){
        cin >> n;
        answer = 0;
        
        for(int i=1;i<=n;i++){
            cin >> choose[i];
            visited[i] = false;
            done[i] = false;
        }
        
        for(int i=1;i<=n;i++){       
            if(!visited[i]) check_cycle(i);
        }
        
        cout << n - answer << '\n';
    }
	
	return 0;
}