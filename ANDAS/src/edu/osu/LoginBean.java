/**
 * 
 */
package edu.osu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import examples.cse769.EJB.Service.LoginSession;
import examples.cse769.EJB.Service.HelloService;
/**
 * @author Reddiah
 *
 */
public class LoginBean
{

	public int getNumSize() {
		return numSize;
	}
	public void setNumSize(int numSize) {
		this.numSize = numSize;
	}
	//private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	//Logger logger = LoggerFactory.getLogger(LoginBean.class);
    private static Logger logger = Logger.getLogger("edu.osu.LoginBean");
    private static FileHandler fh;
	@EJB 
	private HelloService helloService;
    private String name;
    private String password;
    private String selection;
    private Part uploadedFile;
    private String text1;
    private MergeSort ms = new MergeSort();
    private int numSize;
    public int displayNumSize() {
    	numSize = Character.getNumericValue(text.toString().charAt(0));
    	return numSize;
    }
    public void downloadFile() {

        File file = new File("c://temp//sorted.txt");
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  

        response.setHeader("Content-Disposition", "attachment;filename=file.txt");  
        response.setContentLength((int) file.length());  
        ServletOutputStream out = null;  
        try {  
            @SuppressWarnings("resource")
			FileInputStream input = new FileInputStream(file);  
//            String temp=text.toString();
            System.out.println("displayNum "+displayNumSize());
            byte[] buffer = new byte[30];  
            out = response.getOutputStream();  
            @SuppressWarnings("unused")
			int i = 0;  
            while ((i = input.read(buffer)) != -1) {  
                out.write(buffer);  
                out.flush();  
            }  
            FacesContext.getCurrentInstance().getResponseComplete();  
        } catch (IOException err) {  
            err.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
            } catch (IOException err) {  
                err.printStackTrace();  
            }  
        }  

    }
    public String sort() {
    	return ms.storeSorted(text.toString());
    }
	
    public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public static StringBuffer getText() {
		return text;
	}

	public static void setText(StringBuffer text) {
		LoginBean.text = text;
	}
	public void setSB() {
		this.text1=LoginBean.text.toString();
	}
	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	private static StringBuffer text = new StringBuffer("");
	public String upload() {

//        if (null != uploadedFile) {
//            try {
//                InputStream is = uploadedFile.getInputStream();
//                text = new Scanner(is).useDelimiter("\\A").next();
//                return "Upload";
//            } catch (IOException ex) {
//            }
//        }
		return "true";
    }
    public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	@EJB private LoginSession loginSession;
	public String userName() {

 	   String[] params = new String[3];
 	   params[0] = name;
 	   params[1] = password;
 	   params[2] = selection;
 	   try {
 		   if(fh == null)
 	   fh = new FileHandler("final.txt");//"mylog.txt"
 	  fh.setFormatter(new SimpleFormatter());
      logger.addHandler(fh);
      logger.setLevel(Level.ALL);
      logger.entering("LoginBean", "userName", params);
 	   }
 		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 	  //logHelperBean.logMe("LoginBean", "userName", "Entering", params);
		//logger.info("an info message");
		//logger.trace("a trace message");
		String res = loginSession.userName(name, password, selection);
		//initializeLog4j("log4j.properties");

		 //Logger.getRootLogger().getLoggerRepository().resetConfiguration(); null pointer
		//BasicConfigurator.resetConfiguration();

		 //LogManager.resetConfiguration();
		 //Enumeration enumLoggers = Logger.getRootLogger().getLoggerRepository().getCurrentLoggers();
		  //LogManager.getRootLogger().setLevel(Level.TRACE);
		   
		   //Level level = new Level();
		   
		    /*FileAppender fapp = new FileAppender();
		   fapp.setName("FileLogger");

		   fapp.setFile("god.txt");
		   fapp.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		   fapp.setThreshold(Level.ALL);//was debug
		   fapp.setImmediateFlush(true);
		   fapp.activateOptions();
		   
		   Logger.getRootLogger().addAppender(fapp);
		   LogManager.getRootLogger().addAppender(fapp);

		   final Logger log = Logger.getRootLogger();
		     Logger log2 = Logger.getRootLogger();
		   


		   Logger log1 = Logger.getLogger(ApplyBean.class.getName());//static
		   //log1.addAppender(fapp);
		   //log1.setLevel(level);
		 log1.warn("warn");
		 log1.debug("debug");
		 log1.info("info");
		 log1.error("error");
		 log1.fatal("fatal");

		 log.info("Hello this is an info message Dingry");

		 log.warn("Hello this is an warn message Dingry");
		 log.debug("Hello this is an debug message Dingry");
		 log.trace("Trace Message!");
	      log.error("Error Message!");
	      log.fatal("Fatal Message!");
	      
	      log2.warn("warn");
			 log2.debug("debug");
			 log2.info("info");
			 log2.error("error");
			 log2.trace("trace");
	      
	      

	     // log.setLevel(Level.WARN);
	     log.info("Hello this is an info message Dingry");
	     
	     
	     */
	      logger.exiting("LoginBean", "userName", res);

		if (res.equalsIgnoreCase("success"))
		{
				
			return selection;
		}
		else if(res.equalsIgnoreCase("fail"))
			return "false";
		
		return "false";
	}
	
	//public String password() {
		//String pass = helloService.password(password);
		//return pass;
	//}
	
	public String getMessage() {
		//String pass = helloService.password(password);
		//return pass;
		return "lol";
	}
	

	   public String getName ()
	    {
	        return name;
	    }


	    public void setName (final String name)
	    {
	        this.name = name;
	    }


	    public String getPassword ()
	    {
	        return password;
	    }


	    public void setPassword (final String password)
	    {
	        this.password = password;
	    }

		
}
