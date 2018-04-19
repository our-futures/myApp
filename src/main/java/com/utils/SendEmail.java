package com.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	
	    private static final String HOST = "smtp.qq.com"; // smtp服务器
	    private static final String PSOT = "587";//端口号
	    private static final String USER = "513592330@qq.com"; // 用户名
	    private static final String PWD = "lwqwihazpcqicagd"; // 密码
	    private static final String SUBJECT = "悦桔拉拉商城"; // 邮件标题
	    
	    private String from = ""; // 发件人地址
	    private String to = ""; // 收件人地址
	    private String text = "";//邮箱内容

	    public void setAddress(String from, String to,String text) {
	        this.from = from;
	        this.to = to;
	        this.text = text;
	    }


	    public void send() {
	        Properties props = new Properties();
	        // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
	        props.put("mail.smtp.host", SendEmail.HOST); 
	        //qq邮箱需要设置端口号
	        props.put("mail.smtp.port", SendEmail.PSOT);
	        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
	        props.put("mail.smtp.auth", "true");
	        // 用刚刚设置好的props对象构建一个session
	        Session session = Session.getDefaultInstance(props);
//	        session.setDebug(true);
	        // 用session为参数定义消息对象
	        MimeMessage message = new MimeMessage(session);
	        try {
	            // 加载发件人地址
	            message.setFrom(new InternetAddress(from));
	            // 加载收件人地址
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            // 加载标题
	            message.setSubject(SendEmail.SUBJECT);

	            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
	            Multipart multipart = new MimeMultipart();
	            // 设置邮件的文本内容
	            BodyPart contentPart = new MimeBodyPart();
	            contentPart.setText(text);
	            multipart.addBodyPart(contentPart);
	            message.setContent(multipart);
	            // 保存邮件
	            message.saveChanges();
	            // 发送邮件
	            Transport transport = session.getTransport("smtp");
	            // 连接服务器的邮箱
	            transport.connect(SendEmail.HOST, SendEmail.USER, SendEmail.PWD);
	            // 把邮件发送出去
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
}
