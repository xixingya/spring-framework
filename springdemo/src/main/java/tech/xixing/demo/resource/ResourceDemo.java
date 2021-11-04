package tech.xixing.demo.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/10/27 7:26 PM
 */
public class ResourceDemo {

	public static void main(String[] args) throws Exception{
		final FileSystemResource fileSystemResource = new FileSystemResource("/Users/liuzhifei/workspace/sourcecode/my/spring-framework/springdemo/src/main/java/tech/xixing/demo/resource/test.txt");
		final File file = fileSystemResource.getFile();
		System.out.println(file.length());
		final OutputStream outputStream = fileSystemResource.getOutputStream();
		final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.append("hello world!");
		writer.flush();
		outputStream.close();
		writer.close();
	}
}
