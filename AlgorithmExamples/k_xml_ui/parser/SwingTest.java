package com.ssafy.k_xml_ui.parser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.k_xml_ui.parser.SAXTest01.MyHandler;

import java.io.FileInputStream;


public class SwingTest extends JFrame{
	JList<String> jlist;
	JTextField tf;
	DefaultListModel<String> model;
	
	List<Person> list;
	StringBuilder sb;
	Person p;
	
	class MyHandler extends DefaultHandler{
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list=new ArrayList();
			sb=new StringBuilder();
		}
		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
			
		}
		@Override
		public void startElement(String uri, String localName, String name, Attributes attr)
				throws SAXException {
			super.startElement(uri, localName, name, attr);
			if(name.equals("정보")){
				p=new Person();
			}
			
		}
		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			super.endElement(uri, localName, name);
			if(name.equals("이름")) {
				p.setName(sb.toString().trim());
			} else if(name.equals("email")) {
				p.setEmail(sb.toString().trim());
			} else if(name.equals("휴대전화")) {
				p.setMobile(sb.toString().trim());
			} else if(name.equals("주소")) {
				p.setAddress(sb.toString().trim());
			} else if(name.equals("정보")) {
				list.add(p);
			}
			//sb.setLength(0);
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			
			super.characters(ch, start, length);
			sb.append(ch,start,length);
			
		}
	}
		
	public void go()throws SAXException, IOException, ParserConfigurationException {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser= factory.newSAXParser();
		parser.parse(new FileInputStream("addr.xml"),new MyHandler());
		
		System.out.println(list);
	
	}
	
	
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
		jlist = new JList<>();
		this.add(jlist, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1500, 500);
		
		model = new DefaultListModel<>();
		model.addElement("Hello");
		jlist.setModel(model);
		
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
