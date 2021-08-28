import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PvP.PvP;

public class MainMenu {
    ImagePanel bg;
    JFrame frame;
    private JButton pvp;
    JButton history;
    JButton htp;
    JButton sound;

    public MainMenu(){
        bg =  new ImagePanel(new ImageIcon("src\\mainBg.png").getImage());
        frame = new JFrame();
        frame.setTitle("Let's Play Chess!");
        frame.setSize(800,600);
        frame.setLocation(200, 20);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(bg);
        pvp = new JButton("Start P1 vs P2");
        history = new JButton("View Match History");
        htp = new JButton("How to Play");
        sound = new JButton("Sound Off");
        pvp.setBounds(325,175,150, 60);
        bg.add(pvp);
        history.setBounds(325,245,150, 60);
        bg.add(history);
        history.setEnabled(false);
        htp.setBounds(325,315,150, 60);
        bg.add(htp);
        htp.setEnabled(false);
        sound.setBounds(325,385,150, 60);
        bg.add(sound);
        sound.setEnabled(false);
        pvp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new PvP();
            }
        });
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        htp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        sound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        frame.setVisible(true);
    }
    public static void main(String[]Args){
        MainMenu mainScreen = new MainMenu();
    }
}
