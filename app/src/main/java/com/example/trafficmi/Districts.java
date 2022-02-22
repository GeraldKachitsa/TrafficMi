package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class Districts extends AppCompatActivity {

    ListView listView;
    String[] name = {"Balaka","Blantyre", "Chikwawa"," Chiradzulu", "Chitipa", "Dedza",
            "Dowa", "Karonga", "Kasungu", "Likoma","Lilongwe", "Machinga", "Mangochi",
            "Mchinji", "Mulanje", "Mwanza", "Mzimba", "Neno","Ntcheu" ," Nkhata","Bay",
            "Nkhotakota", "Nsanje", "Ntchisi", "Phalombe", "Rumphi", "Salima","Rumphi", "Salima", "Thyolo", "Zomba"};

    ArrayAdapter<String> arrrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districts);
        listView = findViewById(R.id.list_view);
        arrrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,name);
       listView.setAdapter(arrrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}