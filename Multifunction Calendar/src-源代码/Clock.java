import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.File;
import java.util.*;
public class Clock extends JPanel implements ActionListener{
/*
	    File imageFile;
	    Image image;
	    Toolkit tool;

	    public void setImageFile(File f) {
	        imageFile = f;
	        try {
	            image = tool.getImage(imageFile.toURI().toURL());
	        } catch (Exception exp) {
	        }
	        repaint();
	    }

	    public void paintComponent1(Graphics g) {
	        super.paintComponent(g);
	        int w = getBounds().width;
	        int h = getBounds().height;
	        g.drawImage(image, 0, 0, w, h, this);
	    }
	    */
   Date date;
   javax.swing.Timer secondTime; 
   int hour,munite,second;
   Line2D secondLine,muniteLine,hourLine;
   int a,b,c,width,height;
   double [] pointSX=new double[60], //用来表示秒针端点坐标的数组
          pointSY=new double[60], 
          pointMX=new double[60], //用来表示分针端点坐标的数组
          pointMY=new double[60], 
          pointHX=new double[60], //用来表示时针端点坐标的数组
          pointHY=new double[60];
          
Clock(){
	//tool = getToolkit();
     //setBackground(Color.green);
     initPoint();
     secondTime=new javax.swing.Timer(1000,this);
     secondLine=new Line2D.Double(0,0,0,0);
     muniteLine=new Line2D.Double(0,0,0,0);
     hourLine=new Line2D.Double(0,0,0,0);
     secondTime.start();   //从秒针开始计时
     
   }
   private void initPoint(){
     width=getBounds().width;
     height=getBounds().height;
     pointSX[0]=0;                         //12点秒针位置
     pointSY[0]=-height/2*5/6;
     pointMX[0]=0;                         //12点分针位置
     pointMY[0]=-(height/2*4/5);
     pointHX[0]=0;                         //12点时针位置
     pointHY[0]=-(height/2*2/3);
     double angle=6*Math.PI/180;          //刻度为6度,每次走动6度
     for(int i=0;i<59;i++) {               //计算数组中的坐标
       pointSX[i+1]=pointSX[i]*Math.cos(angle)-Math.sin(angle)*pointSY[i];
       pointSY[i+1]=pointSY[i]*Math.cos(angle)+pointSX[i]*Math.sin(angle);
       pointMX[i+1]=pointMX[i]*Math.cos(angle)-Math.sin(angle)*pointMY[i];
       pointMY[i+1]=pointMY[i]*Math.cos(angle)+pointMX[i]*Math.sin(angle);
       pointHX[i+1]=pointHX[i]*Math.cos(angle)-Math.sin(angle)*pointHY[i];
       pointHY[i+1]=pointHY[i]*Math.cos(angle)+pointHX[i]*Math.sin(angle);
     }
     for(int i=0;i<60;i++){              
        pointSX[i]=pointSX[i]+width/2;            //坐标平移
        pointSY[i]=pointSY[i]+height/2;
        pointMX[i]=pointMX[i]+width/2;            //坐标平移
        pointMY[i]=pointMY[i]+height/2;
        pointHX[i]=pointHX[i]+width/2;            //坐标平移
        pointHY[i]=pointHY[i]+height/2;
     }
   }
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      initPoint();  
      for(int i=0;i<60;i++){    //绘制表盘上的小刻度和大刻度
          int m=(int)pointSX[i];
          int n=(int)pointSY[i];
       if(i%5==0){
             if(i==0||i==15||i==30||i==45){
                int k=10;  
                g.setColor(Color.yellow);
                g.fillOval(m-k/2,n-k/2,k,k);
             }
             else{ 
                int k=7;  
                g.setColor(Color.yellow);
                g.fillOval(m-k/2,n-k/2,k,k);
             }   }
          else{
            int k=2;
            g.setColor(Color.black);
            g.fillOval(m-k/2,n-k/2,k,k);
          }   }
      g.fillOval(width/2-5,height/2-5,10,10);  //钟表中心的实心圆
      Graphics2D g_2d=(Graphics2D)g;
      g_2d.setColor(Color.blue);
      g_2d.draw(secondLine);
      BasicStroke bs=
      new BasicStroke(2f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
      g_2d.setStroke(bs);
      g_2d.setColor(Color.cyan);
      g_2d.draw(muniteLine);
      bs=new BasicStroke(4f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
      g_2d.setStroke(bs);
      g_2d.setColor(Color.green);
      g_2d.draw(hourLine);
   }
   public void actionPerformed(ActionEvent e){
     if(e.getSource()==secondTime){
        date=new Date();
        String s=date.toString();//完整的时间dow mon dd hh:mm:ss zzz yyyy
        hour=Integer.parseInt(s.substring(11,13)); //获取小时
        munite=Integer.parseInt(s.substring(14,16));//获取分钟
        second=Integer.parseInt(s.substring(17,19)); //获取秒
        int h=hour%12;
        a=second;                    //秒针端点的坐标在60格的第几个
        b=munite;                    //分针端点的坐标在60格的第几个
        c=h*5+munite/12;             //时针端点的坐标在60格的第几个
        secondLine.setLine(width/2,height/2,(int)pointSX[a],(int)pointSY[a]);//绘制秒针
        muniteLine.setLine(width/2,height/2,(int)pointMX[b],(int)pointMY[b]);//绘制分针
        hourLine.setLine(width/2,height/2,(int)pointHX[c],(int)pointHY[c]);//绘制时针
        repaint();
     } 
   }
}

