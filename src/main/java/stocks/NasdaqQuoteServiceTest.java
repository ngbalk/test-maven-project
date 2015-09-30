package stocks;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class NasdaqQuoteServiceTest {
	QuoteService service;
	
	@Before
	public void getService(){
		this.service = new NasdaqQuoteServiceImpl();
	}
	@Test
	public void testGetStockExchangeName() {
		assertEquals("NASDAQ", this.service.getStockExchangeName());
	}

	@Test (expected = UnknownStock.class)
	public void testLookupSymbol() {
		assertEquals("Intuit", service.lookupSymbol("INTU"));
		service.lookupSymbol("ABC");
	}

	@Test
	public void testGetQuote() {
		assertEquals(new BigDecimal("56.29"), service.getQuote("INTU"));
		assertTrue(!new BigDecimal("60").equals(service.getQuote("YHOO")));
	}

}
