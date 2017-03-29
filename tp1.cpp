#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
using namespace std;

int main (int args, char* argsv[]) {
	ifstream entrada;
	entrada.open(argsv[1]);
	string cabecera;
	getline(entrada, cabecera); // La primera linea contiene la cantida de equipos y partidos
	vector<string> tamanio = split(cabecera, ' ');

	int equipos = stoi(tamanio[0]);
	int partidos = stoi(tamanio[1]);
	
	int matriz[equipos][equipos + 1]; // deberia ser float?

	//Inicializar matriz con 2 en la diagonal (menos ultima columna)
	// y 1 en la ultima columna

	string linea;
	int i = 0;
	while (i < partidos){
		getline(entrada, linea);
		vector<string> resultado = split(linea, ' ');
		int equipo_1 = stoi(resultado[1]);
		int resultado_1 = stoi(resultado[2]);
		int equipo_2 = stoi(resultado[3]);
		int resultado_2 = stoi(resultado[4]);
		matriz[equipo_1 - 1][equipo_2 - 1] -= 1; // Partido entre ellos
		matriz[equipo_2 - 1][equipo_1 - 1] -= 1;
		matriz[equipo_1 - 1][equipo_1 - 1] += 1; // Partidos totales
		matriz[equipo_2 - 1][equipo_2 - 1] += 1;


		if (resultado_1 > resultado_2){
			matriz[equipo_1 - 1][equipos] += 1/2;
			matriz[equipo_2 - 1][equipos] -= 1/2;
		}else{
			matriz[equipo_1 - 1][equipos] -= 1/2;
			matriz[equipo_2 - 1][equipos] += 1/2;
		}
	}
}

template<typename Out>
void split(const std::string &s, char delim, Out result) {
    stringstream ss;
    ss.str(s);
    string item;
    while (getline(ss, item, delim)) {
        *(result++) = item;
    }
}


vector<string> split(const string &s, char delim) {
    vector<string> elems;
    split(s, delim, sback_inserter(elems));
    return elems;
}