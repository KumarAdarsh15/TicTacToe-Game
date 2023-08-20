import javax.swing.*;
import java.awt.*;

public class WhoWins {
    WhoWins(String message){
        JFrame jf=new JFrame();
        jf.setSize(600,500);
        jf.setLocation(300,200);
        jf.setLayout(null);

        JPanel jp=new JPanel();
        jp.setBounds(0,0,600,500);
        jp.setBackground(Color.BLACK);

        JLabel jl=new JLabel(message);
        jl.setBounds(50,50,450,50);
        jl.setFont(new Font("MV Boli", Font.BOLD,70));
        jl.setForeground(Color.GREEN);
        jp.add(jl);
        jf.add(jl);
        jf.add(jp);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
