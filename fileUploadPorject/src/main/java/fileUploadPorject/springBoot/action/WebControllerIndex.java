package fileUploadPorject.springBoot.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fileUploadPorject.springBoot.model.FileDetail;

@Controller
public class WebControllerIndex {

	private static final Logger logger = LoggerFactory.getLogger(WebControllerIndex.class);
		
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String indexJspRedirect(){
		// this method is used to hit the index.jsp 
		logger.info("Inside {}", "indexJspRedirect method");
		return "index";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file,Map<String, Object> model){
		// this method hits when user clicks on upload button after uploading the csv file
		// in this method all the csv data is extracted and printed in the loggers but however data is 
		// not printed in jsp file(it will be printed in jsp by tommorow).
		logger.info("Inside {}", "fileUpload method " +  file.getOriginalFilename());
		List<FileDetail> fileData = new ArrayList<FileDetail>();
		BufferedReader br=null;
		try{
			String fileName= "F:/Practical Learning/test file/csv/" +file.getOriginalFilename();
			logger.info("fileName {}", "" + fileName);
			br = new BufferedReader(new FileReader(fileName));
			String line = "";
			br.readLine();
			while((line=br.readLine()) != null){
				String[] fileDataDetails = line.split(",");
				if(fileDataDetails.length>0){
					FileDetail fd = new FileDetail(Integer.parseInt(fileDataDetails[0]), fileDataDetails[1],
							fileDataDetails[2],Integer.parseInt(fileDataDetails[3]),fileDataDetails[4]);
					fileData.add(fd);
				}
			}

			for(FileDetail e : fileData)
			{
				logger.info("Inside loop {}","" + e.getRecordId()+"   "+e.getFirstName()+"   "
						+e.getLastName()+"   "+e.getAge());
			}
		}
		catch(Exception ee)
		{
			logger.error("Inside loop {}","" + ee);
		}

		String[] messageArray = new String[fileData.size()]; 
		for(int i=0;i<fileData.size(); i++)
		{
			messageArray[i] = "Record ID :" + fileData.get(i).getRecordId() + ",   First Name :" + fileData.get(i).getFirstName()
					+ ",   Last Name :" + fileData.get(i).getLastName() + ",   Gender :" + fileData.get(i).getGender() + ",   Age :" + fileData.get(i).getAge();
		}

		logger.info("String Array Message Print {}","" + Arrays.toString(messageArray));
		model.put("message", messageArray);
		return "index";	
	}
	
	
}
