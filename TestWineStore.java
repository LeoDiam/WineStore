
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class TestWineStore extends JFrame implements ActionListener {
    private static TestWineStore wsFrame = new TestWineStore();
    private JMenuBar mainBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Show");
    private JMenu menu2 = new JMenu("Add");
    private JMenu menu3 = new JMenu("Exit");
    private JMenuItem all = new JMenuItem("All");
    private JMenuItem shownonAlcohol = new JMenuItem("Non-Alcohol Drinks");
    private JMenuItem allAlcoholDrinks = new JMenuItem("All Alcohol Drinks");
    private JMenuItem allWines = new JMenuItem("Wines");
    private JMenuItem allWhiskeys = new JMenuItem("Whiskeys");
    private JMenuItem allotherAlcoholDrinks = new JMenuItem("OtherAlcoholDrinks");

    private JMenuItem alcoholDrink = new JMenuItem("Alcohol Drink");
    private JMenuItem nonAlcoholDrink = new JMenuItem("Non-Alcohol Drink");
    private JMenuItem wine = new JMenuItem("Wine");
    private JMenuItem whyskey = new JMenuItem("whyskey");
    private JMenuItem exit = new JMenuItem("Exit");
    private JTextArea text = new JTextArea(20, 40);

    private WineStore wineStore = new WineStore("Cava", "Venizelou 12", new ArrayList<>());


    public static void main(String[] args) {
        final int WIDTH = 500;
        final int HEIGHT = 400;
        wsFrame.setSize(WIDTH, HEIGHT);
        wsFrame.setTitle("Cava");
        wsFrame.setVisible(true);
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public TestWineStore() {
        setLayout(new FlowLayout());
        setJMenuBar(mainBar);
        mainBar.add(menu1);
        mainBar.add(menu2);
        mainBar.add(menu3);
        menu1.add(all);
        menu1.add(shownonAlcohol);
        menu1.add(allAlcoholDrinks);
        menu1.add(allWines);
        menu1.add(allWhiskeys);
        menu1.add(allotherAlcoholDrinks);

        menu2.add(alcoholDrink);
        menu2.add(nonAlcoholDrink);
        menu2.add(wine);
        menu2.add(whyskey);
        menu3.add(exit);
        add(text);

        all.addActionListener(this);
        shownonAlcohol.addActionListener(this);
        allAlcoholDrinks.addActionListener(this);
        allWines.addActionListener(this);
        allWhiskeys.addActionListener(this);
        allotherAlcoholDrinks.addActionListener(this);

        alcoholDrink.addActionListener(this);
        nonAlcoholDrink.addActionListener(this);
        wine.addActionListener(this);
        whyskey.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exit) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);

            System.exit(0);
        } else if (source == all) {
            text.setText("List of Drinks\n");
            String info = "";
            for (int i = 0; i < wineStore.getDrinks().size(); ++i) {
                info += wineStore.getDrinks().get(i).toString() + "\n";
            }
            text.append(info);
            text.setFont(new Font("Arial", Font.BOLD, 14));
            text.setEditable(false);
        } else if (source == shownonAlcohol) {
            text.setText("List of Non alcohol Drinks\n");
            String info = "";
            for (int i = 0; i < wineStore.getDrinks().size(); ++i) {
                Drink drink = wineStore.getDrinks().get(i);
                if (drink instanceof NonAlcoholDrink)
                    info += wineStore.getDrinks().get(i).toString() + "\n";
            }
            text.append(info);
            text.setFont(new Font("Arial", Font.BOLD, 14));
            text.setEditable(false);
        } else if (source == allAlcoholDrinks) {
            text.setText("List of All Alcohol Drinks\n");
            String info = "";
            for (int i = 0; i < wineStore.getDrinks().size(); ++i) {
                Drink drink = wineStore.getDrinks().get(i);
                if (drink instanceof AlcoholDrink)
                    info += wineStore.getDrinks().get(i).toString() + "\n";
            }
            text.append(info);
            text.setFont(new Font("Arial", Font.BOLD, 14));
            text.setEditable(false);
        } else if (source == allWines) {
            text.setText("List of All Wines\n");
            String info = "";
            for (int i = 0; i < wineStore.getDrinks().size(); ++i) {
                Drink drink = wineStore.getDrinks().get(i);
                if (drink instanceof Wine)
                    info += wineStore.getDrinks().get(i).toString() + "\n";
            }
            text.append(info);
            text.setFont(new Font("Arial", Font.BOLD, 14));
            text.setEditable(false);
        } else if (source == allWhiskeys) {
            text.setText("List of All Whiskeys\n");
            String info = "";
            for (int i = 0; i < wineStore.getDrinks().size(); ++i) {
                Drink drink = wineStore.getDrinks().get(i);
                if (drink instanceof Whiskey)
                    info += wineStore.getDrinks().get(i).toString() + "\n";
            }
            text.append(info);
            text.setFont(new Font("Arial", Font.BOLD, 14));
            text.setEditable(false);
        } else if (source == allotherAlcoholDrinks) {
            text.setText("List of All Other Alcohol Drinks\n");
            String info = "";
            for (int i = 0; i < wineStore.getDrinks().size(); ++i) {
                Drink drink = wineStore.getDrinks().get(i);
                if ((drink instanceof AlcoholDrink) &&
                        !(drink instanceof Wine) &&
                        !(drink instanceof Whiskey))
                    info += wineStore.getDrinks().get(i).toString() + "\n";
            }
            text.append(info);
            text.setFont(new Font("Arial", Font.BOLD, 14));
            text.setEditable(false);
        } else if (source == alcoholDrink) {
            JTextField code = new JTextField();
            JTextField name = new JTextField();
            JTextField alcDegree = new JTextField();
            Object[] message =
                    {
                            "Code:", code,
                            "Name:", name,
                            "Alc. degree:", alcDegree
                    };

            int option = JOptionPane.showConfirmDialog(wsFrame, message, "Add Drink", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                wineStore.getDrinks().add(new AlcoholDrink(Integer.parseInt(code.getText()), name.getText(), Double.parseDouble(alcDegree.getText())));
                text.setText("");
                text.append("The drink was added succesfully");
                text.setFont(new Font("Arial", Font.BOLD, 14));
                text.setEditable(false);
            }
        } else if (source == nonAlcoholDrink) {

            JTextField code = new JTextField();
            JTextField name = new JTextField();

            Object[] message =
                    {
                            "Code:", code,
                            "Name:", name

                    };

            int option = JOptionPane.showConfirmDialog(wsFrame, message, "Add Non-Alcohol Drink", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                wineStore.getDrinks().add(new NonAlcoholDrink(Integer.parseInt(code.getText()), name.getText()));
                text.setText("");
                text.append("The non alcohol drink was added succesfully");
                text.setFont(new Font("Arial", Font.BOLD, 14));
                text.setEditable(false);
            }

        } else if (source == wine) {
            //double alcoholicDegree, String wineColor
            JTextField code = new JTextField();
            JTextField name = new JTextField();
            JTextField alcDeg = new JTextField();
            JTextField color = new JTextField();
            Object[] message =
                    {
                            "Code:", code,
                            "Name:", name,
                            "Alcoholic Degree:", alcDeg,
                            "Wine Color:", color
                    };

            int option = JOptionPane.showConfirmDialog(wsFrame, message, "Add Wine", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                wineStore.getDrinks().add(new Wine(Integer.parseInt(code.getText()),
                        name.getText(),
                        Double.parseDouble(alcDeg.getText()),
                        color.getText()));
                text.setText("");
                text.append("The wine was added succesfully");
                text.setFont(new Font("Arial", Font.BOLD, 14));
                text.setEditable(false);
            }

        } else if (source == whyskey) {
            //double alcoholicDegree, String wineColor
            JTextField code = new JTextField();
            JTextField name = new JTextField();
            JTextField alcDeg = new JTextField();
            JTextField age = new JTextField();
            Object[] message =
                    {
                            "Code:", code,
                            "Name:", name,
                            "Alcoholic Degree:", alcDeg,
                            "Age:", age
                    };

            int option = JOptionPane.showConfirmDialog(wsFrame, message, "Add Whiskey", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                wineStore.getDrinks().add(new Whiskey(Integer.parseInt(code.getText()),
                        name.getText(),
                        Double.parseDouble(alcDeg.getText()),
                        Integer.parseInt(age.getText())));
                text.setText("");
                text.append("The whiskey was added succesfully");
                text.setFont(new Font("Arial", Font.BOLD, 14));
                text.setEditable(false);
            }

        }

    }
}
