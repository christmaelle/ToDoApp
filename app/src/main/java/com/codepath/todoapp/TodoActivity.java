package com.codepath.todoapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class TodoActivity extends ActionBarActivity {
    private ArrayList<String> todoItems;
    private ArrayAdapter<String> todoAdapter;
    private ListView lvItems;
    private EditText etNewItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        etNewItem=(EditText) findViewById(R.id.etNewitem);
        lvItems=(ListView) findViewById(R.id.lvitems);
        populateArrayItems();
        todoAdapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,todoItems);
        lvItems.setAdapter(todoAdapter);
        setupListViewListener();
    }
    private void setupListViewListener() {
     lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
             todoItems.remove(pos);
             todoAdapter.notifyDataSetChanged();
             return true;
         }
     });
    }

    private void populateArrayItems() {
        todoItems=new ArrayList<String>();
        todoItems.add("Item 1");
        todoItems.add("Item 2");
        todoItems.add("Item 3");
    }

    public void onAddedItem(View v){
        String itemText=etNewItem.getText().toString();
        todoAdapter.add(itemText);
        etNewItem.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
