package dk.via;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
public class FlightBoard extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void buttonClickHandler(View view) {
    	setContentView(R.layout.table);
    }
}