package hu.webtown.cart.mnb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hu.mnb.webservices.MNBArfolyamServiceSoap;
import hu.mnb.webservices.MNBArfolyamServiceSoapImpl;

public class MNBCallable implements Callable<String> {

	private static final String EUR = "EUR";

	public MNBCallable() {
		super();
	}

	@Override
	public String call() throws Exception {
		String result = "";
		MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
		MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
		try {
			String localDateString = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
			result = parseEuroExchangeRate(service.getExchangeRates(localDateString, localDateString, EUR));
		} catch (Exception e) {
			System.err.print(e);
		}

		return result;
	}

	private synchronized String parseEuroExchangeRate(String request) {
		String eurRate = "";
		Matcher matcher = Pattern.compile("(?:<Rate.*?>)(.*?)(?:<\\/Rate>)").matcher(request);
		if (matcher.find()) {
			String result = matcher.group(1);
			eurRate = result.replace(',', '.');
		}
		return eurRate;
	}

}
