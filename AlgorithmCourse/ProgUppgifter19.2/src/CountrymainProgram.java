/**
 * <h1>CountrymainProgram.java</h1>
 * <p>This program is a Gui based that will make the  user to choose how he want it to sort.<br/>
 * This class take a file and sort it to another file so you can seperate the sort option it can sort in country name, population and area.</p>
 * @author Fredrik
 * @since 2019-04-08
 * @version 2.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class CountrymainProgram
{
	private JFrame window;
	private JPanel panelBoard;
	private JButton button1;
	private JLabel label1;
	private JButton button2;
	private JLabel label2;
	private JButton button3;
	private JLabel label3;
	
	private static ArrayList<Country> landObject = new ArrayList<Country>();
	private static Scanner textfile;
	private static String landName;
	private static int landpop;
	private static int landarea;
	private static String landCap;
	
	private PrintWriter countrytxt = null;
	private PrintWriter populationtxt = null;
	private PrintWriter areatxt = null;
	
	public CountrymainProgram()
	{

		gui();
	}

	public void gui()
	{
		window = new JFrame("Guitest"); // the name on the window when you show the window
		window.setVisible(true); // show the window
		window.setSize(270, 300); // set the size on the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so you can close it correctly

		panelBoard = new JPanel(new GridBagLayout());// help to the things in the window
		panelBoard.setBackground(Color.WHITE);// set the color

		button1 = new JButton("Country"); // create them
		label1 = new JLabel("Sort by Country");
		button2 = new JButton("Population");
		label2 = new JLabel("Sort by population");
		button3 = new JButton("Area");
		label3 = new JLabel("Sort by area");

		button1.addActionListener(new ActionListener() // add the listener so the button can do something when its
														// pressed
		{

			public void actionPerformed(ActionEvent e)// Is the method that do the thing i want it to do.
			{
				try
				{
					countrytxt = new PrintWriter(new BufferedWriter(new FileWriter("Country.txt")));
				}catch (IOException e1)
				{
					e1.printStackTrace();
				}
				Collections.sort(landObject, new CompareCountry());

				Iterator<Country> magicCountry = landObject.iterator();
				JOptionPane.showMessageDialog(null,"You sort by Country look in the file: Country.txt"); // message box that tell you the action have happened 
				countrytxt.println(" ");
				countrytxt.println("Here is the sort in country:");
				countrytxt.println("Country Capital Population Area");
				countrytxt.println(" ");
				while (magicCountry.hasNext())
				{
					countrytxt.println(magicCountry.next());
				}
				countrytxt.close();
			}
		});

		button2.addActionListener(new ActionListener() // add the listener so the button can do something when its
														// pressed
		{

			public void actionPerformed(ActionEvent e)// Is the method that do the thing i want it to do.
			{
				try {
					populationtxt = new PrintWriter( new BufferedWriter(new FileWriter("Population.txt")));
				}
				catch (IOException e2)
				{
					e2.printStackTrace();
				}
				Collections.sort(landObject, new ComparePopulation());
				Iterator<Country> magicPopulation = landObject.iterator();
				JOptionPane.showMessageDialog(null, "You sort by population look in the file: Population.txt");
				populationtxt.println(" ");
				populationtxt.println("Here is the sort in population:");
				populationtxt.println("Country Capital Population Area");
				populationtxt.println(" ");
				while(magicPopulation.hasNext()) {
					populationtxt.println(magicPopulation.next());
				}
				populationtxt.close();
			}
		});

		button3.addActionListener(new ActionListener() // add the listener so the button can do something when its
														// pressed
		{

			public void actionPerformed(ActionEvent e)// Is the method that do the thing i want it to do.
			{
				try
				{
					areatxt = new PrintWriter(new BufferedWriter(new FileWriter("Area.txt")));
				}catch (IOException e3)
				{
					e3.printStackTrace();
				}
				Collections.sort(landObject, new CompareLandMass());
				Iterator<Country> magicLandMass = landObject.iterator();
				JOptionPane.showMessageDialog(null,"You sort by area look in the file: Area.txt");
				areatxt.println(" ");
				areatxt.println("Here is the sort in area:");
				areatxt.println("Country Capital Population Area");
				areatxt.println(" ");
				while(magicLandMass.hasNext()){
					areatxt.println(magicLandMass.next());
				}
				areatxt.close();
			}
		});
		GridBagConstraints gridArrange = new GridBagConstraints();// set all values to default

		gridArrange.insets = new Insets(10, 10, 10, 10); // give spaces between every object in the panel

		gridArrange.gridx = 0; // change the place in x axis
		gridArrange.gridy = 1; // change the place in y axis
		panelBoard.add(label1, gridArrange); // add them to the panel add c to change there location you added above

		gridArrange.gridx = 1;
		gridArrange.gridy = 1;
		panelBoard.add(button1, gridArrange);

		gridArrange.gridx = 0;
		gridArrange.gridy = 2;
		panelBoard.add(label2, gridArrange);

		gridArrange.gridx = 1;
		gridArrange.gridy = 2;
		panelBoard.add(button2, gridArrange);

		gridArrange.gridx = 0;
		gridArrange.gridy = 3;
		panelBoard.add(label3, gridArrange);

		gridArrange.gridx = 1;
		gridArrange.gridy = 3;
		panelBoard.add(button3, gridArrange);

		window.add(panelBoard, BorderLayout.WEST); // add the panel to the window/ frame
	}

	public static void main(String[] args)
	{
		new CountrymainProgram(); // start the frame.

		try
		{
			textfile = new Scanner(new File("CountryStat.txt"));

			textfile.nextLine();
			while (textfile.hasNextLine())
			{
				landName = textfile.next();
				landpop = Integer.parseInt(textfile.next());
				landarea = Integer.parseInt(textfile.next());
				landCap = textfile.next();

				landObject.add(new Country(landName, landCap, landpop, landarea));

			}

		}catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
	}
}
