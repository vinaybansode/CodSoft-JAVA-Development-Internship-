package Task2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounterV extends JFrame implements ActionListener
{
    JTextArea t1;
    JTextField filePathTextField;
    JButton button1,button2,button3;
    JLabel textLabel, fileLabel;
    WordCounterV()
    {
        super("WORD COUNTER BY VINAY");
        textLabel=new JLabel("Enter Text Here: ");
        textLabel.setBounds(60,30,300,40);
        t1=new JTextArea();
        t1.setBounds(60,60,750,450);

        fileLabel=new JLabel("Enter File Path Here: ");
        fileLabel.setBounds(60,520, 300,40);

        filePathTextField=new JTextField();
        filePathTextField.setBounds(60,550,300,35);

        button1=new JButton("Word");
        button1.setBounds(200,700,140,40);

        button2=new JButton("Character");
        button2.setBounds(400,700,140,40);

        button3=new JButton("Words_In_File");
        button3.setBounds(600,700,140,40);


        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        add(button1);
        add(button2);
        add(button3);
        add(textLabel);
        add(fileLabel);
        add(t1);
        add(filePathTextField);
        setSize(450,450);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a)
    {
        String text=t1.getText();
        if(a.getSource()==button1)
        {
            String[] words =text.split("[\\s\\p{Punct}]+");
            int wordCount = 0;

            // Iterate through the array of words and increment the counter for each word encountered
            for (String word : words) {
                // Increment counter for each non-empty word
                if (!word.isEmpty()) {
                    wordCount++;
                }
            }
            JOptionPane.showMessageDialog(this,"Total words: "+wordCount);
        }
        if(a.getSource()==button2)
        {
            JOptionPane.showMessageDialog(this,"Total Characters including space: "+text.length());
        }

        if(a.getSource()==button3)
        {
            String filePath = filePathTextField.getText();
            int count = countWordsInFile(filePath);
            JOptionPane.showMessageDialog(this,"Word Counter: "+count);
        }
    }
    private int countWordsInFile(String filePath) {
        int count = 0;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(new FileReader(file));
            while (scanner.hasNext()) {
                count++;
                scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while reading the file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    }

    public static void main(String[] args)
    {
        new WordCounterV();
    }

}

