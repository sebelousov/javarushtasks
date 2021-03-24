package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private Storage storage;

    private OriginalRetriever retriever;
    private LRUCache cache;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.retriever = new OriginalRetriever(storage);
        this.cache = new LRUCache(7);
    }

    @Override
    public Object retrieve(long id) {
        Object objectFromCashe = cache.find(id);
        if (objectFromCashe == null) {
            Object object = retriever.retrieve(id);
            cache.set(id, object);
            return object;
        }

        return objectFromCashe;
    }
}
