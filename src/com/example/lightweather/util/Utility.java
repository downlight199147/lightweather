package com.example.lightweather.util;

import java.util.Iterator;

import android.text.TextUtils;

import com.example.lightweather.db.WeatherDataBase;
import com.example.lightweather.model.City;
import com.example.lightweather.model.County;
import com.example.lightweather.model.Province;

public class Utility {
	public synchronized static boolean handleProvincesResponse(
			WeatherDataBase weatherDataBase, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					weatherDataBase.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}

	public static boolean handleCitiesResponse(WeatherDataBase weatherDataBase,
			String response, int pronvinceId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCities = response.split(",");
			if (allCities != null && allCities.length > 0) {
				for (String p : allCities) {
					String[] array = p.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					weatherDataBase.saveCity(city);
				}
				return true;
			}
		}
		return false;

	}
	
	public static boolean handleCountiesResponse(WeatherDataBase weatherDataBase,
			String response, int cityId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCounties = response.split(",");
			if (allCounties != null && allCounties.length > 0) {
				for (String p : allCounties) {
					String[] array = p.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					weatherDataBase.saveCounty(county);
				}
				return true;
			}
		}
		return false;

	}

}
