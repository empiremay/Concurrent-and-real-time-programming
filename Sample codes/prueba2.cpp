//Ejemplo C++ 2
#include <iostream>
#include <thread>
#include <vector>
#include <mutex>
using namespace std;

struct contador {
	mutex cerrojo;
	int valor;
	
	contador(): valor(0) {}	
	
	void inc() {
		cerrojo.lock();
		valor++;
		cerrojo.unlock();
	}	
	void dec() {
		cerrojo.lock();
		valor--;
		cerrojo.unlock();
	}
};

int main() {
	return 0;
}
