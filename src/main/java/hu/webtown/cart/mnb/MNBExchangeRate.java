package hu.webtown.cart.mnb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hu.mnb.webservices.MNBArfolyamServiceSoap;
import hu.mnb.webservices.MNBArfolyamServiceSoapImpl;

public class MNBExchangeRate {

	public float getEuroExchangeRate() {
		float result = 0.0f;
		MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
		MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
		try {
			String localDateString = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
			String resp = service.getExchangeRates(localDateString, localDateString, "EUR");
			result = parseEuroExchangeRate(resp);
		} catch (Exception e) {
			System.err.print(e);
		}
		return result;
	}
	
	private float parseEuroExchangeRate(String request) {
		float eurRate = 0.0f;
		Matcher matcher = Pattern.compile("(?:<Rate.*?>)(.*?)(?:<\\/Rate>)").matcher(request);
		if (matcher.find()) {
			String result = matcher.group(1);
			String str = result.replace(',','.');
			eurRate = Float.parseFloat(str);
		}
		return eurRate;
	}
	
	public static void main(String[] args) {
		float result = new MNBExchangeRate().getEuroExchangeRate();
		System.out.println(result);
	}
	
}
