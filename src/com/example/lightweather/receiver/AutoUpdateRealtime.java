package com.example.lightweather.receiver;

import com.example.lightweather.service.AutoUpdateService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoUpdateRealtime extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO �Զ����ɵķ������
		Intent i=new Intent(context,AutoUpdateService.class);
		context.startService(i);

	}

}
