package br.senai.sp.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import br.senai.sp.frames.FrmLogin;;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	
		FrmLogin log = new FrmLogin();
		log.setLocationRelativeTo(null);
		log.setVisible(true);

	}

}
