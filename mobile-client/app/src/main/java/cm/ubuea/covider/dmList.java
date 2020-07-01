package cm.ubuea.covider;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class dmList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_list);
        final ListView list = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1. MBEKOU DJUATIO JESSIE");
        arrayList.add("2. BAHA TEDDY WILLIAM");
        arrayList.add("3. HARVEY KOLLE NGOE");
        arrayList.add("4. DOMOU BRICE ARMEL ");
        arrayList.add("5. LOBE NYOH SERGE");
        arrayList.add("6. MBINO RUTH ATEM");
        arrayList.add("7. MBINO RUTH ATEM");
        arrayList.add("8. MBINO RUTH ATEM");
        arrayList.add("9. MBINO RUTH ATEM");
        arrayList.add("10. MBINO RUTH ATEM");
        arrayList.add("11. MBINO RUTH ATEM");
        arrayList.add("12. MBINO RUTH ATEM");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent gotoUserLocation = new Intent(getApplicationContext(), dmDisTrack.class);
                startActivity(gotoUserLocation);
            }
        });
    }
}
