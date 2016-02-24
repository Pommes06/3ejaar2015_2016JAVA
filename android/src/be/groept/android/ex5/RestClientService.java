package be.groept.android.ex5;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RestClientService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(final Intent intent, int flags, int startId) {
		Log.d("upload status", "In SERVICE");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpClient httpClient = new DefaultHttpClient();
					HttpContext localContext = new BasicHttpContext();
					HttpPost httpPost = new HttpPost(intent.getExtras()
							.getString("host") + "/ImageService/service/upload");
					HttpEntity httpEntity = MultipartEntityBuilder
							.create()
							.addBinaryBody(
									"image",
									new File(intent.getExtras().getString(
											"image"))).build();
					httpPost.setEntity(httpEntity);
					HttpResponse response = httpClient.execute(httpPost,
							localContext);
					Log.d("upload status", response.getStatusLine()
							.getStatusCode()
							+ " - "
							+ response.getStatusLine().getReasonPhrase());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();

		return 0;
	}

}
