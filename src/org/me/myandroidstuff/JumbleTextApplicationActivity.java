package org.me.myandroidstuff;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class JumbleTextApplicationActivity extends Activity implements OnClickListener {
    private EditText originalText;
    private TextView jumbledText;
    private Button jumbleButton;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        originalText = (EditText) findViewById(R.id.originalText);     
        jumbledText = (TextView) findViewById(R.id.jumbledText);
        jumbleButton = (Button) findViewById(R.id.jumbleButton);
        jumbleButton.setOnClickListener(this);
        
    }

	public static String Jumble(String original)
	  {
	    StringBuilder sb = new StringBuilder(original);
	 
	    char temp;
	    int  swapWith;
	    for(int i=0; i<sb.length(); i++)
	    {
	      temp = sb.charAt(i);
	      swapWith = (int)Math.floor(Math.random()*sb.length());
	      sb.setCharAt(i, sb.charAt(swapWith));
	      sb.setCharAt(swapWith, temp);
	    }

	    return sb.toString();
	  }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("in onClick");
		String originalString = originalText.getText().toString();
		String jumbledString = Jumble(originalString);
		jumbledText.setText(jumbledString);
	}

}