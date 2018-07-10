package com.system;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {
	public static String myEmailAccount = "17761246647@163.com";
    public static String myEmailPassword = "huyang19960917";
    public static String myEmailSMTPHost = "smtp.163.com";
    
	
	
	 public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
	        // 1. 创建一封邮件
	        MimeMessage message = new MimeMessage(session);

	        // 2. From: 发件人
	        message.setFrom(new InternetAddress(sendMail, "兆亿物业管理", "UTF-8"));

	        // 3. To: 收件人
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

	        // 4. Subject: 邮件主题
	        message.setSubject("缴费通知", "UTF-8");

	        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
	        message.setContent("亲爱的用户你好, 今天是物业费生成日期，希望您在三天内缴纳费用哦，感谢配合", "text/html;charset=UTF-8");

	        // 6. 设置发件时间
	        message.setSentDate(new Date());

	        // 7. 保存设置
	        message.saveChanges();

	        return message;
	    }
	 public void sendMailToResident(String receiveMailAccount) throws Exception {
		    Properties props = new Properties();                    // 参数配置
	        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
	        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
	        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证


	        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
	        Session session = Session.getInstance(props);
	        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

	        // 3. 创建一封邮件
	        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);

	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();

	        
	        transport.connect(myEmailAccount, myEmailPassword);

	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());

	        // 7. 关闭连接
	        transport.close();
	 }
}
