package com.baotianqi.valpromise.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.baotianqi.valpromise.R;
import com.baotianqi.valpromise.dialog.interfaces.DialogClick2;


public class ShareDialog extends Dialog {
	private DialogClick2 menuClick;
	private ImageButton  close;
	private ImageButton  haoyou,quan;

	public ShareDialog (Context context, DialogClick2 menuClick, int flag) {
		super(context, R.style.MyDialogStyle);
		this.menuClick = menuClick;

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedialog);
		close = (ImageButton) findViewById(R.id.close);
		haoyou=(ImageButton)findViewById(R.id.haoyou);
		quan=(ImageButton)findViewById(R.id.quan);


		close.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		
		haoyou.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				menuClick.dialogOk();
				dismiss();
			}
		});
		
		quan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				menuClick.dialogCancel();
				dismiss();
			}
		});
	}


}
