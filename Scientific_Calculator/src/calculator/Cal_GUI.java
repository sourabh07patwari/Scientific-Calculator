package calculator;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cal_GUI {

	public JFrame frame;
	public JTextField txt_Cal;
	public JTextField txt_Eqn;
	public DefaultListModel<String> Eqn_List;
	public String ANS;
	Cal_Methods calculators = new Cal_Methods();
	private JTextField txt_XRange;
	private JTextField txt_YRange;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	/**
	 * Create the application.
	 */
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cal_GUI window = new Cal_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Cal_GUI() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 427, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		--------------------------------CALCULATOR TEXT FIELD-----------------------------
		
		txt_Cal = new JTextField();
		txt_Cal.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_Cal.setBounds(6, 244, 413, 41);
		frame.getContentPane().add(txt_Cal);
		txt_Cal.setColumns(10);
		
//      -------------------------------ROW 1-----------------------------------------------
		
		JButton btnDel = new JButton("<-");
		btnDel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String BckSpc = null;
				if(txt_Cal.getText().length() > 0)
				{
					StringBuilder NewText = new StringBuilder(txt_Cal.getText());
					if(NewText.charAt(txt_Cal.getText().length()-1)>=42 && NewText.charAt(txt_Cal.getText().length()-1)<=47)
					{
//						Delete the last element of Num_Cal and Operators_Cal
						calculators.del_Operators();
					}
					NewText.deleteCharAt(txt_Cal.getText().length()-1);
					BckSpc = NewText.toString();
					txt_Cal.setText(BckSpc);
				}
			}
		});
		btnDel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnDel.setBounds(6, 291, 50, 50);
		frame.getContentPane().add(btnDel);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnAdd.getText();
				txt_Cal.setText(Cal_String);
				calculators.add_OperatorsCal("+");
			}
		});
		btnAdd.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnAdd.setBounds(68, 291, 50, 50);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnSub.getText();
				txt_Cal.setText(Cal_String);
				calculators.add_OperatorsCal("-");
			}
		});
		btnSub.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnSub.setBounds(130, 291, 50, 50);
		frame.getContentPane().add(btnSub);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnDiv.getText();
				txt_Cal.setText(Cal_String);
				calculators.add_OperatorsCal("/");
			}
		});
		btnDiv.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnDiv.setBounds(192, 291, 50, 50);
		frame.getContentPane().add(btnDiv);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnSin.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btnSin.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnSin.setBounds(254, 291, 50, 50);
		frame.getContentPane().add(btnSin);
		
//		-------------------------------ROW 2--------------------------------
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Append the Character text of button to the TextField txt_Cal 
				String Cal_String =  txt_Cal.getText() + btn7.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn7.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn7.setBounds(6, 353, 50, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn8.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn8.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn8.setBounds(68, 353, 50, 50);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn9.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn9.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn9.setBounds(130, 353, 50, 50);
		frame.getContentPane().add(btn9);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnMul.getText();
				txt_Cal.setText(Cal_String);
				calculators.add_OperatorsCal("*");
			}
		});
		btnMul.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnMul.setBounds(192, 353, 50, 50);
		frame.getContentPane().add(btnMul);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnCos.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btnCos.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnCos.setBounds(254, 353, 50, 50);
		frame.getContentPane().add(btnCos);
		
//		---------------------------ROW 3-------------------------------------
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn4.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn4.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn4.setBounds(6, 415, 50, 50);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn5.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn5.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn5.setBounds(68, 415, 50, 50);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn6.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn6.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn6.setBounds(130, 415, 50, 50);
		frame.getContentPane().add(btn6);
		
		JButton btnPow = new JButton("^");
		btnPow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnPow.getText();
				txt_Cal.setText(Cal_String);
				calculators.add_OperatorsCal("^");
			}
		});
		btnPow.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnPow.setBounds(192, 415, 50, 50);
		frame.getContentPane().add(btnPow);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnTan.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btnTan.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnTan.setBounds(254, 415, 50, 50);
		frame.getContentPane().add(btnTan);
		
