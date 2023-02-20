import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class randomNumberGenerator {

    JLabel label1, label2, label3, label4;
    JTextField text1;
    JButton guessButton, restartButton;
    int number, rank = 0, remattempts = 10;
    Random randomNumber = new Random();

    public void guess() {
        int guess = Integer.parseInt(text1.getText());
        if (remattempts == 0) {
            label2.setForeground(Color.RED);
            label2.setText("RESTART");
        }
        if (remattempts > 0) {
            if ((guess < number)) {
                label2.setText("Guess Is Too Low");
            } else if ((guess > number)) {
                label2.setText("Guess Is Too High");
            } else {
                label2.setForeground(Color.GREEN);
                label2.setText("You Guessed it Right !! Hurray");
            }
            rank += 1;
            remattempts -= 1;
            label3.setText("RANK: " + rank);
            label4.setText("ATTEMPTS: " + remattempts);
        }
        text1.requestFocus();
    }

    public void restart() {
        number = randomNumber.nextInt(100);
        rank = 0;
        remattempts = 10;
        text1.setText("");
        label2.setText("START");
        label3.setText("RANK: " + rank);
        label4.setText("ATTEMPTS: " + remattempts);
        text1.requestFocus();
    }

    randomNumberGenerator() {

        number = randomNumber.nextInt(100);

        JFrame windowFrame = new JFrame("Number Guessing Game - By SURAJ MAPARI");
        windowFrame.setSize(3000, 3000);
        windowFrame.setLayout(null);

        label1 = new JLabel("Guess the number between 1 to 100");
        label1.setBounds(550, 200, 400, 100);
        Font fo1 = new Font("Serif", Font.BOLD, 22);
        label1.setFont(fo1);
        label1.setForeground(Color.BLACK);
        windowFrame.add(label1);

        label2 = new JLabel("START");
        label2.setBounds(600, 250, 400, 100);
        Font fo2 = new Font("Serif", Font.BOLD, 19);
        label2.setFont(fo2);
        label2.setForeground(Color.BLACK);
        windowFrame.add(label2);
        
        label3 = new JLabel("RANK: " + rank);
        label3.setBounds(1000, 20, 500, 200);
        Font fo3 = new Font("Serif", Font.BOLD, 35);
        label3.setFont(fo3);
        label3.setForeground(Color.BLACK);
        windowFrame.add(label3);
        
        label4 = new JLabel("ATTEMPTS: " + remattempts);
        label4.setBounds(1000, 60, 500, 200);
        Font fo4 = new Font("Serif", Font.BOLD, 25);
        label4.setFont(fo4);
        label4.setForeground(Color.RED);
        windowFrame.add(label4);
        
        text1 = new JTextField(10);
        text1.setBounds(600, 320, 200, 30);
        windowFrame.add(text1);
        
        text1.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    label2.setForeground(Color.BLACK);
                    guess();
                }
            }
            
            public void keyReleased(KeyEvent e) {
            }
            
            public void keyTyped(KeyEvent e) {
            }
        });
        
        guessButton = new JButton("Guess");
        guessButton.setBounds(600, 360, 200, 30);
        guessButton.setForeground(Color.BLACK);
        windowFrame.add(guessButton);
        
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setForeground(Color.BLACK);
                guess();
            }
        });

        
        restartButton = new JButton("Restart");
        restartButton.setBounds(600, 400, 200, 30);
        restartButton.setForeground(Color.BLACK);
        windowFrame.add(restartButton);
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setForeground(Color.BLACK);
                restart();
            }
        });

        windowFrame.setVisible(true);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class numberGuessingGame {
    public static void main(String[] args) {
        randomNumberGenerator obj = new randomNumberGenerator();
    }
}