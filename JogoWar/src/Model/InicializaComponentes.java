package Model;

import java.util.Random;

// Padrão Singleton //
class InicializaComponentes {

	static int numeroDeTerritorios = 51; // Número de países //	
	static int numContinentes = 6;	
	
	
	private static InicializaComponentes ctrl = null;
	
	private InicializaComponentes() {}
	
	public static InicializaComponentes getInicializaComponentes() {
		if (ctrl == null) {
			ctrl = new InicializaComponentes();
		}
		
		return ctrl;
	}
	
	// Métodos da Classe //
	
	// Inicializa os territórios e suas fronteiras //
	protected Territorio[] inicializaTerritorios(Territorio[] listaTerritorios) {
		// Matriz onde o primeiro índice na primeira coluna 0 representa o pais, e o restante das colunas as suas fronteiras  //
		String [][] paisesFronteiras = new String[numeroDeTerritorios+1][numeroDeTerritorios+1]; 
		listaTerritorios = new Territorio[numeroDeTerritorios];
		String []Paises = new String[numeroDeTerritorios+1];
		Paises[0] ="";
		
		// America do Sul //
		Paises[1] = "Brasil";
		Paises[2] = "Argentina";
		Paises[3] = "Peru";
		Paises[4] = "Venezuela";
		
		// America do Norte //
		Paises[5] = "Mexico";
		Paises[6] = "Alasca";
		Paises[7] = "Groelandia";
		Paises[8] = "Calgary";
		Paises[9] = "California";
		Paises[10] = "Nova York";
		Paises[11] = "Quebec";
		Paises[12] = "Texas";
		Paises[13] = "Vancouver";
		
		// Asia //
		Paises[14] = "Arabia Saudita";
		Paises[15] = "Bangladesh";
		Paises[16] = "Cazaquistao";
		Paises[17] = "China";
		Paises[18] = "Coreia do Norte";
		Paises[19] = "Coreia do Sul";
		Paises[20] = "Estonia";
		Paises[21] = "India";
		Paises[22] = "Ira";
		Paises[23] = "Iraque";
		Paises[24] = "Japao";
		Paises[25] = "Jordania";
		Paises[26] = "Letonia";
		Paises[27] = "Mongolia";
		Paises[28] = "Paquistao";
		Paises[29] = "Russia";
		Paises[30] = "Siberia";
		Paises[31] = "Siria";
		Paises[32] = "Tailandia";
		Paises[33] = "Turquia";
		
		// Africa //
		Paises[34] = "Africa do Sul";
		Paises[35] = "Angola";
		Paises[36] = "Argelia";
		Paises[37] = "Egito";
		Paises[38] = "Nigeria";
		Paises[39] = "Somalia";
		
		// Europa //
		Paises[40] = "Espanha";
		Paises[41] = "Franca";
		Paises[42] = "Italia";
		Paises[43] = "Polonia";
		Paises[44] = "Reino Unido";
		Paises[45] = "Romenia";
		Paises[46] = "Suecia";
		Paises[47] = "Ucrania";
		
		// Oceania //
		Paises[48] = "Australia";
		Paises[49] = "Indonesia";
		Paises[50] = "Nova Zelandia";
		Paises[51] = "Perth";
		
		// Lista com todo os territórios //

		
		for ( int i=0; i < numeroDeTerritorios;i++) {
			listaTerritorios[i] = new Territorio();
		}
		
		
		
		for (int i=1; i <= numeroDeTerritorios;i++) {
			paisesFronteiras[i][0] = Paises[i];
		}
		
		/********* América do Sul ********/
		// Brasil [1][4] //
		paisesFronteiras[1][2] = Paises[2];		// 	Argentina	//
		paisesFronteiras[1][3] = Paises[3]; 	// 	Peru 		//
		paisesFronteiras[1][4] = Paises[4];		// 	Venezuela	//
		paisesFronteiras[1][38] = Paises[38];	// Nigeria		//
		// Argentina  [2][2] //
		paisesFronteiras[2][1] = Paises[1];		// 	Brasil	//
		paisesFronteiras[2][3] = Paises[3];		// 	Peru	//	
		// Peru [3][3] //
		paisesFronteiras[3][1] = Paises[1];		// 	Brasil	//
		paisesFronteiras[3][2] = Paises[2]; 	// 	Argentina	//
		paisesFronteiras[3][4] = Paises[4];		// 	Venezuela	//		
		// Venezuela [4][3] //
		paisesFronteiras[4][1] = Paises[1];		// 	Brasil	//
		paisesFronteiras[4][3] = Paises[3];		// 	Peru	//
		paisesFronteiras[4][5] = Paises[5];		// 	Mexico	//
		
		
		/********* América do Norte ******/
		// México [5][3] --  4, 9 e 12//
		paisesFronteiras[5][4] = Paises[4];		// 	Venezuela	//
		paisesFronteiras[5][9] = Paises[9];		// 	Califórnia	//
		paisesFronteiras[5][12] = Paises[12];	// 	Texas	//
		// Alasca [6][3]  -- 8, 13 e 30// 
		paisesFronteiras[6][8] = Paises[8];		// 	Calgary	//
		paisesFronteiras[6][13] = Paises[13];	// 	Vancouver	//
		paisesFronteiras[6][30] = Paises[30];	// 	Sibéria	//
		// Groelândia [7][3] -- 8, 11 e 44//
		paisesFronteiras[7][8] = Paises[8];		// 	Calgary	//
		paisesFronteiras[7][11] = Paises[11];	// 	Québec	//
		paisesFronteiras[7][44] = Paises[44];	// 	Reino Unido	//
		// Calgary [8][3] - 6, 7 e 13//
		paisesFronteiras[8][6] = Paises[6];		// 	Alasca	//
		paisesFronteiras[8][7] = Paises[7];		// 	Groelândia	//
		paisesFronteiras[8][13] = Paises[13];	// 	Vancouver	//
		// Califórnia [9][3] -- 5, 12 e 13//
		paisesFronteiras[8][5] = Paises[5];		// 	México	//
		paisesFronteiras[8][12] = Paises[12];	// 	Texas	//
		paisesFronteiras[8][13] = Paises[13];	// 	Vancouver	//
		// Nova York [10][2] -- 11 e 12//
		paisesFronteiras[10][11] = Paises[11];	// 	Québec	//
		paisesFronteiras[10][12] = Paises[12];	// 	Texas	//
		// Québec [11][4] -- 7, 10, 12 e 13//
		paisesFronteiras[11][7] = Paises[7];	// 	Groelândia	//
		paisesFronteiras[11][10] = Paises[10];	// 	Nova York	//
		paisesFronteiras[11][12] = Paises[12];	// 	Texas	//
		paisesFronteiras[11][13] = Paises[13];	// 	Vancouver	//
		// Texas [12][5] -- 5, 9, 10, 11 e 13//
		paisesFronteiras[12][5] = Paises[5];	// 	México	//
		paisesFronteiras[12][9] = Paises[9];	// 	Califórnia	//
		paisesFronteiras[12][10] = Paises[10];	// 	Nova York	//
		paisesFronteiras[12][11] = Paises[11];	// 	Québec	//
		paisesFronteiras[12][13] = Paises[13];	// 	Vancouver	//
		// Vancouver [13][5] -- 6, 8, 9, 11 e 12//
		paisesFronteiras[13][6] = Paises[6];	// 	Alasca	//
		paisesFronteiras[13][8] = Paises[8];	// 	Calgary	//
		paisesFronteiras[13][9] = Paises[9];	// 	Califórnia	//
		paisesFronteiras[13][11] = Paises[11];	// 	Québec	//
		paisesFronteiras[13][12] = Paises[12];	// 	Texas	//
		
		/********* Asia ******/
		// Arábia Saudita [14][3] -- 22, 25 e 39 //
		paisesFronteiras[14][22] = Paises[22];	// 		//
		paisesFronteiras[14][25] = Paises[25];	// 		//
		paisesFronteiras[14][39] = Paises[39];	// 		//
		// Bangladesh [15][4] -- 19, 21, 32 e 49//
		paisesFronteiras[15][19] = Paises[19];	// 		//
		paisesFronteiras[15][21] = Paises[21];	// 		//
		paisesFronteiras[15][32] = Paises[32];	// 		//
		paisesFronteiras[15][49] = Paises[49];	// 		//
		// Cazaquistão [16][7] -- 17, 24, 26, 27, 29, 30 e 33 //
		paisesFronteiras[16][17] = Paises[17];	// 		//
		paisesFronteiras[16][24] = Paises[24];	// 		//
		paisesFronteiras[16][26] = Paises[26];	// 		//
		paisesFronteiras[16][27] = Paises[27];	// 		//
		paisesFronteiras[16][29] = Paises[29];	// 		//
		paisesFronteiras[16][30] = Paises[30];	// 		//
		paisesFronteiras[16][33] = Paises[33];	// 		//
		// China [17][7] -- 16, 18, 19, 21, 27, 28 e 33//
		paisesFronteiras[17][16] = Paises[16];	// 		//
		paisesFronteiras[17][18] = Paises[18];	// 		//
		paisesFronteiras[17][19] = Paises[19];	// 		//
		paisesFronteiras[17][21] = Paises[21];	// 		//
		paisesFronteiras[17][27] = Paises[27];	// 		//
		paisesFronteiras[17][28] = Paises[28];	// 		//
		paisesFronteiras[17][33] = Paises[33];	// 		//
		// Coréia do Norte [18][3] -- 17, 19 e 24//
		paisesFronteiras[18][17] = Paises[17];	// 		//
		paisesFronteiras[18][19] = Paises[19];	// 		//
		paisesFronteiras[18][24] = Paises[24];	// 		//
		// Coréia do Sul [19][5] --  15, 17, 18, 21 e 32//
		paisesFronteiras[19][15] = Paises[15];	// 		//
		paisesFronteiras[19][17] = Paises[17];	// 		//
		paisesFronteiras[19][18] = Paises[18];	// 		//
		paisesFronteiras[19][21] = Paises[21];	// 		//
		paisesFronteiras[19][32] = Paises[32];	// 		//
		// Estônia [20][3] -- 26, 29 e 46//
		paisesFronteiras[20][26] = Paises[26];	// 		//
		paisesFronteiras[20][29] = Paises[29];	// 		//
		paisesFronteiras[20][46] = Paises[46];	// 		//
		// Índia [21][5] -- 15, 17, 19, 28 e 49//
		paisesFronteiras[21][15] = Paises[15];	// 		//
		paisesFronteiras[21][17] = Paises[17];	// 		//
		paisesFronteiras[21][19] = Paises[19];	// 		//
		paisesFronteiras[21][28] = Paises[28];	// 		//
		paisesFronteiras[21][49] = Paises[49];	// 		//
		// Irã [22][3] -- 23, 28 e 31//
		paisesFronteiras[22][23] = Paises[23];	// 		//
		paisesFronteiras[22][28] = Paises[28];	// 		//
		paisesFronteiras[22][31] = Paises[31];	// 		//
		// Iraque [23][4] -- 14, 22, 25 e 31//
		paisesFronteiras[23][14] = Paises[14];	// 		//
		paisesFronteiras[23][22] = Paises[22];	// 		//
		paisesFronteiras[23][25] = Paises[25];	// 		//
		paisesFronteiras[23][31] = Paises[31];	// 		//
		// Japão [24][3] -- 16, 18 e 27//
		paisesFronteiras[24][16] = Paises[16];	// 		//
		paisesFronteiras[24][18] = Paises[18];	// 		//
		paisesFronteiras[24][27] = Paises[27];	// 		//
		// Jordânia [25][4] -- 14, 23, 30 e 37//
		paisesFronteiras[25][14] = Paises[14];	// 		//
		paisesFronteiras[25][23] = Paises[23];	// 		//
		paisesFronteiras[25][30] = Paises[30];	// 		//
		paisesFronteiras[25][37] = Paises[37];	// 		//
		// Letônia [26][7] -- 16, 20, 29, 33, 43, 46 e 47//
		paisesFronteiras[26][16] = Paises[16];	// 		//
		paisesFronteiras[26][20] = Paises[20];	// 		//
		paisesFronteiras[26][29] = Paises[29];	// 		//
		paisesFronteiras[26][33] = Paises[33];	// 		//
		paisesFronteiras[26][43] = Paises[43];	// 		//
		paisesFronteiras[26][46] = Paises[46];	// 		//
		paisesFronteiras[26][47] = Paises[47];	// 		//
		// Mongólia [27][3] -- 16 17 24//
		paisesFronteiras[27][16] = Paises[16];	// 		//
		paisesFronteiras[27][17] = Paises[17];	// 		//
		paisesFronteiras[27][24] = Paises[24];	// 		//
		// Paquistão [28][5] -- 17, 21, 22, 31 e 33//
		paisesFronteiras[28][17] = Paises[17];	// 		//
		paisesFronteiras[28][21] = Paises[21];	// 		//
		paisesFronteiras[28][22] = Paises[22];	// 		//
		paisesFronteiras[28][31] = Paises[31];	// 		//
		paisesFronteiras[28][33] = Paises[33];	// 		//
		// Russia [29][4] -- 16, 20, 26 e 30//
		paisesFronteiras[29][16] = Paises[16];	// 		//
		paisesFronteiras[29][20] = Paises[20];	// 		//
		paisesFronteiras[29][26] = Paises[26];	// 		//
		paisesFronteiras[29][30] = Paises[30];	// 		//
		// Sibéria [30][3] -- 6, 16 e 29//
		paisesFronteiras[30][6] = Paises[6];	// 		//
		paisesFronteiras[30][16] = Paises[16];	// 		//
		paisesFronteiras[30][29] = Paises[29];	// 		//
		// Siria [31][5] -- 22, 23, 25, 28 e 33//
		paisesFronteiras[31][22] = Paises[22];	// 		//
		paisesFronteiras[31][23] = Paises[23];	// 		//
		paisesFronteiras[31][25] = Paises[25];	// 		//
		paisesFronteiras[31][28] = Paises[28];	// 		//
		paisesFronteiras[31][33] = Paises[33];	// 		//
		// Tailândia [32][2] -- 15 e 19//
		paisesFronteiras[32][15] = Paises[15];	// 		//
		paisesFronteiras[32][19] = Paises[19];	// 		//
		// Turquia [33][5] 16, 17, 26, 28 e 31//
		paisesFronteiras[33][16] = Paises[16];	// 		//
		paisesFronteiras[33][17] = Paises[17];	// 		//
		paisesFronteiras[33][26] = Paises[26];	// 		//
		paisesFronteiras[33][28] = Paises[28];	// 		//
		paisesFronteiras[33][31] = Paises[31];	// 		//
		
		/********* Africa ******/
		// Africa do Sul [34][2] -- 35 e 39//
		paisesFronteiras[34][35] = Paises[35];	// 	Angola	//
		paisesFronteiras[34][39] = Paises[39];	// Somália	//
		// Angola [35][3] -- 34, 36 e 39 //
		paisesFronteiras[35][34] = Paises[34];	// 	Africa do Sul	//
		paisesFronteiras[35][36] = Paises[36];	// 	Argélia	//
		paisesFronteiras[35][39] = Paises[39];	// 	Somália	//
		// Argélia [36][4] -- 37, 38, 40 e 42//
		paisesFronteiras[36][37] = Paises[37];	// 	Egito	//
		paisesFronteiras[36][38] = Paises[38];	// 	Nigéria	//
		paisesFronteiras[36][40] = Paises[40];	// 	Espanha	//
		paisesFronteiras[36][42] = Paises[42];	// 	Itália	//
		// Egito [37][5] -- 36, 38, 39 , 25 e 45//
		paisesFronteiras[37][25] = Paises[25];	// 	Jordânia	//
		paisesFronteiras[37][36] = Paises[36];	// 	Argélia	//
		paisesFronteiras[37][38] = Paises[38];	// 	Nigéria	//
		paisesFronteiras[37][39] = Paises[39];	// 	Somália	//
		paisesFronteiras[37][45] = Paises[45];	// 	Romênia	//
		// Nigéria [38][5] -- 35, 36, 37, 39 e 1//
		paisesFronteiras[38][1] = Paises[1];	// 	Brasil	//
		paisesFronteiras[38][35] = Paises[35];	// 	Angola	//
		paisesFronteiras[38][36] = Paises[36];	// 	Argélia	//
		paisesFronteiras[38][37] = Paises[37];	// 	Egito	//
		paisesFronteiras[38][39] = Paises[39];	// 	Somália	//
		// Somália [39][5] -- 34, 35, 37, 38 e 14//
		paisesFronteiras[39][14] = Paises[14];	// 	Arábia Saudita	//
		paisesFronteiras[39][34] = Paises[34];	// 	Africa do Sul	//
		paisesFronteiras[39][35] = Paises[35];	// 	Angola	//
		paisesFronteiras[39][37] = Paises[37];	// 	Egito	//
		paisesFronteiras[39][38] = Paises[38];	// 	Nigéria	//

		/********* Europa ******/
		// Espanha [40][2] -- 41 e 36//
		paisesFronteiras[40][36] = Paises[36];	// 	Argélia	//
		paisesFronteiras[40][41] = Paises[41];	// 	França	//
		// França [41][4] -- 40, 42, 44 e 46//
		paisesFronteiras[41][40] = Paises[40];	// 	Espanha	//
		paisesFronteiras[41][42] = Paises[42];	// 	Itália	//
		paisesFronteiras[41][44] = Paises[44];	// 	Reino Unido	//
		paisesFronteiras[41][46] = Paises[46];	// 	Suécia	//
		// Itália [42][5] -- 41, 43, 45, 46 e 36 //
		paisesFronteiras[42][36] = Paises[36];	// 	Argélia	//
		paisesFronteiras[42][41] = Paises[41];	// 	França	//
		paisesFronteiras[42][43] = Paises[43];	// 	Polônia	//
		paisesFronteiras[42][45] = Paises[45];	// 	Romênia	//
		paisesFronteiras[42][46] = Paises[46];	// 	Suécia	//
		// Polônia [43][4] -- 42, 45, 47 e 26//
		paisesFronteiras[43][26] = Paises[26];	// 	Letônia	//
		paisesFronteiras[43][42] = Paises[42];	// 	Itália	//
		paisesFronteiras[43][45] = Paises[45];	// 	Romênia	//
		paisesFronteiras[43][47] = Paises[47];	// 	Ucrânia	//
		// Reino Unido [44][2] -- 41 e 7//
		paisesFronteiras[44][7] = Paises[7];	// 	Groelândia	//
		paisesFronteiras[44][41] = Paises[41];	// 	França	//
		// Romênia [45][4] -- 47, 43, 42 e 37//
		paisesFronteiras[45][37] = Paises[37];	// 	Egito	//
		paisesFronteiras[45][42] = Paises[42];	// 	Itália	//
		paisesFronteiras[45][43] = Paises[43];	// 	Polônia	//
		paisesFronteiras[45][47] = Paises[47];	// 	Ucrânia	//
		// Suécia [46][4] -- 41, 42, 26 e 20//
		paisesFronteiras[46][20] = Paises[20];	// 	Estônia	//
		paisesFronteiras[46][26] = Paises[26];	// 	Letônia	//
		paisesFronteiras[46][41] = Paises[41];	// 	França	//
		paisesFronteiras[46][42] = Paises[42];	// 	Itália	//
		// Ucrânia [47][4] -- 26 44 43 e 33//
		paisesFronteiras[47][26] = Paises[26];	// 	Letônia	//
		paisesFronteiras[47][33] = Paises[33];	// 	Turquia	//
		paisesFronteiras[47][43] = Paises[43];	// 	Polônia	//
		paisesFronteiras[47][44] = Paises[44];	// 	Reino Unido	//
		
		/********* Oceania ******/
		// Austrália [48][3] -- 49, 50 e 51//
		paisesFronteiras[48][49] = Paises[49];	// 	Indonésia	//
		paisesFronteiras[48][50] = Paises[50];	// 	Nova Zelândia	//
		paisesFronteiras[48][51] = Paises[51];	// 	Perth	//
		// Indonésia [49][4] -- 15, 21, 48 e 50//
		paisesFronteiras[49][15] = Paises[15];	// 	Bangladesh	//
		paisesFronteiras[49][21] = Paises[21];	// 	Índia	//
		paisesFronteiras[49][48] = Paises[48];	// 	Austrália	//
		paisesFronteiras[49][50] = Paises[50];	// 	Nova Zelândia	//
		// Nova Zelândia [50][2] -- 48 e 49//
		paisesFronteiras[50][48] = Paises[48];	// 	Austrália	//
		paisesFronteiras[50][49] = Paises[49];	// 	Indonésia	//
		// Perth [51][1] -- 48//
		paisesFronteiras[51][48] = Paises[48];	// 	Austrália	//
		
		for ( int i = 0; i < numeroDeTerritorios; i++) {
			listaTerritorios[i].setNomeTerritorio(Paises[i+1]);
			listaTerritorios[i].setdonoTerritorio(null);
			listaTerritorios[i].setNumExercitos(0);
			listaTerritorios[i].setCorExercito(null);
			listaTerritorios[i].setFronteiras(paisesFronteiras[i+1]);			
		}		
		
		return listaTerritorios;
		
	} 		
	
