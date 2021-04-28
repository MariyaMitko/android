package mitsko.mobile.automation.android.objects;

public class TranslatedWord {
	String word;
	String translation;
	
	public TranslatedWord (String word, String translation){
		this.word = word;
		this.translation = translation;
	}

	public synchronized String getWord() {
		return word;
	}

	public synchronized void setWord(String word) {
		this.word = word;
	}

	public synchronized String getTranslation() {
		return translation;
	}

	public synchronized void setTranslation(String translation) {
		this.translation = translation;
	}

}
