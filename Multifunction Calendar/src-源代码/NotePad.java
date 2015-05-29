
 import java.lang.Math.* ;
import java.awt.*;
import javax.swing.*;

import java.io.*;
import java.awt.event.*;
public class NotePad extends JPanel implements ActionListener{
   JTextArea text;              
   JTextField showMessage;
   JTextField showMessage1;
   JPopupMenu menu;         
   JMenuItem itemCopy,itemCut,itemPaste,itemClear; 
   String SwitchNLMonth;
   //�����༭���NotePad
   public NotePad(){
       showMessage=new JTextField();
       showMessage.setHorizontalAlignment(JTextField.CENTER); 
       showMessage.setFont(new Font("TimesRoman",Font.BOLD,16));
       showMessage.setForeground(Color.red);
       showMessage.setBackground(Color.green );
       showMessage.setBorder(BorderFactory.createRaisedBevelBorder());
       showMessage.setEditable(false);
       
       menu=new JPopupMenu();   
       itemCopy=new JMenuItem("����");
       itemCut=new JMenuItem("����");
       itemPaste=new JMenuItem("ճ��");
       itemClear=new JMenuItem("���");
       itemCopy.addActionListener(this);
       itemCut.addActionListener(this);
       itemPaste.addActionListener(this);
       itemClear.addActionListener(this);
       menu.add(itemCopy);
       menu.add(itemCut);
       menu.add(itemPaste);
       menu.add(itemClear);
       text=new JTextArea(10,10);
       text.addMouseListener(new MouseAdapter(){
                                 public void mousePressed(MouseEvent e){
                                   if(e.getModifiers()==InputEvent.BUTTON3_MASK)
                                      menu.show(text,e.getX(),e.getY());
                                 }       });
setLayout(new BorderLayout());
       add(showMessage,BorderLayout.NORTH);
       
       add(new JScrollPane(text),BorderLayout.CENTER);
}
   //�������Ҽ���ʾJPopupitem ������itemΪ ���� ���� ճ�� ���
   public void actionPerformed(ActionEvent e){
	      if(e.getSource()==itemCopy)
	         text.copy();
	      else if(e.getSource()==itemCut)
	         text.cut();
	      else if(e.getSource()==itemPaste)
	         text.paste();
	      else if(e.getSource()==itemClear)
	         text.setText(null); 
	    }
   
