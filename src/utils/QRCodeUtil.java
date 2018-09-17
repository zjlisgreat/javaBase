package utils;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 *@author zjl
 *2018年9月13日 下午10:31:36
 */
public class QRCodeUtil {
	
	private static final int DEFAULT_HEIGHT = 400;
	
	private static final int DEFAULT_WIDTH = 400;
	
	@SuppressWarnings("deprecation")
	public static void generateQRCode(String filePath,String fileName,String imageType,int width,int height,String content) throws Exception {
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("content", content);
//		String result = jsonObj.toString();
		
		Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
		String path = FileSystems.getDefault().getPath(filePath, fileName).toString();
		File file = new File(path);
		
		MatrixToImageWriter.writeToFile(bitMatrix, imageType, file); //输出图像
		
		System.out.println("生成二维码成功!");
		
		System.out.println("图片地址：" + filePath + fileName);  
		
		
	}
	
	public static void main(String[] args) throws Exception {
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("name", "zjl");
//		jsonObject.put("sex", "男");
//		
//		System.out.println(jsonObject.toString());
		String filePath = "F:\\workbooks\\img\\";
		String fileName = "wifi.png";
		String imageType = "png";
		int width = DEFAULT_WIDTH;
		int height = DEFAULT_HEIGHT;
		String content = "我的WIFI密码：zjl805isgreat.";
		generateQRCode(filePath, fileName, imageType, width, height, content);
	}
}
