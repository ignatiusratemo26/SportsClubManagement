import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class purchaseWindow extends JFrame{
    private JLabel bloomerLabel, hockeyLabel;
    private JSpinner bloomerSpinner;
    private JButton receiptButton;
    private JLabel jLabel1, jLabel10, jLabel11,jLabel12 ,jLabel13 ,jLabel14 ,jLabel15 ,jLabel16 ,jLabel17 ,jLabel18 ,jLabel19,jLabel2,jLabel20;
    private JLabel jLabel21,jLabel22 ,jLabel23 ,jLabel24 ,jLabel25 , titleLabel, jLabel3, jLabel4, jLabel5,jLabel6 ,jLabel7;
    private JLabel jLabel8, jLabel9;
    private JPanel jPanel1;
    private JButton orderButton;
    private JCheckBox shoeBox, socksBox, tracksuitBox,tshirtBox, wrapperBox, bloomerBox, shortsBox, hockeyBox;
    private JSpinner shoeSpinner, shortsSpinner,socksSpinner,tracksuitSpinner,tshirtSpinner, wrapperSpinner,hockeySpinner;
    private JLabel shortsLabel;
    private JLabel socksLabel,sportShoeLabel,totalText,tracksuitLabel,tshirtLabel,wrapperLabel;
    private JLabel mainLabel;
    private String receiptText = "";
    Connection connection = DBConnectionManager.getConnection();
    
    public purchaseWindow(){
        setSize(200,400);        
        jPanel1 = new javax.swing.JPanel();
        hockeyLabel = new javax.swing.JLabel();
        tracksuitLabel = new javax.swing.JLabel();
        socksLabel = new javax.swing.JLabel();
        shortsLabel = new javax.swing.JLabel();
        sportShoeLabel = new javax.swing.JLabel();
        wrapperLabel = new javax.swing.JLabel();
        bloomerLabel = new javax.swing.JLabel();
        tshirtLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
                shoeSpinner = new JSpinner();
        hockeySpinner = new JSpinner();
        shortsSpinner = new JSpinner();
        socksSpinner = new JSpinner();
        tshirtSpinner = new JSpinner();
        wrapperSpinner = new JSpinner();
        bloomerSpinner = new JSpinner();
        tracksuitSpinner = new JSpinner();
        jLabel25 = new JLabel();
        totalText = new JLabel();
        orderButton = new JButton();
        receiptButton = new JButton();
        shoeBox = new JCheckBox("Sneakers");
        shortsBox = new JCheckBox("Shorts");
        tracksuitBox = new JCheckBox("TrackSuit");
        bloomerBox = new JCheckBox("Bloomer");
        hockeyBox = new JCheckBox("Hockey stick");
        socksBox = new JCheckBox("Socks");
        tshirtBox = new JCheckBox("T-shirt");
        wrapperBox = new JCheckBox("Wrapper");
        titleLabel = new JLabel();
        
        jPanel1.setBackground(new Color(255, 255, 255));
        jLabel9 = new JLabel("Price: 2000");
        jLabel10 = new JLabel("Price: 750");
        jLabel11 = new JLabel("Price: 1000");
        jLabel12 = new JLabel("Price: 250");
        jLabel13 = new JLabel("Price: 2000");
        jLabel14 = new JLabel("Price : 350");
        jLabel15 = new JLabel("Price: 800");
        jLabel16 = new JLabel("Price: 450");
        jLabel17 = new JLabel("Quantity");
        jLabel18 = new JLabel("Quantity");
        jLabel19 = new JLabel("Quantity");
        jLabel20 = new JLabel("Quantity");
        jLabel21 = new JLabel("Quantity");
        jLabel22 = new JLabel("Quantity");
        jLabel23 = new JLabel("Quantity");
        jLabel24 = new JLabel("Quantity");
        jLabel25.setText("Total:");
        totalText.setText("----");
        orderButton.setText("Order");
        orderButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        orderButton.setBackground(new Color(145, 17, 245));
        orderButton.setForeground(Color.WHITE);

        receiptButton.setText("Receipt");
        receiptButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        receiptButton.setBackground(new Color(145, 17, 245));
        receiptButton.setForeground(Color.WHITE);
        receiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    StringBuilder receipt = new StringBuilder("Receipt:\n\n");

                    if (shoeBox.isSelected()) {
                        int value8 = (Integer) shoeSpinner.getValue();
                        receipt.append(value8).append(" x Sneakers @2000/=").append(" : Ksh.").append(value8 * 2000).append("\n");
                        updateStockLevel( "Sports shoes",value8);
                    }
                    if (shortsBox.isSelected()) {
                        int value7 = (Integer) shortsSpinner.getValue();
                        receipt.append(value7).append(" x Shorts @750/=").append(" : Ksh.").append(value7 * 750).append("\n");
                        updateStockLevel( "Games shorts",value7);
                    }
                    if (tracksuitBox.isSelected()) {
                        int value1 = (Integer) tracksuitSpinner.getValue();
                        receipt.append(value1).append(" x TrackSuit @1000/=").append(" : Ksh.").append(value1 * 1000).append("\n");
                        updateStockLevel( "Track suit",value1);
                    }
                    if (bloomerBox.isSelected()) {
                        int value2 = (Integer) bloomerSpinner.getValue();
                        receipt.append(value2).append(" x Bloomer @250/=").append(" : Ksh.").append(value2 * 250).append("\n");
                        updateStockLevel( "Bloomer",value2);
                    }
                    if (hockeyBox.isSelected()) {
                        int value3 = (Integer) hockeySpinner.getValue();
                        receipt.append(value3).append(" x Hockey stick @2000/=").append(" : Ksh.").append(value3 * 2000).append("\n");
                        updateStockLevel( "Hockey stick",value3);
                    }
                    if (wrapperBox.isSelected()) {
                        int value4 = (Integer) wrapperSpinner.getValue();
                        receipt.append(value4).append(" x Wrapper @450/=").append(" : Ksh.").append(value4 * 450).append("\n");
                        updateStockLevel( "Wrapper",value4);
                    }
                    if (socksBox.isSelected()) {
                        int value5 = (Integer) socksSpinner.getValue();
                        receipt.append(value5).append(" x Socks @350/=").append(" : Ksh.").append(value5 * 350).append("\n");
                        updateStockLevel( "Socks",value5);
                    }
                    if (tshirtBox.isSelected()) {
                        int value6 = (Integer) tshirtSpinner.getValue();
                        receipt.append(value6).append(" x T-shirt @800/=").append(" : Ksh.").append(value6 * 800).append("\n");
                        updateStockLevel( "T-shirt",value6);
                    }

                    receipt.append("\nTotal: Ksh.").append(totalText.getText());

                    JOptionPane.showMessageDialog(null, receipt.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        

        titleLabel.setText("MARINGO SHOP");
        titleLabel.setFont(new Font("CALIBRI", Font.BOLD, 15));
        titleLabel.setForeground(Color.BLUE);
        
        orderButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double total = 0;
                int value;
                
                if ( shoeBox.isSelected()){
                    int value8 = (Integer) shoeSpinner.getValue();
                    total += (value8 *2000 );
                    receiptText += (value8 + " Sneakers: "+(value8 *2000) );
                }
                if ( shortsBox.isSelected()){
                    int value7 = (Integer) shortsSpinner.getValue();
                    total += (value7 *750 );
                    receiptText += (value7 + "Shorst: "+ (value7 * 750));
                }
                if ( tracksuitBox.isSelected()){
                    int value1 = (Integer) tracksuitSpinner.getValue();
                    total += (value1 * 1000 );
                }
                if (bloomerBox.isSelected()){
                    int value2 = (Integer) bloomerSpinner.getValue();
                    total += (value2 *250 );
                }   
                if(hockeyBox.isSelected()){
                    int value3 = (Integer)hockeySpinner.getValue();
                    total += (value3 *2000 );
                }
                
                if(wrapperBox.isSelected()){
                    int value4 = (Integer) wrapperSpinner.getValue();
                    total += (value4 *450 );
                }
                if(socksBox.isSelected()){
                    int value5 = (Integer) socksSpinner.getValue();
                    total += (value5 *350 );
                }
                if(tshirtBox.isSelected()){
                    int value6 = (Integer) tshirtSpinner.getValue();
                    total += (value6 *800 );
                }               
                totalText.setText( String.valueOf(total));
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shoeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(sportShoeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shoeBox)
                            .addComponent(hockeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(hockeyBox))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hockeySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7)))
                            .addComponent(socksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(socksSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(socksBox)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shortsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addComponent(shortsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shortsBox)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tracksuitBox)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tracksuitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tshirtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(jLabel6)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel15)
                                                    .addGap(46, 46, 46)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(tshirtSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(wrapperBox)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(wrapperSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(wrapperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel16)
                                                            .addComponent(jLabel8))))
                                                .addGap(58, 58, 58)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(orderButton)
                                                            .addComponent(receiptButton))
                                                        .addGap(0, 59, Short.MAX_VALUE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel25)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tshirtBox)
                                    .addComponent(jLabel23))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bloomerBox)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tracksuitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel2)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(28, 28, 28))
                                    .addComponent(titleLabel))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel3))
                                        .addComponent(bloomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bloomerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tracksuitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shortsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sportShoeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(shoeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shortsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tracksuitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloomerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shoeBox)
                    .addComponent(shortsBox)
                    .addComponent(tracksuitBox)
                    .addComponent(bloomerBox)
                    .addComponent(orderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hockeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(socksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tshirtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wrapperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(totalText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(receiptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel17)
                    .addComponent(hockeySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(socksSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tshirtSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wrapperSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hockeyBox)
                    .addComponent(socksBox)
                    .addComponent(tshirtBox)
                    .addComponent(wrapperBox))
                .addContainerGap())
        );

        hockeyLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/hockey.png")));
        tracksuitLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/tracksuit.jpeg")));
        socksLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/socks.jpeg")));
        shortsLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/shorts.jpeg")));
        sportShoeLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/shoes.jpeg")));
        wrapperLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/wrapper.jpeg")));
        bloomerLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/bloomer1.jpeg")));
        tshirtLabel.setIcon(new ImageIcon(getClass().getResource("/shopFolder/tshirt.jpeg")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
    }
    public void updateStockLevel(String item, int itemQty){
        
        String query = "UPDATE items SET stock_level = stock_level - ? WHERE item_name = ?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, itemQty);
            ps.setString(2, item);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"An error occurred.");
        }
    }
}