	// Inicializa os Continentes //
	protected Continente[] defineContinentes(Territorio[] listaTerritorios) {
		int i=0;
		Continente[] listaContinentes = new Continente[numContinentes];
		
		for( i=0; i < numContinentes;i++) {
			listaContinentes[i] = new Continente();
		}
		
		/* América do Sul */
		Territorio[] americaSul = new Territorio[4];		 
		for( i=0 ; i < 4;i++) {
			americaSul[i]=new Territorio();
		}
		americaSul[0]=listaTerritorios[0];
		americaSul[1]=listaTerritorios[1];
		americaSul[2]=listaTerritorios[2];
		americaSul[3]=listaTerritorios[3];
		listaContinentes[0].setNomeContinente("America do Sul");
		listaContinentes[0].setNumTerritorios(4);
		listaContinentes[0].setTerritoriosContinente(americaSul);
		
		
		/* América do Norte */
		Territorio[] americaNorte = new Territorio[9];		 
		for( i=0 ; i < 9;i++) {
			americaNorte[i]=new Territorio();
		}
		americaNorte[0]=listaTerritorios[4];
		americaNorte[1]=listaTerritorios[5];
		americaNorte[2]=listaTerritorios[6];
		americaNorte[3]=listaTerritorios[7];
		americaNorte[4]=listaTerritorios[8];
		americaNorte[5]=listaTerritorios[9];
		americaNorte[6]=listaTerritorios[10];
		americaNorte[7]=listaTerritorios[11];
		americaNorte[8]=listaTerritorios[12];
		
		listaContinentes[1].setNomeContinente("America do Norte");
		listaContinentes[1].setNumTerritorios(9);
		listaContinentes[1].setTerritoriosContinente(americaNorte);
		
		
		/* Asia */
		Territorio[] asia = new Territorio[20];		 
		for( i=0 ; i < 20;i++) {
			asia[i]=new Territorio();
		}
		asia[0]=listaTerritorios[13];
		asia[1]=listaTerritorios[14];
		asia[2]=listaTerritorios[15];
		asia[3]=listaTerritorios[16];
		asia[4]=listaTerritorios[17];
		asia[5]=listaTerritorios[18];
		asia[6]=listaTerritorios[19];
		asia[7]=listaTerritorios[20];
		asia[8]=listaTerritorios[21];
		asia[9]=listaTerritorios[22];
		asia[10]=listaTerritorios[23];
		asia[11]=listaTerritorios[24];
		asia[12]=listaTerritorios[25];
		asia[13]=listaTerritorios[26];
		asia[14]=listaTerritorios[27];
		asia[15]=listaTerritorios[28];
		asia[16]=listaTerritorios[29];
		asia[17]=listaTerritorios[30];
		asia[18]=listaTerritorios[31];
		asia[19]=listaTerritorios[32];
		
		listaContinentes[2].setNomeContinente("Asia");
		listaContinentes[2].setNumTerritorios(20);
		listaContinentes[2].setTerritoriosContinente(asia);		
		
		/* Africa */
		Territorio[] africa = new Territorio[6];		 
		for( i=0 ; i < 6;i++) {
			africa[i]=new Territorio();
		}
		africa[0]=listaTerritorios[33];
		africa[1]=listaTerritorios[34];
		africa[2]=listaTerritorios[35];
		africa[3]=listaTerritorios[36];
		africa[4]=listaTerritorios[37];
		africa[5]=listaTerritorios[38];
		
		listaContinentes[3].setNomeContinente("Africa");
		listaContinentes[3].setNumTerritorios(6);
		listaContinentes[3].setTerritoriosContinente(africa);		
		
		/* Europa */
		Territorio[] europa = new Territorio[8];		 
		for( i=0 ; i < 8;i++) {
			europa[i]=new Territorio();
		}
		europa[0]=listaTerritorios[39];
		europa[1]=listaTerritorios[40];
		europa[2]=listaTerritorios[41];
		europa[3]=listaTerritorios[42];
		europa[4]=listaTerritorios[43];
		europa[5]=listaTerritorios[44];
		europa[6]=listaTerritorios[45];
		europa[7]=listaTerritorios[46];
		
		listaContinentes[4].setNomeContinente("Europa");
		listaContinentes[4].setNumTerritorios(8);
		listaContinentes[4].setTerritoriosContinente(europa);		
		
		/* Oceania */
		Territorio[] oceania = new Territorio[4];		 
		for( i=0 ; i < 4;i++) {
			oceania[i]=new Territorio();
		}
		oceania[0]=listaTerritorios[47];
		oceania[1]=listaTerritorios[48];
		oceania[2]=listaTerritorios[49];
		oceania[3]=listaTerritorios[50];
		listaContinentes[5].setNomeContinente("Oceania");
		listaContinentes[5].setNumTerritorios(4);
		listaContinentes[5].setTerritoriosContinente(oceania);			
		
		
		return listaContinentes;
		
	}
	
	
	// Define informações dos jogadores //
	protected Jogador[] defineJogadores(String [] StrJogadores, String[] CorJogadores) {
			Jogador[] lstJogadores = new Jogador[StrJogadores.length];
			
			for ( int i=0; i < StrJogadores.length;i++) {
				lstJogadores[i] = new Jogador();
			}
			
			for ( int i = 0; i < CorJogadores.length;i++) {
				
			}

			
			for (int j =0; j < StrJogadores.length; j++) {
				for( int i = 0 ; i < StrJogadores.length; i++) {
					if( lstJogadores[i].getnomeJogador() != null) {
						if (lstJogadores[i].getnomeJogador().equals(StrJogadores[j]) == true) {
							System.out.println("Nome repetidos, insira outros nomes!");
							return null;
						}
					}
				}
						
				for( int i = 0 ; i < StrJogadores.length; i++) { 
					if(lstJogadores[i].getColor() != null) {
						if (lstJogadores[i].getColor().equals(CorJogadores[j]) == true) {
							System.out.println("Cor repetida, inisra outras cores!");
							return null;
						}
					}
				}
				
				lstJogadores[j].setCor(CorJogadores[j]);
				lstJogadores[j].setnomeJogador(StrJogadores[j]);
			}
			
			return lstJogadores;
		}
		
		
	// Define os donos dos exércitos
	protected Exercito[] defineExercitos(Jogador[] listaJogadores) {
			
			Exercito Ex[] = new Exercito[listaJogadores.length];
			
			for (int i=0; i< listaJogadores.length;i++) {
				Ex[i] = new Exercito();
				Ex[i].setCorExercito(listaJogadores[0].getColor());
				Ex[i].setdonoExercito(listaJogadores[0]);
				Ex[i].setQTDExercito(0);
			}

			return Ex;
	}
	
	
	// Define os donos territórios iniciais // Utiliza inicializaTerritorios() e defineJogadores() //
	protected Jogador[] defineDonoTerritorios(Jogador[] listaJogadores, Territorio[] listaTerritorios, Exercito[] Exercitos, Cartas C) {
		C = Cartas.getCartas();
		int numJogadores = listaJogadores.length;
		int i=0, j=0,jogAlvo;		
		int qtdTerritoriosPorJogador = numeroDeTerritorios/numJogadores;
		Territorio UmTerritorio;
		Jogador[] listaJogOrdenada = new Jogador[numJogadores];		
		Dado d = new Dado();
		Random gerador = new Random();

		// Definição da ordem dos Jogadores //
		System.out.println("Ordem dos Jogadores");
		d.setOrdemJogador(listaJogadores);
		
		// Apresentação da ordem dos Jogadores //
		for ( i = 0; i < numJogadores; i++) {			
			System.out.println("Jogador: " + listaJogadores[i].getnomeJogador()+" "+
								listaJogadores[i].getOrdemJogador()+"º a jogar");
			listaJogOrdenada[listaJogadores[i].getOrdemJogador()-1] = listaJogadores[i];			
		}		
		
		// Retirada de cartas território em ordem //
		for ( i = 0; i < qtdTerritoriosPorJogador; i ++) {
			for( j = 0; j < listaJogadores.length;j++) {
				// Verifica se o território pode ser daquele jogador, se sim, adiciona aquele jogador como dono do território (setDono)(setCor) e coloca 1 exercito //
				UmTerritorio = C.retiraCartaTerritorio(listaTerritorios,listaJogOrdenada,listaJogOrdenada[j].getnomeJogador());
				// Coloca o território em posse do jogador //
				listaJogOrdenada[j].setUmTerritorio(UmTerritorio);
				// Adiciona 1 ao número de territórios do jogador //
				listaJogOrdenada[j].setnumTerritoriosJog(listaJogOrdenada[j].getnumTerritoriosJog()+1);
				
				// Adiciona 1 unidade ao Exército da cor do jogador //
				for (int t=0; t < numJogadores;t++) {
					if (Exercitos[t].getCorExercito()==listaJogOrdenada[j].getColor()) {
						Exercitos[t].setQTDExercito(Exercitos[t].getQTDExercito()+1);
						t=numJogadores;
					}
				}
				
				listaJogOrdenada[j].setNumExercitos(listaJogOrdenada[j].getNumExercitos()+1);
				
				System.out.println(" O Jogador "+listaJogOrdenada[j].getnomeJogador()+" recebe a carta territorio "+UmTerritorio.getNomeTerritorio());

			}
		}
		
		for ( i=0; i < listaTerritorios.length;i++) {
			jogAlvo = gerador.nextInt(listaJogOrdenada.length-1);
			if (listaTerritorios[i].getdonoTerritorio()==null) {
				listaTerritorios[i].setCorExercito(listaJogOrdenada[jogAlvo].getColor());
				listaTerritorios[i].setdonoTerritorio(listaJogOrdenada[jogAlvo].getnomeJogador());
				listaTerritorios[i].setNumExercitos(1);
				
				listaJogOrdenada[jogAlvo].setNumExercitos(listaJogOrdenada[jogAlvo].getNumExercitos()+1);
				listaJogOrdenada[jogAlvo].setUmTerritorio(listaTerritorios[i]);
				listaJogOrdenada[jogAlvo].setnumTerritoriosJog(listaJogOrdenada[jogAlvo].getnumTerritoriosJog()+1);
				
				for (int t=0; t < numJogadores;t++) {
					if (Exercitos[t].getCorExercito()==listaJogOrdenada[jogAlvo].getColor()) {
						Exercitos[t].setQTDExercito(Exercitos[t].getQTDExercito()+1);
						break;
					}
				}
				
			}
				
			
		}

		listaJogadores = listaJogOrdenada;
		
		return listaJogadores;
		
	}
	
