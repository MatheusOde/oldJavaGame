
package fases;

import Modelo.*;
import Controler.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class fase2 {
    public fase2(ArrayList<Elemento> eElementos, Tela tTela, Hero hHero){
        
        hHero.setPosicao(5, 5);
        tTela.addElemento(hHero);
        tTela.Backgroundfase ="background_2.png";
        
        Arrows(eElementos,tTela);
        Premios(eElementos,tTela);
        Paredes(eElementos,tTela);
        Inimigos(eElementos,tTela);
        hHero.setPosicao(5, 5);
        tTela.addElemento(hHero);
    }
    private void Inimigos(ArrayList<Elemento> eElementos, Tela tTela){
        
        Robo Verde = new Robo("robo_verde.png",eElementos);
        Verde.setPosicao(1, 9);
        tTela.addElemento(Verde);     

        Robo Amarelo = new Robo("robo_amarelo.png",eElementos);
        Amarelo.setPosicao(1, 1);
        tTela.addElemento(Amarelo);

        Robo Azul = new Robo("robo_azul.png",eElementos);
        Azul.setPosicao(9, 9);        
        tTela.addElemento(Azul);
        
        Robo Rosa = new Robo("robo_rosa.png",eElementos);
        Rosa.setPosicao(9, 1);        
        tTela.addElemento(Rosa);
    }
    private void Premios(ArrayList<Elemento> eElementos, Tela tTela){
        Prizes prize_1 = new Prizes("prize_insertcoin.png");
        prize_1.setPosicao(5, 9);
        tTela.addElemento(prize_1); 
        
        Prizes prize_2 = new Prizes("prize_gun.png");
        prize_2.setPosicao(5, 1);
        tTela.addElemento(prize_2); 
        
        Prizes prize_3 = new Prizes("prize_atomicbomb.png");
        prize_3.setPosicao(9, 5);
        tTela.addElemento(prize_3); 
        
        Prizes prize_4 = new Prizes("prize_DGP.png");
        prize_4.setPosicao(1, 5);
        tTela.addElemento(prize_4); 
    }
    private void Paredes(ArrayList<Elemento> eElementos, Tela tTela){
        int i,a;
        a=0;
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array*/
        Parede paredes[]= new Parede[16];
        for(i=1;i<11;i=i+2){
            paredes[a] = new Parede("block_red.png",false);
            paredes[a].setPosicao(i, 3);
            tTela.addElemento(paredes[a]);
            a++;
            
            paredes[a] = new Parede("block_red.png",false);
            paredes[a].setPosicao(i, 7);
            tTela.addElemento(paredes[a]);
            a++;
        }
        for(i=1;i<11;i=i+4){
            paredes[a] = new Parede("block_red.png",false);
            paredes[a].setPosicao(3, i);
            tTela.addElemento(paredes[a]);
            a++;
            
            paredes[a] = new Parede("block_red.png",false);
            paredes[a].setPosicao(7, i);
            tTela.addElemento(paredes[a]);
            a++;
        }
    }
    private void Arrows(ArrayList<Elemento> eElementos, Tela tTela){
        //upper arrows
        Arrow UP1 = new Arrow("arrow_up.png",0,eElementos);
        UP1.setPosicao(7, 10);
        tTela.addElemento(UP1); 
        
        Arrow UP2 = new Arrow("arrow_up.png",0,eElementos);
        UP2.setPosicao(7, 8);
        tTela.addElemento(UP2);
        
        Arrow UP3 = new Arrow("arrow_up.png",0,eElementos);
        UP3.setPosicao(7, 6);
        tTela.addElemento(UP3);
        
        Arrow UP4 = new Arrow("arrow_up.png",0,eElementos);
        UP4.setPosicao(7, 0);
        tTela.addElemento(UP4);
        
        Arrow UP5 = new Arrow("arrow_up.png",0,eElementos);
        UP5.setPosicao(6, 0);
        tTela.addElemento(UP5);
        
        Arrow UP6 = new Arrow("arrow_up.png",0,eElementos);
        UP6.setPosicao(5, 0);
        tTela.addElemento(UP6);
        
        
        Arrow UP7 = new Arrow("arrow_up.png",0,eElementos);
        UP7.setPosicao(4, 8);
        tTela.addElemento(UP7);
        
        Arrow UP8 = new Arrow("arrow_up.png",0,eElementos);
        UP8.setPosicao(4, 0);
        tTela.addElemento(UP8);
        
        Arrow UP9 = new Arrow("arrow_up.png",0,eElementos);
        UP9.setPosicao(3, 8);
        tTela.addElemento(UP9);
        
        Arrow UP10 = new Arrow("arrow_up.png",0,eElementos);
        UP10.setPosicao(3, 6);
        tTela.addElemento(UP10);
        
        Arrow UP11 = new Arrow("arrow_up.png",0,eElementos);
        UP11.setPosicao(3, 0);
        tTela.addElemento(UP11);

        //right arrows
        Arrow Right1 = new Arrow("arrow_right.png",1,eElementos);
        Right1.setPosicao(10, 7);
        tTela.addElemento(Right1);
        
        Arrow Right2 = new Arrow("arrow_right.png",1,eElementos);
        Right2.setPosicao(8, 7);
        tTela.addElemento(Right2);
        
        Arrow Right3 = new Arrow("arrow_right.png",1,eElementos);
        Right3.setPosicao(8, 3);
        tTela.addElemento(Right3);
        
        Arrow Right4 = new Arrow("arrow_right.png",1,eElementos);
        Right4.setPosicao(6, 3);
        tTela.addElemento(Right4);
        
        Arrow Right5 = new Arrow("arrow_right.png",1,eElementos);
        Right5.setPosicao(4, 7);
        tTela.addElemento(Right5);
        
        Arrow Right6 = new Arrow("arrow_right.png",1,eElementos);
        Right6.setPosicao(4, 3);
        tTela.addElemento(Right6);
        
        Arrow Right7 = new Arrow("arrow_right.png",1,eElementos);
        Right7.setPosicao(2, 3);
        tTela.addElemento(Right7);
        
        Arrow Right8 = new Arrow("arrow_right.png",1,eElementos);
        Right8.setPosicao(0, 7);
        tTela.addElemento(Right8);
        
        Arrow Right9 = new Arrow("arrow_right.png",1,eElementos);
        Right9.setPosicao(0, 3);
        tTela.addElemento(Right9);
        
        //down arrows
        Arrow down1 = new Arrow("arrow_down.png",2,eElementos);
        down1.setPosicao(7, 4);
        tTela.addElemento(down1);
        
        Arrow down2 = new Arrow("arrow_down.png",2,eElementos);
        down2.setPosicao(7, 2);
        tTela.addElemento(down2);
        
        Arrow down3 = new Arrow("arrow_down.png",2,eElementos);
        down3.setPosicao(3, 10);
        tTela.addElemento(down3);
        
        Arrow down4 = new Arrow("arrow_down.png",2,eElementos);
        down4.setPosicao(3, 4);
        tTela.addElemento(down4);
        
        Arrow down5 = new Arrow("arrow_down.png",2,eElementos);
        down5.setPosicao(3, 2);
        tTela.addElemento(down5);
        
        Arrow down6 = new Arrow("arrow_down.png",2,eElementos);
        down6.setPosicao(2, 4);
        tTela.addElemento(down6);
        
        //left arrows
        Arrow left1 = new Arrow("arrow_left.png",3,eElementos);
        left1.setPosicao(10, 3);
        tTela.addElemento(left1);
        
        Arrow left2 = new Arrow("arrow_left.png",3,eElementos);
        left2.setPosicao(6, 7);
        tTela.addElemento(left2);
        
        Arrow left3 = new Arrow("arrow_left.png",3,eElementos);
        left3.setPosicao(4, 9);
        tTela.addElemento(left3);
        
        Arrow left4 = new Arrow("arrow_left.png",3,eElementos);
        left4.setPosicao(4, 10);
        tTela.addElemento(left4);
        
        Arrow left5 = new Arrow("arrow_left.png",3,eElementos);
        left5.setPosicao(2, 7);
        tTela.addElemento(left5);
        
        Arrow left6 = new Arrow("arrow_left.png",3,eElementos);
        left6.setPosicao(2, 6);
        tTela.addElemento(left6);
        
        Arrow left7 = new Arrow("arrow_left.png",3,eElementos);
        left7.setPosicao(2, 5);
        tTela.addElemento(left7);
    }
}