//		-------------------------ROW 4------------------------------------
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn1.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn1.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn1.setBounds(6, 477, 50, 50);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn2.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn2.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn2.setBounds(68, 477, 50, 50);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn3.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn3.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btn3.setBounds(130, 477, 50, 50);
		frame.getContentPane().add(btn3);
		
		JButton btnSqrt = new JButton("Sqrt");
		btnSqrt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String sqrt = "\u221A";
				String Cal_String =  txt_Cal.getText() + sqrt;
				txt_Cal.setText(Cal_String);
			}
		});
		btnSqrt.setFont(new Font("AppleGothic", Font.PLAIN, 16));
		btnSqrt.setBounds(192, 477, 50, 50);
		frame.getContentPane().add(btnSqrt);
		
		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnLn.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btnLn.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnLn.setBounds(254, 477, 50, 50);
		frame.getContentPane().add(btnLn);
		
//		-----------------------ROW 5-----------------------------------------
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				char dot = 46;
				String Cal_String =  txt_Cal.getText() + dot;
				txt_Cal.setText(Cal_String);
			}
		});
		btnDot.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnDot.setBounds(6, 539, 50, 50);
		frame.getContentPane().add(btnDot);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btn0.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btn0.setFont(new Font("AppleGothic", Font.BOLD, 23));
		btn0.setBounds(68, 539, 50, 50);
		frame.getContentPane().add(btn0);
		
		JButton btnE = new JButton("e");
		btnE.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String Cal_String =  txt_Cal.getText() + btnE.getText();
				txt_Cal.setText(Cal_String);
			}
		});
		btnE.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnE.setBounds(130, 539, 50, 50);
		frame.getContentPane().add(btnE);
		
		JButton btnPi = new JButton("pi");
		btnPi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String pi = "\u03c0";
				String Cal_String =  txt_Cal.getText() + pi;
				txt_Cal.setText(Cal_String);
			}
		});
		btnPi.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		btnPi.setBounds(192, 539, 50, 50);
		frame.getContentPane().add(btnPi);
		
		JButton btnAns = new JButton("ANS");
		btnAns.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
//				String ANS =  txt_Cal.getText();
				txt_Cal.setText("ANS");
			}
		});
		btnAns.setFont(new Font("AppleGothic", Font.PLAIN, 18));
		btnAns.setBounds(254, 539, 50, 50);
		frame.getContentPane().add(btnAns);
		
//		------------------------CLEAR AND EQUAL------------------------------------
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txt_Cal.setText("");
			}
		});
		btnClr.setFont(new Font("AppleGothic", Font.BOLD, 23));
		btnClr.setBounds(342, 291, 75, 50);
		frame.getContentPane().add(btnClr);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					calculators.set_TextCal(txt_Cal.getText());
					ANS = calculators.resultCal();
					txt_Cal.setText(ANS);
					System.out.println("Action Performed!!!");
				}
				catch(Exception exception)
				{
					System.out.println(exception);
					txt_Cal.setText("Error!!!");
					calculators.del_Operators_All();
				}
				
			}
		});
		btnEquals.setFont(new Font("AppleGothic", Font.BOLD, 30));
		btnEquals.setBounds(342, 353, 75, 236);
		frame.getContentPane().add(btnEquals);
		
