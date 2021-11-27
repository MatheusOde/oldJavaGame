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
public class fase4 {
    public fase4(ArrayList<Elemento> eElementos, Tela tTela, Hero hHero){
        
        hHero.setPosicao(4, 5);
        tTela.addElemento(hHero);
        
        tTela.Backgroundfase ="background_4.png";
        
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        Inimigos(eElementos,tTela);
        tTela.addElemento(hHero);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(5, 0);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(0, 5);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(5, 10);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(10, 5);        
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
        Parede paredes[]= new Parede[41];
        for(i=1;i<11;i=i+2){
            for(j=1;j<11;j=j+2){
                paredes[a] = new Parede("block_green.png",true);
                paredes[a].setPosicao(i, j);
                tTela.addElemento(paredes[a]);
                a++;
            }
        }
        for(i=2;i<9;i=i+2){
            for(j=2;j<9;j=j+2){
                paredes[a] = new Parede("block_green.png",true);
                paredes[a].setPosicao(i, j);
                tTela.addElemento(paredes[a]);
                a++;
            }
        }
        Parede Ver1 = new Parede("block_red.png",false);
        Ver1.setPosicao(10, 1);
        tTela.addElemento(Ver1);
        
        Parede Ver2 = new Parede("block_red.png",false);
        Ver2.setPosicao(8, 10);
        tTela.addElemento(Ver2);
        
        Parede Ver3 = new Parede("block_red.png",false);
        Ver3.setPosicao(8, 7);
        tTela.addElemento(Ver3);
        
        Parede Ver4 = new Parede("block_red.png",false);
        Ver4.setPosicao(8, 1);
        tTela.addElemento(Ver4);
        
        Parede Ver5 = new Parede("block_red.png",false);
        Ver5.setPosicao(7, 0);
        tTela.addElemento(Ver5);
        
        Parede Ver6 = new Parede("block_red.png",false);
        Ver6.setPosicao(6, 3);
        tTela.addElemento(Ver6);
        
        Parede Ver7 = new Parede("block_red.png",false);
        Ver7.setPosicao(5, 8);
        tTela.addElemento(Ver7);
        
        Parede Ver8 = new Parede("block_red.png",false);
        Ver8.setPosicao(5, 2);
        tTela.addElemento(Ver8);
        
        Parede Ver9 = new Parede("block_red.png",false);
        Ver9.setPosicao(3, 10);
        tTela.addElemento(Ver9);
        
        Parede Ver10 = new Parede("block_red.png",false);
        Ver10.setPosicao(3, 2);
        tTela.addElemento(Ver10);
        
        Parede Ver11 = new Parede("block_red.png",false);
        Ver11.setPosicao(2, 5);
        tTela.addElemento(Ver11);
        
        Parede Ver12 = new Parede("block_red.png",false);
        Ver12.setPosicao(1, 8);
        tTela.addElemento(Ver12);
        
        Parede Ver13 = new Parede("block_red.png",false);
        Ver13.setPosicao(1, 0);
        tTela.addElemento(Ver13);
        
        Parede Ver14 = new Parede("block_red.png",false);
        Ver14.setPosicao(0, 7);
        tTela.addElemento(Ver14);
        
        Parede Ver15 = new Parede("block_red.png",false);
        Ver15.setPosicao(0, 3);
        tTela.addElemento(Ver15);
    }
}