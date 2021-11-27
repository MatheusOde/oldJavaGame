package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Controler.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Robo extends Elemento implements Serializable{
    private boolean bRight;
    private boolean foiPraCima = false;
    private boolean foiPraBaixo = false;
    private boolean foiPraEsquerda = false;
    private boolean foiPraDireita = false;
    private ControleDeJogo cControle = new ControleDeJogo();
    ArrayList<Elemento> eElementos;
    public Robo(String sNomeImagePNG,ArrayList<Elemento> eElementinhos) {
        super(sNomeImagePNG);
        eElementos = eElementinhos;
        this.bTransponivel = true;
        this.bMortal = true;
    }
    
    public void autoDesenho(){
        Random random = new Random();
        int a = random.nextInt(18);
        switch (a) {
            case 0:
                if(foiPraDireita == false){
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos,this.getPosicao())) {
                         this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = true;
                    foiPraCima = false;
                    foiPraBaixo = false;
                    foiPraEsquerda = true;
                }
                else{
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }   break;
            case 1:
                if(foiPraEsquerda == false){
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos,this.getPosicao())) {
                         this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = true;
                    foiPraCima = false;
                    foiPraBaixo = false;
                    foiPraEsquerda = true;
                }
                else{
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }   break;
            case 2:
                if(foiPraCima == false){
                    this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos,this.getPosicao())) {
                         this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = false;
                    foiPraCima = true;
                    foiPraBaixo = true;
                    foiPraEsquerda = false;
                }
                else{
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }   break;
            case 3:
                if(foiPraBaixo == false){
                    this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                    if (!cControle.ehPosicaoValidaRobos(this.eElementos,this.getPosicao())) {
                         this.voltaAUltimaPosicao();
                    }
                    foiPraDireita = false;
                    foiPraCima = true;
                    foiPraBaixo = true;
                    foiPraEsquerda = false;
                }
                else{
                    this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                }   break;
            default:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
                break;
        }
        super.autoDesenho();
        bRight = !bRight;
    }
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}