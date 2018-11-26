package com.kotlin.khum.mobilesafe.multiThread.io;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * <pre>
 *     author : khum
 *     desc   : 文件拷贝
 * </pre>
 */
public class FileCopy {

	public void FileCopy1(File source, File dest) throws IOException {
		try(InputStream is = new FileInputStream(source);
			OutputStream os = new FileOutputStream(dest)) {
			byte[] buffer = new byte[1024];
			int length;
			while((length = is.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
		}
	}

	public void FileCopy2(File source, File dest) throws IOException {
		try(FileChannel sourceChannel = new FileInputStream(source).getChannel();
			FileChannel targetChannel = new FileOutputStream(dest).getChannel()){
			for(long count = sourceChannel.size(); count>0; ){
				long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
				sourceChannel.position(sourceChannel.position()+ transferred);
				count -= transferred;
			}
		}
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	public void FileCopy3(File source, File dest) throws IOException {
		Files.copy(source.toPath(), new FileOutputStream(dest));
	}

}
