package br.com.eltonpignatel.app.gateway.database.jdbc;


public interface Repository<K, E> {

    void persist(E entity) throws Exception;

    E findById(K id);

    E merge(E entity) throws Exception;

    void remove(E entity);

    E getReference(K id);

    long sequenceID(String nameSequence);

    void flush();
}