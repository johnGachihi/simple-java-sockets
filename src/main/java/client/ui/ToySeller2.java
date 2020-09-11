package client.ui;

import client.ClientProtocol;
import client.SocketClient2;
import utils.Step;

import javax.swing.*;
import java.awt.*;

public class ToySeller2 {
    private final JFrame mainFrame;
    private final JPanel cards;

    public ToySeller2() {
        ClientProtocol clientProtocol = new ClientProtocol();
        SocketClient2 socketClient2 = new SocketClient2("localhost", clientProtocol);

        mainFrame = new JFrame("ToySeller2");
        cards = new JPanel(new CardLayout());

        LayoutNavigation layoutNavigation = new LayoutNavigation(cards);
        Layouts layouts = new Layouts(socketClient2, layoutNavigation);

        cards.add(layouts.stepZeroLayout(), Step.ZERO.name());
        cards.add(layouts.stepOneLayout(), Step.ONE.name());
        cards.add(layouts.stepTwoLayout(), Step.TWO.name());
        cards.add(layouts.stepThreeLayout(), Step.THREE.name());
        cards.add(layouts.stepFourLayout(), Step.FOUR.name());
        cards.add(layouts.finalLayout(), Step.FINAL.name());
    }


    public void show() {
        mainFrame.getContentPane().add(cards);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ToySeller2 toySeller2 = new ToySeller2();
        toySeller2.show();
    }
}
