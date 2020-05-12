package com.example.dicodjavv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        list.addAll(HeroData.getData());
        showReyclerList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int SelectedMode) {
        switch (SelectedMode){
            case R.id.action_cardView:
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                getSupportActionBar().setTitle("Mode Grid");
                break;
            case R.id.action_list:
                showReyclerList();
                getSupportActionBar().setTitle("Mode Title");
                break;
        }
    }

    private void showReyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listheroadapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listheroadapter);
    }

    private void showRecyclerGrid(){
        rvHeroes.setLayoutManager(new GridLayoutManager(this,2 ));
        GridHeroAdapter gridheroadapter = new GridHeroAdapter(list);
        rvHeroes.setAdapter(gridheroadapter);
    }
}
