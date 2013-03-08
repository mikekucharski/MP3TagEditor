package editor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener{
	
	private JPanel pnlMain;
	private JTextField txtDirectoryPath, txtCustomGenre;
	private JLabel lblDirectory, lblError;
	private JRadioButton rdbtnDeathcore, rdbtnPopPunk, rdbtnOther, rdbtnSingle, rdbtnList;
	private ButtonGroup typeSelector, genreSelector;
	private JCheckBox chkIgnoreArtwork;
	private JButton btnDone, btnFileChooser;
	private JTextArea taLog;
	private JScrollPane scrollLog;
	
	public MainMenu() {
		setTitle("MP3 Tag Formatter");
	    setSize(469, 388);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    Color blue = new Color(26, 140, 149);
	    
	    pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setBackground(blue);
		
		getContentPane().add(pnlMain);
		
		btnFileChooser = new JButton("...");
		btnFileChooser.setToolTipText("Select A File Location");
		btnFileChooser.setBounds(413, 40, 37, 25);
		btnFileChooser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				openJFileChooser();
			}
		});
		pnlMain.add(btnFileChooser);
		
		txtDirectoryPath = new JTextField();
		txtDirectoryPath.setEditable(false);
		txtDirectoryPath.setBounds(21, 40, 382, 25);
		pnlMain.add(txtDirectoryPath);
		txtDirectoryPath.setColumns(10);
		
		lblDirectory = new JLabel("Directory:");
		lblDirectory.setForeground(Color.WHITE);
		lblDirectory.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblDirectory.setBounds(21, 11, 78, 25);
		pnlMain.add(lblDirectory);
		
		rdbtnDeathcore = new JRadioButton("Deathcore");
		rdbtnDeathcore.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnDeathcore.setForeground(Color.ORANGE);
		rdbtnDeathcore.setBackground(blue);
		rdbtnDeathcore.setBounds(21, 75, 109, 20);
		rdbtnDeathcore.setActionCommand("Deathcore");
		rdbtnDeathcore.setSelected(true);
		rdbtnDeathcore.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				txtCustomGenre.setEnabled(false);
			}
		});
		pnlMain.add(rdbtnDeathcore);

	    rdbtnPopPunk = new JRadioButton("Pop Punk");
	    rdbtnPopPunk.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnPopPunk.setForeground(Color.ORANGE);
	    rdbtnPopPunk.setBounds(21, 95, 109, 20);
	    rdbtnPopPunk.setBackground(blue);
		rdbtnPopPunk.setActionCommand("Pop Punk");
		rdbtnPopPunk.setSelected(false);
		rdbtnPopPunk.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				txtCustomGenre.setEnabled(false);
			}
		});
		pnlMain.add(rdbtnPopPunk);
		
		rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnOther.setForeground(Color.ORANGE);
		rdbtnOther.setBounds(21, 115, 109, 20);
		rdbtnOther.setBackground(blue);
		rdbtnOther.setActionCommand("Other");
		rdbtnOther.setSelected(false);
		rdbtnOther.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				txtCustomGenre.setText("Metal");
				txtCustomGenre.setEnabled(true);
			}
		});
		pnlMain.add(rdbtnOther);
		
		 //Group the radio buttons.
	    genreSelector = new ButtonGroup();
	    genreSelector.add(rdbtnDeathcore);
	    genreSelector.add(rdbtnPopPunk);
	    genreSelector.add(rdbtnOther);
		
		chkIgnoreArtwork = new JCheckBox("Ignore Artwork");
		chkIgnoreArtwork.setFont(new Font("Tahoma", Font.BOLD, 14));
		chkIgnoreArtwork.setForeground(Color.ORANGE);
		chkIgnoreArtwork.setBackground(blue);
		chkIgnoreArtwork.setBounds(151, 139, 140, 23);
		chkIgnoreArtwork.setSelected(false);
		pnlMain.add(chkIgnoreArtwork);
		
		txtCustomGenre = new JTextField();
		txtCustomGenre.setToolTipText("This genre will be assigned to your songs.");
		txtCustomGenre.setEnabled(false);
		txtCustomGenre.setText("Enter a genre.");
		txtCustomGenre.setBounds(21, 142, 109, 20);
		pnlMain.add(txtCustomGenre);
		
		btnDone = new JButton("Format Songs");
		btnDone.setBounds(274, 76, 176, 39);
		btnDone.setActionCommand("Format");
		btnDone.addActionListener(this);
		pnlMain.add(btnDone);
		
		rdbtnList = new JRadioButton("Many CDs");
		rdbtnList.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnList.setForeground(Color.ORANGE);
		rdbtnList.setBackground(blue);
		rdbtnList.setSelected(true);
		rdbtnList.setActionCommand("List");
		rdbtnList.setBounds(151, 75, 109, 20);
		pnlMain.add(rdbtnList);
		
		rdbtnSingle = new JRadioButton("Single CD");
		rdbtnSingle.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnSingle.setForeground(Color.ORANGE);
		rdbtnSingle.setBackground(blue);
		rdbtnSingle.setSelected(false);
		rdbtnSingle.setActionCommand("Single");
		rdbtnSingle.setBounds(151, 95, 109, 20);
		pnlMain.add(rdbtnSingle);
		
		 //Group the radio buttons.
	    typeSelector = new ButtonGroup();
	    typeSelector.add(rdbtnSingle);
	    typeSelector.add(rdbtnList);
	    
	    lblError = new JLabel("Error");
	    lblError.setForeground(Color.ORANGE);
	    lblError.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	    lblError.setBounds(118, 11, 332, 18);
	    lblError.setVisible(false);
	    pnlMain.add(lblError);
	    
	    taLog = new JTextArea();
	    taLog.setMargin(new Insets(8, 8, 8, 8));
	    taLog.setEditable(false);
	    taLog.setLineWrap(true);
	    taLog.setWrapStyleWord(true);
	    taLog.setCaretPosition(taLog.getDocument().getLength());
		
		scrollLog = new JScrollPane(taLog);
		scrollLog.setBounds(21, 173, 429, 77);
		scrollLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlMain.add(scrollLog);
	    
		///
	    JTextArea taErrorLog = new JTextArea();
	    taErrorLog.setBounds(21, 262, 429, 87);
	    pnlMain.add(taErrorLog);
	
	}
	
	@SuppressWarnings("static-access")
	private boolean openJFileChooser() {
		JFileChooser chooser = new JFileChooser("C:\\Users\\Kucharskim\\Downloads");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(chooser.showOpenDialog(null) == chooser.APPROVE_OPTION){		
			txtDirectoryPath.setText(chooser.getSelectedFile().toString());
		}
		else{
			System.out.println("No file selected.");	
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() instanceof JButton){
			JButton temp = (JButton) event.getSource();
			if(temp.getActionCommand() == "Format"){
				taLog.setText("");
				lblError.setVisible(false);
				
				if(txtDirectoryPath.getText().isEmpty()){
					lblError.setText("You have not selected a directory!");
					lblError.setVisible(true);
					return;
				}
				formatCD();
			}
		}
	}
	
	public void formatCD(){
		String genre;
		if(genreSelector.getSelection().getActionCommand() == "Other"){
			genre = txtCustomGenre.getText().toString(); 
		}
		else{
			genre = genreSelector.getSelection().getActionCommand().toString();
		}
		if(rdbtnList.isSelected()){
			File albumDirectoryParent = new File(txtDirectoryPath.getText());
			ArrayList<File> cdList = new ArrayList<File>();
			File[] cdFileList;
			try{
				cdFileList = albumDirectoryParent.listFiles();
				for(int i = 0; i < cdFileList.length; i++){
					if (cdFileList[i].isDirectory()) {
						cdList.add(cdFileList[i]);
					}
				}
			}catch(NullPointerException e){
				lblError.setText("ERROR: Invalid Directory!");
				lblError.setVisible(true);
				return;
			}
			

			if(cdList.size() < 2){
				lblError.setText("You selected multiple CDs but there was < 1");
				lblError.setVisible(true);
				return;
			}
			
			System.out.println("There are " + cdList.size() + " album folders in the working directory.\n");
			
			for(int cdNum = 0; cdNum < cdList.size(); cdNum++){
				CDFormatter formatter;
				try{
					formatter = new CDFormatter(cdList.get(cdNum).toString(), genre);
					formatter.setMenu(this);
				}catch(NullPointerException e){
					lblError.setText("ERROR: Invalid Directory!");
					lblError.setVisible(true);
					return;
				}
				formatter.printFileCount();
				if(formatter.getNumberOfSongsInDir() == 0){
					lblError.setText("There are no mp3 files in the directory you chose!");
					lblError.setVisible(true);
					continue;
				}
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				if(!chkIgnoreArtwork.isSelected())	{
					if(!formatter.embedCover())	{
						System.out.println("\n***ERROR: Album cover Not Found. Could not find image in directory and extraction failed.*** \n" +
								"***Skipping this directory.***\n");
						setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						continue;
					}
				}
				formatter.doMagic();
			}
		}
		else{
			CDFormatter formatter;
			try{
				formatter = new CDFormatter(txtDirectoryPath.getText(), genre);
				formatter.setMenu(this);
			}catch(NullPointerException e){
				lblError.setText("***ERROR: Directory cannot be found. Please select a valid directory.***");
				lblError.setVisible(true);
				return;
			}
			formatter.printFileCount();
			if(formatter.getNumberOfSongsInDir() == 0){
				lblError.setText("There are no mp3 files in the dir you chose!");
				lblError.setVisible(true);
				return;
			}
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			if(!chkIgnoreArtwork.isSelected())	{ 
				if(!formatter.embedCover())	{
					System.out.println("\n***ERROR: Album cover Not Found. Could not find image in directory and extraction failed.*** \n" +
							"***Skipping this directory.***\n");
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					return;
				}
			}
			
			formatter.doMagic();
		}
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));	
	}
	
	public void addTextToLog(String text)
	{
		taLog.append(text+"\n");
		taLog.setCaretPosition(taLog.getDocument().getLength());
		validate();
		repaint();
	}
}
