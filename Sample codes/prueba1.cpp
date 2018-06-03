//Ejemplo C++ 1
#include <iostream>
#include <thread>
#include <vector>
using namespace std;

void funcion() {
	cout << "Hola" << endl;
}

int main() {
	vector<thread> hilos;
	for(int i=0; i<5; i++) {
		//hilos.push_back(thread(funcion));
		hilos.push_back(thread([](){cout << "Hola" << endl;}));	//Función lambda
	}
	for(auto& thread:hilos) {
		thread.join();
	}
	return 0;
}
