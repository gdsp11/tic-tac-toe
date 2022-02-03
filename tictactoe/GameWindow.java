package tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class GameWindow extends JFrame {
    JFrame mainWindowFrame;

    private JPanel gamePanel;
    public static XOButton[][] gameXOButton = new XOButton[3][3];

    GameWindow() {
        //Initialize variables
        mainWindowFrame = new JFrame();
        gamePanel = new JPanel();

        //Initialize the game window
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setSize(600, 600);
        mainWindowFrame.setTitle("Tic Tac Toe");
        mainWindowFrame.setVisible(true);

        //Initialize the buttons and panel
        gamePanel.setLayout(new  GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameXOButton[i][j] = new XOButton();
                gamePanel.add(gameXOButton[i][j]);
            }
        }

        mainWindowFrame.add(gamePanel);
    }

    public static int CheckState() {
        /*
            [1] [2] [3]
            [4] [5] [6]
            [7] [8] [9]
        */

        //step 1 - check 123, 147, 159 - DONE
        //step 2 - check 456 - DONE
        //step 3 - check 789 - DONE
        //step 4 - check 258 - DONE
        //step 5 - check 369, 357
        
        if ((gameXOButton[0][0].getText() == gameXOButton[0][1].getText() && gameXOButton[0][1].getText() == gameXOButton[0][2].getText()) ||
            (gameXOButton[0][0].getText() == gameXOButton[1][0].getText() && gameXOButton[1][0].getText() == gameXOButton[2][0].getText()) ||
            (gameXOButton[0][0].getText() == gameXOButton[1][1].getText() && gameXOButton[1][1].getText() == gameXOButton[2][2].getText())) {

            if (gameXOButton[0][0].getText() == "X")
                return -1;
            else if (gameXOButton[0][0].getText() == "O")
                return 1;
        }
        else if ((gameXOButton[1][0].getText() == gameXOButton[1][1].getText() && gameXOButton[1][1].getText() == gameXOButton[1][2].getText())) {
            if (gameXOButton[1][0].getText() == "X")
                return -1;
            else if (gameXOButton[1][0].getText() == "O")
                return 1;
        }
        else if ((gameXOButton[2][0].getText() == gameXOButton[2][1].getText() && gameXOButton[2][1].getText() == gameXOButton[2][2].getText())) {
            if (gameXOButton[2][0].getText() == "X")
                return -1;
            else if (gameXOButton[2][0].getText() == "O")
                return 1;
        }
        else if ((gameXOButton[0][1].getText() == gameXOButton[1][1].getText() && gameXOButton[1][1].getText() == gameXOButton[2][1].getText())) {
            if (gameXOButton[0][1].getText() == "X")
                return -1;
            else if (gameXOButton[0][1].getText() == "O")
                return 1;
        }
        else if ((gameXOButton[0][2].getText() == gameXOButton[1][2].getText() && gameXOButton[1][2].getText() == gameXOButton[2][2].getText()) ||
                 (gameXOButton[0][2].getText() == gameXOButton[1][1].getText() && gameXOButton[1][1].getText() == gameXOButton[2][0].getText())) {
            if (gameXOButton[0][2].getText() == "X")
                return -1;
            else if (gameXOButton[0][2].getText() == "O")
                return 1;
        }
        else {
            if (Game.moves == 9)
                return 0;
            else
                return -100;
        }

        return -100;
    }
}
