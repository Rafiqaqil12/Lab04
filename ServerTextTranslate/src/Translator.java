import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Translator {
  // TODO: If you have your own Premium account credentials, put them down here:
  private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
  private static final String CLIENT_SECRET = "PUBLIC_SECRET";
  private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
  private static String malay;
  private static String arabic;
  private static String korean;

  public Translator(String english, String choice) throws Exception {
		main(english,choice);
	}
  public Translator(String english) {
	// TODO Auto-generated constructor stub
}

/**
   * Entry Point
   */
  public static void main(String english,String choice) throws Exception {
    // TODO: Specify your translation requirements here:
    String fromLang = "en";
    String toLang = "ms";
    String toLang1 = "ar";
    String toLang2 = "ko";
    
    String my = toLang;
    String arab = toLang1;
    String korea = toLang2; 
    
    if (choice.equals(my)) {
    	Translator.translate(fromLang, toLang, english);
    	ServerTextApplication app = new ServerTextApplication();
    	app.Continue(malay);
    }
    	

    else if (choice.equals(arab)){
    	Translator.translate(fromLang, toLang1, english);
    	ServerTextApplication app = new ServerTextApplication();
    	app.Continue(arabic);
    }

    else if (choice.equals(korea)){
    	Translator.translate(fromLang, toLang2, english);
    	ServerTextApplication app = new ServerTextApplication();
    	app.Continue(korean);
    }
   

  }

  /**
   * Sends out a WhatsApp message via WhatsMate WA Gateway.
   */
  public static void translate(String fromLang, String toLang, String text) throws Exception {
    // TODO: Should have used a 3rd party library to make a JSON string from an object
    String jsonPayload = new StringBuilder()
      .append("{")
      .append("\"fromLang\":\"")
      .append(fromLang)
      .append("\",")
      .append("\"toLang\":\"")
      .append(toLang)
      .append("\",")
      .append("\"text\":\"")
      .append(text)
      .append("\"")
      .append("}")
      .toString();

    URL url = new URL(ENDPOINT);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
    conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
    conn.setRequestProperty("Content-Type", "application/json");

    OutputStream os = conn.getOutputStream();
    os.write(jsonPayload.getBytes());
    os.flush();
    os.close();

    int statusCode = conn.getResponseCode();
    System.out.println("Status Code: " + statusCode);
    BufferedReader br = new BufferedReader(new InputStreamReader(
        (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
      ));
    String output;
    
    while ((output = br.readLine()) != null) {
        System.out.println(output);
        
        if(toLang == "ms")
        	malay = new String(output);
        
        else if(toLang == "ar")
        	arabic = new String(output);
        
        else if(toLang == "ko")
        	korean = new String(output);
        
    }
    conn.disconnect();
  }

}