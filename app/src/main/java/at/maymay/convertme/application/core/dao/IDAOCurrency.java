package at.maymay.convertme.application.core.dao;

import at.maymay.convertme.application.core.model.Currency;

public interface IDAOCurrency {
   public Currency load();
   public void save(Currency currency);
}
