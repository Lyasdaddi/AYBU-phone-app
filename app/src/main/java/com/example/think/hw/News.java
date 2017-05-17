package com.example.think.hw;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by THINK on 5/10/2017.
 */

public class News extends Fragment {
    ListView listView;
    ArrayList arraylist;
    ArrayAdapter adapter;
    private static final String TAG="News";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab2_fragment,container, false);
    arraylist=new ArrayList();
        listView=(ListView) view.findViewById(R.id.list_item_news);
       adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,arraylist);

        new MyTask1().execute();
        return view;
    }

 class MyTask1 extends AsyncTask<Void,Void, Void>{



     @Override
     protected void onPreExecute() {
         super.onPreExecute();
     }

     @Override
     protected Void doInBackground(Void... params) {

         Document doc= null;
         try {
             doc= Jsoup.connect("http://ybu.edu.tr/muhendislik/bilgisayar/").get();
             //StringBuilder builder = new StringBuilder();
             Elements elements =doc.select("div.cnContent>div.cncItem");
             for (int i = 0; i < elements.size(); i++) {
                 arraylist.add(elements.get(i).text());
             }

         } catch (IOException e) {
             e.printStackTrace();
         }


         return null;
     }



     @Override
     protected void onPostExecute(Void aVoid) {
         super.onPostExecute(aVoid);
         listView.setAdapter(adapter);
     }
 }


}
