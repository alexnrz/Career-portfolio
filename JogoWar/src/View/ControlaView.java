package View;

import javax.swing.JOptionPane;

import Controller.ControlaJogo;
import Model.Ctrl;
import Model.ObservadoIF;
import Model.ObservadorIF;

public class ControlaView implements ObservadorIF {
	
	int qtdJogadores;
	private int qtdEx;
	private int faseCtrl = 0;
	private int jogAlvoCtrl  =0;
	private int qtdExAtk;
	private int qtdExDef;
	private String corAtk;
	private String territorioAtacante;
	private String territorioDefensor = null;
	private String territorioDistribuidor = null;
	private String territorioRecebedor;
	private String respostaAtk = "Nao";
	private String respostaDesloca = "Nao";
	
	private static ControlaView ctrl = null;
	
	public static ControlaView getInicializaView() {
		if(ctrl == null) {
			ctrl = new ControlaView();
		}		
		return ctrl;
	}
	
	private ControlaView(){}
	
	public void iniciaPartida() {
		new CxNovoJogo();
	}


	public void inicilizaInfosIniciais() {

		new CxDefineQtdJog();
		faseCtrl = 1;
	
	}
	
	public void  inicializaTabuleiro() {
		jogAlvoCtrl = ControlaJogo.getControlaJogo().getJogDaVez();
		
		CxTabuleiro.getCxTabuleiro();	
		CxSaveGame.getCxSaveGame();
		CxLoadData.getCxLoadData();
		CxExibeOrdemJogadores.getCxExibeOrdemJogadores();
		CxObjetivos.getCxObjetivos(qtdJogadores);
		inicializaControleJogadas(faseCtrl,ControlaJogo.getControlaJogo().getJogDaVez());
	}
	
