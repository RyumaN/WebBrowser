package com.example.webbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class WebBrowserActivity extends Activity {

	 private WebView webView;
	 private EditText editText;


	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_web_browser);


	 webView = (WebView)findViewById(R.id.WebView01);
	 webView.setWebViewClient(new WebViewClient());

	//拡大表示を行う為のクラス
	 webView.getSettings().setBuiltInZoomControls(true);

	//javascriptを行う為のクラス
	 webView.getSettings().setJavaScriptEnabled(true);
	 webView.loadUrl("http://www.google.com");

	 }
	 public boolean onCreateOptionsMenu(Menu menu){
		 super.onCreateOptionsMenu(menu);
		 getMenuInflater().inflate(R.menu.menu,menu);
		 return true;
	 }

	 	public boolean onPrepareOptionsMenu(Menu menu){
	 		super.onPrepareOptionsMenu(menu);

	 		if(webView.canGoBack()){
	 			menu.findItem(R.id.item1).setEnabled(true);
	 		}else{
	 			menu.findItem(R.id.item1).setEnabled(false);
	 }
	 		if(webView.canGoForward()){
	 			menu.findItem(R.id.item2).setEnabled(true);
	 		}else{
	 			menu.findItem(R.id.item2).setEnabled(false);
	 }
	 return true;
	 }
	 public boolean onOptionsItemSelected(MenuItem item){
		 switch(item.getItemId()){
		 	case R.id.item1:
		 		webView.goBack();
		 		break;
		 	case R.id.item2:
		 		webView.goForward();
		 		break;
		 	case R.id.item3:
		 		finish();
		 		break;
		 		default:
		 		break;
	 }
	 return super.onOptionsItemSelected(item);
	 }

	}