package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class TicTacToe extends JFrame implements ActionListener {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private JLabel label;
    private JPanel board;
    private JButton[][] buttons;
    private char[][] vars;
    private boolean XTurn;
    private int cnt;


    public TicTacToe() {
        super("TicTacToe");

        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Welcome to TicTacToe! Player X's turn:");
        this.add(label, BorderLayout.NORTH);
        label.setVisible(true);
        XTurn = true;
        cnt = 0;

        board = new JPanel(new GridLayout(3, 3));
        board.setVisible(true);
        buttons = new JButton[3][3];
        vars = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setActionCommand(i + "," + j);
                buttons[i][j].addActionListener(this);
                board.add(buttons[i][j]);
                vars[i][j] = '*';
            }
        }
        this.add(board, BorderLayout.CENTER);
    }

    private boolean winning(char player, int row, int col) {

        int rCnt = 0;
        int cCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (vars[row][i] == player) {
                rCnt++;
            }
            if (vars[i][col] == player) {
                cCnt++;
            }
        }
        if (rCnt == 3 || cCnt == 3) {
            return true;
        }

        if (vars[1][1] == player && vars[0][0] == player && vars[2][2] == player) {
            return true;
        }

        if (vars[1][1] == player && vars[0][2] == player && vars[2][0] == player) {
            return true;
        }

        return false;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        JButton button = (JButton)e.getSource();

        String[] a = action.split(",");
        int row = Integer.parseInt(a[0]);
        int col = Integer.parseInt(a[1]);

        if (button.isEnabled()) {
            if (XTurn) {
                button.setText("X");
                vars[row][col] = 'X';
                label.setText("Player O's turn:");
                if (winning('X', row, col)) {
                    label.setText("Player X has won!");
                    endGame();
                    return;
                }
            } else {
                button.setText("O");
                vars[row][col] = 'O';
                label.setText("Player X's turn:");
                if (winning('O', row, col)) {
                    label.setText("Player O has won!");
                    endGame();
                    return;
                }
            }
            button.setEnabled(false);
            XTurn = !XTurn;
            cnt++;
        }

        if (cnt == 9) {
            label.setText("Tie Game! ");
            endGame();
        }
    }

    private void endGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.setVisible(true);
    }
}