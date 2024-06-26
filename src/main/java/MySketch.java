import processing.core.PApplet;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {

	private float x;
	private float y;
	int framcount = 0;
	int maxframe = 15;
	;

	ControlP5 cp5;

	public void setup() {
		this.getSurface().setResizable(true);
		background(100, 180, 180);
		noStroke();
		blendMode(REPLACE);

		cp5 = new ControlP5(this);
		cp5.addSlider("maxframe")
				.setPosition(10, 10)
				.setRange(1, 20)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.001f, 0.005f)
				.setValue(5)
				.setSize(100, 20);
	}

	public void settings() {
		size(500, 500);
	}

	public void mouseDragged() {
		x = random(5, 50);
		y = random(5, 50);
	}

	public void frameResized(int w, int h) {

	}

	public void draw() {
		framcount++;
		if( framcount > maxframe){
			for (int i = 0; i < 25; i++){
				int c = color(100, random(180, 255), random(180, 255), random(15, 150));
				fill(c);
				float r = random(width / 40, width / 20);
				ellipse(random(width), random(height), r, r);
				tint(255, 128);
			}
			framcount = 0;

			var img = get();
			background(100, 180, 180);
			tint(255, 220);
			image(img,0, 0);
		}
	}
}
