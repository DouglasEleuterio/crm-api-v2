package br.com.tresptecnologia.service.storage;

import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.service.storage.exception.StorageException;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.Result;
import io.minio.StatObjectArgs;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.InputStream;

@Slf4j
public class MinioStorageService implements IStorageService {

    private static final String FALHA_AO_REALIZAR_O_UPLOAD_DOS_ARQUIVOS = "Falha ao realizar o upload dos arquivos";
    private static final String FALHA_AO_REALIZAR_REMOCAO_OBJETO = "Falha ao realizar remoção do arquivo";
    private static final String STORAGE_ERROR_FAIL_EXISTS = "storage.error.failExists";

    private final MinioClient minioClient;

    public MinioStorageService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public boolean exists(String bucket, String path, String nome) throws StorageException {
        try {
            isBucketExists(bucket);

            var objectStat =
                    minioClient.statObject(
                            StatObjectArgs.builder().bucket(bucket).object(getFullPath(path, nome)).build());

            if (objectStat != null) {
                log.debug("Objeto encontrado: {}", objectStat.etag());
            }

            return objectStat != null;

        } catch (Exception ex) {
            log.debug(FALHA_AO_REALIZAR_O_UPLOAD_DOS_ARQUIVOS, ex);
            throw new StorageException(Message.toLocale(STORAGE_ERROR_FAIL_EXISTS));
        }
    }

    @Override
    public void upload(String bucket,
                       String path,
                       String nome,
                       String contentType,
                       long size,
                       InputStream inputStream) throws StorageException {
        try {
            isBucketExists(bucket);

            var putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucket)
                    .object(getFullPath(path, nome))
                    .contentType(contentType)
                    .stream(inputStream, size, -1)
                    .build();
            minioClient.putObject(putObjectArgs);

        } catch (Exception ex) {
            log.debug(FALHA_AO_REALIZAR_O_UPLOAD_DOS_ARQUIVOS, ex);
            throw new StorageException(Message.toLocale("storage.error.failUpload"));
        }

    }

    public InputStream get(String bucket, String path, String name) throws StorageException {
        try {
            isBucketExists(bucket);

            var objectResponse =
                    minioClient.getObject(
                            GetObjectArgs.builder()
                                    .bucket(bucket)
                                    .object(getFullPath(path, name))
                                    .build());
            if (objectResponse == null) {
                throw new StorageException(Message.toLocale(STORAGE_ERROR_FAIL_EXISTS));
            }

            log.debug("Objeto encontrado: {}", objectResponse.object());

            return objectResponse;

        } catch (Exception ex) {
            log.debug(FALHA_AO_REALIZAR_O_UPLOAD_DOS_ARQUIVOS, ex);
            throw new StorageException(Message.toLocale(STORAGE_ERROR_FAIL_EXISTS));
        }
    }

    @Override
    public void delete(String bucket, String path, String name) throws StorageException {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(bucket)
                    .object(getFullPath(path, name))
                    .build());

        } catch (Exception ex) {
            log.debug(FALHA_AO_REALIZAR_REMOCAO_OBJETO, ex);
            throw new StorageException(Message.toLocale("storage.error.failRemove"));
        }
    }

    @Override
    public void deleteFilesFromPath(String bucket, String path) throws StorageException {
        try {
            var listItens = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucket).prefix(path).delimiter(File.pathSeparator).build());

            for (Result<Item> item : listItens) {
                minioClient.removeObject(
                        RemoveObjectArgs.builder().bucket(bucket).object(getFullPath(path, FilenameUtils.getName(item.get().objectName()))).build());
            }

        } catch (Exception ex) {
            log.debug(FALHA_AO_REALIZAR_REMOCAO_OBJETO, ex);
            throw new StorageException(Message.toLocale("storage.error.failRemove"));
        }
    }

    private void isBucketExists(String bucket) throws StorageException {
        try {
            boolean isExist =
                    minioClient.bucketExists(BucketExistsArgs
                            .builder()
                            .bucket(bucket)
                            .build());
            if (!isExist) {
                throw new StorageException(Message.toLocale("storage.error.notfound"));
            }
        } catch (Exception ex) {
            log.debug("Error ao conectar ao serviço de storage", ex);
            throw new StorageException(Message.toLocale("storage.error.failConnect"));
        }
    }

    private String getFullPath(String path, String name) {
        var objectName = path;

        if (!objectName.startsWith("/")) {
            objectName = "/" + objectName;
        }

        if (!objectName.endsWith("/")) {
            objectName = objectName + "/";
        }

        objectName = objectName + name;

        return objectName;
    }

}
