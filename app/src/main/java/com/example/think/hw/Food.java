package com.example.think.hw;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

//import static com.example.think.hw.R.id.list_view;

public class Food extends Fragment {
    private static  final  String TAG = "Food";
    TextView date;
    TextView element1,element2, element3, element4;
    ArrayList list= new ArrayList<>();
    ProgressDialog doTheDialog;

    public Food() {

    }
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View view= inflater.inflate(R.layout.tab1_fragment,container, false);

      //listView=(ListView) listView.findViewById(list_view);
     // listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new ArrayList<String>()));
      date=(TextView)view.findViewById(R.id.date);
      element1=(TextView)view.findViewById(R.id.item1);
      element2=(TextView)view.findViewById(R.id.item2);
      element3=(TextView)view.findViewById(R.id.item3);
      element4=(TextView)view.findViewById(R.id.item4);
      new MyTask().execute();

      return view;


  }




    class MyTask extends AsyncTask<Void,Void,Void>{

    // ArrayAdapter<String> adapter;



        @Override
        protected void onPreExecute() {

           //adapter=(ArrayAdapter<String>) listView.getAdapter();
             doTheDialog= new ProgressDialog(getActivity());
            doTheDialog.setTitle("getting Information in progress...");
            doTheDialog.setMax(10);
            doTheDialog.setProgress(0);
           // doTheDialog.setIndeterminate(false);
            //doTheDialog.setCancelable(true);
            doTheDialog.show();

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

         Document doc;
          try{
             doc = Jsoup.connect("http://ybu.edu.tr/sks/").get();
              Elements date = doc.select("h3");
              Elements element = doc.select("h5");
              //final int food = Log.d("food", element.toString());
              list.add(date.text());
              for (int i = 0; i < element.size(); i++) {
                  list.add(element.get(i).text());
              }
          }catch (IOException e ){

            e.printStackTrace();
          }


            return null;
        }

       // @Override
      // protected void onProgressUpdate(String... values) {



      //     //adapter.add(values[0]);



      //     super.onProgressUpdate(values);
      // }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            date.setText(list.get(0).toString());
            element1.setText(list.get(1).toString());
            element2.setText(list.get(2).toString());
            element3.setText(list.get(3).toString());
            element4.setText(list.get(4).toString());
            doTheDialog.dismiss();



           ;
        }
    }





}
