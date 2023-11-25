package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	PageObjectManager pageObjectManager;
	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for (.+) shortname in offers page to check if product exist with same name$")
	public void user_searched_for_same_shortname_in_offers_page(String shortname) throws InterruptedException {

		switchToOffersPage();
		OffersPage offerspage = testContextSetup.pageObjectManager.OffersPage();
		offerspage.searchItem(shortname);
		Thread.sleep(2000);
		offerPageProductName = offerspage.getProductName();
	}

	public void switchToOffersPage() {

		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericutils.SwitchWindowToChild();

	}

	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
}
