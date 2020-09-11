package client.ui;

import org.jetbrains.annotations.NotNull;
import utils.Step;

import javax.swing.*;
import java.awt.*;

public class LayoutNavigation {
    private final JPanel cards;
    private final CardLayout cardLayout;

    public LayoutNavigation(@NotNull JPanel cards) {
        this.cards = cards;
        cardLayout = (CardLayout) cards.getLayout();
    }

    public void moveTo(@NotNull Step step) {
        cardLayout.show(cards, step.name());
    }
}
