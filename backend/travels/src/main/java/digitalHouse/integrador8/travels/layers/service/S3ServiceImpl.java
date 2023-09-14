/*package digitalHouse.integrador8.travels.layers.service;

import digitalHouse.integrador8.travels.layers.service.serviceInterfaces.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    CreadorExperienciaServiceImpl creadorExperienciaService;

    @Autowired
    private AmazonS3 amazonS3;

    @Value("aws.s3.bucket")
    private String bucketName;

    @Override
    public String cargarImagen(MultipartFile archivo, Long experienciaId) throws IOException {
        File archivoPrincipal = new File(archivo.getOriginalFilename());
        try (FileOutputStream fileOutputStream = new FileOutputStream(archivoPrincipal)) {
            fileOutputStream.write(archivo.getBytes());
            String nuevoNombreArchivo = System.currentTimeMillis() + " " + archivoPrincipal.getName();
            PutObjectRequest request = new PutObjectRequest(bucketName, nuevoNombreArchivo, archivoPrincipal);
            amazonS3.putObject(request);
            return "Se subió el archvo " + nuevoNombreArchivo;
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }
}*/
