package abcd;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author princ
 */
public class EnterInfo {
                    
	private JFrame frame;
    private JTextField AddressField;
    private JLabel AddressLabel;
    private JButton BackstoMainMenu;
    private JLabel CurrentInvoiceLabel;
    private JTextField DateField;
    private JTextArea DescriptionField;
    private JLabel DescriptionLabel;
    private JPanel InfoPanel;
    private JTextField ItemInfoField;
    private JLabel ItemInfoLabel;
    private JTextField NameField;
    private JLabel NameLabel;
    private JTextField Phone1Field;
    private JFormattedTextField PhoneField;
    private JLabel PhoneLabel;
    private JFormattedTextField PriceField;
    private JLabel PriceLabel;
    private JButton SaveBtn;
    public String CInvoice, CName, CAddress, CPhone, CPhone2;
    public String IDate, IItemDesc, IDescription, IPrice;

    public EnterInfo() {
    	MainXML x = new MainXML();
    	int xinvoice = x.IncrementInvoiceNo();
    	
    	frame = new JFrame();
        InfoPanel = new JPanel();
        BackstoMainMenu = new JButton();
        CurrentInvoiceLabel = new JLabel();
        NameLabel = new JLabel();
        AddressLabel = new JLabel();
        PhoneLabel = new JLabel();
        DateField = new JTextField();
        ItemInfoLabel = new JLabel();
        DescriptionLabel = new JLabel();
        NameField = new JTextField();
        AddressField = new JTextField();
        PhoneField = new JFormattedTextField();
        Phone1Field = new JTextField();
        DescriptionField = new JTextArea();
        PriceLabel = new JLabel();
        PriceField = new JFormattedTextField();
        SaveBtn = new JButton();
        ItemInfoField = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BackstoMainMenu.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        BackstoMainMenu.setText("< Main Menu");
        BackstoMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackstoMainMenuActionPerformed(evt);
            }
        });

        CurrentInvoiceLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        CurrentInvoiceLabel.setText("Invoice No. :" + String.valueOf(xinvoice));

        NameLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        NameLabel.setText("Name :");

        AddressLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        AddressLabel.setText("Address :");

        PhoneLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        PhoneLabel.setText("Phone No. :");

        DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        
        DateField.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        DateField.setText(dateformat.format(date));

        ItemInfoLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        ItemInfoLabel.setText("Item Info :");

        DescriptionLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        DescriptionLabel.setText("Description :");

        NameField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        AddressField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        try {
			MaskFormatter PhoneFormat = new MaskFormatter("(###)-###-####");
			PhoneFormat.setPlaceholderCharacter('_');
			PhoneField = new JFormattedTextField(PhoneFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        PhoneField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        Phone1Field.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        DescriptionField.setColumns(20);
        DescriptionField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N
        DescriptionField.setRows(5);

        PriceLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        PriceLabel.setText("Price :");
        
        try{
        	MaskFormatter PriceFormat = new MaskFormatter("$  ******");
        	PriceFormat.setPlaceholderCharacter(' ');
        	PriceField = new JFormattedTextField(PriceFormat);
        }catch(Exception e){
        	e.printStackTrace();
        }
        PriceField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        SaveBtn.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        ItemInfoField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        GroupLayout InfoPanelLayout = new GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(BackstoMainMenu)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CurrentInvoiceLabel))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(NameLabel)
                                    .addComponent(AddressLabel)
                                    .addComponent(PhoneLabel)
                                    .addComponent(ItemInfoLabel))
                                .addGap(28, 28, 28)
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(Phone1Field, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(NameField)
                                    .addComponent(AddressField)
                                    .addComponent(ItemInfoField)))
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(DescriptionLabel)
                                    .addComponent(PriceLabel))
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PriceField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(DescriptionField, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BackstoMainMenu)
                    .addComponent(DateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(CurrentInvoiceLabel)
                .addGap(0, 0, 0)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressLabel)
                    .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneLabel)
                    .addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Phone1Field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemInfoLabel)
                    .addComponent(ItemInfoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DescriptionLabel)
                    .addComponent(DescriptionField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceLabel))
                .addGap(26, 26, 26)
                .addComponent(SaveBtn)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(InfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(InfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        
        frame.setVisible(true);
        frame.pack();
    }// </editor-fold>                        

    private void BackstoMainMenuActionPerformed(ActionEvent evt) {                                                
        InfoPanel.setVisible(false);
       // MainMenu();
    }                                               

    private void SaveBtnActionPerformed(ActionEvent evt) {                                        
        CInvoice = CurrentInvoiceLabel.getText();
        CName = NameField.getText();
        CAddress = AddressField.getText();
        CPhone = PhoneField.getText();
        CPhone2 = Phone1Field.getText();
        IDate = DateField.getText();
        IItemDesc = ItemInfoField.getText();
        IDescription = DescriptionField.getText();
        IPrice = PriceField.getText();
        
        if(CName.equals("")){
    		JOptionPane.showMessageDialog(frame, "Please Enter Customer Name");
    	}else if(CPhone.equals("")){
    		JOptionPane.showMessageDialog(frame, "Please Enter Customer Phone No.");
    	}else if(IItemDesc.equals("")){
    		JOptionPane.showMessageDialog(frame, "Please Enter Item Info");
    	}else{
    		MainXML XML = new MainXML();
    		XML.AddCustomerInfo(CInvoice, CName, CAddress, CPhone, CPhone2, "", "");
    		XML.AddItemDescription(CInvoice, IDate, IItemDesc, IDescription, IPrice);
    	}
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnterInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EnterInfo();
            }
        });
    }                
}
