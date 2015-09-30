package stocks;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class NyseQuoteServiceTest {
	QuoteService service;

	@Test
	public void testGetStockExchangeName() {
		assertEquals("NYSE", service.getStockExchangeName());
	}

	@Test (expected = UnknownStock.class)
	public void testLookupSymbol() {
		assertEquals("Microsoft", service.lookupSymbol("MSFT"));
		service.lookupSymbol("BINGBONG");
	}

	@Test
	public void testGetQuote() {
		assertEquals(new BigDecimal("62.05"), service.getQuote("RHT"));
	}
	
	@Before
	public void getService(){
		service = new NyseQuoteServiceImpl();
	}

}
