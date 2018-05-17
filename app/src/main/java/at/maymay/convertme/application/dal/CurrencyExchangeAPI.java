package at.maymay.convertme.application.dal;

import com.github.sarxos.xchange.ExchangeCache;
import com.github.sarxos.xchange.ExchangeRate;

public class CurrencyExchangeAPI {

    public static double getExchangeRate(String from, String to) {
        ExchangeRate rate = null;
        try {
            ExchangeCache.setParameter("openexchangerates.org.apikey", "4a473f8e307b47d4862f6ab1dfdb269c");
            ExchangeCache cache = new ExchangeCache(from);
            rate = cache.getRate(to);

            return rate.getRate().doubleValue();

        } catch (Exception e) {
            System.out.println("Couldn't get Exchange rate for: [" + from + " > " + to + "]");
        }

        return 0.0;
    }
}
