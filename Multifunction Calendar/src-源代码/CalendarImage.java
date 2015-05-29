import javax.swing.*;

import java.awt.Container;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;

public class CalendarImage extends JPanel implements ActionListener{

    File imageFile;
    Image image;
    Toolkit tool;
    private JComboBox box;
    private String[] a = { "北京", "天津", "武汉","杭州","合肥","上海","福州"," 重庆","南昌",
   		 "香港"," 济南"," 澳门 "," 郑州","呼和浩特","乌鲁木齐"," 长沙"," 银川"," 广州"," 拉萨"," 海口"," 南京"," 成都"," 石家庄",
   		 "贵阳 ","太原"," 昆明"," 沈阳"," 西安"," 长春"," 兰州"," 西宁","哈尔滨"
    };

   JPanel p=new JPanel(new GridLayout(2,1,10,10));
   JLabel lc;
   public CalendarImage() {

       tool = getToolkit();
	   box = new JComboBox(a);
	   box.addActionListener(this);
	    p.add(box);
	    lc=new JLabel("",JLabel.CENTER);
	    p.add(lc);
	   this.add(p);
	   this.setVisible(true);
	  }

   public void setImageFile(File f) {
       imageFile = f;
       try {
           image = tool.getImage(imageFile.toURI().toURL());
       } catch (Exception exp) {
       }
       repaint();
   }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getBounds().width;
        int h = getBounds().height;
        g.drawImage(image, 0, 0, w, h, this);
    }

    @Override
    public void  actionPerformed(ActionEvent e) {
   	
   	  
   	   String weather="";
     if (e.getSource() == box) {
      int index = box.getSelectedIndex();
      System.out.println(index);
      GetWeatherInfo info = new GetWeatherInfo();//执行天气
      switch (index) {                          //点击选择JCombobox下拉表中的某项，index代表对应某项 
      case 0:
   	 String   weath0= box.getSelectedItem().toString();
   	   System.out.println(weath0);
   	 
   	   String weather0=info.getWeather(weath0);//获取天气
   	   weather=weather0;
   	 
   	   
       break;
      case 1:
   	   String weath1= box.getSelectedItem().toString();
   	   System.out.println(weath1);
   	   String weather1=info.getWeather(weath1);
   	   System.out.println(weather1);
   	   weather=weather1;
       break;
      case 2:
   	   String weath2= box.getSelectedItem().toString();
   	   System.out.println(weath2);
   	   String weather2=info.getWeather(weath2);
   	   weather=weather2;

   	   System.out.println(weather2);
       break;
      case 3:
   	   String weath3= box.getSelectedItem().toString();
   	   System.out.println(weath3);
   	   String weather3=info.getWeather(weath3);
   	   weather=weather3;

   	   System.out.println(weather3);
       break;
      case 4:
   	   String weath4= box.getSelectedItem().toString();
   	   System.out.println(weath4);
   	   String weather4=info.getWeather(weath4);
   	   weather=weather4;

   	   System.out.println(weather4);
       break;
      case 5:
   	   String weath5= box.getSelectedItem().toString();
   	   System.out.println(weath5);
   	   String weather5=info.getWeather(weath5);
   	   weather=weather5;

   	   System.out.println(weather5);
       break;
      case 6:
   	   String weath6= box.getSelectedItem().toString();
   	   System.out.println(weath6);
   	   String weather6=info.getWeather(weath6);
   	   weather=weather6;

   	   System.out.println(weather6);
       break;
      case 7:
   	   String weath7= box.getSelectedItem().toString();
   	   System.out.println(weath7);
   	   String weather7=info.getWeather(weath7);
   	   weather=weather7;

   	   System.out.println(weather7);
       break;
      case 8:
   	   String weath8= box.getSelectedItem().toString();
   	   System.out.println(weath8);
   	   String weather8=info.getWeather(weath8);
   	   weather=weather8;

   	   System.out.println(weather8);
       break;
      case 9:
   	   String weath9= box.getSelectedItem().toString();
   	   System.out.println(weath9);
   	   String weather9=info.getWeather(weath9);
   	   weather=weather9;

   	   System.out.println(weather9);
       break;
      case 10:
   	   String weath10= box.getSelectedItem().toString();
   	   System.out.println(weath10);
   	   String weather10=info.getWeather(weath10);
   	   weather=weather10;

   	   System.out.println(weather10);
       break;
      case 11:
   	   String weath11= box.getSelectedItem().toString();
   	   System.out.println(weath11);
   	   String weather11=info.getWeather(weath11);
   	   weather=weather11;

   	   System.out.println(weather11);
       break;
      case 12:
   	   String weath12= box.getSelectedItem().toString();
   	   System.out.println(weath12);
   	   String weather12=info.getWeather(weath12);
   	   weather=weather12;

   	   System.out.println(weather12);
       break;
      case 13:
   	   String weath13= box.getSelectedItem().toString();
   	   System.out.println(weath13);
   	   String weather13=info.getWeather(weath13);
   	   weather=weather13;

   	   System.out.println(weather13);
       break;
      case 14:
   	   String weath14= box.getSelectedItem().toString();
   	   System.out.println(weath14);
   	   String weather14=info.getWeather(weath14);
   	   weather=weather14;

   	   System.out.println(weather14);
       break;
      case 15:
   	   String weath15= box.getSelectedItem().toString();
   	   System.out.println(weath15);
   	   String weather15=info.getWeather(weath15);
   	   weather=weather15;

   	   System.out.println(weather15);
       break;
      case 17:
   	   String weath17= box.getSelectedItem().toString();
   	   System.out.println(weath17);
   	   String weather17=info.getWeather(weath17);
   	   weather=weather17;

   	   System.out.println(weather17);
       break;
      case 18:
   	   String weath18= box.getSelectedItem().toString();
   	   System.out.println(weath18);
   	   String weather18=info.getWeather(weath18);
   	   weather=weather18;

   	   System.out.println(weather18);
       break;
      case 19:
   	   String weath19= box.getSelectedItem().toString();
   	   System.out.println(weath19);
   	   String weather19=info.getWeather(weath19);
   	   weather=weather19;

   	   System.out.println(weather19);
       break;
      case 20:
   	   String weath20= box.getSelectedItem().toString();
   	   System.out.println(weath20);
   	   String weather20=info.getWeather(weath20);
   	   weather=weather20;

   	   System.out.println(weather20);
       break;
      case 21:
   	   String weath21= box.getSelectedItem().toString();
   	   System.out.println(weath21);
   	   String weather21=info.getWeather(weath21);
   	   weather=weather21;

   	   System.out.println(weather21);
       break;
      case 22:
   	   String weath22= box.getSelectedItem().toString();
   	   System.out.println(weath22);
   	   String weather22=info.getWeather(weath22);
   	   weather=weather22;

   	   System.out.println(weather22);
       break;
      case 23:
   	   String weath23= box.getSelectedItem().toString();
   	   System.out.println(weath23);
   	   String weather23=info.getWeather(weath23);
   	   weather=weather23;

   	   System.out.println(weather23);
       break;
      case 24:
   	   String weath24= box.getSelectedItem().toString();
   	   System.out.println(weath24);
   	   String weather24=info.getWeather(weath24);
   	   weather=weather24;

   	   System.out.println(weather24);
       break;
      case 25:
   	   String weath25= box.getSelectedItem().toString();
   	   System.out.println(weath25);
   	   String weather25=info.getWeather(weath25);
   	   weather=weather25;

   	   System.out.println(weather25);
       break;
      case 26:
   	   String weath26= box.getSelectedItem().toString();
   	   System.out.println(weath26);
   	   String weather26=info.getWeather(weath26);
   	   weather=weather26;

   	   System.out.println(weather26);
       break;
      case 27:
   	   String weath27= box.getSelectedItem().toString();
   	   System.out.println(weath27);
   	   String weather27=info.getWeather(weath27);
   	   weather=weather27;

   	   System.out.println(weather27);
       break;
       case 28:
   	   String weath28= box.getSelectedItem().toString();
   	   System.out.println(weath28);
   	   String weather28=info.getWeather(weath28);
   	   weather=weather28;

   	   System.out.println(weather28);
       break;
       case 29:
    	   String weath29= box.getSelectedItem().toString();
    	   System.out.println(weath29);
    	   String weather29=info.getWeather(weath29);
       	   weather=weather29;

    	   System.out.println(weather29);
        break;
       case 30:
    	   String weath30= box.getSelectedItem().toString();
    	   System.out.println(weath30);
    	   String weather30=info.getWeather(weath30);
       	   weather=weather30;

    	   System.out.println(weather30);
        break;
       case 31:
    	   String weath31= box.getSelectedItem().toString();
    	   System.out.println(weath31);
    	   String weather31=info.getWeather(weath31);
       	   weather=weather31;

    	   System.out.println(weather31);
        break;
       case 32:
    	   String weath32= box.getSelectedItem().toString();
    	   System.out.println(weath32);
    	   String weather32=info.getWeather(weath32);
       	   weather=weather32;

    	   System.out.println(weather32);
        break;
        
      }
      if(weather!=null){
    	  String a="";
    	 	 String b="";
    	 	  
    	    int ind=weather.indexOf("明天");
    	     a=weather.substring(0, ind-1);
    	     b=weather.substring(ind);
    	  
    	 
    	   String  c="<html>"+a+"<br>"+b+"<html>";
    	  lc.setText(c);
    		  //getContentPane().add(lc,BorderLayout.CENTER); 
      }else 
    	  System.out.println("Sorry!This city weather isn't avaliable!");
    	  
    
     }
    
    }
}
