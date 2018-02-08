package test.retrofit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity {

	private static Logger logger = LoggerFactory.getLogger(MainActivity.class);

	public static void main(String[] args) {
		Retrofit retrofit2 = new Retrofit.Builder().baseUrl("https://api.thinkpage.cn")
				.addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
		IWeather iWeather = retrofit2.create(IWeather.class);

		Call<WeatherBean> call = iWeather.weather("lqrwicdjnqedm76d", "chengdu");
		call.enqueue(new Callback<WeatherBean>() {
			@Override
			public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
				WeatherBean weatherBean = response.body();
				logger.debug("cylog {}", weatherBean.results.get(0).now.temperature + "");
			}

			@Override
			public void onFailure(Call<WeatherBean> call, Throwable t) {
				logger.debug("cylog {}", "Error" + t.toString());
			}
		});

	}

}
