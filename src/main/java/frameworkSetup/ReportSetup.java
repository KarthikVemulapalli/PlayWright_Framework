package frameworkSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import webcore.cucumber.CommonFunctions;

public class ReportSetup {
	
	public void initialReportStep() {
		String sourcefolderpath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Automation_Report";
		
		String archievedreportpath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Archieved_Reports"; 
		File folderCreation = new File(archievedreportpath);
		folderCreation.mkdir();
		
		String zipfilepath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Archieved_Reports" + File.separator + "Automation_Report_Zip_"+ CommonFunctions.getCurrentISTDate("dd-MMM-yyyy-HH-mm-ss") +".zip";
		zipFolder(sourcefolderpath, zipfilepath);
		
		deleteAutomationReportDirectory();
	} 

	private static void deleteAutomationReportDirectory() {
		String directoryAutomationReport = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Automation_Report";	
        try{
        	File file = new File(directoryAutomationReport);
            FileUtils.deleteDirectory(file);
            file.delete();           
        }catch(Exception e) {  
        	Assert.fail(e.getMessage());
        }  
    }
	
	private static void zipFolder(String sourceFolderPath, String zipFilePath) {
		try {
			FileOutputStream fos = new FileOutputStream(zipFilePath);
			ZipOutputStream zos = new ZipOutputStream(fos);
			File sourceFolder = new File(sourceFolderPath);
			
			zipDirectory(sourceFolder, sourceFolder.getName(), zos);
			zos.close();
			fos.close();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	private static void zipDirectory(File folder, String parentFolder, ZipOutputStream zos) throws Exception {
		for(File file: folder.listFiles()) {
			if(file.isDirectory()) {
				zipDirectory(file, parentFolder+"/"+file.getName(), zos);
			} else {
				byte[] buffer = new byte[1024];
				FileInputStream fis = new FileInputStream(file);
				zos.putNextEntry(new ZipEntry(parentFolder+"/"+file.getName()));
				int length;
				
				while( (length = fis.read(buffer))>0 ) {
					zos.write(buffer, 0, length);
				}
				
				zos.closeEntry();
				fis.close();
			}
		}
	}
	
}