    //showMessage ��Ӧ��������е�������ʾ��Ӧ��������ũ��������������
public void setShowMessage(int year,int month,int day){
       
       int[] rNong = Change(year, month, day); //�������������� ת��� ��Ӧ��ũ��
       SwitchNLMonth(rNong[1]);                //��������Month������Ĵ�ͳд��
       String NLmoth=SwitchNLMonth;
       int Y=rNong[0];
       int M=rNong[1];
       int D=rNong[2];
    //��������day��ɴ�ͳд��
       if(rNong[2]<11)
       {
       SwitchNLMonth(rNong[2]);
       String NLday=SwitchNLMonth;
       
       showMessage.setText(""+year+"-"+month+"-"+day+"  ũ��"+rNong[0]+"��"+NLmoth+"��"+"��"+NLday);
     
       }
       else if(11<=rNong[2]&&rNong[2]<20)
         {
          SwitchNLMonth(rNong[2]-10);
          String NLday=SwitchNLMonth;
          showMessage.setText(""+year+"-"+month+"-"+day+"  ũ��"+rNong[0]+"��"+NLmoth+"��"+"ʮ"+NLday);
     
          }
       else if(20<=rNong[2]&&rNong[2]<30)
          {
           SwitchNLMonth(rNong[2]-20);
           String NLday=SwitchNLMonth;
           showMessage.setText(""+year+"-"+month+"-"+day+"  ũ��"+rNong[0]+"��"+NLmoth+"��"+"��"+NLday);
         
          }
       else
          {
           SwitchNLMonth(rNong[2]-30);
           String NLday=SwitchNLMonth;
           showMessage.setText(""+year+"-"+month+"-"+day+"  ũ��"+rNong[0]+"��"+NLmoth+"��"+"��"+NLday);
        
          }
       //��������Ҫ�Ľ���ѡ��
       if(M==1&&D==1)
    	   showMessage.setText(" ����");
      if(M==1&&D==15)
    	   showMessage.setText(" Ԫ����");
      if(M==3&&D==14)
    	   showMessage.setText(" ������");
      if(M==5&&D==5)
    	   showMessage.setText(" �����");
       if(M==7&&D==7)
    	   showMessage.setText(" ��Ϧ");
       if(M==8&&D==15)
    	   showMessage.setText(" �����");
       if(M==9&&D==9)
    	   showMessage.setText(" ������");
       if(M==12&&D==8)
    	   showMessage.setText(" ���˽�");
       if(month==2&&day==14)
    	   showMessage.setText(" ���˽�");
       if(month==3&&day==8)
    	   showMessage.setText(" ��Ů��");
       if(month==3&&day==12)
    	   showMessage.setText(" ֲ����");
       if(month==4&&day==1)
    	   showMessage.setText(" ���˽�");
       if(month==5&&day==1)
    	   showMessage.setText(" �Ͷ���");
       if(month==5&&day==4)
    	   showMessage.setText(" �����");
       if(month==6&&day==1)
    	   showMessage.setText("��ͯ��");
       if(month==7&&day==1)
    	   showMessage.setText("������");
       if(month==8&&day==1)
    	   showMessage.setText(" ������");
       if(month==9&&day==10)
    	   showMessage.setText(" ��ʦ��");
       if(month==12&&day==25)
    	   showMessage.setText(" ʥ����");
       
   //��Ӷ�ʮ�Ľ���,�����1900��1,0�굽���ڵ�������
     int finaldays=getTotalDay(year,month)+day;
     double jisuan=finaldays- 365.242 * (year-1900);
     int jqnum=jieqicount(jisuan);
    
       if(jqnum!=-1){
    	   switch(jqnum){
    	   case 0:
    		   showMessage.setText("С��");
    		   break;
    	   case 1:
    		   showMessage.setText("��");
    		   break;
    	   case 2:
    		   showMessage.setText("����");
    		   break;
    	   case 3:
    		   showMessage.setText("��ˮ");
    		   break;
    	   case 4:
    		   showMessage.setText("����");
    		   break;
    	   case 5:
    		   showMessage.setText("����");
    		   break;
    	   case 6:
    		   showMessage.setText("����");
    		   break;
    	   case 7:
    		   showMessage.setText("����");
    		   break;
    	   case 8:
    		   showMessage.setText("����");
    		   break;
    	   case 9:
    		   
    		   showMessage.setText("С��");
    		   break;
    	   case 10:
    		   showMessage.setText("â��");
    		   break;
    	   case 11:
    		   showMessage.setText("����");
    		   break;
    	   case 12:
    		   
    		   showMessage.setText("С��");
    		   break;
    	   case 13:
    		   showMessage.setText("����");
    		   break;
    	   case 14:
    		   showMessage.setText("����");
    		   break;
    	   case 15:
    		   showMessage.setText("����");
    		   break;
    	   case 16:
    		   showMessage.setText("¶ˮ");
    		   break;
    	   case 17:
    		   showMessage.setText("���");
    		   break;
    	   case 18:
    		   showMessage.setText("��¶");
    		   break;
    	   case 19:
    		   showMessage.setText("˪��");
    		   break;
    	   case 20:
    		   showMessage.setText("����");
    		   break;
    	   case 21:
    		   showMessage.setText("Сѩ");
    		   break;
    	   case 22:
    		   showMessage.setText("��ѩ");
    		   break;
    	   case 23:
    		   showMessage.setText("����");
    		   break;
    	   }
       }
   } 

 public int jieqicount(double jisuan){
	 for(int i=0;i<=23;i++){
		 if(Abs((6.2+15.22 * i - 1.9 *sin(0.262 * i))-jisuan)<=0.27){
			 return i;
		 }
	 }
	 return -1;
 }

