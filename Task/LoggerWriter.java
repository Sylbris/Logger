import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.BlockingQueue;

/**
 * Implements a thread that consumes messages,
 * and writes them to file.
 */
public class LoggerWriter implements Runnable{
    BlockingQueue<Message> blockingQueue;

    public LoggerWriter(BlockingQueue<Message> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message queueMessage = blockingQueue.take();
                LocalDate localDate = LocalDate.now();
                String str = localDate.toString() + " " + queueMessage.severity + " " + queueMessage.message + " \n";

                BufferedWriter writer = new BufferedWriter(new FileWriter("logger.txt", true));

                writer.write(str);
                writer.close();

            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
