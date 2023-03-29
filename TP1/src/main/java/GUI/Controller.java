package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logic.OperationsP;
import Model.*;

import javax.swing.*;

public class Controller {
    private View view;

    public Controller(View view){
        this.view = view;
        this.view.addButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPoly1;
                String strPoly2;

                OperationsP op = new OperationsP();

                Polynomial p1;
                Polynomial p2;
                try{
                    strPoly1 = view.getFirstTxt();
                    strPoly2 = view.getSecondTxt();
                    p1 = new Polynomial(strPoly1);
                    p2 = new Polynomial(strPoly2);
                    Polynomial r = op.add(p1,p2);
                    view.setOutTxt(r.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.view.subButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPoly1;
                String strPoly2;

                OperationsP op = new OperationsP();

                Polynomial p1;
                Polynomial p2;
                try{
                    strPoly1 = view.getFirstTxt();
                    strPoly2 = view.getSecondTxt();
                    p1 = new Polynomial(strPoly1);
                    p2 = new Polynomial(strPoly2);
                    Polynomial r = op.sub(p1,p2);
                    view.setOutTxt(r.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.view.mulButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPoly1;
                String strPoly2;

                OperationsP op = new OperationsP();

                Polynomial p1;
                Polynomial p2;
                try{
                    strPoly1 = view.getFirstTxt();
                    strPoly2 = view.getSecondTxt();
                    p1 = new Polynomial(strPoly1);
                    p2 = new Polynomial(strPoly2);
                    Polynomial r = op.mul(p1,p2);
                    view.setOutTxt(r.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.view.divButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPoly1;
                String strPoly2;

                OperationsP op = new OperationsP();

                Polynomial p1;
                Polynomial p2;
                try{
                    strPoly1 = view.getFirstTxt();
                    strPoly2 = view.getSecondTxt();
                    p1 = new Polynomial(strPoly1);
                    p2 = new Polynomial(strPoly2);
                    Polynomial[] p;
                    p  = op.div(p1,p2);
                    view.setOutTxt("Q: " + p[0].toString()
                            +   "\nR: "+ p[1].toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.view.itgButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPoly1;

                OperationsP op = new OperationsP();

                Polynomial p1;
                try{
                    strPoly1 = view.getFirstTxt();
                    view.getSecondTxtFld().setText("");
                    p1 = new Polynomial(strPoly1);
                    Polynomial r = op.intg(p1);
                    view.setOutTxt(r.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.view.derButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPoly1;

                OperationsP op = new OperationsP();

                Polynomial p1;
                try{
                    strPoly1 = view.getFirstTxt();
                    view.getSecondTxtFld().setText("");
                    p1 = new Polynomial(strPoly1);
                    Polynomial r = op.der(p1);
                    view.setOutTxt(r.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
