package com.ssafy.k_xml_ui.parser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingTest extends JFrame{
	JList<String> list;
	JTextField tf;
	DefaultListModel<String> model;
	public SwingTest() {
		setTitle("SwingTest");
		setSize(300,400);
		//setLayout(new);
		JButton button = new JButton("Send");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.addElement(tf.getText());
			}
		});
		tf = new JTextField();
		tf.setColumns(20);
		JPanel p = new JPanel();
		p.add(tf);
		p.add(button);
		this.add(p,BorderLayout.SOUTH);
		list = new JList<>();
		this.add(list, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1500, 500);
		
		model = new DefaultListModel<>();
		model.addElement("Hello");
		list.setModel(model);
		
		JMenuBar bar = new JMenuBar();
		JMenu menu1 = new JMenu("file");
		JMenuItem item = new JMenuItem("Hello");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idx = list.getSelectedIndex();
				model.removeElementAt(idx);
				JDialog dlg = new JDialog(SwingTest.this, "this is a dialog");
				dlg.add(new Label("Dialog �Դϴ�"));
				dlg.setSize(300, 300);
				dlg.setLocation(500, 500);
				dlg.setVisible(true);
			}
		});
		
		menu1.add(item);
		bar.add(menu1);
		this.setJMenuBar(bar);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JFrame f = new JFrame("��ܿ� ǥ�õǴ� ����");
		new SwingTest();
	}

}