//		--------------------------EQUATION PANEL---------------------------------
		
		JLabel lblEqn = new JLabel("Equation:");
		lblEqn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEqn.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		lblEqn.setBounds(6, 6, 75, 19);
		frame.getContentPane().add(lblEqn);
		
		JLabel lblYFx = new JLabel("y = f(x) = ");
		lblYFx.setHorizontalAlignment(SwingConstants.CENTER);
		lblYFx.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		lblYFx.setBounds(6, 31, 88, 25);
		frame.getContentPane().add(lblYFx);
		
		txt_Eqn = new JTextField();
		txt_Eqn.setFont(new Font("AppleGothic", Font.PLAIN, 23));
		txt_Eqn.setText("Enter f(x) here...");
		txt_Eqn.setBounds(112, 21, 307, 41);
		frame.getContentPane().add(txt_Eqn);
		txt_Eqn.setColumns(10);
		
		JComboBox<String> cBox_Color = new JComboBox<String>();
		cBox_Color.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int index = cBox_Color.getSelectedIndex();
				if(index == 0)
				{
					txt_Eqn.setForeground(Color.BLACK);
				}
				if(index == 1)
				{
					txt_Eqn.setForeground(Color.RED);
				}
				if(index == 2)
				{
					txt_Eqn.setForeground(Color.GREEN);
				}
			}
		});
		cBox_Color.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		cBox_Color.setModel(new DefaultComboBoxModel<String>(new String[] {"Black", "Red", "Green"}));
		cBox_Color.setSelectedIndex(0);
		cBox_Color.setBounds(317, 68, 102, 27);
		frame.getContentPane().add(cBox_Color);
		
		JLabel lblColor = new JLabel("Select Color:");
		lblColor.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		lblColor.setBounds(212, 68, 92, 25);
		frame.getContentPane().add(lblColor);
		
		JLabel lblHistory = new JLabel("History:");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("AppleGothic", Font.PLAIN, 15));
		lblHistory.setBounds(6, 138, 61, 25);
		frame.getContentPane().add(lblHistory);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 146, 340, 86);
		frame.getContentPane().add(scrollPane);
		
		Eqn_List = new DefaultListModel<String>(); 
		
		JList<String> list = new JList<String>(Eqn_List);
		scrollPane.setViewportView(list);
		list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		
		
		JButton btnLoad_Eqn = new JButton("Load");
		btnLoad_Eqn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int i = list.getSelectedIndex();
				final String LoadText = (String) Eqn_List.get(i);
				txt_Eqn.setText(LoadText); 
			}
		});
		btnLoad_Eqn.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnLoad_Eqn.setBounds(6, 164, 61, 29);
		frame.getContentPane().add(btnLoad_Eqn);
		
		JButton btnErase_Plot = new JButton("Erase");
		btnErase_Plot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int i = list.getSelectedIndex();
				if(i !=- 1)
				{
					Eqn_List.remove(i);
				}
			}
		});
		btnErase_Plot.setFont(new Font("AppleGothic", Font.PLAIN, 12));
		btnErase_Plot.setBounds(112, 69, 88, 27);
		frame.getContentPane().add(btnErase_Plot);
		
		JButton btnPlot_Eqn = new JButton("Plot");
		btnPlot_Eqn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				final String InputText = txt_Eqn.getText();
				Eqn_List.addElement(InputText);
			}
		});
		btnPlot_Eqn.setFont(new Font("AppleGothic", Font.PLAIN, 12));
		btnPlot_Eqn.setBounds(16, 69, 88, 27);
		frame.getContentPane().add(btnPlot_Eqn);
		
		JButton btnDel_Eqn = new JButton("Del");
		btnDel_Eqn.setFont(new Font("AppleGothic", Font.PLAIN, 13));
		btnDel_Eqn.setBounds(6, 197, 61, 29);
		frame.getContentPane().add(btnDel_Eqn);
		
		JLabel lblX = new JLabel("X-Range:");
		lblX.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblX.setBounds(79, 111, 61, 23);
		frame.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("Y-Range:");
		lblY.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblY.setBounds(264, 111, 61, 23);
		frame.getContentPane().add(lblY);
		
		txt_XRange = new JTextField();
		txt_XRange.setBounds(152, 108, 82, 26);
		frame.getContentPane().add(txt_XRange);
		txt_XRange.setColumns(10);
		
		txt_YRange = new JTextField();
		txt_YRange.setBounds(337, 108, 82, 26);
		frame.getContentPane().add(txt_YRange);
		txt_YRange.setColumns(10);
	}
}
