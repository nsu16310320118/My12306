package cn.edu.nsu.a12306_program;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TrainDetail extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    private List<Number> trainNumber=new ArrayList<Number>();
    //private String[] trainNumber={"G131","G133","G135","G137","G139","G141","G143"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_list);
        initTrainNumber();

        TrainListAdapter adapter=new TrainListAdapter(this,R.layout.train_number,trainNumber);
        ListView listView=(ListView)findViewById(R.id.trianListView);
        listView.setAdapter(adapter);

//        ListView trainListView=(ListView)findViewById(R.id.trianListView);
//        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,trainNumber);
//        trainListView.setAdapter(adapter);

    }

    private void initTrainNumber() {
        Number beijing1=new Number("G131");//如果加图片，R.drawable.图片名
        trainNumber.add(beijing1);
        Number beijing2=new Number("G133");
        trainNumber.add(beijing2);
        Number beijing3=new Number("G135");
        trainNumber.add(beijing3);
        Number beijing4=new Number("G137");
        trainNumber.add(beijing4);
        Number beijing5=new Number("G139");
        trainNumber.add(beijing5);
        Number beijing6=new Number("G141");
        trainNumber.add(beijing6);
        Number beijing7=new Number("G143");
        trainNumber.add(beijing7);
        Number beijing8=new Number("G143");
        trainNumber.add(beijing8);
        Number beijing9=new Number("G143");
        trainNumber.add(beijing9);
        Number beijing10=new Number("G143");
        trainNumber.add(beijing10);
    }

    public static class Number{//车次类
        private static String number;
        public Number(String number){
            this.number=number;
        }
        public static String getNumber(){
            return number;
        }
    }

}
