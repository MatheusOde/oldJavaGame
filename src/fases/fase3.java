/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class fase3 {
    public fase3(ArrayList<Elemento> eElementos, Tela tTela, Hero hHero){
        
        hHero.setPosicao(5, 5);
        tTela.addElemento(hHero);
        
        tTela.Backgroundfase ="background_5.png";
        
        Premios(eElementos,tTela);
        ParedesFuradas(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hHero);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(10, 5);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(0, 5);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(8, 5);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(2, 5);        
        tTela.addElemento(Rosa);
    }
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("prize_insertcoin.png");
        prize_1.setPosicao(5, 2);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("prize_gun.png");
        prize_2.setPosicao(5, 8);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("prize_atomicbomb.png");
        prize_3.setPosicao(5, 10);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("prize_DGP.png");
        prize_4.setPosicao(5, 0);
        tTela.addElemento(prize_4); 
    }
    private void ParedesFuradas(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a;
        a=0;
        ParedeFurada PF[]= new ParedeFurada[48];
        for(i=1;i<10;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(i, 1);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=2;i<10;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(1, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=2;i<10;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(9, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=2;i<9;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(i, 9);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=3;i<8;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(3, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=3;i<8;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(7, i);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=4;i<7;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(i, 3);
            tTela.addElemento(PF[a]);
            a++;
        }
        for(i=4;i<7;i++){
            PF[a] = new ParedeFurada("hole_red.png", true);
            PF[a].setPosicao(i, 7);
            tTela.addElemento(PF[a]);
            a++;
        }
    }
}
