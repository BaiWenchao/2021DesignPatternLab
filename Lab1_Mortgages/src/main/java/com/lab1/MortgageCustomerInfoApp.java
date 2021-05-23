package com.lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MortgageCustomerInfoApp {
    private JButton getTheResultButton;
    private JPanel panel1;
    private JTextField today;
    private JTextField enddate;
    private JTextField startdate;
    private JLabel R;
    private JLabel I;
    private JComboBox type;
    private JButton pay;
    private JLabel total;

    public MortgageCustomerInfoApp() {
        getTheResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate startDate = null;
                LocalDate endDate = null;
                LocalDate now = null;
                try {
                    startDate = LocalDate.parse(startdate.getText());
                    endDate = LocalDate.parse(enddate.getText());
                    now = LocalDate.parse(today.getText());
                }catch (Exception exception){
                    System.out.println("Please input the correct format of date (yyyy-MM-dd)");
                }

                Object s = type.getSelectedItem();
                Mortgage m =new Mortgage(500000,500000,startDate,endDate,42);

                if (s.equals("Linear")){
                    // s = 1 -> Linear
                    Payment payment = m.getRequiredPayment(now, 1);
                    R.setText("$"+payment.getRedemption());
                    I.setText("$"+payment.getInterest());
                    total.setText("$"+(payment.getRedemption()+payment.getInterest()));
                }
                else {
                    // s = 2 -> Amoritized
                    Payment payment = m.getRequiredPayment(now, 2);
                    R.setText("$"+payment.getRedemption());
                    I.setText("$"+payment.getInterest());
                    total.setText("$"+(payment.getRedemption()+payment.getInterest()));
                }
            }
        });

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, "Pay success!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MortgageCustomerInfoApp");
        frame.setContentPane(new MortgageCustomerInfoApp().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setVisible(true);
    }

}
