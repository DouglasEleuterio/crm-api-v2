package br.com.tresptecnologia.service.storage;

import br.com.tresptecnologia.service.storage.exception.StorageException;

import java.io.InputStream;

public interface IStorageService {
    boolean exists(String bucket, String path, String nome) throws StorageException;

    void upload(String bucket,
                String path,
                String nome,
                String contentType,
                long size,
                InputStream inputStream) throws StorageException;

    /**
     *
     * @param bucketSource - Bucket
     * @param pathTarget - Path
     * @param nomeSource - NomeOriginal
     */
    InputStream get(String bucketSource,
                    String pathTarget,
                    String nomeSource) throws StorageException;

    void delete(String bucket, String path, String name) throws StorageException;

    void deleteFilesFromPath(String bucket, String path) throws StorageException;
}
