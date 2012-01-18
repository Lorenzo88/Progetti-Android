package lory.project.myplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyPlayerActivity extends Activity {
    /** Called when the activity is first created. */
	MediaPlayer mp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mp = MediaPlayer.create(MyPlayerActivity.this, R.raw.lost);
        Button bottone = (Button) findViewById(R.id.button1);
        bottone.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		mp.start();
        	}
		});
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mp.pause();
			}
		});
        
    }
    protected void onDestroy() {
    	mp.release();
    }
}