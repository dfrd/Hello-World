package helloworld.android;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.os.Handler;
import android.view.View;


//HelloWorld
public class HelloView extends View{
	private int colorRedNum;
	private int colorBlueNum;
	private int colorGreenNum;
	private boolean plus;
	//コンストラクタ
	public HelloView(Context context){
		super(context);
		colorRedNum = 0;
		colorGreenNum = 0;
		colorBlueNum = 0;
		plus = true;
		setBackgroundColor(Color.BLACK);	
		timerCount();
	}
	@Override
	protected void onDraw(Canvas canvas){
		String helloWorld = "Hello World!";
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setARGB(255, colorRedNum, colorGreenNum, colorBlueNum);
		paint.setTextSize(getWidth() /10);
		
		FontMetrics fontMetrics = paint.getFontMetrics();
		float positionX = (getWidth() - paint.measureText(helloWorld)) /2;
		float positionY = (getHeight() - fontMetrics.ascent - fontMetrics.descent)/2;
		
		canvas.drawText(helloWorld, positionX, positionY, paint);
	}
	//------------------------------
	//	制限時間
	//------------------------------
	private void timerCount(){
		Timer timer = new Timer(true);
		final Handler timerHandler = new Handler();
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				timerHandler.post(new Runnable() {
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						if(plus){
							colorRedNum++;
							if(colorRedNum >= 255){
								colorRedNum = 255;
								colorGreenNum++;
								if(colorGreenNum >= 255){
									colorGreenNum = 255;
									colorBlueNum++;
									if(colorBlueNum >= 255){
										colorBlueNum = 255;
										plus = false;
									}
								}
							}
						}
						else if(!plus){
							colorBlueNum--;
							if(colorBlueNum <= 0){
								colorBlueNum = 0;
								colorGreenNum--;
								if(colorGreenNum <= 0){
									colorGreenNum = 0;
									colorRedNum--;
									if(colorRedNum <= 0){
										colorRedNum = 0;
										plus = true;
									}
								}
							}
						}
						invalidate();
					}
				});
			}
		}, 0, 10);
	}
}