	// Cria uma lista de Objetivos de acordo com o número de jogadores e define seus donos //
	// Implementar o caso de ter menos de 6 jogadores (menos objetivos) //
	public Objetivo[] defineDonoObjetivos(Jogador[] listaJogadores, Objetivo[] Objetivos, Cartas C) {
		Objetivo Objtemp = new Objetivo();
		C = Cartas.getCartas();
		
		/*– Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro. OK
		– Conquistar na totalidade a ASIA e a AMÉRICA DO SUL. OK
		– Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro. OK
		– Conquistar na totalidade a ASIA e a ÁFRICA. OK
		– Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA. OK
		– Conquistar 24 TERRITÓRIOS à sua escolha. OK
		– Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA. OK
		– Destruir totalmente OS EXÉRCITOS AZUIS. OK
		– Destruir totalmente OS EXÉRCITOS AMARELOS. OK
		– Destruir totalmente OS EXÉRCITOS VERMELHOS. OK
		– Destruir totalmente OS EXÉRCITOS PRETOS. OK
		– Destruir totalmente OS EXÉRCITOS BRANCO. OK
		– Destruir totalmente OS EXÉRCITOS VERDES. OK */
		
		// Instancia a lista de Objetivos //
		Objetivos = new Objetivo[13];		
			for ( int i=0; i < Objetivos.length;i++) {
				Objetivos[i]= new Objetivo();
		}
			Objetivos[0].setContinentes(null); 		// Continentes necessários para ganhar					//
			Objetivos[0].setDonoObjetivo(null); 	// Dono do Objetivo que será escolhido aleatoriamente 	//
			Objetivos[0].setExercitos("Vermelho"); 	// Exército que precisa ser destrído para ganhar 		//
			Objetivos[0].setTerritorios(1); 		// Quantidade de territórios necessários para ganhar	//
			 
			String[] eaS = new String [2];
			eaS[0] = "Europa";
			eaS[1] = "America do Sul";
			Objetivos[1].setContinentes(eaS); 				
			Objetivos[1].setDonoObjetivo(null); 	
			Objetivos[1].setExercitos("nenhum"); 	
			Objetivos[1].setTerritorios(0); 

			Objetivos[2].setContinentes(null); 				
			Objetivos[2].setDonoObjetivo(null); 	
			Objetivos[2].setExercitos("Verde"); 	
			Objetivos[2].setTerritorios(1);
			
			Objetivos[3].setContinentes(null); 				
			Objetivos[3].setDonoObjetivo(null); 	
			Objetivos[3].setExercitos("Azul"); 	
			Objetivos[3].setTerritorios(1);
			
			Objetivos[4].setContinentes(null); 				
			Objetivos[4].setDonoObjetivo(null); 	
			Objetivos[4].setExercitos("Preto"); 	
			Objetivos[4].setTerritorios(1);		
			
			Objetivos[5].setContinentes(null); 				
			Objetivos[5].setDonoObjetivo("nenhum"); 	
			Objetivos[5].setExercitos("Branco"); 	
			Objetivos[5].setTerritorios(1);
			
			Objetivos[6].setContinentes(null); 				
			Objetivos[6].setDonoObjetivo(null); 	
			Objetivos[6].setExercitos("Amarelo"); 	
			Objetivos[6].setTerritorios(1);

			Objetivos[7].setContinentes(null); 				
			Objetivos[7].setDonoObjetivo(null); 	
			Objetivos[7].setExercitos("nenhum"); 	
			Objetivos[7].setTerritorios(24);
			
			String[] aNo = new String [2];
			aNo[0] = "America do Norte";
			aNo[1] = "Oceania";
			Objetivos[8].setContinentes(aNo); 				
			Objetivos[8].setDonoObjetivo(null); 	
			Objetivos[8].setExercitos("nenhum"); 	
			Objetivos[8].setTerritorios(0);
			
			String[] aNa = new String [2];
			aNa[0] = "America do Norte";
			aNa[1] = "Africa";
			Objetivos[9].setContinentes(aNa); 				
			Objetivos[9].setDonoObjetivo(null); 	
			Objetivos[9].setExercitos("nenhum"); 	
			Objetivos[9].setTerritorios(0);
			
			String[] aa = new String [2];
			aa[0] = "Africa";
			aa[1] = "Asia";
			Objetivos[10].setContinentes(aa); 				
			Objetivos[10].setDonoObjetivo(null); 	
			Objetivos[10].setExercitos("nenhum"); 	
			Objetivos[10].setTerritorios(0);
			
			String[] aSa = new String [2];
			aSa[0] = "America do Sul";
			aSa[1] = "Asia";
			Objetivos[11].setContinentes(aSa); 				
			Objetivos[11].setDonoObjetivo(null); 	
			Objetivos[11].setExercitos("nenhum"); 	
			Objetivos[11].setTerritorios(0);
			
			String[] eo = new String [2];
			eo[0] = "Europa";
			eo[1] = "Oceania";
			Objetivos[12].setContinentes(eo); 				
			Objetivos[12].setDonoObjetivo(null); 	
			Objetivos[12].setExercitos("nenhum"); 	
			Objetivos[12].setTerritorios(0);
		///				///				///
		
		// Escolhe um objetivo aleatório para os jogadores //
		for(int i=0; i < listaJogadores.length;i++ ) {
			Objtemp = C.retiraCartaObjetivo(Objetivos, listaJogadores, listaJogadores[i].getnomeJogador() );
			listaJogadores[i].setObjetivo(Objtemp);
			System.out.println("Objetivos do Jogador: "+listaJogadores[i].getnomeJogador());
			System.out.println("Exercitos a serem destruídos para ganhar: "+listaJogadores[i].getObjetivo().getExercitos());
			System.out.println("Continentes necessários para ganhar: ");
			if(listaJogadores[i].getObjetivo().getContinentes()!=null) {
				for(int j=0;j<listaJogadores[i].getObjetivo().getContinentes().length;j++) {
					String []a = new String[listaJogadores[i].getObjetivo().getContinentes().length];
					a = listaJogadores[i].getObjetivo().getContinentes();
					System.out.println("\t"+a[j]);
	
				}
			}
			
			System.out.println("Territorios necessários para ganhar: "+listaJogadores[i].getObjetivo().getTerritorios());
		}
		return Objetivos;
		
	}
	

}
	
	
	
	
	
	
	
	
	
	
	

