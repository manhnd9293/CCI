#include <iostream>
#include <string>

using namespace std;

int insertion(int m, int n, int i, int j){
    int res = n;
    int mask = ((1 << (j-i+1)) - 1) << i;
    mask = ~mask;
    res &= mask;
    mask = m << i;
    res |= mask;
    return res;
}

string bintoStr(double n){
    string s;
    s += '.';
    char d;
    int count = 1;
    while(n != 0){
        count++;
        if(count > 32) return "Error";
        d = ((n *2 ) >= 1 ? '1' : '0');
        s += d;
        if(2*n >= 1) n = 2*n-1;
        else n = 2*n;
    }
    return s;

}

int maxFlip(int n){
    if(n == 0) return 0;
    if(~n == 0) return 32;
    int max = 1;
    int prev = 0, cur = 0;

    while(n != 0){
        prev = cur;
        cur = 0;

        /*find the longest consecutive 1s*/
        while((n & 1) != 0){
            cur++;
            n >>= 1;
        }
        if(prev + cur + 1 > max) max =prev + cur + 1;
        if(n != 0) n >>= 1;
    }
    return max;
}


int main()
{
    string s = bintoStr(0.75);
    cout << s << endl;
}