	public void inicializaControleJogadas(int fase,int jogAlvo) {
		String [] nomes  = Ctrl.getInstance().registra(this).getNomesJogadores();
		
		System.out.println("JOG ALVO: "+jogAlvo);
		// Verificar se atinigiu objetivo //
		if(ControlaJogo.getControlaJogo().getGanhou()==true) {
			JOptionPane.showMessageDialog(null, "O Jogador "+nomes[jogAlvo]+" venceu o jogo",null,JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);

		}
		// Fase de Receber e posicionar Exércitos //		
		if(fase == 1) {
			
			JOptionPane.showMessageDialog(null, "Início da Rodada do Jogador: "+nomes[jogAlvo],null,JOptionPane.INFORMATION_MESSAGE);
			faseCtrl = 1;
			
			CxProxJogada.getCxProxJogada(fase, jogAlvo);
		}
		// Ataque fase 2 e 3 //
		if(fase == 2) {
			if(ControlaJogo.getControlaJogo().getGanhou()==true) {
				JOptionPane.showMessageDialog(null, "O Jogador "+nomes[jogAlvo]+" venceu o jogo",null,JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
			CxProxJogada.getCxProxJogada(fase, jogAlvo);
		}
		
		// Deslocar Exércitos //
		if(fase == 4) {
			if(ControlaJogo.getControlaJogo().getGanhou()==true) {
				JOptionPane.showMessageDialog(null, "O Jogador "+nomes[jogAlvo]+" venceu o jogo",null,JOptionPane.INFORMATION_MESSAGE);

			}
			territorioAtacante = null;
			territorioDefensor = null;
			territorioDefensor = null;
			territorioDistribuidor = null;
			
			CxProxJogada.getCxProxJogada(fase, jogAlvo);
		}
		if (fase == 6) {
			if(ControlaJogo.getControlaJogo().getGanhou()==true) {
				JOptionPane.showMessageDialog(null, "O Jogador "+nomes[jogAlvo]+" venceu o jogo",null,JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}

			int c = Ctrl.getInstance().registra(this).getQtdCartasBonusJogador(jogAlvo);
			// Jogador recebe uma carta //
			if (ControlaJogo.getControlaJogo().getConquistouTerritorio()==1) {
				
				JOptionPane.showMessageDialog(null, "O Jogador recebe uma carta",null,JOptionPane.INFORMATION_MESSAGE);

				String CartaBonus = Ctrl.getInstance().registra(this).distribuiCartaBonus(jogAlvo);				
				CxExibeCartaBonus.getCxExibeCartaBonus(CartaBonus);
				// O jogador e obrigado a trocar as cartas por exércitos //
				if (c==5) {
					JOptionPane.showMessageDialog(null, "O Jogador irá trocar cartas por exérciotos obrigatoriamente",null,JOptionPane.INFORMATION_MESSAGE);

					Ctrl.getInstance().registra(this).realizaTrocaCartas(jogAlvo);
				}
			}
			else {
				System.out.println( "O jogador não conquistou nenhuma carta!");
			}
			// Se ele possui mais de 2 cartas esta apto a realizar uma troca se quiser//
			
			
			if (c > 2) {
				CxPerguntaTroca.getCxPerguntaTroca();
			}
			CxProxJogada.getCxProxJogada(fase, jogAlvo);

		}
		
		// Reset das Informações //
		if (fase == 7) {
			qtdEx = 0;
			qtdExAtk = 0;
			qtdExDef = 0;
			
			corAtk = null;
			territorioAtacante = null;
			territorioDefensor = null;
			territorioDistribuidor = null;
			territorioRecebedor = null;
			respostaAtk = "Nao";
			respostaDesloca = "Nao";
			ControlaJogo.getControlaJogo().setConquistouTerritorio(0);
			jogAlvoCtrl = ControlaJogo.getControlaJogo().getJogDaVez();
			System.out.print("FASE "+fase+" JOG ALVO" + jogAlvo);
			CxProxJogada.getCxProxJogada(fase, jogAlvo);
			
		}
		
	}
	
	public void setQtdJogadores(int qtd) {
		qtdJogadores = qtd;
	}
	
	public void setQtdEx(int n) {
		qtdEx= n;
	}
	public int getQtdEx() {
		return qtdEx;
	}
	public int getFaseCtrl() {
		return faseCtrl;
	}
	public void setFaseJogada(int n) {
		faseCtrl = n;
	}
	public void setJogAlvo(int jog) {
		jogAlvoCtrl = jog;
	}	
	public int getJogAlvo() {
		return jogAlvoCtrl;
	}
	public void setTerritorioAtk(String atk) {
		territorioAtacante = atk;
	}
	public String getTerritorioAtk() {
		return territorioAtacante;
	}
	public void setTerritorioDef(String def) {
		territorioDefensor = def;
	}
	public String getTerritorioDef() {
		return territorioDefensor;
	}
	public String getCorAtk() {
		return corAtk;
	}
	public void setCorAtk(String cor) {
		corAtk = cor;
	}
	
	
	public void setQtdExAtk(int n) {
		qtdExAtk = n;
	}
	public int getQtdExAtk() {
		return qtdExAtk;
	}
	public void setQtdExDef(int n) {
		qtdExDef = n;
	}
	public int getQtdExDef() {
		return qtdExDef;
	}
	
	public void setRespostaAtk(String n) {
		respostaAtk = n;
	}
	public String getRespostaAtk() {
		return respostaAtk;
	}
	
	public void setRespostaDesloca(String n) {
		respostaDesloca = n;
	}
	public String getRespostaDesloca() {
		return respostaDesloca;
	}
	
	public void setTerritorioDistribuidor(String n) {
		territorioDistribuidor = n;
	}
	
	public String getTerritorioDistribuidor() {
		return territorioDistribuidor;
	}
	
	public void setTerritorioRecebedor(String n) {
		territorioRecebedor = n;
	}
	
	public String getTerritorioRecebedor() {
		return territorioRecebedor;
	}

	@Override
	public void add(ObservadorIF o) {
		// TODO Auto-generated method stub
		
	}

	public void atualizaInfosLoad() {
		CxTabuleiro.getCxTabuleiro().setExercitosIniciais();
	}
	@Override
	public void remove(ObservadorIF o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void not(ObservadoIF o) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
