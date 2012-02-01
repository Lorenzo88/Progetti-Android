package lory.project.chat;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatActivity extends Activity {
    /** Called when the activity is first created. */
	EditText edit;
	TextView text;
	Connection connection;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edit= (EditText) findViewById(R.id.editText1);
        text= (TextView) findViewById(R.id.textView1);
        text.setMovementMethod(new ScrollingMovementMethod());
        Button button= (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				text.append("ME: "+edit.getText().toString()+"\n");
				Message msg = new Message();
				msg.setTo("loreti@ppl.eln.uniroma2.it");
				msg.setBody(edit.getText().toString());
				connection.sendPacket(msg);
			}
		});
        try {
        	ConnectionConfiguration config = new ConnectionConfiguration("ppl.eln.uniroma2.it", 5222);
        	config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        	connection = new XMPPConnection(config);
        	connection.connect();
        	connection.login("silvestri", "silvestri");
        } catch (XMPPException e) {
        	e.printStackTrace();
        }
        connection.addPacketListener(new PacketListener() {
			
			@Override
			public void processPacket(Packet pkt) {
				// TODO Auto-generated method stub
				Message msg = (Message) pkt;
				String from = msg.getFrom();
				String body = msg.getBody();
				text.append(from+" : "+body+"\n");
			}
		}, new MessageTypeFilter(Message.Type.normal));
    }
}