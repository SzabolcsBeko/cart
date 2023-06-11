package hu.webtown.cart.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import hu.webtown.cart.dao.CartDao;
import hu.webtown.cart.dao.CartDaoImpl;
import hu.webtown.cart.dto.ItemDto;
import hu.webtown.cart.item.Salami;
import hu.webtown.cart.util.Converter;


public class ServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCartService() {

		CartDao cartDaoMock;
		CartService cartService;

		cartDaoMock = Mockito.mock(CartDaoImpl.class);
		cartService = new CartServiceImpl(cartDaoMock); 

		int num1 = 3;
		
		ItemDto expected = Converter.Item2Dto(new Salami(num1));

		when(cartDaoMock.getItemDtoById(num1)).thenReturn(expected);
		
		ItemDto actual = cartService.getItemDtoById(num1);
		
		assertEquals(expected, actual);
		
		assertEquals(num1, expected.getCount());
		
		verify(cartDaoMock).getItemDtoById(num1);
		

	}
	
	@Test
	public void testMNBEurExchangeRate() {
		
	}
}
