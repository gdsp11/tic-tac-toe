package tictactoe;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener {
    JButton gameButton;
    int filled;

    XOButton() {
        filled = 0; //0 is empty, 1 is X, 2 is O
        gameButton = new JButton();
        this.FillButton("NULL");
        this.addActionListener(this);
    }

    public void FillButton(String fillType) {
        if (fillType == "NULL") {
            this.setText(null);
            this.filled = 0;
        }
        else if (fillType == "X") {
            this.setText("X");
            this.filled = 1;
        }
        else if (fillType == "O") {
            this.setText("O");
            this.filled = 2;
        }
        else {
            System.out.println("Cannot set text. Invalid fill type.");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (this.filled == 0) {
            Game.moves++;
            if (Game.moves % 2 == 1) {
                this.FillButton("X");
            }
            else {
                this.FillButton("O");
            }
            System.out.println("Moves - " + Game.moves);
            int result = GameWindow.CheckState();
            if (result == -1) {
                JOptionPane.showMessageDialog(null, "X won.");
                System.exit(0);
            }
            else if (result == 1) {
                JOptionPane.showMessageDialog(null, "O won.");
                System.exit(0);
            }
            else if (result == 0) {
                JOptionPane.showMessageDialog(null, "Tie.");
                System.exit(0);
            }
        }
    }
}
