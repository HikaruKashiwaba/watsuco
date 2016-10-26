package jp.co.ugatria.base.multipart;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.MultiPart;

@Component
public class MultiPartParser {

    @Autowired
    @Qualifier("systemSettings")
    protected Properties systemSettings;

    /**
     * マルチパートリクエストデータを解析して、パラメータを返す.
     *
     * @param part マルチパートデータ
     * @return マルチパートリクエストデータをキー、バリューの形式で保持するオブジェクヿ
     */
    public MultiPartParam parse(MultiPart part) {
        MultiPartParam params = new MultiPartParam();

        List<BodyPart> bodyPartList = part.getBodyParts();
        for (BodyPart bodyPart : bodyPartList) {
            if (bodyPart instanceof FormDataBodyPart) {
                FormDataBodyPart fdbp = (FormDataBodyPart)bodyPart;
                FormDataContentDisposition disposition = fdbp.getFormDataContentDisposition();
                String filename = disposition.getFileName();

                if (fdbp.isSimple() && StringUtils.isEmpty(filename)) {
                    params.setParameter(fdbp.getName(), fdbp.getValue());
                }
                else {
                    params.setParameter(fdbp.getName(), disposition.getFileName());

                    if (!StringUtils.isEmpty(disposition.getFileName())) {
                        BodyPartEntity entity = (BodyPartEntity)bodyPart.getEntity();

                        BufferedInputStream bis = new BufferedInputStream(entity.getInputStream());
                        ByteArrayOutputStream bos = null;
                        byte[] data = new byte[1024];
                        try {
                            bos = new ByteArrayOutputStream();
                            int len = 0;
                            while ((len = bis.read(data)) >= 0) {
                                bos.write(data, 0, len);
                            }
                            params.setFileData(fdbp.getName(), bos.toByteArray());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        finally {
                            if (bos != null) {
                                try {
                                    bos.close();
                                }
                                catch (Exception ex) {}
                            }
                        }
                    }
                }
            }
        }
        return params;
    }
}
