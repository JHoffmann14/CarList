package us.mattgreen.listexample;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    ArrayAdapter<String> arrayadapter;



    static final String[] CARSARRAY = new String[] {"Add Car", "Ford Mustang", "Saab 77", "Plymoth Horizon",
            "Dodge Carivan", "Toyota Tercel", "Toyota Rav4", "Chrsysler Sebring", "Eagle Talon",
            "Dodge Diplomat"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<String> cars = new ArrayList(Arrays.asList(CARSARRAY)); //asList from Arrays class, asList is static
        arrayadapter = new ArrayAdapter<String>(this,R.layout.list_car, cars);
       // setListAdapter(new ArrayAdapter<String>(this, R.layout.list_car, cars));

        ListView listView = getListView();
        listView.setAdapter(arrayadapter);
        listView.setTextFilterEnabled(true);


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
              /*  // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                    ((TextView) view).getText() + (" "+position), Toast.LENGTH_SHORT).show();*/

               if (position != 0) {
                    cars.remove(position);
                }
                if(position == 0){
                  cars.add(new String());
                }
               arrayadapter.notifyDataSetChanged();
            }

        });


        //adding button to add new item to list

        listView.invalidateViews();
    }
}
