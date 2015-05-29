
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
   //日历编辑面板NotePad
   public NotePad(){
       showMessage=new JTextField();
       showMessage.setHorizontalAlignment(JTextField.CENTER); 
       showMessage.setFont(new Font("TimesRoman",Font.BOLD,16));
       showMessage.setForeground(Color.red);
       showMessage.setBackground(Color.green );
       showMessage.setBorder(BorderFactory.createRaisedBevelBorder());
       showMessage.setEditable(false);
       
       menu=new JPopupMenu();   
       itemCopy=new JMenuItem("复制");
       itemCut=new JMenuItem("剪切");
       itemPaste=new JMenuItem("粘贴");
       itemClear=new JMenuItem("清空");
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
   //点击鼠标右键显示JPopupitem 包含的item为 复制 剪切 粘贴 清空
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
   
    //showMessage 对应日历面板中的日期显示相应的阳历，农历，节气，节日
public void setShowMessage(int year,int month,int day){
       
       int[] rNong = Change(year, month, day); //把阳历的年月日 转变成 对应的农历
       SwitchNLMonth(rNong[1]);                //把阳历的Month变成中文传统写法
       String NLmoth=SwitchNLMonth;
       int Y=rNong[0];
       int M=rNong[1];
       int D=rNong[2];
    //把阳历的day变成传统写法
       if(rNong[2]<11)
       {
       SwitchNLMonth(rNong[2]);
       String NLday=SwitchNLMonth;
       
       showMessage.setText(""+year+"-"+month+"-"+day+"  农历"+rNong[0]+"年"+NLmoth+"月"+"初"+NLday);
     
       }
       else if(11<=rNong[2]&&rNong[2]<20)
         {
          SwitchNLMonth(rNong[2]-10);
          String NLday=SwitchNLMonth;
          showMessage.setText(""+year+"-"+month+"-"+day+"  农历"+rNong[0]+"年"+NLmoth+"月"+"十"+NLday);
     
          }
       else if(20<=rNong[2]&&rNong[2]<30)
          {
           SwitchNLMonth(rNong[2]-20);
           String NLday=SwitchNLMonth;
           showMessage.setText(""+year+"-"+month+"-"+day+"  农历"+rNong[0]+"年"+NLmoth+"月"+"二"+NLday);
         
          }
       else
          {
           SwitchNLMonth(rNong[2]-30);
           String NLday=SwitchNLMonth;
           showMessage.setText(""+year+"-"+month+"-"+day+"  农历"+rNong[0]+"年"+NLmoth+"月"+"三"+NLday);
        
          }
       //把所有重要的节日选出
       if(M==1&&D==1)
    	   showMessage.setText(" 春节");
      if(M==1&&D==15)
    	   showMessage.setText(" 元宵节");
      if(M==3&&D==14)
    	   showMessage.setText(" 清明节");
      if(M==5&&D==5)
    	   showMessage.setText(" 端午节");
       if(M==7&&D==7)
    	   showMessage.setText(" 七夕");
       if(M==8&&D==15)
    	   showMessage.setText(" 中秋节");
       if(M==9&&D==9)
    	   showMessage.setText(" 重阳节");
       if(M==12&&D==8)
    	   showMessage.setText(" 腊八节");
       if(month==2&&day==14)
    	   showMessage.setText(" 情人节");
       if(month==3&&day==8)
    	   showMessage.setText(" 妇女节");
       if(month==3&&day==12)
    	   showMessage.setText(" 植树节");
       if(month==4&&day==1)
    	   showMessage.setText(" 愚人节");
       if(month==5&&day==1)
    	   showMessage.setText(" 劳动节");
       if(month==5&&day==4)
    	   showMessage.setText(" 青年节");
       if(month==6&&day==1)
    	   showMessage.setText("儿童节");
       if(month==7&&day==1)
    	   showMessage.setText("建党节");
       if(month==8&&day==1)
    	   showMessage.setText(" 建军节");
       if(month==9&&day==10)
    	   showMessage.setText(" 教师节");
       if(month==12&&day==25)
    	   showMessage.setText(" 圣诞节");
       
   //添加二十四节气,计算从1900，1,0年到现在的总天数
     int finaldays=getTotalDay(year,month)+day;
     double jisuan=finaldays- 365.242 * (year-1900);
     int jqnum=jieqicount(jisuan);
    
       if(jqnum!=-1){
    	   switch(jqnum){
    	   case 0:
    		   showMessage.setText("小寒");
    		   break;
    	   case 1:
    		   showMessage.setText("大寒");
    		   break;
    	   case 2:
    		   showMessage.setText("立春");
    		   break;
    	   case 3:
    		   showMessage.setText("雨水");
    		   break;
    	   case 4:
    		   showMessage.setText("惊蛰");
    		   break;
    	   case 5:
    		   showMessage.setText("春分");
    		   break;
    	   case 6:
    		   showMessage.setText("清明");
    		   break;
    	   case 7:
    		   showMessage.setText("谷雨");
    		   break;
    	   case 8:
    		   showMessage.setText("立夏");
    		   break;
    	   case 9:
    		   
    		   showMessage.setText("小满");
    		   break;
    	   case 10:
    		   showMessage.setText("芒种");
    		   break;
    	   case 11:
    		   showMessage.setText("夏至");
    		   break;
    	   case 12:
    		   
    		   showMessage.setText("小暑");
    		   break;
    	   case 13:
    		   showMessage.setText("大暑");
    		   break;
    	   case 14:
    		   showMessage.setText("立秋");
    		   break;
    	   case 15:
    		   showMessage.setText("处暑");
    		   break;
    	   case 16:
    		   showMessage.setText("露水");
    		   break;
    	   case 17:
    		   showMessage.setText("秋分");
    		   break;
    	   case 18:
    		   showMessage.setText("寒露");
    		   break;
    	   case 19:
    		   showMessage.setText("霜降");
    		   break;
    	   case 20:
    		   showMessage.setText("立冬");
    		   break;
    	   case 21:
    		   showMessage.setText("小雪");
    		   break;
    	   case 22:
    		   showMessage.setText("大雪");
    		   break;
    	   case 23:
    		   showMessage.setText("冬至");
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
   //把阳历转变成农历
   public int[] Change(int year, int month, int day) {
       int NongDate[] = new int[5];
       int nong[][] = {                   //农历1949年至2020年的农历
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
               { 0, 29, 30, 29, 29, 30, 29, 30, 29, 30, 30, 29, 30, 2, 15, 0 },// 72年
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

       if (nong[year - 1949][13] > month)// 查找的月份小于春节的月份
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

       if (nong[rYear][13] == month)// 查找的月份等于春节的月份
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

       if (nong[rYear][13] < month) {         // 查找的月份大于春节的月份
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
   //把日期中的数字转变成农历的数字
   public void SwitchNLMonth(int month)
   {
    switch(month)
       {
           case 0:
               SwitchNLMonth="十";break;
           case 1:
               SwitchNLMonth="一";break;
           case 2:
               SwitchNLMonth="二";break;
           case 3:
               SwitchNLMonth="三";break;
           case 4:
               SwitchNLMonth="四";break;
           case 5:
               SwitchNLMonth="五";break;
           case 6:
               SwitchNLMonth="六";break;
           case 7:
               SwitchNLMonth="七";break;
           case 8:
               SwitchNLMonth="八";break;
           case 9:
               SwitchNLMonth="九";break;
           case 10:
               SwitchNLMonth="十";break;
           case 11:
               SwitchNLMonth="十一";break;
           case 12:
               SwitchNLMonth="十二";break;
        } 
  }
   //保存 删除  读取 日志
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
          String m=""+year+"年"+month+"月"+day+"已有日志,将新的内容添加到日志吗?";
          int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
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
          String m=""+year+"年"+month+"月"+day+"还没有日志,保存日志吗?";
          int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
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
           String m="删除"+year+"年"+month+"月"+day+"日的日志吗?";
           int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE);
           if(ok==JOptionPane.YES_OPTION){
             String fileName=""+year+""+month+""+day+".txt";
             File deleteFile=new File(dir,fileName);
             deleteFile.delete();
           } }
        else{
          String m=""+year+"年"+month+"月"+day+"无日志记录";
          JOptionPane.showMessageDialog(this,m,"提示",JOptionPane.WARNING_MESSAGE);
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
          String m=""+year+"年"+month+"月"+day+"有日志,显示日志内容吗?";
          int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
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
         String m=""+year+"年"+month+"月"+day+"无日志记录";
         JOptionPane.showMessageDialog(this,m,"提示",JOptionPane.WARNING_MESSAGE);
      }
   }
  
  
}
