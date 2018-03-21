package at.maymay.convertme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Converter extends AppCompatActivity {

    private double fromValue;
    private double toValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        UnitHelper helper = new UnitHelper();
        helper.init();

    }

    public void convert(Unit from, Unit to) {

    }


}
