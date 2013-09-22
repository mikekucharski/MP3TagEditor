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
import javax.swing.UIManager;

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
	private JRadioButton rdbtnGenre1, rdbtnGenre2, rdbtnGenreOther, rdbtnSingleCD, rdbtnManyCDs;
	private ButtonGroup typeSelector, genreSelector;
	private JCheckBox chkIgnoreArtwork;
	private JButton btnFormat, btnChooseFile;
	private JTextArea taOutputLog;
	private JScrollPane scrollLog;
	private CDFormatter formatter;
	
	public MainMenu() 
	{
		this.setTitle("MP3 Tag Formatter");
	    this.setSize(674, 295);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setBackground(new Color(0, 128, 0));
		this.getContentPane().add(pnlMain);
		
		btnChooseFile = new JButton("...");
		btnChooseFile.setToolTipText("Select A File Location");
		btnChooseFile.setBounds(608, 37, 42, 25);
		btnChooseFile.setActionCommand("ChooseFile");
		btnChooseFile.addActionListener(this);
		pnlMain.add(btnChooseFile);
		
		txtDirectoryPath = new JTextField();
		txtDirectoryPath.setEditable(false);
		txtDirectoryPath.setBounds(92, 37, 506, 25);
		pnlMain.add(txtDirectoryPath);
		
		lblDirectory = new JLabel("Directory:");
		lblDirectory.setForeground(Color.WHITE);
		lblDirectory.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDirectory.setBounds(21, 37, 65, 25);
		pnlMain.add(lblDirectory);
		
		chkIgnoreArtwork = new JCheckBox("Ignore Artwork");
		chkIgnoreArtwork.setFont(new Font("Tahoma", Font.BOLD, 14));
		chkIgnoreArtwork.setForeground(Color.ORANGE);
		chkIgnoreArtwork.setBackground(new Color(0, 128, 0));
		chkIgnoreArtwork.setBounds(169, 154, 135, 23);
		chkIgnoreArtwork.setSelected(false);
		pnlMain.add(chkIgnoreArtwork);
		
		txtCustomGenre = new JTextField();
		txtCustomGenre.setToolTipText("This genre will be assigned to your songs.");
		txtCustomGenre.setEnabled(false);
		txtCustomGenre.setText("Enter a genre.");
		txtCustomGenre.setBounds(21, 157, 109, 20);
		pnlMain.add(txtCustomGenre);
		
		btnFormat = new JButton("Format Songs");
		btnFormat.setForeground(new Color(165, 42, 42));
		btnFormat.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnFormat.setBounds(21, 204, 265, 46);
		btnFormat.setActionCommand("Format");
		btnFormat.addActionListener(this);
		pnlMain.add(btnFormat);
	    
	    lblError = new JLabel("Error");
	    lblError.setForeground(Color.ORANGE);
	    lblError.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    lblError.setBounds(92, 11, 506, 18);
	    lblError.setVisible(false);
	    pnlMain.add(lblError);
	    
	    taOutputLog = new JTextArea();
	    taOutputLog.setMargin(new Insets(8, 8, 8, 8));
	    taOutputLog.setEditable(false);
	    taOutputLog.setLineWrap(true);
	    taOutputLog.setWrapStyleWord(true);
	    taOutputLog.setCaretPosition(taOutputLog.getDocument().getLength());
		
		scrollLog = new JScrollPane(taOutputLog);
		scrollLog.setBounds(307, 73, 343, 177);
		scrollLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlMain.add(scrollLog);
		
		// Type radio buttons
		rdbtnManyCDs = new JRadioButton("Many CDs");
		rdbtnManyCDs.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnManyCDs.setForeground(Color.ORANGE);
		rdbtnManyCDs.setBackground(new Color(0, 128, 0));
		rdbtnManyCDs.setSelected(true);
		rdbtnManyCDs.setActionCommand("List");
		rdbtnManyCDs.setBounds(169, 84, 100, 20);
		pnlMain.add(rdbtnManyCDs);
		
		rdbtnSingleCD = new JRadioButton("Single CD");
		rdbtnSingleCD.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnSingleCD.setForeground(Color.ORANGE);
		rdbtnSingleCD.setBackground(new Color(0, 128, 0));
		rdbtnSingleCD.setSelected(false);
		rdbtnSingleCD.setActionCommand("Single");
		rdbtnSingleCD.setBounds(169, 107, 109, 20);
		pnlMain.add(rdbtnSingleCD);
		
		 //Group the radio buttons.
	    typeSelector = new ButtonGroup();
	    typeSelector.add(rdbtnSingleCD);
	    typeSelector.add(rdbtnManyCDs);
		
		// Genre radio buttons
		rdbtnGenre1 = new JRadioButton("Deathcore");
		rdbtnGenre1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnGenre1.setForeground(Color.ORANGE);
		rdbtnGenre1.setBackground(new Color(0, 128, 0));
		rdbtnGenre1.setBounds(21, 84, 109, 20);
		rdbtnGenre1.setActionCommand("Deathcore");
		rdbtnGenre1.setSelected(true);
		rdbtnGenre1.addActionListener(this);
		pnlMain.add(rdbtnGenre1);

	    rdbtnGenre2 = new JRadioButton("Pop Punk");
	    rdbtnGenre2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnGenre2.setForeground(Color.ORANGE);
	    rdbtnGenre2.setBounds(21, 107, 100, 20);
	    rdbtnGenre2.setBackground(new Color(0, 128, 0));
		rdbtnGenre2.setActionCommand("Pop Punk");
		rdbtnGenre2.setSelected(false);
		rdbtnGenre2.addActionListener(this);
		pnlMain.add(rdbtnGenre2);
		
		rdbtnGenreOther = new JRadioButton("Other");
		rdbtnGenreOther.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnGenreOther.setForeground(Color.ORANGE);
		rdbtnGenreOther.setBounds(21, 130, 78, 20);
		rdbtnGenreOther.setBackground(new Color(0, 128, 0));
		rdbtnGenreOther.setActionCommand("Other");
		rdbtnGenreOther.setSelected(false);
		rdbtnGenreOther.addActionListener(this);
		pnlMain.add(rdbtnGenreOther);
		
		 //Group the radio buttons.
	    genreSelector = new ButtonGroup();
	    genreSelector.add(rdbtnGenre1);
	    genreSelector.add(rdbtnGenre2);
	    genreSelector.add(rdbtnGenreOther);
	    
	    // set the style of the windows to match the system
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// get action command
		String eventActionCommand = event.getActionCommand();
		
		if(eventActionCommand.equals("Format") && !txtDirectoryPath.getText().trim().isEmpty()){
			taOutputLog.setText("");
			lblError.setVisible(false);
			
			if(rdbtnSingleCD.isSelected())
				formatCD(txtDirectoryPath.getText());
			else if(rdbtnManyCDs.isSelected())
				formatCDList();
			
		}else if(eventActionCommand.equals("ChooseFile")){
			openJFileChooser();
		}else if(eventActionCommand.equals("Deathcore") || eventActionCommand.equals("Pop Punk")){
			txtCustomGenre.setEnabled(false);
		}else if(eventActionCommand.equals("Other")){
			txtCustomGenre.setText("Metal");
			txtCustomGenre.setEnabled(true);
		}
		
	}

	@SuppressWarnings("static-access")
	private boolean openJFileChooser() 
	{
		JFileChooser chooser = new JFileChooser("C:\\Users\\Kucharskim\\Downloads");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		if(chooser.showOpenDialog(null) == chooser.APPROVE_OPTION)	
			txtDirectoryPath.setText(chooser.getSelectedFile().toString());
		else
			System.out.println("No file selected.");	
		
		return true;
	}
	
	public void addTextToLog(String text)
	{
		taOutputLog.append(text+"\n");
		taOutputLog.setCaretPosition(taOutputLog.getDocument().getLength());
	}
	
	public void formatCD(String CDdirectory)
	{
		// get genre from selection
		String genre;
		if(genreSelector.getSelection().getActionCommand().equals("Other"))
			genre = txtCustomGenre.getText().toString(); 
		else
			genre = genreSelector.getSelection().getActionCommand().toString();
		
		try{
			formatter = new CDFormatter(CDdirectory, genre);
			formatter.setMenu(this);
		}catch(NullPointerException e){
			lblError.setText("***ERROR: Directory cannot be found. Please select a valid directory.***");
			lblError.setVisible(true);
			return;
		}
		
		if(formatter.getMP3Count() <= 0)
		{
			lblError.setText("There are no mp3 files in the dir you chose!");
			lblError.setVisible(true);
			return;
		}
		
		System.out.println("Working in directory \"" + formatter.getCurrentDirectory() + "\"");
		System.out.println("There are " + formatter.getFileCount() + " files and " + formatter.getMP3Count() + " mp3 files in this directory.");
		addTextToLog("Working in directory \"" + formatter.getCurrentDirectory() + "\"");
		addTextToLog("There are " + formatter.getFileCount() + " files and " + formatter.getMP3Count() + " mp3 files in this directory.");
			
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			
		if(!chkIgnoreArtwork.isSelected())	
		{ 
			if(!formatter.embedCover())	
			{
				System.out.println("\nWARNING: Album cover not found in directory and extraction failed. Saving default.");
				if(!formatter.saveDefaultImage())
				{
					System.out.println("WARNING: Problem saving default image. Ignoring artwork.");
					formatter.ignoreImage();
				}
			}
		}else{
			formatter.ignoreImage();
		}
		
		formatter.format();
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));	
	}
	
	private void formatCDList() 
	{
		File albumDirectoryParent = new File(txtDirectoryPath.getText());
		ArrayList<File> cdList = new ArrayList<File>();
		File[] cdFileList;
		
		try{
			cdFileList = albumDirectoryParent.listFiles();
			for(int i = 0; i < cdFileList.length; i++)
			{
				if (cdFileList[i].isDirectory())
					cdList.add(cdFileList[i]);
			}
		}catch(NullPointerException e){
			lblError.setText("ERROR: Invalid Directory!");
			lblError.setVisible(true);
			return;
		}

		if(cdList.size() < 2)
		{
			lblError.setText("You selected multiple CDs but there was no more than 1");
			lblError.setVisible(true);
			return;
		}
		
		System.out.println("There are " + cdList.size() + " album folders in the working directory.\n");
		
		// loop through and format each cd
		for(int cdNum = 0; cdNum < cdList.size(); cdNum++)
			formatCD(cdList.get(cdNum).toString());
	}
}
