import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    JTextField textField;
    Font font=new Font(null,Font.ITALIC,25);
    JButton[] numberButton =new JButton[10];
    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton decButton;
    JButton equalsButton;
    JButton clearButton;
    JButton allClearButton;
    int operand1=0;
    int operand2=0;
    char operator=' ';


    //constructor
    Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(350,450);
        this.setResizable(false);

        textField=new JTextField();
        textField.setEditable(false);
        textField.setBounds(10,10,310,50);
        textField.setFont(font);
        textField.setText("");

        for (int i = 0; i < 10; i++) {
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
            numberButton[i].setFont(font);
            this.add(numberButton[i]);
        }

        //new JButton
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equalsButton=new JButton("=");
        clearButton=new JButton("C");
        allClearButton=new JButton("AC");

        //set.focusable
        addButton.setFocusable(false);
        subButton.setFocusable(false);
        mulButton.setFocusable(false);
        divButton.setFocusable(false);
        decButton.setFocusable(false);
        equalsButton.setFocusable(false);
        clearButton.setFocusable(false);
        allClearButton.setFocusable(false);

        //add actionListener
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        decButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
        allClearButton.addActionListener(this);

        //positioning of buttons
        numberButton[1].setBounds(10,70,70,40);
        numberButton[2].setBounds(100,70,70,40);
        numberButton[3].setBounds(180,70,70,40);
        addButton.setBounds(260,70,70,40);

        numberButton[4].setBounds(10,120,70,40);
        numberButton[5].setBounds(100,120,70,40);
        numberButton[6].setBounds(180,120,70,40);
        subButton.setBounds(260,120,70,40);

        numberButton[7].setBounds(10,170,70,40);
        numberButton[8].setBounds(100,170,70,40);
        numberButton[9].setBounds(180,170,70,40);
        mulButton.setBounds(260,170,70,40);

        equalsButton.setBounds(10,220,70,40);
        numberButton[0].setBounds(100,220,70,40);
        clearButton.setBounds(180,220,70,40);
        divButton.setBounds(260,220,70,40);

        allClearButton.setBounds(20,280,290,40);

        //add to frame
        this.add(addButton);
        this.add(subButton);
        this.add(mulButton);
        this.add(divButton);
        this.add(decButton);
        this.add(equalsButton);
        this.add(clearButton);
        this.add(allClearButton);

        this.add(textField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean result=textField.getText().toString().endsWith("+") || textField.getText().toString().endsWith("-") || textField.getText().toString().endsWith("*") || textField.getText().toString().endsWith("/")|| textField.getText().toString().endsWith(".");
        boolean res=textField.getText().toString().contains("+") ||textField.getText().toString().contains("-") ||textField.getText().toString().contains("*") ||textField.getText().toString().contains("/") ||textField.getText().toString().contains(".") ;
        for (int i = 0; i <numberButton.length ; i++) {
            if (e.getSource() == numberButton[i]) {
                if (result){
                    operand2 = Integer.parseInt(  String.valueOf(i));
                }
                else if(res){
                    operand2= Integer.parseInt( String.valueOf(operand2)+ String.valueOf(i));
                }

                else {
                    if (operand1 != 0) {
                        operand1 = Integer.parseInt(String.valueOf(operand1) + String.valueOf(i));
                    } else {
                        operand1 = Integer.parseInt(textField.getText() + String.valueOf(i));
                    }

                }
                textField.setText(textField.getText()+String.valueOf(i));
            }

            }
        if(e.getSource()==addButton){
            if(result||res){

            }
            else{
                operator='+';
                textField.setText(textField.getText()+"+");
            }

        }
        if(e.getSource()==subButton) {
            if (result||res){

            } else {
                operator = '-';
                textField.setText(textField.getText() + "-");
            }
        }
        if(e.getSource()==mulButton) {
            if (result||res){

            } else {
                operator = '*';
                textField.setText(textField.getText() + "*");
            }
        }
        if(e.getSource()==divButton) {
            if (result||res){

            } else {
                operator = '/';
                textField.setText(textField.getText() + "/");
            }
        }
        if(e.getSource()==equalsButton){

            if(result){

            }
            else{
                switch(operator){
                    case '+':
                        textField.setText(String.valueOf(operand1+operand2));
                        break;
                    case '-':
                        textField.setText(String.valueOf(operand1-operand2));
                        break;
                    case '*':
                        textField.setText(String.valueOf(operand1*operand2));
                        break;
                    case '/':
                        textField.setText(String.valueOf(operand1/operand2));
                        break;

                }
            }
            System.out.println(operand1+"and"+operand2);
        }
        if(e.getSource()==clearButton){
            String string1=textField.getText().toString();
            int length=string1.length();
            String string2=string1.substring(0,length-1);
            textField.setText(string2);
        }
        if(e.getSource()==allClearButton){

            textField.setText(" ");
        }
    }
}
