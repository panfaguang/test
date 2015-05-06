package test.redis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

class NmapMessage {
    public NmapMessage(String Message) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String processId = Thread.currentThread().getId() + "";
        if (processId.length() > 6) {
            processId = processId.substring(processId.length() - 6);
        } else {
            while (processId.length() < 6) {
                processId = "0" + processId;
            }
        }
        this.messageId = df.format(date) + processId;
        System.out.println(messageId);
        this.message = Message;
        semaphore = new Semaphore(0);
    }

    String getMessageId() {
        return this.messageId;
    }

    String getMessage() {
        return this.message;
    }

    String waitResult() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            this.result = null;
        }
        return this.result;
    }

    void setResult(String result) {
        this.result = result;
        semaphore.release();
    }

    private String messageId;
    private String message;
    private String result;
    private Semaphore semaphore;
}
