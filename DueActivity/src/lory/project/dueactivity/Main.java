package lory.project.dueactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
    /** Called when the activity is first creatpublic void onCreate(Bundle savedInstanceSted. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new OnClickListener()  {
        	/** Non so perché non gli piace l'override. */
        	public void onClick(View v){
        		startActivity(new Intent(Main.this, Second.class));
        	}
        });
    }
}