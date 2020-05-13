package com.tenuchon.weatherapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.tenuchon.weatherapp.utils.CityAdapter;
import com.tenuchon.weatherapp.utils.DataUtils;
import com.tenuchon.weatherapp.R;
import com.tenuchon.weatherapp.model.City;

import java.util.List;


public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CityAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = findViewById(R.id.swipe_container);
        toolbar = refreshLayout.findViewById(R.id.toolbar);
        recyclerView = refreshLayout.findViewById(R.id.recycler_view);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        initRecyclerView();
    }

    public void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<City> cities = DataUtils.getCitiesList(this, refreshLayout);
        adapter = new CityAdapter(this, cities);
        recyclerView.setAdapter(adapter);
        adapter.attachHelperToRecyclerView(recyclerView);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                final SearchView searchView = (SearchView) item.getActionView();
                searchView.onActionViewExpanded();
                searchView.setQueryHint(getResources().getString(R.string.search_hint));
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        DataUtils.loadCity(query, adapter, getApplicationContext(), null, false);
                        searchView.onActionViewCollapsed();
                        searchView.clearFocus();
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
        }
        return true;
    }

    @Override
    public void onRefresh() {
        List<City> cities = DataUtils.getCitiesList(this, refreshLayout);
        adapter.setList(cities);
    }
}
