#include <iostream>
#include <vector>
using namespace std;


int findIndexMax(vector <int> h, int start, int end){
    int imax = start;
    for(int i = start+1; i <= end; i++){
        if(h[i] > h[imax]){
            imax = i;
        }
    }
    return imax;
}
int borderVolume(vector <int> h, int start, int end){
    int sum = 0;
    int min = h[start] > h[end] ? h[start] : h[end];
    for(int i = start+1; i < end; i++){
        sum += min - h[i];
    }
    return sum;
}
int subGraph(vector <int> h, int start, int end, bool isLeft){
    if(start == end) return 0;

    int sum = 0;
    if(isLeft){
        int max = findIndexMax(h,start, end-1);
        sum += borderVolume(h,max, end);
        sum += subGraph(h,start,max,true);
    } else {
        int max = findIndexMax(h, start+1, end);
        sum += borderVolume(h,start, max);
        sum += subGraph(h, max, end,false);
    }
    return sum;
}

int volumeH(vector <int> h, int start, int end){
    int imax = findIndexMax(h, start, end);
    int sum = 0;
    vector <int> leftMaxes (h.size());
    vector <int> rightMaxes (h.size());
    int left_imax = 0;

    for(int i = 0; i < h.size(); i++){
        if(h[i] > h[left_imax]){
            left_imax = i;
        }
        leftMaxes[i] = left_imax;
    }

    int right_imax = h.size()-1;
    for(int i = h.size()-1; i >=  0; i--){
        if(h[i] > h[right_imax]){
            right_imax = i;
        }
        rightMaxes[i] = right_imax;
    }

    sum += subGraph(h, start, imax, true) + subGraph(h, imax,end, false);
}



int main()
{
    cout << "Hello World!" << endl;
    return 0;
}
