package lory.project.dotoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DoToastActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	EditText edit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(DoToastActivity.this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        edit= new EditText(this);
        edit.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        Button btn = new Button(this);
        btn.setText("Saluta");
        btn.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        btn.setOnClickListener(this);
        ll.addView(edit);
        ll.addView(btn);
        setContentView(ll);
   
        
        
    }   
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),edit.getText().toString(), Toast.LENGTH_LONG).show();
    }
    
    
}