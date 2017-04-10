package com.agile.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.agile.model.Abonat;
import com.agile.model.CarteDeTelefon;
import com.agile.model.Cautare;
import com.agile.model.NrFix;
import com.agile.model.NrMobil;
import com.agile.model.Verificare;

public class Agenda {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
	private Table table;

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
		
		ScrolledForm scrldfrmListingabonati = formToolkit.createScrolledForm(shell);
		scrldfrmListingabonati.setBounds(36, 37, 456, 297);
		formToolkit.paintBordersFor(scrldfrmListingabonati);
		scrldfrmListingabonati.setText("Abonati");
		
		table = new Table(scrldfrmListingabonati.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(20, 10, 404, 244);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNume = new TableColumn(table, SWT.NONE);
		tblclmnNume.setWidth(100);
		tblclmnNume.setText("Nume");
		
		TableColumn tblclmnPrenume = new TableColumn(table, SWT.NONE);
		tblclmnPrenume.setWidth(100);
		tblclmnPrenume.setText("Prenume");

		TableColumn tblclmnCnp = new TableColumn(table, SWT.NONE);
		tblclmnCnp.setWidth(100);
		tblclmnCnp.setText("CNP");

		TableColumn tblclmnNrtelefon = new TableColumn(table, SWT.NONE);
		tblclmnNrtelefon.setWidth(100);
		tblclmnNrtelefon.setText("Nr.Telefon");

		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		formToolkit.adapt(tableCursor);
		formToolkit.paintBordersFor(tableCursor);

		final Label lblCautare = new Label(shell, SWT.NONE);
		lblCautare.setBounds(36, 0, 360, 41);
		formToolkit.adapt(lblCautare, true, true);
		lblCautare.setText("");
		lblCautare.setVisible(false);

		final Button btnStergereFiltre = new Button(shell, SWT.NONE);
		btnStergereFiltre.setBounds(402, 0, 90, 31);
		formToolkit.adapt(btnStergereFiltre, true, true);
		btnStergereFiltre.setText("Stergere filtre");
		btnStergereFiltre.setVisible(false);

		//on INREGISTRARE
		mntmInregistrare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JPanel inregistrare = new JPanel();
				JPanel labels = new JPanel(new GridLayout(0,1,2,2));
				labels.add(new JLabel("Cod inregistrare", SwingConstants.RIGHT));
				inregistrare.add(labels, BorderLayout.WEST);
				JPanel controls = new JPanel(new GridLayout(0,1,2,2));
			    JPasswordField codInregistrare = new JPasswordField(15);
			    controls.add(codInregistrare);
			    inregistrare.add(controls, BorderLayout.CENTER);
			    int result = JOptionPane.showConfirmDialog(null, inregistrare, "Inregistrare", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			    	char [] parola = codInregistrare.getPassword();
			    	if(parola[0] == 'c' && parola[1] == 'o' && parola[2] == 'd' && parola[3] == '@') {
//					if(codInregistrare.getPassword().equals("codInregistrare")) {
						mntmOpen.setEnabled(true);
						mntmSave.setEnabled(true);
						mntmAbonati.setEnabled(true);
						mntmHelp.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(inregistrare, "Cod de inregistrare invalid!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		//on CAUTA
		mntmCauta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JPanel cautareAbonati = new JPanel();
				JPanel labels = new JPanel(new GridLayout(0,1,2,2));
				labels.add(new JLabel("Nume", SwingConstants.RIGHT));
		        labels.add(new JLabel("Prenume", SwingConstants.RIGHT));
		        labels.add(new JLabel("CNP", SwingConstants.RIGHT));
		        labels.add(new JLabel("Nr. Telefon", SwingConstants.RIGHT));
		        cautareAbonati.add(labels, BorderLayout.WEST);
		        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
		        JTextField firstName = new JTextField(15);
				JTextField lastName = new JTextField(15);
				JTextField cnp = new JTextField(15);
				JTextField phone = new JTextField(15);
				controls.add(firstName);
				controls.add(lastName);
				controls.add(cnp);
				controls.add(phone);
				cautareAbonati.add(controls, BorderLayout.CENTER);
				int result = JOptionPane.showConfirmDialog(null, cautareAbonati, "Cautare abonat", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					List<Abonat> lista = carteDeTelefon.getListaAbonati();
					List<Integer> indexesToRemove = new ArrayList<Integer>();
					String filtrare = "Rezultate filtrate dupa: ";
					if(!firstName.getText().equals("")) {
						filtrare +=  "nume = " + firstName.getText() + ", \n";
					}
					if(!lastName.getText().equals("")) {
						filtrare += " prenume = " + lastName.getText()  + ", ";
					}
					if(!cnp.getText().equals("")) {
						filtrare += " CNP = " + cnp.getText()  + ", ";
					}
					if(!phone.getText().equals("")) {
						filtrare += " nr. telefon = " + phone.getText()  + ", ";
					}
					indexesToRemove=Cautare.cautareCompleta(lista, firstName.getText(), lastName.getText(), cnp.getText(), phone.getText());
					table.removeAll();
					for(int i = 0 ; i < lista.size(); i++ ) {
						if(!indexesToRemove.contains(i)) {
							TableItem linie = new TableItem(table, SWT.NONE);
							linie.setText(new String [] {lista.get(i).getNume(), lista.get(i).getPrenume(), lista.get(i).getCNP(), lista.get(i).getNrTelefon().getNumar() });
						}
					}
					if(indexesToRemove.size() > 0) {
						lblCautare.setText(filtrare.substring(0, filtrare.length()-2));
						lblCautare.setVisible(true);
						btnStergereFiltre.setVisible(true);
					} else {
						lblCautare.setVisible(false);
						btnStergereFiltre.setVisible(false);
					}

				}
			}
		});

		//on ADAUGA
		mntmAdauga.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JPanel adaugareAbonat = new JPanel();
				JPanel labels = new JPanel(new GridLayout(0,1,2,2));
				labels.add(new JLabel("Nume", SwingConstants.RIGHT));
		        labels.add(new JLabel("Prenume", SwingConstants.RIGHT));
		        labels.add(new JLabel("CNP", SwingConstants.RIGHT));
		        labels.add(new JLabel("Telefon fix", SwingConstants.RIGHT));
		        labels.add(new JLabel("Telefon mobil", SwingConstants.RIGHT));
		        labels.add(new JLabel("Nr. Telefon", SwingConstants.RIGHT));
		        adaugareAbonat.add(labels, BorderLayout.WEST);
		        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
		        JTextField firstName = new JTextField(15);
				JTextField lastName = new JTextField(15);
				JTextField cnp = new JTextField(15);
				JRadioButton telefonFix = new JRadioButton();
				JRadioButton telefonMobil = new JRadioButton();
				ButtonGroup bG = new ButtonGroup();
			    bG.add(telefonFix);
			    bG.add(telefonMobil);
			    telefonMobil.setSelected(true);
				JTextField phone = new JTextField(15);
				controls.add(firstName);
				controls.add(lastName);
				controls.add(cnp);
				controls.add(telefonFix);
				controls.add(telefonMobil);
				controls.add(phone);
				adaugareAbonat.add(controls, BorderLayout.CENTER);
				int result = JOptionPane.showConfirmDialog(null, adaugareAbonat, "Adaugare abonat", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					Abonat abonat;
					List<Abonat> lista = carteDeTelefon.getListaAbonati();
					switch(Verificare.codEroare(firstName.getText(), lastName.getText(), cnp.getText(), phone.getText(), telefonMobil.isSelected(), lista)) {
						case 1:
							JOptionPane.showMessageDialog(adaugareAbonat, "Numele de abonat este obligatoriu!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						case 2:
							JOptionPane.showMessageDialog(adaugareAbonat, "Prenumele de abonat este obligatoriu!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						case 3:
							JOptionPane.showMessageDialog(adaugareAbonat, "CNP invalid!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						case 4:
							JOptionPane.showMessageDialog(adaugareAbonat, "Numar de telefon invalid!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						case 5:
							JOptionPane.showMessageDialog(adaugareAbonat, "Numar de telefon invalid!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						case 6:
							JOptionPane.showMessageDialog(adaugareAbonat, "CNP-ul introdus este deja folosit!", "Error", JOptionPane.ERROR_MESSAGE);
							return;
					}
					if(telefonFix.isSelected()) {
						abonat = new Abonat(firstName.getText(), lastName.getText(), cnp.getText(), new NrFix(phone.getText()));
					} else {
						abonat = new Abonat(firstName.getText(), lastName.getText(), cnp.getText(), new NrMobil(phone.getText()));
					}
					carteDeTelefon.adaugaAbonat(abonat);
					TableItem itemNume = new TableItem(table, SWT.NONE);
					itemNume.setText(new String [] {abonat.getNume(), abonat.getPrenume(), abonat.getCNP(), abonat.getNrTelefon().getNumar() });
				}
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
