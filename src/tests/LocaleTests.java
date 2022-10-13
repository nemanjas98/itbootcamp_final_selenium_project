package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
	
	@Test (priority = 10)
	public void SetLocaleToUa() {
		navPage.getLanguageButton().click();
		navPage.getUkranianLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderText().getText(), "Лендінг");
	}
	
	@Test (priority = 20)
	public void SetLocaleToEs() {
		navPage.getLanguageButton().click();
		navPage.getSpanishLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderText().getText(), "Página de aterrizaje");
	}
	
	@Test (priority = 30)
	public void SetLocaleToEn() {
		navPage.getLanguageButton().click();
		navPage.getEnglishLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderText().getText(), "Landing");
	}
	
	@Test (priority = 40)
	public void SetLocaleToFr() {
		navPage.getLanguageButton().click();
		navPage.getFrenchLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderText().getText(), "Page d'atterrissage");
	}
	
	@Test (priority = 50)
	public void SetLocaleToCn() {
		navPage.getLanguageButton().click();
		navPage.getChineseLanguageButton().click();
		Assert.assertEquals(navPage.getHeaderText().getText(), "首页");
	}
	
	

}
