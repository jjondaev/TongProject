package imgTest;

import java.io.*;  
import java.util.Iterator;  
import javax.imageio.*;  
import javax.imageio.stream.*;  
import java.awt.image.*;  
  
public class ImageQualityReducer {  
    public static void main(String[] args) throws Exception {  
    	
    	// jpg 파일 품질 낮추기
        String srcPath = "C:\\test.jpg";  
        String destPath = "C:\\test2.jpg";  
        float quality = 0.5f;  
  
        Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");  
  
        ImageWriter writer = (ImageWriter)iter.next();  
  
        ImageWriteParam iwp = writer.getDefaultWriteParam();  
  
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);  
  
        iwp.setCompressionQuality(quality);  
  
        File file = new File(destPath);  
        FileImageOutputStream output = new FileImageOutputStream(file);  
        writer.setOutput(output);  
  
        FileInputStream inputStream = new FileInputStream(srcPath);  
        BufferedImage originalImage = ImageIO.read(inputStream);  
  
        IIOImage image = new IIOImage(originalImage, null, null);  
        writer.write(null, image, iwp);  
        writer.dispose();  
  
        System.out.println("DONE");  
    }  
}  