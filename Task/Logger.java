import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is a simple Logger class,
 * The logger receives messages and writes them to a file.
 *
 */
public class Logger {
    static BlockingQueue<Message> blockingQueue = new LinkedBlockingQueue<>();
    LoggerWriter loggerWriter;

    public Logger(){
        loggerWriter = new LoggerWriter(blockingQueue);

        Thread loggerWriterThread = new Thread(loggerWriter);
        loggerWriterThread.start();
    }

    public static void sendMessage(Message message) throws InterruptedException {
        blockingQueue.put(message);
    }

    public static void main(String[] args) throws InterruptedException {
        Logger logger = new Logger();
        Logger.sendMessage(new Message("hello", SEVERITY.ACTION));
    }
}
