package day2.webscrapprodcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

//This is the class template for the four Producer Threads P1-P4 in the exercise figure
public class DocumentProducer implements Runnable {

  BlockingQueue<String> urlsToUse;
  BlockingQueue<Document> producedDocuments;
  Document doc;
  

  public DocumentProducer(BlockingQueue<String> urlsToUse, BlockingQueue producedDocuments) {
    this.urlsToUse = urlsToUse;
    this.producedDocuments = producedDocuments;
  }

  @Override
  public void run() {
    boolean moreUrlsToFecth = true;
    while (moreUrlsToFecth) {
      try {
        String url = urlsToUse.poll(5, TimeUnit.SECONDS);
        
        if (url == null) {
          moreUrlsToFecth = false;
        } else {

          doc = Jsoup.connect(url).get(); 
         producedDocuments.put(doc);
            //TODO Use the right method on producedDocuments to add this doc to the queue

   

        }
      } catch(Exception ex) {
        Logger.getLogger(DocumentProducer.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    
  }

}
