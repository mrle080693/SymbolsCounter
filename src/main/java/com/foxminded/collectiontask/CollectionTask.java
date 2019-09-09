package main.java.com.foxminded.collectiontask;

import main.java.com.foxminded.collectiontask.processors.CollectionTaskProcessor;

public class CollectionTask {
    public static void main(String[] args) {
        CollectionTaskProcessor collectionTaskProcessor = new CollectionTaskProcessor();
        System.out.println(collectionTaskProcessor.process(" "));
    }
}
