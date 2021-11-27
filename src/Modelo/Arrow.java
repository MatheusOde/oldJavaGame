/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.*;
import java.io.Serializable;
import java.util.ArrayList;
import Controler.*;

/**
 *
 * @author User
 */
public class Arrow extends Elemento implements Serializable {
    int dir; // 0 pra cima, 1 pra direita, 2 pra baixo, 3 pra esquerda
    ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    public Arrow(String sNomeImagePNG, int dire,ArrayList<Elemento> eElementinhos) {
        super(sNomeImagePNG);
        dir = dire;
        this.bTransponivel = true;
        this.bArrow=true;
        eElementos = eElementinhos;
    }
    public boolean empurrar(){
        Elemento eTemp;
        /*elemento auxiliar*/
        Parede Ver1 = new Parede("block_red.png",false);
        Ver1.setPosicao(10, 1);
        /*Validacao da posicao de todos os elementos com relacao a da seta atual*/
        for(int i = 1; i < eElementos.size(); i++){ /*Olha todos os elementos*/
            eTemp = eElementos.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp!=this)
                if(eTemp.getPosicao().estaNaMesmaPosicao(this.getPosicao()))
                    switch(dir) {
                        //empurra para cima
                        case 0:
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(),eTemp.pPosicao.getColuna());
                            Ver1.moveUp();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos,Ver1.getPosicao())) {
                                eTemp.moveUp();
                            }
                        break;
                        //empurra para direita
                        case 1:
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(),eTemp.pPosicao.getColuna());
                            Ver1.moveRight();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos,Ver1.getPosicao())) {
                                eTemp.moveRight();
                            }
                            
                        break;
                        //empurra para baixo
                        case 2:
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(),eTemp.pPosicao.getColuna());
                            Ver1.moveDown();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos,Ver1.getPosicao())) {
                                eTemp.moveDown();
                            }
                            
                        break;
                        //empurra para esquerda
                        case 3:
                            Ver1.setPosicao(eTemp.pPosicao.getLinha(),eTemp.pPosicao.getColuna());
                            Ver1.moveLeft();
                            if (cControle.ehPosicaoValidaArrows(this.eElementos,Ver1.getPosicao())) {
                                eTemp.moveLeft();
                            }
                            
                        break;
                        default:
                        break;
                    }
                        
        }
        return true;
    }
    public void autoDesenho(){
        super.autoDesenho();
        empurrar();
    }   
}