package Yatzy;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HighScoreWindow extends JFrame {

    private JPanel topPanel = new JPanel();
    private JLabel header = new JLabel("Scoreboard");
    private JTextArea scoreArea = new JTextArea();
    private JScrollPane sp = new JScrollPane(scoreArea);
    private List<Score> list;

    public HighScoreWindow(List<Score> list){
        this.list = list;
        setUpScoreBoardLabel();
        setUpScoreBoard();
        printToScoreboard();
        setUpJFrame();
    }

    public void setUpScoreBoardLabel(){
        this.setLayout(new BorderLayout());
        header.setFont(new Font("MonoSpaced", Font.PLAIN,24));
        topPanel.add(header);
        add(topPanel,BorderLayout.NORTH);
    }

    public void setUpScoreBoard(){
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scoreArea.setEditable(false);
        sp.setPreferredSize(new Dimension(280,390));
        scoreArea.setFont(new Font("MonoSpaced", Font.PLAIN,14));
        add(sp,BorderLayout.CENTER);
    }

    public void printToScoreboard(){
        for(int i = 0; i < list.size(); i++){
            String nr = String.format("%-4d",(i+1));
            String line = nr + list.get(i).toString() + "\n";
            scoreArea.append(line);
        }
    }

    public void setUpJFrame(){
        this.setLocation(1000,150);
        this.setSize(320,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
