package joy.mangosoft.com.overflowmenu;

import android.app.Activity;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

   ListView listView;
   public String title[];
    String description[];
    int resource[]={R.drawable.one,R.drawable.two,R.drawable.three,
            R.drawable.four,R.drawable.five,R.drawable.six,
            R.drawable.seven,R.drawable.eight ,R.drawable.nine,
            R.drawable.ten,R.drawable.eleven,R.drawable.twelve};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        this.title=resources.getStringArray(R.array.title);
        this.description=resources.getStringArray(R.array.description);


        listView=(ListView)findViewById(R.id.list);

        ListAdapter listAdapter=new ListAdapter(MainActivity.this,this.title,this.description,this.resource);
        listView.setAdapter(listAdapter);


    }
}

class ListAdapter extends ArrayAdapter<String>{

    Context context;
    String [] title;
    String []describ;
    int [] resouces;

    public ListAdapter(@NonNull Context context, String [] title,String []describ,int [] resources) {
        super(context ,R.layout.activity_main2,R.id.textView,title);
        this.context=context;
        this.describ=describ;
        this.title=title;
        this.resouces=resources;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.activity_main2,parent,false);
        ImageView imageView=view.findViewById(R.id.imageView);
        TextView title=view.findViewById(R.id.textView);
        TextView des=view.findViewById(R.id.textView2);

        imageView.setImageResource(resouces[position]);
        title.setText(this.title[position]);
        des.setText(this.describ[position]);




        return view;
    }
}
