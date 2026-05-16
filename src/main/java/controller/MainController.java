
package controller;

import java.awt.event.*;
import javax.swing.JOptionPane;
import model.dao.*;
import model.entity.MyException;
import view.*;


public class MainController {
    Menu menu;
    IntroducirRecetaDialog introducirRecetaDialog;
    InitDAO initDAO;
    
    public MainController(){
        start();
    }
    
    private void start(){
        try {
            crearObjetos();
            
            initDAO.crearDB();
            initDAO.crearTablas();
            
            crearListenersMenu();
            crearListenersIntroducirRecetaDialog();

            menu.setVisible(true);
            
        } catch (MyException excepcion) {
            JOptionPane.showMessageDialog(null, excepcion.getMessage());
        }
        
    }
    
    private void crearObjetos(){
        menu = new Menu();
        menu.setLocationRelativeTo(null);
        
        introducirRecetaDialog = new IntroducirRecetaDialog(menu, true);
        introducirRecetaDialog.setLocationRelativeTo(null);
        
        initDAO = new InitDAO();
    }
    
    private void crearListenersMenu(){
        menu.getBtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(1);
            }
        } );
    }
    
    private void crearListenersIntroducirRecetaDialog(){
        menu.getBtnIntroducirReceta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                menu.setVisible(false);
                introducirRecetaDialog.setVisible(true);
            }
        } );
        
        introducirRecetaDialog.getBtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                introducirRecetaDialog.setVisible(false);
                menu.setVisible(true);
            }
        } );
    }
}
