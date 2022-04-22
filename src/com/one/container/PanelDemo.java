package com.one.container;


import java.awt.*;


public class PanelDemo {
    public static void main(String[] args){
        Frame frame=new Frame("made by TUTU");
        Panel panel=new Panel();
        panel.add(new TextField("欢迎!!!!"));
        panel.add(new Button("点这里"));
        frame.add(panel);
        frame.setBounds(100,100,100,500);
        frame.setVisible(true);

    }

}
