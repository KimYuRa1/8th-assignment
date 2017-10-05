import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener{
	 private JPanel p;
	 private JPanel p2;
	 private JLabel la;
	 Button[] b;
	 //Button clear;
	 ArrayList<Integer> arr;
	 ArrayList<String> srr;
	 private int result;
	 private int count = 1;

	 Calculator() {
	  setTitle("°è»ê±â");
	  arr = new ArrayList<Integer>();
	  srr = new ArrayList<String>();
	  p = new JPanel();
	  p2 = new JPanel();
	  la = new JLabel("");
	  b = new Button[16];
	  //clear = new Button("Clear");
	  //clear.addActionListener(this);
	  
	  p2.setLayout(new BorderLayout());
	  p2.add(la, BorderLayout.CENTER);
	  //p2.add(clear, BorderLayout.EAST);
	  p.setLayout(new GridLayout(4, 4));
	  
	  String button[] = { 
			  "7", "8", "9", "/",
			  "4", "5", "6", "*",
			  "1", "2","3", "-",
			  "<-", "0", "=", "+"
	  };
	  
	  for (int i = 0; i < button.length; i++) {
	   b[i] = new Button(button[i]);
	   b[i].addActionListener(this);
	   p.add(b[i]);
	  }
	  add(p2, BorderLayout.NORTH);
	  add(p, BorderLayout.CENTER);

	  setSize(300, 300);
	  setLocation(600, 300);
	  setVisible(true);
	 }

	 @Override
	 public void actionPerformed(ActionEvent e) {
	  // TODO Auto-generated method stub
	  Button in = (Button) e.getSource();

	  for (int i = 0; i < b.length; i++) {
	   if (in == b[i]) {
		   if (b[i].getLabel() == "<-") {
			   String str2 = la.getText();
			   if (str2 == null)
				   break;
			   String temp = str2.substring(0, str2.length() - 1);
			   la.setText(temp);
			   break;
		   } 
		   else if ((b[i].getLabel() == "*") || (b[i].getLabel() == "/")
			|| (b[i].getLabel() == "+") || (b[i].getLabel() == "-")) {
			   arr.add(Integer.parseInt(la.getText()));
			   srr.add(b[i].getLabel());
			   la.setText("");
			   break;
		   } 
		   else if (b[i].getLabel() == "=") {
			   arr.add(Integer.parseInt(la.getText()));
			   while(srr.size()!=0){
				   for(int j=0; j<srr.size(); j++){
					   if(srr.get(j) == "*" || srr.get(j) == "/"){
						   if(srr.get(j) == "*"){
							   result = arr.get(j) * arr.get(j+1);
							   arr.remove(j);
							   arr.remove(j);
							   arr.add(j, result);
							   srr.remove(j);
							   break;
	        }
			else if(srr.get(j) == "/" || arr.get(j+1) != 0){
				result = arr.get(j) / arr.get(j+1);
				arr.remove(j);
	         	arr.remove(j);
	         	arr.add(j, result);
	         	srr.remove(j);
	         	break;
	        }
		   }
	      }
	      for(int j=0; j<srr.size(); j++){
	       if(srr.get(j) == "+" || srr.get(j) == "-"){
	        if(srr.get(j) == "+"){
	         result = arr.get(j) + arr.get(j+1);
	         arr.remove(j);
	         arr.remove(j);
	         arr.add(j, result);
	         srr.remove(j);
	         break;
	        }else if(srr.get(j) == "-"){
	         result = arr.get(j) - arr.get(j+1);
	         arr.remove(j);
	         arr.remove(j);
	         arr.add(j, result);
	         srr.remove(j);
	         break;
	        }
	       }
	      }
	     }
	     la.setText(result + "");
	     break;
	    }
	    String str = la.getText() + b[i].getLabel();
	    la.setText(str);
	   }
	  }
	 }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal=new Calculator();
	}

}
