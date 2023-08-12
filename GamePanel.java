import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel implements ActionListener{
    Random random = new Random();
    JFrame frame;
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JTextField textField = new JTextField();
    JButton buttons[] = new JButton[9];
    boolean player_turn;
    int count = 0;
    String player1,player2;
    int total_series,series_count=1;
    int player1_win_count=0,player2_win_count=0;
    GamePanel(String player1,String player2,int total_series) {
        this.player1=player1;
        this.player2=player2;
        this.total_series=total_series;
    }
    public void openGamePanel(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        frame = new JFrame();
        frame.setSize(600, 500);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLayout(new BorderLayout());

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 600, 100);

        buttons = new JButton[9];
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player_turn = false;
                        textField.setText(player1+" (O) Turn");
                        check();
                        if (count == 9) {
                            series_count++;
                            textField.setText("Match Draw");
                            restartGame();
                            firstTurn();
                        }
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player_turn = true;
                        textField.setText(player2+" (X) Turn");
                        check();
                        if (count == 9) {
                            series_count++;
                            textField.setText("Match Draw");
                            restartGame();
                            firstTurn();
                        }
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        if (random.nextInt(2) == 0) {
            player_turn = true;
            textField.setText(player2+" (X) Turn");
        } else {
            player_turn = false;
            textField.setText(player1+" (O) Turn");
        }
    }

    public void check() {
        //x Wins
        //Horizontal
        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
            xWins(0, 1, 2);

        } else if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
            xWins(3, 4, 5);
        } else if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
            xWins(6, 7, 8);
        }
        //Vertical
        else if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
            xWins(0, 3, 6);
        } else if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
            xWins(1, 4, 7);
        } else if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
            xWins(2, 5, 8);
        }
        //Diagonal
        else if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
            xWins(0, 4, 8);
        } else if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
            xWins(2, 4, 6);
        }
        //o Wins
        //Horizontal
        else if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
            oWins(0, 1, 2);
        } else if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
            oWins(3, 4, 5);
        } else if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
            oWins(6, 7, 8);
        }
        //Vertical
        else if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
            oWins(0, 3, 6);
        } else if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
            oWins(0, 4, 7);
        } else if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
            oWins(2, 5, 8);
        }
        //Diagonal
        else if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
            oWins(0, 4, 8);
        } else if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        series_count++;
        textField.setText(player2+" (X) WINS");
        player2_win_count++;
        restartGame();
        firstTurn();
        buttons[a].setBackground(null);
        buttons[b].setBackground(null);
        buttons[c].setBackground(null);
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        series_count++;
        textField.setText(player1+" (O) WINS");
        player1_win_count++;
        restartGame();
        firstTurn();
        buttons[a].setBackground(null);
        buttons[b].setBackground(null);
        buttons[c].setBackground(null);
    }

    public void restartGame() {
        if(total_series>=series_count){
            int x = JOptionPane.showConfirmDialog(frame, "Restart Game");
            //Yes
            if (x == 0) {
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setText("");
                    buttons[i].setEnabled(true);
                }
            }
            //No
            else if (x == 1)
                System.exit(0);
                //Cancel
            else {
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
            }
            count = 0;
        }
        else{
            JOptionPane.showMessageDialog(frame,"Series Completed");
            if(player1_win_count>player2_win_count){
                new WhoWins(player1+" WINS");
                frame.setVisible(false);
            }
            else if(player2_win_count>player1_win_count){
                new WhoWins(player2+" WINS");
                frame.setVisible(false);
            }
            else{
                new WhoWins("SERIES DRAW");
                frame.setVisible(false);
            }
        }
    }
}

