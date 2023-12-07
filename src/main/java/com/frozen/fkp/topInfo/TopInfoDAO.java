package com.frozen.fkp.topInfo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

@Service
public class TopInfoDAO {
	
	public TopInfos selectOfTopInfo(String where, HttpServletRequest req) throws Exception {
		String name = "여행추천";
		String url = "https://www.google.com/search?q=";
		url += where + name;
		url += "#ttdcs=EAE";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
//	    co.addArguments("--disable-popup-blocking");
//	    co.addArguments("--disable-gpu");
//	    co.addArguments("--blink-settings=imagesEnabled=false");
		co.addArguments("--headless");
//		co.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(co);
		
		driver.get(url);
		Thread.sleep(1000);
		WebElement plus = driver.findElement(By.cssSelector(".TOQyFc.MmMIvd.jRKCUd"));
//		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		List<WebElement> ele = driver.findElements(By.cssSelector("#ttdg-_1 > div > div.jhtnKe > div"));
//		System.out.println(ele.size());
		
		List<TopInfo> toplist = new ArrayList<TopInfo>();
		TopInfos tops = new TopInfos();
		int num = 0;
		for (WebElement ele1 : ele) {
			TopInfo top = new TopInfo();
			num++;
			if (num < 6) {
				top.setNameResult(ele1.findElement(By.cssSelector("div > div > div > div > a > div.MiF81b > div")).getText());
				top.setImgResult(ele1.findElement(By.cssSelector("div > div > div > div > a > div.VJrHBf > div > img")).getAttribute("src"));
				top.setAddress(ele1.findElement(By.cssSelector("div > div > div > div > a")).getAttribute("href"));
				toplist.add(top);
				tops.setTopInfo(toplist);
			} else {
				top.setNameResult(ele1.findElement(By.cssSelector("div > div > div > div > a > div.MiF81b > div")).getText());
				top.setAddress(ele1.findElement(By.cssSelector("div > div > div > div > a")).getAttribute("href"));
				toplist.add(top);
				tops.setTopInfo(toplist);
			}
		}
		
		return tops;
	}
	
	public void selectListMap(String address, HttpServletRequest req) throws Exception {
		String url = address.replace("!", "&");
//		System.out.println(url);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
//	    co.addArguments("--disable-popup-blocking");
//	    co.addArguments("--disable-gpu");
//	    co.addArguments("--blink-settings=imagesEnabled=false");
		co.addArguments("--headless");
//		co.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(co);
		
		driver.get(url);
//		Thread.sleep(1000);
//		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		WebElement ele = driver.findElement(By.cssSelector("div > div > div:nth-child(1) > div:nth-child(2) > div > div > span.LrzXr"));
		String ele1 = ele.getText();
		System.out.println(ele1);
		req.setAttribute("address", ele1);
		
	}
}
