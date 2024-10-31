#include<bits/stdc++.h>
using namespace std;

 
long long findSuccessor(long long &n) 
{	 long long t=n,gg=0;
    int numlen=trunc(log10(n)+1);
 	 vector<int> v;
 	while(numlen--){
        v.push_back(t%10);
        t = t/10;
    }
 	reverse(v.begin(),v.end());
 	next_permutation(v.begin(),v.end());
 	for(int x:v){
         
        gg = (gg*10)+x;
        
    }
 	if(gg>n){
 	return gg;
    }
 	else{
        return -1;
    }
}


int main(){

    long long num = 321;
    
    long long found =  findSuccessor(num) ;
    cout <<found;


    return 0;
}
