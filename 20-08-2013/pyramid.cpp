#include <iostream>;
using namespace std;

int main(){
	cout<<"Ingrese la altura de la piramide"<<endl;
	int altura=0;
	cin>>altura;
	for(int i=0; i<altura;i++){
		for(int k=i;k<altura-1;k++) 
			cout<<" ";
		for(int j=0; j<i+1 ; j++)						
			cout<<"* ";
		cout<<endl;
	}	
	return 0;
}
