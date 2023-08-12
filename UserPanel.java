import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserPanel implements ActionListener{
    JFrame jf;
    JLabel jl1,jl2,jl3;
    JTextField jt1,jt2;
    JButton jb;
    JComboBox cb;
    UserPanel(){
        jf=new JFrame();
        jf.setSize(600, 500);
        jf.setLayout(null);

        jl1=new JLabel("Player 1: ");
        jl1.setBounds(80,40,60,30);
        jf.add(jl1);

        jt1=new JTextField();
        jt1.setBounds(150, 40, 200, 30);
        jf.add(jt1);

        jl2=new JLabel("Player 2: ");
        jl2.setBounds(80,150,60,30);
        jf.add(jl2);

        jt2=new JTextField();
        jt2.setBounds(150, 150, 200, 30);
        jf.add(jt2);

        jl3=new JLabel("Total Series: ");
        jl3.setBounds(80,260,150,30);
        jf.add(jl3);

        String series[]={"1","3","5","7","9"};
        cb=new JComboBox(series);
        cb.setBounds(200,260,200,30);
        jf.add(cb);

        jb=new JButton("Start");
        jb.setBounds(200, 300, 100, 40);
        jb.addActionListener(this);
        jf.add(jb);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        String player1=jt1.getText();
        String player2=jt2.getText();
        String choice=(String)cb.getSelectedItem();

        GamePanel gp=new GamePanel(player1,player2,Integer.parseInt(choice));
        gp.openGamePanel();
        jf.setVisible(false);
    }
}
