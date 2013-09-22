package editor;

public class Filename 
{	
	    private String fullPath, pathSeparator;
	    private char extensionSeparator;

	    public Filename(String fullPath, String pathSeparator, char extensionSeparator) 
	    {
	        this.fullPath = fullPath;
	        this.pathSeparator = pathSeparator;
	        this.extensionSeparator = extensionSeparator;
	    }

	    public String extension() 
	    {
	        int dot = fullPath.lastIndexOf(extensionSeparator);
	        return fullPath.substring(dot + 1);
	    }

	    // gets filename without extension
	    public String filename() 
	    {
	        int dot = fullPath.lastIndexOf(extensionSeparator);
	        int sep = fullPath.lastIndexOf(pathSeparator);
	        return fullPath.substring(sep + 1, dot);
	    }

	    public String path() 
	    {
	        int sep = fullPath.lastIndexOf(pathSeparator);
	        return fullPath.substring(0, sep);
	    }
}
