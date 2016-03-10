package test.zp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		TextView user = (TextView)findViewById(R.id.user);
		TextView password = (TextView)findViewById(R.id.password);
		TextView email = (TextView)findViewById(R.id.email);
		user.setText("”√ªß√˚£∫"+bundle.getString("user"));
		password.setText("√‹¬Î£∫"+bundle.getString("password"));
		email.setText("” œ‰£∫"+bundle.getString("email"));
		
		Button backButton = (Button)findViewById(R.id.back);
		backButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(0x717);
				finish();
			}
		});
		
	}
}