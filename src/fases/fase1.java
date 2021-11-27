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
public class fase1 {
    public fase1(ArrayList<Elemento> eElementos, Tela tTela, Hero hHero){
        
        hHero.setPosicao(4, 4);
        tTela.addElemento(hHero);
        
        tTela.Backgroundfase ="background_1.png";
        
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        ParedesFuradas(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hHero);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(10, 1);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(2, 0);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(10, 9);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(0, 9);        
        tTela.addElemento(Rosa);
    }
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("prize_insertcoin.png");
        prize_1.setPosicao(10, 0);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("prize_gun.png");
        prize_2.setPosicao(0, 10);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("prize_atomicbomb.png");
        prize_3.setPosicao(10, 10);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("prize_DGP.png");
        prize_4.setPosicao(0, 0);
        tTela.addElemento(prize_4); 
    }
    private void Paredes(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a,j;
        a=0;
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        Parede paredes[]= new Parede[25];
        for(i=1;i<11;i=i+2){
            for(j=1;j<11;j=j+2){
                paredes[a] = new Parede("block_red.png",false);
                paredes[a].setPosicao(i, j);
                tTela.addElemento(paredes[a]);
                a++;
            }
        }
    }
    private void ParedesFuradas(ArrayList<Elemento> eElementos, Tela tTela){
        ParedeFurada PF1  = new ParedeFurada("hole_green.png");
        PF1.setPosicao(0, 1);
        tTela.addElemento(PF1); 
        
        
        ParedeFurada PF2  = new ParedeFurada("hole_green.png");
        PF2.setPosicao(1, 2);
        tTela.addElemento(PF2); 
        
        ParedeFurada PF3  = new ParedeFurada("hole_green.png");
        PF3.setPosicao(2, 1);
        tTela.addElemento(PF3); 
        
        ParedeFurada PF4  = new ParedeFurada("hole_green.png");
        PF4.setPosicao(3, 0);
        tTela.addElemento(PF4); 
        
        ParedeFurada PF5  = new ParedeFurada("hole_green.png");
        PF5.setPosicao(4, 1);
        tTela.addElemento(PF5); 
        
        ParedeFurada PF6  = new ParedeFurada("hole_green.png");
        PF6.setPosicao(5, 2);
        tTela.addElemento(PF6);
        
        ParedeFurada PF7 = new ParedeFurada("hole_green.png");
        PF7.setPosicao(0, 5);
        tTela.addElemento(PF7);
        
        ParedeFurada PF8 = new ParedeFurada("hole_green.png");
        PF8.setPosicao(2, 5);
        tTela.addElemento(PF8);
        
        ParedeFurada PF9 = new ParedeFurada("hole_green.png");
        PF9.setPosicao(1, 8);
        tTela.addElemento(PF9);
        
        ParedeFurada PF10 = new ParedeFurada("hole_green.png");
        PF10.setPosicao(1, 10);
        tTela.addElemento(PF10);
        
        ParedeFurada PF11 = new ParedeFurada("hole_green.png");
        PF11.setPosicao(3, 8);
        tTela.addElemento(PF11);
        
        ParedeFurada PF12 = new ParedeFurada("hole_green.png");
        PF12.setPosicao(4, 9);
        tTela.addElemento(PF12);
        
        ParedeFurada PF13 = new ParedeFurada("hole_green.png");
        PF13.setPosicao(6, 5);
        tTela.addElemento(PF13);
        
        ParedeFurada PF14 = new ParedeFurada("hole_green.png");
        PF14.setPosicao(5, 6);
        tTela.addElemento(PF14);
        
        ParedeFurada PF15 = new ParedeFurada("hole_green.png");
        PF15.setPosicao(6, 7);
        tTela.addElemento(PF15);
        
        ParedeFurada PF16 = new ParedeFurada("hole_green.png");
        PF16.setPosicao(7, 8);
        tTela.addElemento(PF16);
        
        ParedeFurada PF17 = new ParedeFurada("hole_green.png");
        PF17.setPosicao(8, 9);
        tTela.addElemento(PF17);
        
        ParedeFurada PF18 = new ParedeFurada("hole_green.png");
        PF18.setPosicao(7, 10);
        tTela.addElemento(PF18);
        
        ParedeFurada PF19 = new ParedeFurada("hole_green.png");
        PF19.setPosicao(9, 8);
        tTela.addElemento(PF19);
        
        ParedeFurada PF20 = new ParedeFurada("hole_green.png");
        PF20.setPosicao(10, 7);
        tTela.addElemento(PF20);
        
        ParedeFurada PF21 = new ParedeFurada("hole_green.png");
        PF21.setPosicao(9, 6);
        tTela.addElemento(PF21);
        
        ParedeFurada PF22 = new ParedeFurada("hole_green.png");
        PF22.setPosicao(8, 3);
        tTela.addElemento(PF22);
        
        ParedeFurada PF23 = new ParedeFurada("hole_green.png");
        PF23.setPosicao(9, 2);
        tTela.addElemento(PF23);
        
        ParedeFurada PF24 = new ParedeFurada("hole_green.png");
        PF24.setPosicao(9, 0);
        tTela.addElemento(PF24);
    }
}
