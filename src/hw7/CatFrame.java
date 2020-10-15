package hw7;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * This is homework of lesson #7
 * Educational portal "GeekBrains"
 * Geek University Android-development
 *
 * @author Alsado Salim
 */
public class CatFrame extends JFrame {
    Cat[] cats = new Cat[5];
    Plate plate = new Plate();
    JLabel addCatLabel, catLabel1, catLabel2,
            catLabel3, catLabel4, catLabel5, plateMsg, plateState;
    JLabel[] catLabels = new JLabel[5];
    JTextField nameTextField;
    JButton addCatBtn, addFoodBtn, giveFoodBtn;

    void initComponents() {
        addCatLabel = new JLabel("Добавьте кота (максимум 5) ");
        catLabel1 = new JLabel();
        catLabel2 = new JLabel();
        catLabel3 = new JLabel();
        catLabel4 = new JLabel();
        catLabel5 = new JLabel();
        catLabels[0] = catLabel1;
        catLabels[1] = catLabel2;
        catLabels[2] = catLabel3;
        catLabels[3] = catLabel4;
        catLabels[4] = catLabel5;
        plateMsg = new JLabel();
        plateState = new JLabel("Тарелка пустая");
        nameTextField = new JTextField(15);
        addCatBtn = new JButton("Добавить");
        addFoodBtn = new JButton("Наполнить тарелку");
        giveFoodBtn = new JButton("Кормить коты");
    }

    public CatFrame(String title) {
        super(title);
        this.setSize(700, 500);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        //set the container of all
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(Color.white);
        //set the main border
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));
        //set the top panel
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.white, 3));
        topPanel.setBackground(Color.white);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainContainer.add(topPanel, BorderLayout.NORTH);
        topPanel.add(addCatLabel);
        topPanel.add(nameTextField);
        topPanel.add(addCatBtn);
        //set the left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(Color.white, 30));
        leftPanel.setBackground(Color.white);
        leftPanel.setLayout(new GridLayout(5, 1));
        mainContainer.add(leftPanel, BorderLayout.WEST);
        leftPanel.add(catLabel1);
        leftPanel.add(catLabel2);
        leftPanel.add(catLabel3);
        leftPanel.add(catLabel4);
        leftPanel.add(catLabel5);
        //set the right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.white, 3));
        rightPanel.setBackground(Color.white);
        rightPanel.setLayout(new GridLayout(5, 1));
        mainContainer.add(rightPanel, BorderLayout.EAST);
        rightPanel.add(plateState);
        rightPanel.add(addFoodBtn);
        rightPanel.add(plateMsg);
        rightPanel.add(giveFoodBtn);

        addCatBtn.addActionListener(e -> {
            for (int i = 0; i < cats.length; i++) {
                if (cats[i] == null) {
                    cats[i] = new Cat(nameTextField.getText());
                    break;
                }
            }

            showCats();
        });

        addFoodBtn.addActionListener(e -> plateState.setText(plate.addFood()));

        giveFoodBtn.addActionListener(e -> {
            if (cats[0] == null) {
                plateMsg.setText("У вас нет котов!");
            } else if (plate.getFood() == 0) {
                plateMsg.setText("<html>Сначала нужно<br>добавить еды!</html>");
            } else if (plate.getFood() > 0) {
                for (Cat cat : cats) {
                    if (cat != null && !cat.getSatiety()) {
                        if (cat.getRequired_food() > plate.getFood()) {
                            plateMsg.setText("<html>Еды не хватило<br>на всех котов,<br>добавьте еще еды!</html>");
                        } else {
                            cat.eat(plate);
                            plateState.setText("Тарелка полная на " + plate.getFood() + " %");
                            plateMsg.setText("Коты накормлены!");
                        }
                    }
                }
                showCats();
            }
        });
    }

    public void showCats() {
        for (int i = 0; i < catLabels.length; i++) {
            if (cats[i] != null) {
                String msg = cats[i].getSatiety() ? "сытый" : "голодный";
                catLabels[i].setText("Кот " + cats[0].getName() + " " + msg);
            }
        }
    }

    public static void main(String[] args) {
        CatFrame catFrame = new CatFrame("Котики");
        catFrame.setVisible(true);
    }
}
