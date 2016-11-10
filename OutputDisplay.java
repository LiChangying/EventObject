import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class LoginCheck{
	private String name;
	private String password;
	public LoginCheck(String name,String password){
		this.name = name;
		this.password = password;
	}
	public boolean validate(){
		if("lixinghua".equals(name)&&"mldn".equals(password)){
			return true;
		}else {
			return false;
		}
	}
}
class ActiveHandle{
	private JFrame frame = new JFrame("This is my component");
	private JButton but1 = new JButton("apply");
	private JButton but2 = new JButton("reset");
	private JLabel nameLab = new JLabel("user name:");
	private JLabel passwordLab = new JLabel("password:");
	private JLabel infoLab = new JLabel("Succeed");
	private JTextField nameText = new JTextField();
	private JTextField passwordText = new JTextField();
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	public ActiveHandle(){
		Font fnt = new Font("Serief",Font.BOLD+Font.ITALIC,30);
		infoLab.setFont(fnt);
		but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1){
					String name = nameText.getText();
					String password = passwordText.getText();
					LoginCheck log = new LoginCheck(name,password);
					if(log.validate()==true){
						infoLab.setText("Succeed!login in");
					}else{
						infoLab.setText("please reinput");
					}
				}
				if(arg0.getSource()==but2){
					nameText.setText("");
					passwordText.setText("");
					infoLab.setText("Succeed");
				}
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
	frame.setLayout(new GridLayout(3,1));
	pan1.setLayout(new GridLayout(1,3));
	pan2.setLayout(new GridLayout(1,3));
	pan1.add(nameLab);
	pan1.add(nameText);
	pan1.add(but1);
	pan2.add(passwordLab);
	pan2.add(passwordText);
	pan2.add(but2);
	frame.add(pan1);
	frame.add(pan2);
	frame.add(infoLab);
	frame.pack();
	frame.setVisible(true);
	}
}
public class OutputDisplay{
	public static void main(String[] args){
		new ActiveHandle();
	}
}