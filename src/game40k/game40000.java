package game40k;
import javax.swing.*;

public class game40000 {
	public static void main(String[] args) {
		// TODO ������������� ��������� �������� ������
String rez =
JOptionPane.showInputDialog(null, "������� ��������� ���� �� 1 �� 7","��������� �����", 1);
	int slogn = rez.charAt(0)-'0';
	if((slogn>= 1)&&(slogn<= 7))
	

	{
		
		okno window = new okno(slogn);
		}

	}
}