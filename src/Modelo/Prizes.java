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
public class Prizes extends Elemento implements Serializable {

    private boolean bRight;
    
    public Prizes(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
        this.bTransponivel = true;;
        this.bColetavel = true;
    }
    
}