   private double Abs(double d) {
	// TODO Auto-generated method stub
	   double g=Math.abs(d);
	return g;
}
private double sin(double d) {
	// TODO Auto-generated method stub
	   double g;
      
      g=Math.sin(d);

	return g;
}
public  int getTotalDay(int year ,int month){
	   int total=0;
	   for(int i=1900;i<year;i++){
		   if(isleapyear(i)){
			   total+=366;
		   }else
			   total+=365;
	   }
	   for(int i=1;i<month;i++){
		   total+=getmonthdays(year,i);
	   }
	   return total;
   }
   int getmonthdays(int year,int month){
	   if(month==1||month== 3||month== 5||month== 7||month== 8 ||month==10||month== 12)
		   return 31;
	   if(month==4||month== 6||month== 9||month== 11)
		   return 30;
	   if(month==2)
		   return isleapyear(year) ? 29:28;
	   return 0;
   }
   boolean isleapyear(int year){
	   return year%400==0||(year%4==0 && year %100 !=0);
   }
   //������ת���ũ��
   public int[] Change(int year, int month, int day) {
       int NongDate[] = new int[5];
       int nong[][] = {                   //ũ��1949����2020���ũ��
               { 7, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 1, 29, 29 },
               { 0, 29, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 2, 17, 0 },
               { 0, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 2, 6, 0 },
               { 5, 29, 30, 29, 30, 29, 29, 30, 30, 29, 30, 29, 30, 1, 27, 30 },
               { 0, 29, 30, 29, 29, 30, 30, 29, 30, 30, 29, 30, 29, 2, 14, 0 },
               { 0, 30, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 2, 3, 0 },
               { 3, 29, 30, 29, 29, 29, 30, 29, 30, 29, 30, 30, 30, 1, 24, 30 },
               { 0, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 2, 12, 0 },
               { 8, 30, 29, 30, 29, 30, 29, 29, 30, 30, 29, 30, 29, 1, 31, 29 },
               { 0, 30, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 2, 18, 0 },
               { 0, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 2, 8, 0 },
               { 6, 30, 29, 30, 29, 30, 30, 30, 29, 30, 29, 30, 29, 1, 28, 29 },
               { 0, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 2, 15, 0 },
               { 0, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 2, 5, 0 },
               { 4, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 1, 25, 29 },
               { 0, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 30, 2, 13, 0 },
               { 0, 29, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 2, 2, 0 },
               { 3, 30, 30, 30, 30, 29, 29, 30, 29, 29, 30, 30, 29, 1, 21, 29 },
               { 0, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30, 2, 9, 0 },
               { 7, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 1, 30, 30 },
               { 0, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 2, 17, 0 },
               { 0, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 2, 6, 0 },
               { 5, 29, 30, 29, 29, 30, 30, 29, 30, 30, 30, 29, 30, 1, 27, 30 },
               { 0, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 2, 15, 0 },// 72��
               { 0, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 2, 3, 0 },
               { 4, 30, 30, 29, 30, 29, 30, 29, 29, 30, 30, 29, 30, 1, 23, 29 },// 74
               { 0, 30, 30, 29, 30, 29, 29, 30, 29, 29, 30, 29, 30, 2, 11, 0 },
               { 8, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 1, 31, 29 },
               { 0, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 29, 2, 18, 0 },
               { 0, 30, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 2, 7, 0 },
               { 6, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 1, 28, 30 },
               { 0, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 2, 16, 0 },
               { 0, 29, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30, 2, 5, 0 },
               { 4, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 30, 30, 1, 25, 29 },
               { 0, 30, 29, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 2, 13, 0 },
               { 10, 30, 29, 30, 30, 29, 29, 30, 29, 29, 30, 30, 30, 2, 2, 29 },//84
               { 0, 29, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 2, 20, 0 },
               { 0, 29, 30, 30, 29, 30, 30, 29, 30, 29, 30, 29, 29, 2, 9, 0 },
               { 6, 30, 29, 30, 29, 30, 30, 30, 30, 29, 30, 29, 29, 1, 29, 29 },// 87
               { 0, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 2, 17, 0 },
               { 0, 30, 29, 29, 30, 29, 29, 30, 30, 29, 30, 30, 30, 2, 6, 0 },
               { 5, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 30, 30, 1, 27, 29 },
               { 0, 29, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30, 2, 15, 0 },
               { 0, 29, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 2, 4, 0 },
               { 3, 29, 30, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 1, 23, 29 },
               { 0, 30, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 2, 10, 0 },
               { 8, 29, 30, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 1, 31, 29 },
               { 0, 29, 30, 29, 30, 30, 29, 30, 29, 30, 30, 29, 29, 2, 19, 0 },
               { 0, 30, 29, 30, 29, 30, 29, 30, 30, 29, 30, 30, 29, 2, 7, 0 },// 97
               { 5, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 29, 30, 1, 28, 29 },
               { 0, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 2, 16, 0 },
               { 0, 30, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 29, 2, 5, 0 },// 00
               { 4, 30, 30, 29, 30, 30, 29, 29, 30, 29, 30, 29, 30, 1, 24, 29 },
               { 0, 30, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 2, 12, 0 },
               { 0, 30, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 2, 1, 0 },
               { 2, 29, 30, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 1, 22, 29 },// 04
               { 0, 29, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 2, 9, 0 },
               { 7, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30, 30, 1, 29, 29 },// 06
               { 0, 29, 29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 2, 18, 0 },
               { 0, 30, 29, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 2, 7, 0 },
               { 5, 30, 30, 29, 29, 30, 29, 30, 29, 30, 29, 30, 30, 1, 26, 29 },// 09
               { 0, 30, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 2, 14, 0 },
               { 0, 30, 29, 30, 30, 29, 30, 29, 29, 30, 29, 30, 29, 2, 3, 0 },
               { 4, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 29, 30, 1, 23, 29 },// 12
               { 0, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30, 29, 30, 2, 10, 0 },
               { 9, 29, 30, 29, 30, 29, 30, 29, 30, 30, 30, 29, 30, 1, 31, 29 },
               { 0, 29, 30, 29, 29, 30, 29, 30, 30, 30, 29, 30, 29, 2, 19, 0 },
               { 0, 30, 29, 30, 29, 29, 30, 29, 30, 30, 29, 30, 30, 2, 8, 0 },
               { 6, 29, 30, 29, 30, 29, 29, 29, 30, 29, 30, 30, 30, 1, 28, 30 },
               { 0, 29, 30, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 2, 16, 0 },
               { 0, 30, 29, 30, 29, 30, 29, 29, 30, 29, 29, 30, 30, 2, 5, 0 },
               { 4, 29, 30, 30, 30, 30, 29, 29, 30, 29, 30, 29, 30, 1, 25, 29 } };

       int rYear = year - 1949;
       int rDay = 0;
       int i = 0;
       int months[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
       if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
           months[2] = 29;

       if (nong[year - 1949][13] > month)// ���ҵ��·�С�ڴ��ڵ��·�
       {

           rDay = months[1] - day + nong[rYear][14] - 1;
           for (i = 12; rDay >= 0; i--) {
               rDay = rDay - nong[rYear - 1][i];
               if (i == nong[rYear - 1][0] && rDay >= 0) {
                   if (nong[rYear - 1][15] == nong[rYear - 1][nong[rYear - 1][0]]) {
                       rDay = rDay - nong[rYear - 1][i];
                   } else {
                       rDay = rDay - nong[rYear - 1][i] - 1;
                       if (rDay > 0)
                           rDay = rDay + 1;
                   }
               }
           }
           year = year - 1;
           i = i + 1;
           rDay = Math.abs(rDay);

       }

       if (nong[rYear][13] == month)// ���ҵ��·ݵ��ڴ��ڵ��·�
       {
           if (nong[rYear][14] > day) {
               rDay = nong[rYear][14] - day - 1;

               rDay = rDay - nong[rYear - 1][12];
               rDay = Math.abs(rDay);
               year -= 1;

               i = 12;
           }
           if (nong[rYear][14] == day) {
               i = 1;
               rDay = 1;

           }
           if (nong[rYear][14] < day) {
               rDay = day - nong[rYear][14] + 1;
               i = 1;

           }

       }

       if (nong[rYear][13] < month) {         // ���ҵ��·ݴ��ڴ��ڵ��·�
           for (i = nong[rYear][13] + 1; i < month; i++) { 
               rDay = rDay + months[i];
           }
           rDay = rDay + months[nong[rYear][13]] - nong[rYear][14]
                                                                           + day;

           for (i = 1; rDay >= 0; i++) {
               rDay = rDay - nong[rYear][i];

               if (i == nong[rYear][0] && rDay >= 0) {
                   if (nong[rYear][15] == nong[rYear][nong[rYear][0]]) {
                       rDay = rDay - nong[rYear][15];
                   } else {
                       rDay = rDay - nong[rYear][15] - 1;
                       if (rDay > 0)
                           rDay = rDay + 1;
                   }
               }
           }
           i = i - 1;
           if (nong[rYear][i] == Math.abs(rDay)) {
               rDay = 1;
           } else
               rDay = nong[rYear][i] + rDay + 1;

       }
       NongDate[0] = year;
       NongDate[1] = i;
       NongDate[2] = rDay;
       NongDate[3] = nong[rYear][13];
       NongDate[4] = nong[rYear][14];

       return NongDate;
   }
   //�������е�����ת���ũ��������
   public void SwitchNLMonth(int month)
   {
    switch(month)
       {
           case 0:
               SwitchNLMonth="ʮ";break;
           case 1:
               SwitchNLMonth="һ";break;
           case 2:
               SwitchNLMonth="��";break;
           case 3:
               SwitchNLMonth="��";break;
           case 4:
               SwitchNLMonth="��";break;
           case 5:
               SwitchNLMonth="��";break;
           case 6:
               SwitchNLMonth="��";break;
           case 7:
               SwitchNLMonth="��";break;
           case 8:
               SwitchNLMonth="��";break;
           case 9:
               SwitchNLMonth="��";break;
           case 10:
               SwitchNLMonth="ʮ";break;
           case 11:
               SwitchNLMonth="ʮһ";break;
           case 12:
               SwitchNLMonth="ʮ��";break;
        } 
  }
   //���� ɾ��  ��ȡ ��־
   public void save(File dir,int year,int month,int day){
       String dailyContent=text.getText();
       String fileName=""+year+""+month+""+day+".txt";
       String key=""+year+""+month+""+day;
       String [] dayFile=dir.list();
       boolean boo=false;
       for(int k=0;k<dayFile.length;k++){
           if(dayFile[k].startsWith(key)){
             boo=true;
             break;
           } }
       if(boo){
          String m=""+year+"��"+month+"��"+day+"������־,���µ�������ӵ���־��?";
          int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE);
          if(ok==JOptionPane.YES_OPTION){ 
            try{
                 File f=new File(dir,fileName);
                 RandomAccessFile out=new RandomAccessFile(f,"rw");
                 long fileEnd=out.length();
                 byte []bb=dailyContent.getBytes();    
                 out.seek(fileEnd);
                 out.write(bb);
                 out.close();
            }
            catch(IOException exp){}
         }    }
      else{
          String m=""+year+"��"+month+"��"+day+"��û����־,������־��?";
          int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE);
          if(ok==JOptionPane.YES_OPTION){ 
            try{
                 File f=new File(dir,fileName);
                 RandomAccessFile out=new RandomAccessFile(f,"rw");
                 long fileEnd=out.length();
byte []bb=dailyContent.getBytes();    
                 out.write(bb);
                 out.close();
            }
            catch(IOException exp){}
         }
      }   
       }
  public void delete(File dir,int year,int month,int day){
       String key=""+year+""+month+""+day;
       String [] dayFile=dir.list();
       boolean boo=false;
       for(int k=0;k<dayFile.length;k++){
           if(dayFile[k].startsWith(key)){
             boo=true;
             break;
           } } 
       if(boo){
           String m="ɾ��"+year+"��"+month+"��"+day+"�յ���־��?";
           int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE);
           if(ok==JOptionPane.YES_OPTION){
             String fileName=""+year+""+month+""+day+".txt";
             File deleteFile=new File(dir,fileName);
             deleteFile.delete();
           } }
        else{
          String m=""+year+"��"+month+"��"+day+"����־��¼";
          JOptionPane.showMessageDialog(this,m,"��ʾ",JOptionPane.WARNING_MESSAGE);
       }
       }
   public void read(File dir,int year,int month,int day){
       String fileName=""+year+""+month+""+day+".txt";
       String key=""+year+""+month+""+day;
       String [] dayFile=dir.list();
       boolean boo=false;
       for(int k=0;k<dayFile.length;k++){
           if(dayFile[k].startsWith(key)){
             boo=true;
              break;
           }}
       if(boo){
          String m=""+year+"��"+month+"��"+day+"����־,��ʾ��־������?";
          int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE);
          if(ok==JOptionPane.YES_OPTION){ 
            text.setText(null);
            try{
                 File f=new File(dir,fileName);
                 FileReader  inOne=new FileReader(f);
                 BufferedReader inTwo= new BufferedReader(inOne);
                 String s=null;
                 while((s=inTwo.readLine())!=null)
                    text.append(s+"\n");
                 inOne.close();
                 inTwo.close(); }
            catch(IOException exp){} 
         } }
      else{
         String m=""+year+"��"+month+"��"+day+"����־��¼";
         JOptionPane.showMessageDialog(this,m,"��ʾ",JOptionPane.WARNING_MESSAGE);
      }
   }
  
  
}
