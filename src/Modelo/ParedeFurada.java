/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author User
 */
public class ParedeFurada extends Elemento implements Serializable {

    public ParedeFurada(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovable = true;
        this.bBreakable = true;
    }
    public ParedeFurada(String sNomeImagePNG, boolean vermelha) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bMovable = true;
        this.bBreakable = false;
    }
}
