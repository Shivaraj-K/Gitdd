package shivaraj;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumuuu {

	public static void main(String[] args) throws IOException {
		
		WebDriver d=new ChromeDriver();
		
		System.out.println("Hiiii.........");
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> l=d.findElements(By.tagName("a"));
		int a=0;
		for(WebElement w:l)
		{
//			1.The connection object is created by invoking the openConnection method on a URL. 
//			2.The setup parameters and general request properties are manipulated. 
//			3.The actual connection to the remote object is made, using the connect method. 
//			4.The remote object becomes available. The header fields and the contentsof the remote object can be accessed

			String url=w.getAttribute("href");
			if(url==null||url.isEmpty())
			{
				continue;
			}
			else {
			URL u=new URL(url);
//			A new instance of URLConnection iscreated every time when invoking the 
//			URLStreamHandler.openConnection(URL) method of the protocol handler forthis URL.
			URLConnection c=u.openConnection();
			HttpURLConnection h=(HttpURLConnection)c;
			h.setRequestMethod("HEAD");
			//When the tester invokes the connect() method, the actual connection to the 
			//URL is established and the HTTP request is sent.
			h.connect();
			int n=h.getResponseCode();
			
			if(n>=400)
			{
				a++;
				System.out.println("it is broken Link");
			}
			}
			
		}
		System.out.println(a);
	}           
}
