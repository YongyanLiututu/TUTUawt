package com.one.container;
import javax.swing.Timer;
import  java.awt.*;
import  java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Ball {
    private Frame frame=new Frame("made by tutu");
    private final int TABLE_WIDTH=400;
    private final int TABLE_HEIGHT=400;
    private final int RACKET_WIDTH=50;

    private final int RACKET_HEIGHT=50;
    private final int BALL_SIZE=16;
    private int BX=200;
    private int BY=5;
    private int speedy=20;
    private int speedx=10;
    private int X1=150;
    private final int Y1=380;
    private boolean Over=false;
    private Timer timer;
    private class Canvas1 extends Canvas{
        public void paint(Graphics g)
        {
            if(Over){
                g.setColor(Color.PINK);
                g.setFont(new Font("Calibri", Font.BOLD,25));
                g.drawString("Over!!",50,200);

            }
            else{
                g.setColor(Color.BLUE);
                g.fillOval(BX,BY,BALL_SIZE,BALL_SIZE);
                g.setColor(Color.BLACK);
                g.fillRect(X1,Y1,RACKET_WIDTH,RACKET_HEIGHT);

            }

        }
    }

Canvas1 drawArea=new Canvas1();
    public  void init(){
        KeyListener listener=new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int key1=e.getKeyCode();
                if (key1==KeyEvent.VK_LEFT){
                    if(X1>0){
                        X1-=20;
                    }
                }
                if(key1==KeyEvent.VK_RIGHT){
                    if(X1<TABLE_WIDTH-RACKET_WIDTH){
                        X1+=20;
                    }
                }

            }


        };

        frame.addKeyListener(listener);
        drawArea.addKeyListener(listener);
        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if (BX<=0 || BX >=(TABLE_WIDTH-BALL_SIZE)){
                    speedx = -speedx;
                }

                if( BY <=0 || ( BY > Y1-BALL_SIZE && BX>X1 && BX < X1+RACKET_WIDTH)){
                    speedy = -speedy;
                }

                if (BY > Y1-BALL_SIZE && ( BX < X1|| BX > X1+RACKET_WIDTH)){



                    timer.stop();

                    Over = true;

                    drawArea.repaint();
                }


                BX+=speedx;
                BY+=speedy;

                drawArea.repaint();
            }
        };
        timer = new Timer(100,task);
        timer.start();


        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        frame.add(drawArea);



        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Ball().init();
    }
}
