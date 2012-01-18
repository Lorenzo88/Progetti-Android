package lory.project.dueactivityv2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Second extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TextView label = (TextView) findViewById(R.id.textview1);
        String iltestoricevuto = getIntent().getExtras().getString("iltestonelbox");
        label.setText(iltestoricevuto);
	}
	protected void onStart(){
		super.onStart();
		String str = "START";
		Log.d("LOG XML",str);
	}
	protected void onRestart(){
		super.onRestart();
		String str = "RESTART";
		Log.d("LOG XML",str);
	}
	protected void onResume() {
		super.onResume();
		String str = "ONRESUME";
		Log.d("LOG XML",str);
	}
	protected void onPause() {
		super.onPause();
		String str = "ONPAUSE";
		Log.d("LOG XML",str);
	}
	protected void onStop() {
		super.onStop();
		String str = "ONSTOP";
		Log.d("LOG XML",str);
	}
}
