package hu.webtown.cart.webcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.webtown.cart.dao.CartDaoImpl;
import hu.webtown.cart.domain.Cart;
import hu.webtown.cart.domain.DiscountMegaPack;
import hu.webtown.cart.domain.DiscountThreeForTwo;
import hu.webtown.cart.domain.DiscountType;
import hu.webtown.cart.dto.ItemDto;
import hu.webtown.cart.item.Chestnut;
import hu.webtown.cart.item.Cucumber;
import hu.webtown.cart.item.RubberDuck;
import hu.webtown.cart.item.Salami;
import hu.webtown.cart.mnb.MNBExchangeRateFuture;
import hu.webtown.cart.service.CartService;
import hu.webtown.cart.service.CartServiceImpl;
import hu.webtown.cart.util.Converter;
import hu.webtown.cart.util.DiscountCalculatorHelper;
import hu.webtown.cart.util.DiscountTypeName;

@WebServlet("/CartWebController")
public class CartWebController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String CART_EDIT = "/cart_edit.jsp";
	private static String CART_LIST = "/cart_list.jsp";

	String forward;

	private CartService service;
	private Cart cart;

	public CartWebController() {
		super();
		service = new CartServiceImpl(new CartDaoImpl());
		cart = new Cart();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		try {
			switch (action) {
			case "delete":
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateCart(request, response);
				break;
			default:
				listCartItems(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

	private void listCartItems(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		for (ItemDto itemDto1 : service.getAllItemDtos()) {
			for (DiscountType discType : cart.getCartItems()) {
				ItemDto itemDto2 = discType.getItemDto();
				if (itemDto1.getId() == itemDto2.getId()) {
					itemDto2.setCount(itemDto1.getCount());
				}
			}
		}
		List<ItemDto> cartItems = service.getAllItemDtos();
		DiscountCalculatorHelper.setCartTotalSum(cart);
		DiscountCalculatorHelper.calculate(cart);
		request.setAttribute("cartItems", cartItems);
		request.setAttribute("total", String.valueOf(cart.getTotal()));
		request.setAttribute("discount", String.valueOf(cart.getTotal() - cart.getDiscountPrice()));
		request.setAttribute("discountName", String.valueOf(cart.getDiscountTypeName()));
		request.setAttribute("eurRate", String.valueOf(cart.getEurRate()));
		RequestDispatcher dispatcher = request.getRequestDispatcher(CART_LIST);
		dispatcher.forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		new MNBExchangeRateFuture(cart).compute();
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(0))));
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Cucumber(0))));
		cartItems.add(
				new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new Salami(0))));
		cartItems.add(
				new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new RubberDuck(0))));
		cart = new Cart(cartItems);
		DiscountCalculatorHelper.calculate(cart);
		DiscountCalculatorHelper.setCartTotalSum(cart);
		for (DiscountType discountType : cartItems) {
			ItemDto itemDto = discountType.getItemDto();
			service.addItemDto(itemDto);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ItemDto existingItem = service.getItemDtoById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(CART_EDIT);
		request.setAttribute("cart", existingItem);
		dispatcher.forward(request, response);
	}

	private void updateCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		boolean megaPack = "true".equals(request.getParameter("megaPack")) ? true : false;
		int count = Integer.parseInt(request.getParameter("count"));

		ItemDto updatedCart = new ItemDto(id, name, price, megaPack, count);
		service.updateItemDto(updatedCart);
		response.sendRedirect("cart");
	}

}
