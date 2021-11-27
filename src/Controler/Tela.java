package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;
import fases.*;
/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
    public String Backgroundfase;
    private int vidas = 5;
    private int fase = 1;
    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
        //this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
            Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        
        /*Cria o Heroi*/
        hHero = new Hero("skooter_hero.png");
        /*seletor de fases*/
        switch(fase){
            case 1:
                eElementos = new ArrayList<Elemento>(100);
                fase1 fase1 = new fase1(eElementos, this, hHero);
                break;
            case 2:
                eElementos = new ArrayList<Elemento>(100);
                fase2 fase2 = new fase2(eElementos, this, hHero);
                break;
            case 3:
                eElementos = new ArrayList<Elemento>(100);
                fase3 fase3 = new fase3(eElementos, this, hHero);
                break;
            case 4:
                eElementos = new ArrayList<Elemento>(100);
                fase4 fase4 = new fase4(eElementos, this, hHero);
                break;
            default:
            break;
        }
    }
    public void Tela(int faseAtual) {
        fase=faseAtual;
        /*seletor de fases*/
        hHero = new Hero("skooter_hero.png");
        switch(faseAtual){
            case 1:
                eElementos = new ArrayList<Elemento>(100);
                fase1 fase1 = new fase1(eElementos, this, hHero);
                break;
            case 2:
                eElementos = new ArrayList<Elemento>(100);
                fase2 fase2 = new fase2(eElementos, this, hHero);
                break;
            case 3:
                eElementos = new ArrayList<Elemento>(100);
                fase3 fase3 = new fase3(eElementos, this, hHero);
                break;
            case 4:
                eElementos = new ArrayList<Elemento>(100);
                fase4 fase4 = new fase4(eElementos, this, hHero);
                break;
            default:
            break;
        }
    }

/*--------------------------------------------------*/
    public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + Backgroundfase);
                    g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hHero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hHero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hHero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hHero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R && this.fase == 0) {
            this.eElementos.clear();
            this.vidas = 5;
            Tela(1);
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            this.eElementos.clear();
            Tela(fase);
        }
        /*Se o heroi for para uma posicao mortal, sobre um inimigo, reinicia a fase e perde uma vida*/
        if (cControle.ehPosicaoMortal(this.eElementos,hHero.getPosicao())) {
            vidas--;
            System.out.println("Vidas: "+ vidas);
            if (vidas == 0){
                System.out.println("Game Over");
                System.out.println("Voce perdeu!");
                this.eElementos.clear();
                this.fase = 0;
            }
            this.eElementos.clear();
            Tela(fase);
        }
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }
        /* checa se o objetivo foi atingido*/
        if(cControle.GanhouYey(this.eElementos, hHero.getPosicao())){
            if(fase!=0){
                
                this.eElementos.clear();
                fase++;
                if(fase==5){
                    System.out.println("Voce Ganhou!");
                    System.out.println("Ceditos:");
                    System.out.println("Matheus Odebrecht Oliveira");
                    System.out.println("Uriel Ramiro Munerato");
                    fase = 0;
                }
            }
            Tela(fase);
        }
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()));
    }

    public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }         
         
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
