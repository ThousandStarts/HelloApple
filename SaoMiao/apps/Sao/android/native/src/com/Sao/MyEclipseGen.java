import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class MyEclipseKeyGen
{  
	public static final void main(String[] args){          
		String subscriber = "tianshansangong";  //subscriber        
		String licenseNum = "500";  //Number of Licenses        
		String version = "100"; //版本号        
		String subscriptionCode = getSubscriptionCode(subscriber, version , licenseNum ,true);        
		System.out.println(subscriptionCode);  //gLR8ZO-655055-62677056522757051    
	}    
	
	public static String getSubscriptionCode(
				String subscriber, 
				String version,              
				String licenseNum,
				boolean selected
	) 
		
	{          
			Calendar cal = Calendar.getInstance();          
			cal.add(1, 3);  //年份加三年        
			cal.add(6, -1);  //日期减一        //当前日期20141226，到期日期则为20171225        
			NumberFormat nf = new DecimalFormat("000");          
			licenseNum = nf.format(Integer.valueOf(licenseNum));          
			String verTime = selected ? (new StringBuffer("-")).append((new SimpleDateFormat("yyMMdd")).format(cal.getTime())).append("0").toString() : "-0812310";
			String type = "YE3MB-";          
			String need = (new StringBuffer(String.valueOf(subscriber.substring(0, 1)))).append(type).append(version).append(licenseNum).append(verTime).toString();          
			String dx = (new StringBuffer(String.valueOf(need))).append("Decompiling this copyrighted software is a violation of both your license agreement and the Digital Millenium Copyright Act of 1998 (http://www.loc.gov/copyright/legislation/dmca.pdf). Under section 1204 of the DMCA, penalties range up to a $500,000 fine or up to five years imprisonment for a first offense. Think about it; pay for a license, avoid prosecution, and feel better about yourself.").append(subscriber).toString();          
			int suf = decode(dx);          
			String code = (new StringBuffer(String.valueOf(need))).append(String.valueOf(suf)).toString();
			return change(code);      
	}     
	
	private static int decode(String s) {          
		int i = 0;          
		char ac[] = s.toCharArray();          
		int j = 0;          
		for (int k = ac.length; j < k; j++)
			i = 31 * i + ac[j];         
		return Math.abs(i);      
	}     
	
	private static String change(String s) {          
		byte abyte0[] = s.getBytes();          
		char ac[] = new char[s.length()];          
		int i = 0;          
		for (int k = abyte0.length; i < k; i++) {              
			int j = abyte0[i];              
			if (j >= 48 && j <= 57)                  
				j = ((j - 48) + 5) % 10 + 48;              
			else if (j >= 65 && j <= 90)                  
				j = ((j - 65) + 13) % 26 + 65;              
			else if (j >= 97 && j <= 122)                  
				j = ((j - 97) + 13) % 26 + 97;              
			ac[i] = (char) j;          
		}         
		return String.valueOf(ac);      
		}
	}
		
	
