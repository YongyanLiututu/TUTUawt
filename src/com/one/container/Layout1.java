package com.one.container;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout1 {
    public static void main(String[] args) {
        Frame frame = new Frame("made by tutu");
        Panel panel = new Panel();
        CardLayout cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        String[] names = {"欢迎来到我的页面--第一面", "第2面", "第3面", "第4面", "第5面"};
        for (int i = 0; i < names.length; i++) {
            panel.add(names[i], new Button(names[i]));
        }
        frame.add(panel);
        Panel pane2 = new Panel();
        Button a1 = new Button("上一页");
        Button a2 = new Button("下一页");
        Button a3 = new Button("第一页");
        Button a4 = new Button("最后一页");
        Button a5 = new Button("欢迎");
        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String actionCommand = e.getActionCommand();
                switch (actionCommand) {
                    case "上一页":
                        cardLayout.previous(panel);
                        break;
                    case "下一页":
                        cardLayout.next(panel);
                        break;
                    case "第一页":
                        cardLayout.first(panel);
                        break;
                    case "最后一页":
                        cardLayout.last(panel);
                        break;
                    case "欢迎":
                        cardLayout.show(panel, "欢迎回家");
                        break;
                }

            }
        };
        a1.addActionListener(listener);
        a2.addActionListener(listener);
        a3.addActionListener(listener);
        a4.addActionListener(listener);
        a5.addActionListener(listener);
        pane2.add(a1);
        pane2.add(a2);
        pane2.add(a3);
        pane2.add(a4);
        pane2.add(a5);


        frame.add(pane2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);



    }
}
