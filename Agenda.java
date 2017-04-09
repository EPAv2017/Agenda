package com.agile.ui;

import java.awt.Container;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class Agenda {

	protected Shell shell;
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JWindow splash = new JWindow();
			Container container = splash.getContentPane();
			container.add(new JLabel("", new ImageIcon(new URL("http://www.midorax.ro/uploads/produse/mare/14270574597794786.jpg")), SwingConstants.CENTER));
			splash.setBounds(500, 150, 375, 375);
			splash.setVisible(true);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			splash.setVisible(false);
			Agenda window = new Agenda();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(536, 420);
		shell.setText("Agenda telefonica");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");

		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);

		final MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.setText("Open");
		mntmOpen.setEnabled(false);

		final MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText("Save");
		mntmSave.setEnabled(false);

		new MenuItem(menu_1, SWT.SEPARATOR);

		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");

		final MenuItem mntmAbonati = new MenuItem(menu, SWT.CASCADE);
		mntmAbonati.setText("Abonati");
		mntmAbonati.setEnabled(false);
		
		Menu menu_2 = new Menu(mntmAbonati);
		mntmAbonati.setMenu(menu_2);

		MenuItem mntmAdauga = new MenuItem(menu_2, SWT.NONE);
		mntmAdauga.setText("Adauga");

		MenuItem mntmCauta = new MenuItem(menu_2, SWT.NONE);
		mntmCauta.setText("Cauta");

		MenuItem mntmSterge = new MenuItem(menu_2, SWT.NONE);
		mntmSterge.setText("Sterge");

		MenuItem mntmModifica = new MenuItem(menu_2, SWT.NONE);
		mntmModifica.setText("Modifica");

		final MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");

		Menu menu_3 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_3);

		MenuItem mntmInregistrare = new MenuItem(menu_3, SWT.NONE);
		mntmInregistrare.setText("Inregistrare");

		new MenuItem(menu_3, SWT.SEPARATOR);

		MenuItem mntmAbout = new MenuItem(menu, SWT.NONE);
		mntmAbout.setText("About");
		
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent se) {
				System.exit(0);
			}
        });

		//on EXIT
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Doriti sa parasiti aplicatia?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}

}
