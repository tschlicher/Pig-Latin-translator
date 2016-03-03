// This program creates a simple applet that translates 
// english words into pig latin that contains:
// menu bar with menu items, textareas and labels for
// specifying to the user where information is entered, 
// also has a button to translate.
// This uses action listenser to handle the click actions
// of the button or menu item.
//
// Written 12/4/2015 by Thomas Schlicher, Tampa Florida USA
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.PigLatin;


public class TxtCrypt extends JApplet{
	//declaring everything here to make visibile in the init().
	private ImageIcon image = new ImageIcon("pig.jpg");
		private ImageIcon image2 = new ImageIcon("latin.jpg");
		private JLabel imageLbl, imageLbl2, textIn, textOut, title, spacing1, spacing2;
		private JTextArea plainText, cipherText;
		private JButton button;
		
	
	
	public void init(){
		JMenu file = new JMenu("File");
			file.setMnemonic('F'); //setting my alt keys
			
		JMenuItem translate = new JMenuItem("Translate");
		translate.setMnemonic('t');
		file.add(translate);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(file);

		//actionListener for my menu item (translate).
		
			translate.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					String a = plainText.getText();
					cipherText.setText(PigLatin.encrypt(a) + "\n");           					
			}
		});
		
		setLayout(new BorderLayout());
			title = new JLabel("English To PigLatin Translator");
			title.setFont(new Font("SansSerif", Font.BOLD, 18));
			add(title, BorderLayout.NORTH);		
		
		//chose to add panels to slightly customize my applets appearance.
		
		JPanel mid = new JPanel();
			mid.setLayout(new FlowLayout());
				textIn = new JLabel("Enter English words here to be translated");
				mid.add(textIn);
				plainText = new JTextArea(1, 40);
				mid.add(plainText);
				
				//only used spacing labels for getting space.
				
				spacing1 = new JLabel("     ");
				button = new JButton("Click to translate the english word/phrase into Pig Latin");
				mid.add(button);
				spacing2 = new JLabel("                                            ");
				mid.add(spacing);
				textOut = new JLabel("Pig Latin Translation of English words       ");
				mid.add(textOut);
				cipherText = new JTextArea(1, 40);
				mid.add(cipherText);
				add(mid, BorderLayout.CENTER);
		
				imageLbl = new JLabel(image);
				add(imageLbl, BorderLayout.SOUTH);
		
		button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					
					//used to get translation of english words to pig latin.
					
					String a = plainText.getText();
					cipherText.setText(PigLatin.encrypt(a) + "\n");           					
			}
		});
	
	}
}
