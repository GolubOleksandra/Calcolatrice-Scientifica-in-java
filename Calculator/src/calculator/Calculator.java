package calculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener 
{
    private static final int larghezza = 400; 
    private static final int altezza = 350; 
    
	JTextField tfield;
	double temp, temp1, result, a;
	static double m1, m2;
	int k = 1, x = 0, y = 0, z = 0;
	char ch;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, canc, pow2, pow3, pi,
		fatt, piu, meno, div, log, rec, per, ug, punto, sqrt, sin, cos, tan, a1;
	Container cont;
	JPanel textPanel, buttonpanel;

	Calculator() 
        {
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		JPanel textpanel = new JPanel();
		tfield = new JTextField();
                tfield.setPreferredSize( new Dimension( 390, 30 ) );
		tfield.setHorizontalAlignment(SwingConstants.RIGHT);
                tfield.setFont(new Font("Lucida Sans", Font.BOLD, 16));
                tfield.setForeground(Color.white);//il colore delle lettere
                tfield.setBackground(Color.black); //colore del panel
		
                tfield.addKeyListener(new KeyAdapter() 
                {
			public void keyTyped(KeyEvent keyevent) 
                        {
				char c = keyevent.getKeyChar();
				if (c >= '0' && c <= '9') {
				} 
                                else 
                                {
					keyevent.consume();
				}
			}
		}
                );
                
		textpanel.add(tfield);
                textpanel.setBackground(Color.DARK_GRAY); //imposta il colore sotto il panel
		buttonpanel = new JPanel();
                tfield.setHorizontalAlignment(JTextField.CENTER);
                
		buttonpanel.setLayout(new GridLayout(7, 4, 2, 2));
                buttonpanel.setBackground(Color.BLACK); //imposta il colore dello sfondo sotto i bottoni
		boolean t = true;
                
                
                sin = new JButton("sin");
		buttonpanel.add(sin);
		sin.addActionListener(this);
                sin.setForeground(Color.white);
                sin.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                sin.setBackground(Color.gray); //imposta il colore del button

                
		cos = new JButton("cos");
		buttonpanel.add(cos);
		cos.addActionListener(this);
                cos.setForeground(Color.white);
                cos.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                cos.setBackground(Color.gray); //imposta il colore del button
                
		tan = new JButton("tan");
		buttonpanel.add(tan);
		tan.addActionListener(this);
                tan.setForeground(Color.white);
                tan.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                tan.setBackground(Color.gray); //imposta il colore del button
                
                log = new JButton("ln");
		buttonpanel.add(log);
		log.addActionListener(this);
                log.setForeground(Color.white);
                log.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                log.setBackground(Color.gray); //imposta il colore del button
                
                
                canc = new JButton("C");
		buttonpanel.add(canc);
		canc.addActionListener(this);
                canc.setForeground(Color.black);
                canc.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                canc.setBackground(Color.lightGray); //imposta il colore del button
                
                
                
                
                a1 = new JButton("bin");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                a1.setBackground(Color.gray); //imposta il colore del button
                
                a1 = new JButton("oct");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                a1.setBackground(Color.gray); //imposta il colore del button
                
                a1 = new JButton("hex");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                a1.setBackground(Color.gray); //imposta il colore del button
                
                log = new JButton("log");
		buttonpanel.add(log);
		log.addActionListener(this);
                log.setForeground(Color.white);
                log.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                log.setBackground(Color.gray); //imposta il colore del button
                
                a1 = new JButton("exp");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                a1.setBackground(Color.gray); //imposta il colore del button
                
                
                
                a1 = new JButton("e^x");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                a1.setBackground(Color.gray); //imposta il colore del button
                
                pow2 = new JButton("x^2");
		buttonpanel.add(pow2);
		pow2.addActionListener(this);
                pow2.setForeground(Color.white);
                pow2.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                pow2.setBackground(Color.gray); //imposta il colore del button
                
                pow3 = new JButton("x^3");
		buttonpanel.add(pow3);
		pow3.addActionListener(this);
                pow3.setForeground(Color.white);
                pow3.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                pow3.setBackground(Color.gray); //imposta il colore del button
		
                rec = new JButton("1/x");
		buttonpanel.add(rec);
		rec.addActionListener(this); 
                rec.setForeground(Color.white);
                rec.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                rec.setBackground(Color.gray); //imposta il colore del button
                
                div = new JButton("/");
		buttonpanel.add(div);
                div.addActionListener(this);
                div.setForeground(Color.white);
                div.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
                div.setBackground(Color.gray); //imposta il colore del button
                
                

                sqrt = new JButton("√");
		buttonpanel.add(sqrt);
		sqrt.addActionListener(this);
                sqrt.setForeground(Color.white);
                sqrt.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
                sqrt.setBackground(Color.gray); //imposta il colore del button
                
                b7 = new JButton("7");
		buttonpanel.add(b7);
		b7.addActionListener(this);
                b7.setForeground(Color.black);
                b7.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b7.setBackground(Color.lightGray); //imposta il colore del button
                
		b8 = new JButton("8");
		buttonpanel.add(b8);
		b8.addActionListener(this);
                b8.setForeground(Color.black);
                b8.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b8.setBackground(Color.lightGray); //imposta il colore del button
               
                b9 = new JButton("9");
		buttonpanel.add(b9);
		b9.addActionListener(this);
                b9.setForeground(Color.black);
                b9.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b9.setBackground(Color.lightGray); //imposta il colore del button
               
                per = new JButton("x");
		buttonpanel.add(per);
		per.addActionListener(this); 
                per.setForeground(Color.white);
                per.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
                per.setBackground(Color.gray); //imposta il colore del button
                
                

                a1 = new JButton("10^x");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                a1.setBackground(Color.gray); //imposta il colore del button
		
                b4 = new JButton("4"); 
		buttonpanel.add(b4);
		b4.addActionListener(this);
                b4.setForeground(Color.black);
                b4.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b4.setBackground(Color.lightGray); //imposta il colore del button
                
                b5 = new JButton("5");
		buttonpanel.add(b5);
		b5.addActionListener(this);
                b5.setForeground(Color.black);
                b5.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b5.setBackground(Color.lightGray); //imposta il colore del button
                
                b6 = new JButton("6");
		buttonpanel.add(b6);
		b6.addActionListener(this);
                b6.setForeground(Color.black);
                b6.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b6.setBackground(Color.lightGray); //imposta il colore del button
		
                meno = new JButton("-");
		buttonpanel.add(meno);
		meno.addActionListener(this);
                meno.setForeground(Color.white);
                meno.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
                meno.setBackground(Color.gray); //imposta il colore del button
                
                
                
                
                fatt = new JButton("n!");
		fatt.addActionListener(this);
                buttonpanel.add(fatt);
                fatt.setForeground(Color.white);
                fatt.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                fatt.setBackground(Color.gray); //imposta il colore del button
                
                b1 = new JButton("1");
		buttonpanel.add(b1);
		b1.addActionListener(this);
                b1.setForeground(Color.black);
                b1.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b1.setBackground(Color.lightGray); //imposta il colore del button
                
		b2 = new JButton("2");
		buttonpanel.add(b2);
		b2.addActionListener(this);
                b2.setForeground(Color.black);
                b2.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b2.setBackground(Color.lightGray); //imposta il colore del button
                
		b3 = new JButton("3");
		buttonpanel.add(b3);
		b3.addActionListener(this);
                b3.setForeground(Color.black);
                b3.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                b3.setBackground(Color.lightGray); //imposta il colore del button
                
                piu = new JButton("+");
		buttonpanel.add(piu);
		piu.addActionListener(this);
                piu.setForeground(Color.white);
                piu.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
                piu.setBackground(Color.gray); //imposta il colore del button
                
                
                
                a1 = new JButton("+/-");
		buttonpanel.add(a1);
		a1.addActionListener(this);
                a1.setForeground(Color.white);
                a1.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
                a1.setBackground(Color.gray); //imposta il colore del button
                
                pi = new JButton("π");
		pi.addActionListener(this);
                buttonpanel.add(pi);
                pi.setForeground(Color.white);
                pi.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                pi.setBackground(Color.gray); //imposta il colore del button
                
                zero = new JButton("0");
		buttonpanel.add(zero);
		zero.addActionListener(this);
                zero.setForeground(Color.black);
                zero.setFont(new Font("Lucida Sans", Font.BOLD, 20));
                zero.setBackground(Color.lightGray); //imposta il colore del button
                
                punto = new JButton(".");
                buttonpanel.add(punto);
		punto.addActionListener(this);
                punto.setForeground(Color.white);
                punto.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                punto.setBackground(Color.gray); //imposta il colore del button
                
                ug = new JButton("=");
		buttonpanel.add(ug);
		ug.addActionListener(this);
                ug.setForeground(Color.white);
                ug.setFont(new Font("Lucida Sans", Font.BOLD, 15));
                ug.setBackground(Color.GRAY); //imposta il colore del button
                
		cont.add("Center", buttonpanel);
		cont.add("North", textpanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

        @Override
	public void actionPerformed(ActionEvent e) 
        {
		String s = e.getActionCommand();
                
		if (s.equals("1")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "1");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "1");
				z = 0;
			}
		}
                
		if (s.equals("2")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "2");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "2");
				z = 0;
			}
		}
                
		if (s.equals("3")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "3");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "3");
				z = 0;
			}
		}
                
		if (s.equals("4")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "4");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "4");
				z = 0;
			}
		}
                
		if (s.equals("5")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "5");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "5");
				z = 0;
			}
		}
                
		if (s.equals("6")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "6");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "6");
				z = 0;
			}
		}
                
		if (s.equals("7")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "7");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "7");
				z = 0;
			}
		}
                
		if (s.equals("8")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "8");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "8");
				z = 0;
			}
		}
                
		if (s.equals("9")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "9");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "9");
				z = 0;
			}
		}
                
		if (s.equals("0")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + "0");
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + "0");
				z = 0;
			}
		}
                
                if (s.equals("C")) 
                {
			tfield.setText("");
			x = 0;
			y = 0;
			
		}
                
		if (s.equals("ln")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Double.parseDouble(tfield.getText());
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.log(a));
			}
		}
                
                if (s.equals("log")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Double.parseDouble(tfield.getText());
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.log10(a));
			}
		}
                
		if (s.equals("1/x")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = 1 / Double.parseDouble(tfield.getText());
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
		if (s.equals("π")) 
                {
			if (z == 0) 
                        {
				tfield.setText(tfield.getText() + Math.PI);
			} 
                        else 
                        {
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.PI);
				z = 0;
			}
		}
                
                if (s.equals("x^2")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Math.pow(Double.parseDouble(tfield.getText()), 2);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
		if (s.equals("x^3")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Math.pow(Double.parseDouble(tfield.getText()), 3);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
		if (s.equals("+/-")) 
                {
			if (x == 0) 
                        {
				tfield.setText("-" + tfield.getText());
				x = 1;
			} 
                        else 
                        {
				tfield.setText(tfield.getText());
			}
		}
                  
		if (s.equals(".")) 
                {
			if (y == 0) 
                        {
				tfield.setText(tfield.getText() + ".");
				y = 1;
			} 
                        else 
                        {
				tfield.setText(tfield.getText());
			}
		}
                
		if (s.equals("+")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
				temp = 0;
				ch = '+';
			} 
                    
                        else 
                        {
                                x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				tfield.setText("");
				ch = '+';
			}
			tfield.requestFocus();
		}
                
		if (s.equals("-")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
				temp = 0;
				ch = '-';
			} 
                        else 
                        {
				x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				tfield.setText("");
				ch = '-';
			}
			tfield.requestFocus();
		}
                
		if (s.equals("/")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
				temp = 1;
				ch = '/';
			} 
                        else 
                        {
				x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				ch = '/';
				tfield.setText("");
			}
			tfield.requestFocus();
		}
                
		if (s.equals("x")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
				temp = 1;
				ch = '*';
			} 
                        else 
                        {
				x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				ch = '*';
				tfield.setText("");
			}
			tfield.requestFocus();
		}
                
		if (s.equals("√")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Math.sqrt(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
		if (s.equals("sin")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Double.parseDouble( (tfield.getText())  );
                                double b = Math.toRadians(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.sin(b) );
			}
		}
		if (s.equals("cos")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Double.parseDouble( (tfield.getText())  );
                                double b = Math.toRadians(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.cos(b) );
			}
		}
                
                if (s.equals("exp")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Double.parseDouble( (tfield.getText())  );
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.exp(a) );
			}
		}
                
		if (s.equals("tan")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Double.parseDouble( (tfield.getText())  );
                                double b = Math.toRadians(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + Math.tan(b) );
			}
		}
                
		if (s.equals("=")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				temp1 = Double.parseDouble(tfield.getText());
				switch (ch) {
				case '+':
					result = temp + temp1;
					break;
				case '-':
					result = temp - temp1;
					break;
				case '/':
					result = temp / temp1;
					break;
				case '*':
					result = temp * temp1;
					break;
				}
				tfield.setText("");
				tfield.setText(tfield.getText() + result);
				z = 1;
			}
		}
                
		if (s.equals("n!")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = fatt(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
                if (s.equals("bin")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Integer.parseInt(tfield.getText());
                                String b = Integer.toBinaryString((int) a);
				tfield.setText("");
				tfield.setText(tfield.getText() + b);
                
			}
		}
                
                if (s.equals("hex")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Integer.parseInt(tfield.getText());
                                String b = Integer.toHexString((int) a).toUpperCase();
				tfield.setText("");
				tfield.setText(tfield.getText() + b);
                
			}
		}
                
                if (s.equals("oct")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Integer.parseInt(tfield.getText());
                                String b = Integer.toOctalString((int) a).toUpperCase();
				tfield.setText("");
				tfield.setText(tfield.getText() + b);
                
			}
		}
                
                if (s.equals("e^x")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Math.pow(Math.E ,Double.parseDouble(tfield.getText()) );
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
                
                if (s.equals("10^x")) 
                {
			if (tfield.getText().equals("")) 
                        {
				tfield.setText("");
			} 
                        else 
                        {
				a = Math.pow(10 , Double.parseDouble(tfield.getText()) );
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
                
                
		tfield.requestFocus();
	}
        
        
	public double fatt(double x) 
        {
               double i;
               double f=1;
               
               for(i=1; i<=x; i=i+1) 
               {
                   f=f*i;
               }
               
            return f;
	}
    
	public static void main(String args[]) 
        {
		Dimension dimensione_finestra = new Dimension(larghezza, altezza);
                Calculator f = new Calculator();
                f.setPreferredSize(dimensione_finestra);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // per chiudere la finestra
                f.setTitle("Calcolatrice"); // il titolo
                //f.setSize(f.getWidth(), f.getHeight()); //proporzionale allo schermo
                f.setResizable(false); // false - non si puo modificare le dimensioni della finestra
		f.setLocationRelativeTo(null);
                f.pack();
		f.setVisible(true);
	}        
}