import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class ChangeTheEncode {
	public static void main(String[] args) {
		// 用commons-io.jar实现文件的
		// GBK编码格式源码目录
		String srcDirPath = "/Users/gahon/git/FiveChess/src/";
		// 转为UTF-8编码格式源码目录
		String utf8DirPath = "/Users/gahon/git/FiveChess/src/UTF8/";

		// 获取所有java文件
		Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File(srcDirPath), new String[]{"java"}, true);

		for(File javaGbkFile:javaGbkFileCol)
		{
			// UTF8格式文件路径
			String utf8FilePath = utf8DirPath + javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
			
			// 使用GBK读取数据，然后用UTF-8写入数据
			try {
				FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("转换完成");
	}
}