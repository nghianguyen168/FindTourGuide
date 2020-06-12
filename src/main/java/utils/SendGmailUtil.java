package utils;

public class SendGmailUtil {
	public static void sendGmail(String gmail,String sub,String msg) {
		final String user = "nsklap2611@gmail.com";
		final String pass="maiyeu97";
					SendMail.send(gmail, sub, msg, user, pass);
		}
	
}
