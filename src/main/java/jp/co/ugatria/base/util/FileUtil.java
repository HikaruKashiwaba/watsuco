package jp.co.ugatria.base.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Properties;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.medsea.mimeutil.MimeType;
import eu.medsea.mimeutil.MimeUtil;
import jp.co.ugatria.base.log.LoggerFactory;
import jp.co.ugatria.base.multipart.MultiPartParam;

public class FileUtil {

	private static Logger log = LoggerFactory.make();

	private static final Properties systemSettings;

	static {
		@SuppressWarnings("resource")
		ApplicationContext context =
				new ClassPathXmlApplicationContext("application-config.xml");
		systemSettings = (Properties) context.getBean("systemSettings");
	}

	private FileUtil() {}

	/**
	 * ファイルのアップロードを実行します.
	 * 拡張子のチェックは呼び出し元で行うこと.
	 * @param params アップロードファイルの含まれたMultiPartParam
	 * @param fileDir デフォルトの保存先ディレクトリ
	 * @param types 使用機能ごとのディレクトリ
	 * @return 成功true,失敗false
	 */
	public static String uploadFile(MultiPartParam params, String fileDir) {
        byte[] filedata = params.getFileData("file");
        String filename = params.getParameter("file");
        File file = new File(fileDir, filename);

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
        	// ディレクトリを生成
        	if (!file.getParentFile().exists()) {
        		file.getParentFile().mkdirs();
        	}

            in = new BufferedInputStream(new ByteArrayInputStream(filedata));
            out = new BufferedOutputStream(new FileOutputStream(file));

            byte[] buff = new byte[1024];
            int readCnt = -1;
            while ((readCnt = in.read(buff)) != -1) {
                out.write(buff, 0, readCnt);
            }
            out.flush();
        }
        catch (Exception e) {
        	log.error("ファイルのアップロードでエラー発生", e);
        	return null;
        }
        finally {
            if (out != null) {
                try {
                    out.close();
                }
                catch (Exception e) {}
            }
            if (in != null) {
                try {
                    in.close();
                }
                catch (Exception e) {}
            }
        }
        return file.getAbsolutePath();
	}

	public static String copyUploadFile(MultiPartParam params, String fileDir, String ulDir, String unique) {
        byte[] filedata = params.getFileData("file");
        String filename = params.getParameter("file");
        File file = new File(fileDir + ulDir + unique + "/" + filename);

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
        	// ディレクトリを生成
        	if (!file.getParentFile().exists()) {
        		file.getParentFile().mkdirs();
        	}

            in = new BufferedInputStream(new ByteArrayInputStream(filedata));
            out = new BufferedOutputStream(new FileOutputStream(file));

            byte[] buff = new byte[1024];
            int readCnt = -1;
            while ((readCnt = in.read(buff)) != -1) {
                out.write(buff, 0, readCnt);
            }
            out.flush();
        }
        catch (Exception e) {
        	log.error("アップロードファイルのコピーでエラー発生", e);
        	return null;
        }
        finally {
            if (out != null) {
                try {
                    out.close();
                }
                catch (Exception e) {}
            }
            if (in != null) {
                try {
                    in.close();
                }
                catch (Exception e) {}
            }
        }
        return file.getAbsolutePath();
	}

	public static void copyUploadFile(byte[] data, String destFilePath) {
        File file = new File(destFilePath);
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
        	// ディレクトリを生成
        	if (!file.getParentFile().exists()) {
        		file.getParentFile().mkdirs();
        	}

            in = new BufferedInputStream(new ByteArrayInputStream(data));
            out = new BufferedOutputStream(new FileOutputStream(file));

            byte[] buff = new byte[1024];
            int readCnt = -1;
            while ((readCnt = in.read(buff)) != -1) {
                out.write(buff, 0, readCnt);
            }
            out.flush();
        }
        catch (Exception e) {
        	log.error("アップロードファイルのコピーでエラー発生", e);
        }
        finally {
            if (out != null) {
                try {
                    out.close();
                }
                catch (Exception e) {}
            }
            if (in != null) {
                try {
                    in.close();
                }
                catch (Exception e) {}
            }
        }
	}

	public static Collection<MimeType> getMimeType(String filepath) {
		return getMimeType(new File(filepath));
	}

	@SuppressWarnings("unchecked")
	public static Collection<MimeType> getMimeType(File file) {
		MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
		return MimeUtil.getMimeTypes(file);
	}

	/**
	 * 画像かどうかを判定し返す.
	 * @param types
	 * @return 画像の場合はtrue、それ以外はfalseを返す
	 */
	public static boolean isImage(Collection<MimeType> types) {
		for (MimeType type : types) {
			// image/xxx
			if (type.getMediaType().indexOf("image") == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 画像かどうかを判定し返す.
	 * @param types
	 * @return 画像の場合はtrue、それ以外はfalseを返す
	 */
	public static boolean isImage(String filepath) {
		Collection<MimeType> types = getMimeType(filepath);
		for (MimeType type : types) {
			// image/xxx
			if (type.getMediaType().indexOf("image") == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean move(String fullpath, String destDir) {
		File srcFile = new File(fullpath);
		File destFile = new File(destDir, srcFile.getName());
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
//		log.info("SRC:[{}] -> DEST:[{}]", fullpath, destDir + srcFile.getName());
		return srcFile.renameTo(destFile);
	}

	public static boolean move(String fullpath, String destDir, String destFilename) {
		File srcFile = new File(fullpath);
		File destFile = new File(destDir, destFilename);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
//		log.info("SRC:[{}] -> DEST:[{}]", fullpath, destDir + destFilename);
		return srcFile.renameTo(destFile);
	}

	public static boolean deleteFile(String dirpath, String fileName) {
		File file = new File(dirpath, fileName);
		log.debug(file.getAbsolutePath());
		return file.delete();
	}
	public static void deleteDir(String dirpath) {
		File dir = new File(dirpath);
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				file.delete();
			}
		}
		dir.delete();
	}

	/**
	 *  ディレクトリ圧縮のための再帰処理
	 *  @param zipOut ZipOutputStream
	 *  @param afterFile File 保存先ファイル
	 *  @param targetDir File 圧縮対象ディレクトリ
	 */
	private static void archive(ZipOutputStream zipOut, File afterFile, File targetDir) {
		if (targetDir.isDirectory()) {
			// 圧縮対象を相対パスで指定する
			File[] fileList = targetDir.listFiles();
			if (fileList != null) {
				for (File file : fileList) {
					if (file.isDirectory()) {
						// ディレクトリ判定
						archive(zipOut, afterFile, file);
					}
					else {
						// ファイル判定
						if (!file.getAbsoluteFile().equals(afterFile)) {
							// 圧縮処理
							log.debug("圧縮ファイルフルパス:" + file.getAbsolutePath());
							log.debug("圧縮ファイル親パス:" + afterFile.getParent());
							archive(zipOut, file, file.getAbsolutePath().replace(afterFile.getParent(), ""));
						}
					}
				}
			}
		}
	}

	/**
	 *  圧縮処理
	 * @param zipOut ZipOutputStream
     * @param targetDir File 圧縮対象ディレクトリ
     * @param entryName String 圧縮ファイル名
	 */
	private static boolean archive(ZipOutputStream zipOut, File targetDir, String entryName) {
		log.debug("エントリー名:" + entryName);
		// 圧縮レベル設定
		//zipOut.setLevel(5);

		entryName = entryName.substring(1);

		BufferedInputStream in = null;
		try {
			// ZIPエントリ作成
			zipOut.putNextEntry(new ZipEntry(entryName));
			// 圧縮ファイル読込みストリーム取得
			in = new BufferedInputStream(new FileInputStream(targetDir));

			// 圧縮ファイル出力
			byte[] buffer = new byte[1024];	// 読み込みバッファ
			int len = 0;

			// read()：ZipOutputStreamへデータ登録
			while ((len = in.read(buffer, 0 , buffer.length)) != -1) {
				// byte配列を現在のZIPエントリデータに書き込む。
				zipOut.write(buffer, 0, len);
			}
		} catch (Exception e) {
			// 圧縮失敗
			log.error("FileUtils:作業結果ファイル生成でエラー["+e+"]");
			return false;
		}
		finally {
			if (in != null) {
				try {in.close();} catch (Exception e) {}
			}
			try {zipOut.closeEntry();} catch (Exception e) {}
		}
		return true;
	}

	/**
	 * 指定ファイルのコピーファイルを作成する.
	 * @param file コピー元ファイル情報
	 * @param targetDir コピー先ディレクトリ情報
	 * @return boolean コピー処理結果 true:コピー成功 false:コピー失敗
	 * @throws IOException
	 */
	public static boolean copyFile(File file, File targetDir) {
    	return copyFile(file, targetDir, file.getName());
    }

	/**
	 * 指定ファイルのコピーファイルを作成する.
	 * @param file コピー元ファイル情報
	 * @param targetDir コピー先ディレクトリ情報
	 * @return boolean コピー処理結果 true:コピー成功 false:コピー失敗
	 * @throws IOException
	 */
	public static boolean copyFile(File file, File targetDir, String targetFilename) {
		// コピー先ファイル名の設定を行う
    	File newFile = new File(targetDir + "/" + targetFilename);
    	Boolean result = false;
    	try {
    		if (!targetDir.exists()) {
    			targetDir.mkdirs();
    		}

    		// 作成日等の全属性をコピーする。コピー先に同名ファイルが存在する場合は、上書き保存を行う。
    		Path path = Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    		result = path != null ? true : false;
    	}
    	catch (IOException e) {
    		// コピー失敗
   			log.error("FileUtils:作業結果ファイル生成でエラー["+e+"]");
    	}
    	return result;
    }

	/**
	 * JSONファイルを作成する.
	 * @param projectContent String 内容
	 * @param dirPath String 作成先ディレクトリのパス
	 * @return JSONファイルへのパス
	 */
	public static String makeJsonFile(String projectContent, String dirPath) {
		// JSONファイルへのパスを指定
		File file = new File(dirPath + "/response.json");
		PrintWriter pw = null;
		try {
			// 空ファイル作成
			file.createNewFile();
			// 書き込み準備
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			// 内容を書き込む
            pw.write(projectContent.toString());
		}
		catch (IOException e) {
			log.error("File:作業結果ファイル生成でエラー["+e+"]");
		}
		finally {
			if (pw != null) {
				pw.close();
			}
		}
		return file.getPath();
	}

	/**
	 * ユニークな名称のディレクトリを作成する.
	 * @param path String ディレクトリ作成位置へのパス
	 * @return 作成成功：ディレクトリパス String, 作成失敗：null
	 */
	public static String makeDir(String path) {
		// 圧縮対象ディレクトリ
		File dir = new File(path);

		// ディレクトリ作成
		if (dir.mkdirs()) {
			// 作成成功
			return dir.getPath();
		}
		// 作成失敗
		return null;
	}

	/**
	 * 指定されたフォルダの中身ごと削除する.
	 * @param dir File
	 * @return
	 */
	public static boolean deleteAll(File dir) {
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				deleteAll(file);
			}
		}
		if (dir.isFile()) {
			dir.delete();
		}
		return dir.delete();
	}

	public static boolean createPdf(String fileName, byte[] jasperObj) {
		File filePath = new File(systemSettings.getProperty("pdf.file.dir"));
		File pdf = new File(filePath.getPath() + "/" + fileName);

		try {
			// ファイル格納用ディレクトリ存在チェック
			if (!filePath.exists()) {
				if (!filePath.mkdirs()) {
					log.error(String.format("PDF格納フォルダ作成失敗。"));
					return false;
				}
			}
			// PDF出力ファイル存在チェック
			if (!pdf.exists()) {
				if (!pdf.createNewFile()) {
					log.error(String.format("PDF出力ファイル作成失敗。"));
					return false;
				}
			}

			// 出力ストリームの生成
			FileOutputStream fos = new FileOutputStream(pdf);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			// 出力ストリームへの書き込み（ファイルへの書き込み）
			bos.write(jasperObj);

		    // 後始末
		    bos.flush();
		    bos.close();

		}
		catch(IOException e) {
			log.error(String.format("ファイル出力エラー", e.getMessage()));
			return false;
		}
		return true;
	}
}
