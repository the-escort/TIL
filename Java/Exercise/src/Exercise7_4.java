
public class Exercise7_4 {

	public static void main(String args[]) {
		MyTv t = new MyTv();

	}
}

class MyTv {
	private boolean isPowerOn;
	private int channel;
	private int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		if (channel > MAX_VOLUME || channel < MIN_CHANNEL) {
			return;
		}

		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if (volume > MAX_VOLUME || volume < MIN_CHANNEL) {
			return;
		}

		this.volume = volume;
	}
}