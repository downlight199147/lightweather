package com.example.lightweather.util;

public interface HttpCallbackListener {
	void onFinish(String reponse);
	void onError(Exception e);

}
