package at.maymay.convertme.application.dal.dao;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.Converter;
import at.maymay.convertme.application.core.dao.IDAOCurrency;
import at.maymay.convertme.application.core.model.Currency;
import at.maymay.convertme.application.core.model.Unit;
import at.maymay.convertme.application.dal.CurrencyExchangeAPI;
import at.maymay.convertme.application.dal.dalmodel.DALUnit;

public class DAOCurrency implements IDAOCurrency{

    private List<DALUnit> dal_units =  new ArrayList<>();
    private List<Unit> units_ = new ArrayList<>();

    @Override
    public Currency load(){
        Currency currency = new Currency();
        units_ = currency.getUnitList();
        units_.add(new Unit( "U.S. Dollar", "USD", 1.0));
        units_.add(new Unit( "Euro", "EUR", 0.0));
        units_.add(new Unit( "Yen", "JPY", 0.0));
        units_.add(new Unit( "British Pound", "GBP", 0.0));
        units_.add(new Unit( "Swiss Franc", "CHF", 0.0));
        long remoteID;
        remoteID = 1;
        Unit usd = units_.get(0);
        Unit eur = units_.get(1);
        Unit yen = units_.get(2);
        Unit pound = units_.get(3);
        Unit frank = units_.get(4);
        DALUnit dal_usd = new DALUnit(usd.getName(), usd.getShortcut(),  remoteID++,  usd.getFactor());
        DALUnit dal_eur = new DALUnit(eur.getName(), eur.getShortcut(), remoteID++, eur.getFactor());
        DALUnit dal_yen = new DALUnit(yen.getName(), yen.getShortcut(), remoteID++, yen.getFactor());
        DALUnit dal_pound = new DALUnit(pound.getName(), pound.getShortcut(), remoteID++, pound.getFactor());
        DALUnit dal_frank = new DALUnit(frank.getName(), frank.getShortcut(), remoteID, frank.getFactor());

        dal_units.add(dal_usd);
        dal_units.add(dal_eur);
        dal_units.add(dal_yen);
        dal_units.add(dal_pound);
        dal_units.add(dal_frank);

        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
        api.execute(this);
        return currency;
    }

    public void loadExchangeRates(JSONObject obj)
    {
        if(obj != null) {
            try {
                String base = obj.getString("base");
                if (base.equals("USD")) {
                    JSONObject rates = obj.getJSONObject("rates");
                    for (DALUnit unit: dal_units) {
                        unit.setFactor(1/rates.getDouble(unit.getShortcut()));
                    }
                    saveUnitListToDB();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(!checkFactorsUnitList()){
            Context context = Converter.getAppContext();

            Toast toast = Toast.makeText(context, "Couldn't load ExchangeRates, trying to load from database.", Toast.LENGTH_LONG);
            toast.show();
            for (DALUnit dalunit: dal_units) {
                DALUnit remoteUnit = DALUnit.load(DALUnit.class, dalunit.remote_id_);
                if (remoteUnit != null) {
                    double factor = remoteUnit.getFactor();
                    dalunit.setFactor(factor);
                }
                else {
                    context = Converter.getAppContext();
                    toast = Toast.makeText(context, "Couldn't load ExchangeRates from database.", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
            }
        }
        for(int index = 0; index < units_.size(); index++)
        {
            saveFactorToUnitList(index);
        }
    }

    private boolean checkFactorsUnitList()
    {
        for(DALUnit unit: dal_units) {
            if(unit != null && unit.getFactor() == 0.0)
                return false;
        }
        return true;
    }

    private void saveUnitListToDB()
    {
        for (DALUnit unit: dal_units) {
            if (unit != null)
                unit.save();
        }
    }

    private void saveFactorToUnitList(int position)
    {
        units_.set(position, convertDALUnitToUnit(dal_units.get(position)));
    }

    private Unit convertDALUnitToUnit(DALUnit dalunit)
    {
        return new Unit(dalunit.getName(), dalunit.getShortcut(), dalunit.getFactor());
    }

    @Override
    public void loadFactors()
    {
        CurrencyExchangeAPI api = new CurrencyExchangeAPI();
        api.execute(this);
    }

    @Override
    public void save(Currency currency) {

    }
}
