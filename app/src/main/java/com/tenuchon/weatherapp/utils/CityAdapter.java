package com.tenuchon.weatherapp.utils;


import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.tenuchon.weatherapp.R;
import com.tenuchon.weatherapp.model.City;
import com.tenuchon.weatherapp.ui.AboutActivity;

import java.util.List;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityHolder> {
    private List<City> list;
    private LayoutInflater inflater;
    private Context context;

    public CityAdapter(Context context, List<City> cities) {
        this.list = cities;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityHolder(inflater.inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder holder, int position) {
        City city = list.get(position);
        holder.bind(city);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addCity(City city) {
        list.add(city);
        notifyDataSetChanged();
    }

    public void setList(List<City> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public Context getContext() {
        return context;
    }


    public void attachHelperToRecyclerView(final RecyclerView recyclerView) {
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                City city = list.get(position);
                CityLab.getInstance(context).removeCity(city);
                list.remove(position);
                notifyItemRemoved(position);
            }
        });
        helper.attachToRecyclerView(recyclerView);
    }


    static class CityHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView temp, name, maxMin, time;
        private ImageView icon;
        private City city;

        public CityHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            temp = itemView.findViewById(R.id.temp);
            name = itemView.findViewById(R.id.name);
            maxMin = itemView.findViewById(R.id.max_mix);
            time = itemView.findViewById(R.id.time);
            itemView.setOnClickListener(this);
        }

        public void bind(City city) {
            this.city = city;
            DataUtils.setWeatherIcon(icon,city.getWeatherId());
            name.setText(city.getName());
            temp.setText(Converter.convertTemperature(city.getTemp()));
            maxMin.setText(Converter.convertMaxAndMin(city.getMaxTemp(), city.getMinTemp()));
            time.setText(Converter.convertTime(city.getTime(), city.getTimezone()));
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, AboutActivity.class);
            intent.putExtra("item", city);
            context.startActivity(intent);
        }
    }
}
