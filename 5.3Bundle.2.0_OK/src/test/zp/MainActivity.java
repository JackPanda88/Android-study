package test.zp;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    final int CODE = 0x717;
    
	   
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == CODE && resultCode == CODE) {
			((EditText)findViewById(R.id.pwd)).setText("111");
			((EditText)findViewById(R.id.pwd1)).setText("");
		}
	}



	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user = ((EditText)findViewById(R.id.nickname)).getText().toString();
				String password = ((EditText)findViewById(R.id.pwd)).getText().toString();
				String password1 = ((EditText)findViewById(R.id.pwd1)).getText().toString();
				String email = ((EditText)findViewById(R.id.email)).getText().toString();
				
				if(!"".equals(user)&&!"".equals(password)&&!"".equals(email)) {
					if(!password.equals(password1)) {
						Toast.makeText(MainActivity.this, "两次输入的密码不一致,请重新输入！", Toast.LENGTH_LONG).show();
						((EditText)findViewById(R.id.pwd)).setText("");
						((EditText)findViewById(R.id.pwd1)).setText("");
						((EditText)findViewById(R.id.pwd)).requestFocus();
					} else {
						Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
						Bundle bundle = new Bundle();
						bundle.putCharSequence("user", user);
						bundle.putCharSequence("password", password);
						bundle.putCharSequence("email", email);
						intent.putExtras(bundle);
						startActivityForResult(intent, CODE);
					}
				} else {
					Toast.makeText(MainActivity.this, "请输入完整的注册信息", Toast.LENGTH_LONG).show();
				}
				
				
				
			}
		});
        
        Button clearButton = (Button)findViewById(R.id.clearButton);
		clearButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((EditText)findViewById(R.id.nickname)).setText("");
				((EditText)findViewById(R.id.pwd)).setText("");
				((EditText)findViewById(R.id.pwd1)).setText("");
				((EditText)findViewById(R.id.email)).setText("");
			}
		});
        
    }
}