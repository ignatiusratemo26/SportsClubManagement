import javax.swing.*;
import java.awt.Color;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class viewEquipmentWindow extends JFrame{
    private JScrollPane resultScrollPane;
    private JPanel resultPanel;
    
    
    public viewEquipmentWindow(){
        resultScrollPane = new JScrollPane();
        resultPanel = new JPanel();
        
        setSize(480,300);
        setTitle("Damaged & Lost Equipment");
                setLocationRelativeTo(null);
                setBackground(Color.WHITE);
                resultScrollPane.setBounds(200, 100, 200,150);
                resultPanel.setBackground(Color.WHITE);
                resultPanel.add(resultScrollPane);
                add(resultPanel);
                setVisible(true);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
